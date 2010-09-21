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
package org.webharvest.runtime.scripting;

import org.webharvest.runtime.DynamicScopeContext;
import org.webharvest.runtime.variables.InternalVariable;
import org.webharvest.runtime.variables.Variable;
import org.webharvest.utils.KeyValuePair;

/**
 * Abstract scripting engine.
 */
abstract public class ScriptEngine {

    public static final String CONTEXT_VARIABLE_NAME = "___web_harvest_context___";

    private DynamicScopeContext context;

    /**
     * Constructor - initializes context of variables.
     *
     * @param context
     */
    protected ScriptEngine(DynamicScopeContext context) {
        this.context = context;
    }

    /**
     * Sets variable in scripter context.
     *
     * @param name
     * @param value
     */
    public abstract void setVariable(String name, Object value);

    /**
     * Evaluates specified expression or code block.
     *
     * @return value of evaluation or null if there is nothing.
     */
    public final Object evaluate(String expression) {
        // push all variables from context to the scripter
        for (KeyValuePair<Variable> pair : context) {
            final Variable value = pair.getValue();

            //todo: why not just unwrap every variable?
            setVariable(pair.getKey(), (value instanceof InternalVariable)
                    ? value.getWrappedObject()
                    : value);
        }
        return doEvaluate(expression);
    }


    protected abstract Object doEvaluate(String expression);

}