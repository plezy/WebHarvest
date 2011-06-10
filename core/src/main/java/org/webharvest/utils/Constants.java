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
package org.webharvest.utils;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Constants {

    //todo: merge with org.webharvest.WHConstants

    public static final int DEFAULT_MAX_LOOPS = 1000000000;

    public static final String VALUE_PROPERTY_NAME = "[Value]";
    public static final String EXECUTION_TIME_PROPERTY_NAME = "[Execution Time]";

    // size of splitter pane dividers
    public static final int SPLITTER_WIDTH = 7;

    // uris to identify xml namespaces of the Web-Harvest language
    public static final String XMLNS_CORE = "http://web-harvest.sourceforge.net/schema/2.1/core";
    public static final String XMLNS_VAR = "http://web-harvest.sourceforge.net/schema/2.1/var";
    public static final String XMLNS_PARAM = "http://web-harvest.sourceforge.net/schema/2.1/param";

    // Legacy namespaces (aka WH-1.0)
    public static final String XMLNS_CORE_10 = "http://web-harvest.sourceforge.net/schema/1.0/config";
    public static final Set<String> XMLNS_CORE_10_ALIASES = Collections.unmodifiableSet(new HashSet<String>(Arrays.asList(
            "http://web-harvest.sourceforge.net/wh-core.xsd"
            // what other URIs might people have used?
    )));

}