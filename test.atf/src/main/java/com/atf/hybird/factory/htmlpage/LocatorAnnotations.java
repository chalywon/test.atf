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
import com.atf.hybird.annotations.FindBy;

/**
 *
 * @author charl
 */
public class LocatorAnnotations {
    Field field;
    public LocatorAnnotations(Field field){
        this.field=field;
    }
    
     protected void assertValidAnnotations(){
         FindBy findBy=field.getAnnotation(FindBy.class);
         if(findBy==null){
            throw new IllegalArgumentException("not found '@FindBy' annotations!");
         }
    }
     
    public By buildBy(){
        assertValidAnnotations();
        By ans = null;
        FindBy findBy=this.field.getAnnotation(FindBy.class);
        if(!"".equals(findBy.name()))
            ans=By.name(findBy.name());
        if(!"".equals(findBy.id()))
            ans=By.id(findBy.id());
        if(!"".equals(findBy.tagName()))
            ans=By.tagName(findBy.tagName());
        if(!"".equals(findBy.className()))
            ans=By.className(findBy.className());
         return ans;
    }
    
}
