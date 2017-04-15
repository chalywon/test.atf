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
package com.atf.hybird.testbuilder.internal;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.dom4j.DocumentException;

import com.atf.support.assembly.annotations.DataValidate;
import com.atf.support.assembly.interfaces.DataField;
import com.atf.support.factory.TestCaseFactory;

/**
 *
 * @author charl
 */
public class DataFieldValidateHandler<T> implements InvocationHandler {

    private final Class<T> dataFieldClass;
    private final String dataFieldName;

    public DataFieldValidateHandler(Class<T> dataFieldClass, String dataFieldName) {
        this.dataFieldClass = dataFieldClass;
        this.dataFieldName = dataFieldName;
    }

    @Override
    public Object invoke(Object object, Method method, Object[] args) throws Throwable {
        if(dataFieldClass.getClass().isAssignableFrom(DataField.class)){
            Field[] fields=dataFieldClass.getDeclaredFields();
            for(Field f:fields){
                f.getAnnotation(DataValidate.class);
            }
        }
        
        return null;
    }

}
