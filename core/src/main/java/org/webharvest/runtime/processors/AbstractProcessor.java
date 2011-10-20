/*  Copyright (c) 2006-2007, Vladimir Nikic
    All rights reserved.

    Redistribution and use of this software in source and binary forms,
    with or without modification, are permitted provided that the following
    conditions are met:

    * Redistributions of source code must retain the above
      copyright notice, this list of conditions and the
      following disclaimer.

    * Redistributions in binary form must reproduce the above
      copyright notice, this list of conditions and the
      following disclaimer in the documentation and/or other
      materials provided with the distribution.

    * The name of Web-Harvest may not be used to endorse or promote
      products derived from this software without specific prior
      written permission.

    THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
    AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
    IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
    ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE
    LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
    CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
    SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
    INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
    CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
    ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
    POSSIBILITY OF SUCH DAMAGE.

    You can contact Vladimir Nikic by sending e-mail to
    nikic_vladimir@yahoo.com. Please include the word "Web-Harvest" in the
    subject line.
*/
package org.webharvest.runtime.processors;

import org.apache.commons.io.FileUtils;
import org.webharvest.definition.AbstractElementDef;
import org.webharvest.definition.ProcessorElementDef;
import org.webharvest.runtime.DynamicScopeContext;
import org.webharvest.runtime.Scraper;
import org.webharvest.runtime.templaters.BaseTemplater;
import org.webharvest.runtime.variables.EmptyVariable;
import org.webharvest.runtime.variables.NodeVariable;
import org.webharvest.runtime.variables.Variable;
import org.webharvest.utils.CommonUtil;
import org.webharvest.utils.Constants;
import org.webharvest.utils.KeyValuePair;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Base processor that contains common processor logic.
 * All other processors extend this class.
 */
public abstract class AbstractProcessor<TDef extends AbstractElementDef> {

    abstract public Variable execute(Scraper scraper, DynamicScopeContext context) throws InterruptedException;

    protected TDef elementDef;
    private Map properties = new LinkedHashMap();

    protected AbstractProcessor() {
    }

    /**
     * Base constructor - assigns element definition to the processor.
     *
     * @param elementDef
     */
    protected AbstractProcessor(TDef elementDef) {
        this.elementDef = elementDef;
    }

    /**
     * Wrapper for the execute method. Adds controlling and logging logic.
     */
    public Variable run(final Scraper scraper, DynamicScopeContext context) throws InterruptedException {
        final int scraperStatus = scraper.getStatus();

        if (scraperStatus == Scraper.STATUS_STOPPED || scraperStatus == Scraper.STATUS_EXIT) {
            return EmptyVariable.INSTANCE;
        }

        if (Thread.currentThread().isInterrupted()) {
            throw new InterruptedException();
        }

        if (scraperStatus == Scraper.STATUS_PAUSED) {
            final SimpleDateFormat dateFormatter = new SimpleDateFormat("HH:mm:ss.SSS");
            synchronized (scraper) {
                scraper.getLogger().info("Execution paused [{}].", dateFormatter.format(new Date()));
                scraper.wait();
            }


            scraper.continueExecution();
            scraper.getLogger().info("Execution continued [{}].", dateFormatter.format(new Date()));
        }

        final long startTime = System.currentTimeMillis();

        final String id = (this.elementDef != null) ? BaseTemplater.evaluateToString(this.elementDef.getId(), null, scraper) : null;

        setProperty("ID", id);

        if (scraper.getLogger().isInfoEnabled()) {
            scraper.getLogger().info("{}{} starts processing...{}", new Object[]{
                    CommonUtil.indent((scraper.getRunningLevel() - 1) * 4),
                    getClass().getSimpleName(),
                    id != null ? "[ID=" + id + "] " : ""});
        }

        scraper.setExecutingProcessor(this);

        final Variable result = execute(scraper, context);
        final long executionTime = System.currentTimeMillis() - startTime;

        setProperty(Constants.EXECUTION_TIME_PROPERTY_NAME, executionTime);
        setProperty(Constants.VALUE_PROPERTY_NAME, result);

        scraper.processorFinishedExecution(this, this.properties);
        scraper.finishExecutingProcessor();

        // if debug mode is true and processor ID is not null then write debugging file
        if (scraper.isDebugMode() && id != null) {
            writeDebugFile(result, id, scraper);
        }

        if (scraper.getLogger().isInfoEnabled()) {
            scraper.getLogger().info("{}{} processor executed in {}ms.{}", new Object[]{
                    CommonUtil.indent((scraper.getRunningLevel() - 1) * 4),
                    getClass().getSimpleName(),
                    executionTime,
                    id != null ? "[ID=" + id + "] " : ""});
        }

        return result;
    }

    /**
     * Defines processor runtime property with specified name and value.
     *
     * @param name
     * @param value
     */
    protected void setProperty(String name, Object value) {
        if (name != null && !"".equals(name) && value != null) {
            this.properties.put(name, value);
        }
    }

    protected void debug(ProcessorElementDef elementDef, Scraper scraper, Variable variable) {
        String id = (elementDef != null) ? BaseTemplater.evaluateToString(elementDef.getId(), null, scraper) : null;

        if (scraper.isDebugMode() && id != null) {
            if (variable != null) {
                writeDebugFile(variable, id, scraper);
            }
        }
    }

    protected Variable getBodyTextContent(ProcessorElementDef elementDef, Scraper scraper, DynamicScopeContext context,
                                          boolean registerExecution, KeyValuePair properties[]) throws InterruptedException {
        if (elementDef == null) {
            return null;
        } else if (elementDef.hasOperations()) {
            BodyProcessor bodyProcessor = new BodyProcessor(elementDef);
            if (properties != null) {
                for (KeyValuePair property : properties) {
                    bodyProcessor.setProperty(property.getKey(), property.getValue());
                }
            }
            Variable body = registerExecution ? bodyProcessor.run(scraper, context) : bodyProcessor.execute(scraper, context);
            return new NodeVariable(body == null ? "" : body.toString());
        } else {
            return new NodeVariable(elementDef.getBodyText());
        }
    }

    protected Variable getBodyTextContent(ProcessorElementDef elementDef, Scraper scraper, DynamicScopeContext context, boolean registerExecution) throws InterruptedException {
        return getBodyTextContent(elementDef, scraper, context, registerExecution, null);
    }

    protected Variable getBodyTextContent(ProcessorElementDef elementDef, Scraper scraper, DynamicScopeContext context) throws InterruptedException {
        return getBodyTextContent(elementDef, scraper, context, false);
    }

    public AbstractElementDef getElementDef() {
        return elementDef;
    }

    private void writeDebugFile(Variable var, String processorId, Scraper scraper) {
        byte[] data = var == null ? new byte[]{} : var.toString().getBytes();

        String workingDir = scraper.getWorkingDir();
        String dir = CommonUtil.getAbsoluteFilename(workingDir, "_debug");

        int index = 1;
        File debugFile = new File(dir, processorId + "_" + index + ".debug");
        while (debugFile.exists()) {
            index++;
            debugFile = new File(dir, processorId + "_" + index + ".debug");
        }

        try {
            FileUtils.writeByteArrayToFile(debugFile, data);
        } catch (IOException e) {
            scraper.getLogger().warn(e.getMessage(), e);
        }
    }

}