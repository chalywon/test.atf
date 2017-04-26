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
package com.atf.hybird.server.httpsvr;

import com.atf.hybird.server.httpsvr.handler.Handler;
import com.atf.support.XmlUtils;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author charl
 */
public class Context {
    private static Map<String,Handler> handlers;
    public static String contextPath;
    public static void createContext(String contextPath) throws Exception{
        handlers=new HashMap();
        Document document=XmlUtils.load(contextPath);
        Element root=document.getDocumentElement();
        List<Element> elementHandlers=XmlUtils.getChildrenByTagName(root, "handler");
        for(Element e:elementHandlers){
            String name=XmlUtils.getAttribute(e, "name");
            String handler_class=XmlUtils.getChildText(e, "handler-class");
            String url_pattern=XmlUtils.getChildText(e, "url-pattern");
            Class<?> cls=Class.forName(handler_class);
            Constructor construstor=cls.getDeclaredConstructor(String.class);
            Handler newInstance=(Handler)construstor.newInstance(url_pattern);
            handlers.put(name, newInstance);
        }
    }
    public static Handler getHandler(String name){
        return handlers.get(name);
        }
    
    public static Handler[] getAllHandlers(){
        return handlers.values().toArray(new Handler[handlers.size()]);
    }
    
}
