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
package com.atf.hybird;

import com.atf.hybird.interfaces.LocateContext;
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
public abstract class By {
    public static By id(final String id) {
        if (id == null) {
            throw new IllegalArgumentException(
                    "Cannot find elements with a null id attribute.");
        }
        return new ById(id);
    }
    
    public static By name(final String name) {
        if (name == null) {
            throw new IllegalArgumentException(
                    "Cannot find elements with a null id attribute.");
        }
        return new ByName(name);
    }
    
    public static By tagName(final String tagName) {
        if (tagName == null) {
            throw new IllegalArgumentException(
                    "Cannot find elements with a null id attribute.");
        }
        return new ByTagName(tagName);
    }
    
     public static By className(final String className) {
        if (className == null) {
            throw new IllegalArgumentException(
                    "Cannot find elements with a null id attribute.");
        }
        return new ByClass(className);
    }
    
    public abstract Element locateElement(LocateContext context);
    public abstract String getLoactorScript(LocateContext context);
    public static class ByClass extends By{
        private final String className;
        public ByClass(String className){
            this.className=className;
        }
         public Element locateElement(LocateContext context){
            return ((LocateElementByClass)context).locateElementByClass(className);
        }
        @Override
        public String getLoactorScript(LocateContext context){
            return ((LocateScriptByClass)context).getLocateScriptByClass(className);
        }
    }
    public static class ById extends By {
        private final String id;
        public ById(String id) {
            this.id = id;
        }
        @Override
        public Element locateElement(LocateContext context){
            return ((LocateElementById)context).locateElementById(id);
        }
        @Override
        public String getLoactorScript(LocateContext context){
            return ((LocateScriptById)context).getLocateScriptById(id);
        }
    }
    
     public static class ByName extends By {
        private final String name;
        public ByName(String name) {
            this.name = name;
        }
        @Override
        public Element locateElement(LocateContext context){
            return ((LocateElementByName)context).locateElementByName(name);
        }
        
        @Override
        public String getLoactorScript(LocateContext context){
            return ((LocateScriptByName)context).getLocateScriptByName(name);
        }
    }
     
      public static class ByTagName extends By {
        private final String tagName;
        public ByTagName(String tabName) {
            this.tagName = tabName;
        }
        @Override
        public Element locateElement(LocateContext context){
            return ((LocateElementByTagName)context).locateElementByTagName(tagName);
        }
        
        @Override
        public String getLoactorScript(LocateContext context){
            return ((LocateScriptByTagName)context).getLocateScriptByTagName(tagName);
        }
    }
}
