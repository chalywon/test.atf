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
package com.atf.hybird.factory.htmlpage;

import java.lang.reflect.Field;

import com.atf.hybird.By;
import com.atf.hybird.Element;
import com.atf.hybird.interfaces.LocateContext;

/**
 *
 * @author charl
 */
public class HtmlElementLocator implements ElementLocator{
    private final LocateContext locateContext;
    private By by;
    
    public HtmlElementLocator(LocateContext locateContext,Field field){
        this(locateContext,new LocatorAnnotations(field));
    }
    
    public HtmlElementLocator(LocateContext locateContext,LocatorAnnotations annotations){
        this.locateContext=locateContext;
        this.by=annotations.buildBy();
    }
    @Override
    public Element locateElement(){
        Element element=this.locateContext.locateElement(by);
        return element;
    }
    
}
