/*
 * Copyright 2016 charl.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.atf.hybird.implement;

/**
 *
 * @author charl
 */
public interface Constant {
    String PARAMETER_DOUCUMENT_ELEMENT="document.documentElement";
    String PARAMETER_ELMENT_PARENT="########";
    String PARAMETER_VALUE_FIND="%%%%%%%%";
    String PARAMETER_VALUE_RESULT = "$$$$$$$$";
    String PARAMETER_FUNCTION_TIMEOUT = "&&&&&&&&";
    String PARAMETER_TIMEOUT_WAIT = "@@@@@@@@";
    String ACTION_CLICK = ".click()";
    String BODY_FUNCTION_VALUE = ".value=" + "'" + PARAMETER_VALUE_RESULT + "'";
    String BODY_FUNCTION_TIMEOUT = "setTimeout(function(){"
            + PARAMETER_FUNCTION_TIMEOUT 
            + ";}," 
            + PARAMETER_TIMEOUT_WAIT 
            + ")";
    String BODY_FUNCTION_FIND_BYID = "findElementById("
            + PARAMETER_ELMENT_PARENT
            + ","
            + "'"
            + PARAMETER_VALUE_FIND
            + "')";

    String BODY_FUNCTION_FIND_BYNAME = "findElementByName("
            + PARAMETER_ELMENT_PARENT
            + ","
            + "'"
            + PARAMETER_VALUE_FIND
            + "')";

    String BODY_FUNCTION_FIND_BYTAGNAME = "findElementByTagName("
            + PARAMETER_ELMENT_PARENT
            + ","
            + "'"
            + PARAMETER_VALUE_FIND
            + "')";
    
     String BODY_FUNCTION_FIND_BYCLASS = "findElementByClass("
            + PARAMETER_ELMENT_PARENT
            + ","
            + "'"
            + PARAMETER_VALUE_FIND
            + "')";

    


}
