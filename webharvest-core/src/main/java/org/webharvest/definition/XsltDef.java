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
package org.webharvest.definition;

import org.webharvest.ioc.InjectorHelper;
import org.webharvest.runtime.processors.Processor;

/**
 * Definition of user-defined function.
 */
public class XsltDef extends WebHarvestPluginDef {

    private IElementDef xmlDef;

    private IElementDef stylesheetDef;

    public XsltDef(XmlNode xmlNode, Class<? extends Processor> processorClass) {
        super(xmlNode, processorClass);

        XmlNode xmlDefNode = xmlNode.getFirstSubnode(new ElementName("xml", xmlNode.getUri()));
        xmlDef = xmlDefNode == null ? null : InjectorHelper.getInjector().getInstance(ConfigurableResolver.class).createElementDefinition(xmlDefNode);

        XmlNode stylesheetDefNode = xmlNode.getFirstSubnode(new ElementName("stylesheet", xmlNode.getUri()));
        stylesheetDef = stylesheetDefNode == null ? null : InjectorHelper.getInjector().getInstance(ConfigurableResolver.class).createElementDefinition(stylesheetDefNode);
    }

    public IElementDef getStylesheetDef() {
        return stylesheetDef;
    }

    public IElementDef getXmlDef() {
        return xmlDef;
    }

    public String getShortElementName() {
        return "xslt";
    }

    public IElementDef[] getOperationDefs() {
        IElementDef[] result = new IElementDef[2];
        result[0] = xmlDef;
        result[1] = stylesheetDef;

        return result;
    }

}