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

import com.atf.hybird.annotations.FindBy;

/**
 *
 * @author charl
 */
public class HtmlFieldDecorator implements FieldDecorator {
    ElementLocatorFactory factory;
    
    public HtmlFieldDecorator(ElementLocatorFactory factory){
        this.factory=factory;
    }
    
    public Object decorate(ClassLoader loader, Field field){
        if(field.getAnnotation(FindBy.class)==null)
            return null;
        ElementLocator locator=factory.createLocator(field);
        return locator.locateElement();
    }
    
}
