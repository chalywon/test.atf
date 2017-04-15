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

import com.atf.hybird.By;
import com.atf.hybird.Element;
import com.atf.hybird.AppDriver;
import com.atf.hybird.interfaces.locator.LocateElementByClass;
import com.atf.hybird.interfaces.locator.LocateElementById;
import com.atf.hybird.interfaces.locator.LocateElementByName;
import com.atf.hybird.interfaces.locator.LocateElementByTagName;
import com.atf.hybird.interfaces.script.LocateScriptByClass;
import com.atf.hybird.interfaces.script.LocateScriptById;
import com.atf.hybird.interfaces.script.LocateScriptByName;
import com.atf.hybird.interfaces.script.LocateScriptByTagName;

/**
 *
 * @author charl
 */
public class HybirdDriver implements AppDriver, LocateElementById,
        LocateElementByName, LocateElementByTagName,
        LocateScriptById, LocateScriptByName,
        LocateScriptByTagName,LocateElementByClass,
        LocateScriptByClass,Constant {

    String testScript = "";

    @Override
    public Element locateElement(By by) {
        return by.locateElement(this);
    }

    @Override
    public void input(Element element, String value) {
        String script = element.getLocateScript();
        
        int index = BODY_FUNCTION_VALUE.indexOf(PARAMETER_VALUE_RESULT);
        int length = PARAMETER_VALUE_RESULT.length();
        StringBuilder builder = new StringBuilder(BODY_FUNCTION_VALUE);
        String str = builder.replace(index, index + length, value).toString();
        script = script + str;
        appendTestScript(script);
    }

    @Override
    public void input(Element element, String value, int wait) {
            String script = element.getLocateScript();
        
        int index = BODY_FUNCTION_VALUE.indexOf(PARAMETER_VALUE_RESULT);
        int length = PARAMETER_VALUE_RESULT.length();
        StringBuilder builder = new StringBuilder(BODY_FUNCTION_VALUE);
        String str = builder.replace(index, index + length, value).toString();
        script = script + str;
   
        index = BODY_FUNCTION_TIMEOUT.indexOf(PARAMETER_FUNCTION_TIMEOUT);
        length = PARAMETER_FUNCTION_TIMEOUT.length();
        builder = new StringBuilder(BODY_FUNCTION_TIMEOUT);
        script = builder.replace(index, index + length, script).toString();
        index = script.indexOf(PARAMETER_TIMEOUT_WAIT);
        length = PARAMETER_TIMEOUT_WAIT.length();
        builder = new StringBuilder(script);
        script = builder.replace(index, index + length, String.valueOf(wait)).toString();
        appendTestScript(script);

    }

    @Override
    public void click(Element element) {
        String script=element.getLocateScript();
        script+=ACTION_CLICK;
        appendTestScript(script);
    }

    @Override
    public void click(Element element, int wait) {
        String script=element.getLocateScript();
        script+=ACTION_CLICK;
        int index = BODY_FUNCTION_TIMEOUT.indexOf(PARAMETER_FUNCTION_TIMEOUT);
        int length = PARAMETER_FUNCTION_TIMEOUT.length();
        StringBuilder builder = new StringBuilder(BODY_FUNCTION_TIMEOUT);
        script = builder.replace(index, index + length, script).toString();
        index = script.indexOf(PARAMETER_TIMEOUT_WAIT);
        length = PARAMETER_TIMEOUT_WAIT.length();
        builder = new StringBuilder(script);
        script = builder.replace(index, index + length, String.valueOf(wait)).toString();
        appendTestScript(script);
    }

    @Override
    public String getLocateScriptById(String id) {
        int index = BODY_FUNCTION_FIND_BYID.indexOf(PARAMETER_VALUE_FIND);
        int length = PARAMETER_VALUE_FIND.length();
        StringBuilder builder = new StringBuilder(BODY_FUNCTION_FIND_BYID);
        String str = builder.replace(index, index + length, id).toString();

        return str;
    }

    @Override
    public String getLocateScriptByName(String name) {
        int index = BODY_FUNCTION_FIND_BYNAME.indexOf(PARAMETER_VALUE_FIND);
        int length = PARAMETER_VALUE_FIND.length();
        StringBuilder builder = new StringBuilder(BODY_FUNCTION_FIND_BYNAME);
        String str = builder.replace(index, index + length, name).toString();

        return str;
    }

    @Override
    public String getLocateScriptByTagName(String tagName) {
        int index = BODY_FUNCTION_FIND_BYTAGNAME.indexOf(PARAMETER_VALUE_FIND);
        int length = PARAMETER_VALUE_FIND.length();
        StringBuilder builder = new StringBuilder(BODY_FUNCTION_FIND_BYTAGNAME);
        String str = builder.replace(index, index + length, tagName).toString();

        return str;
    }
    
    @Override
    public String getLocateScriptByClass(String className) {
        int index = BODY_FUNCTION_FIND_BYCLASS.indexOf(PARAMETER_VALUE_FIND);
        int length = PARAMETER_VALUE_FIND.length();
        StringBuilder builder = new StringBuilder(BODY_FUNCTION_FIND_BYCLASS);
        String str = builder.replace(index, index + length, className).toString();

        return str;
    }

    @Override
    public Element locateElementById(String id) {
        Element e = new HybirdElement(this, By.id(id));
        return e;
    }

    @Override
    public Element locateElementByName(String name) {
        Element e = new HybirdElement(this, By.name(name));
        return e;
    }

    @Override
    public Element locateElementByTagName(String tagName) {
        Element e = new HybirdElement(this, By.tagName(tagName));
        return e;
    }
    
    @Override
    public Element locateElementByClass(String className){
        Element e=new HybirdElement(this,By.className(className));
        return e;
    }

    @Override
    public void appendTestScript(String testScriptPart) {
        testScript += (testScriptPart + ";\n");
    }

    @Override
    public String getTestScript() {
        return this.testScript;
    }

}
