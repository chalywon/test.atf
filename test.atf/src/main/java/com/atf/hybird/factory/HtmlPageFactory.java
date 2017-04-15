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
package com.atf.hybird.factory;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import com.atf.hybird.AppDriver;
import com.atf.hybird.factory.htmlpage.ElementLocatorFactory;
import com.atf.hybird.factory.htmlpage.FieldDecorator;
import com.atf.hybird.factory.htmlpage.HtmlElementLocatorFactory;
import com.atf.hybird.factory.htmlpage.HtmlFieldDecorator;

/**
 *
 * @author charl
 */
public class HtmlPageFactory {
    
    public static<T> T initPageElements(AppDriver driver, Class<T> pageClassToProxy) throws Exception{
        T page=instantiatePage(driver, pageClassToProxy);
        initElements(driver,page);
        return page;
    }

    public static void initElements(AppDriver driver,Object page) throws Exception{
        final AppDriver driverRef=driver;
        initElements(new HtmlElementLocatorFactory(driverRef),page);
    }
    
    public static void initElements(ElementLocatorFactory factory,Object page) throws Exception{
        final ElementLocatorFactory factoryRef=factory;
        initElements(new HtmlFieldDecorator(factoryRef),page);
    }
    
    public static void initElements(FieldDecorator decorator, Object page) throws Exception {
        Class<?> proxyIn = page.getClass();
        while (proxyIn != Object.class) {
            proxyFields(decorator, page, proxyIn);
            proxyIn = proxyIn.getSuperclass();
        }
        
    }
    
    private static  void proxyFields(FieldDecorator decorator,Object page,Class<?> proxyIn) throws Exception{
        Field[] fields=proxyIn.getDeclaredFields();
        for(Field field:fields){
            Object value=decorator.decorate(page.getClass().getClassLoader(), field);
            if(value!=null){
                field.setAccessible(true);
                field.set(page, value);
            }
        }
    }
    
    
    private static <T> T instantiatePage(AppDriver driver, Class<T> pageClassToProxy) {
        try {
            try {
                Constructor<T> constructor = pageClassToProxy.getConstructor(AppDriver.class);
                return constructor.newInstance(driver);
            } catch (NoSuchMethodException e) {
                return pageClassToProxy.newInstance();
            }
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}
