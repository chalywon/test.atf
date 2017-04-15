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

import static com.atf.hybird.implement.Constant.PARAMETER_DOUCUMENT_ELEMENT;
import static com.atf.hybird.implement.Constant.PARAMETER_ELMENT_PARENT;

import com.atf.hybird.By;
import com.atf.hybird.Element;
import com.atf.hybird.AppDriver;

/**
 *
 * @author charl
 */
public class HybirdElement implements Element {
    AppDriver driver;
    Element parent=null;
    By by;
    public HybirdElement(AppDriver driver,By by){
        this.driver=driver;
        this.by=by;
    }
    
    @Override
    public Element getParentElement(){
        return parent;
    }
    
    @Override
    public void setParentElement(Element parent){
       this.parent=parent; 
    }
    
    @Override
    public Element locateElement(By by){
        Element element=new HybirdElement(this.driver,by);
        element.setParentElement(this);
        return element;
        
    }
    
    @Override
    public String getLocateScript(){
        String script = by.getLoactorScript(driver);
        Element e = this.getParentElement();
        while (!(e == null)) {
            int index = script.indexOf(PARAMETER_ELMENT_PARENT);
            int length = PARAMETER_ELMENT_PARENT.length();
            StringBuilder builder = new StringBuilder(script);
            script = builder.replace(index, index + length, e.getBy().getLoactorScript(driver)).toString();
            e = e.getParentElement();
        }
        int index = script.indexOf(PARAMETER_ELMENT_PARENT);
        int length = PARAMETER_ELMENT_PARENT.length();
        StringBuilder builder = new StringBuilder(script);
        script = builder.replace(index, index + length, PARAMETER_DOUCUMENT_ELEMENT).toString();
        return script;
    }
   
    @Override
    public AppDriver getTestDriver(){
        return this.driver;
    }
    
    @Override
    public void setBy(By by){
        this.by=by;
    }
    
    @Override
    public By getBy(){
        return this.by;
    }
    
    
    @Override
    public void click(){
        this.driver.click(this);
    }
    
    @Override
    public void click(int wait){
        this.driver.click(this, wait);
    }
    
    @Override
    public void input(String value){
        this.driver.input(this, value);
    }
    
    public void input(String value,int wait){
        this.driver.input(this,value, wait);
    }
}
