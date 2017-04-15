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
package com.atf.hybird.server.httpsvr.handler;

import com.atf.hybird.server.httpsvr.Request;
import com.atf.hybird.server.httpsvr.Response;
import com.atf.hybird.server.httpsvr.impl.HttpRequest;
import com.atf.hybird.server.httpsvr.impl.HttpResponse;
import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author charl
 */
public class PostHtmlHandler implements Handler {
    String url;
    public PostHtmlHandler(String url){
        this.url=url;
    }
    
    @Override
    public String getUrl(){
        return this.url;
    }
    @Override
    public void handle(HttpExchange exchange) throws IOException{
        if(exchange.getRequestMethod().equalsIgnoreCase(Request.GET)){
            Request request=new HttpRequest(exchange);
            Response response=new HttpResponse(exchange);
            doGet(request,response);
        }else if(exchange.getRequestMethod().equalsIgnoreCase(Request.POST)){
            Request request=new HttpRequest(exchange);
            Response response=new HttpResponse(exchange);
            doPost(request,response);
        }else
        {
            try {
                throw new Exception("missing method!");
            } catch (Exception ex) {
                Logger.getLogger(PageLoadHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
           
    }
    
    @Override
    public void doGet(Request request,Response response){
        response.setHttpHeader("Access-Control-Allow-Origin", "*");
         if (request.getReuestURI().getPath().equals( "/favicon.ico")) {
            response.write("");
            return;
        }
        System.out.println("Html:doGet");
        @SuppressWarnings("restriction")
		Set<String> keySet = request.getRequestHeaders().keySet();
        Iterator<String> iter = keySet.iterator();
        String headers="";
        while (iter.hasNext()) {
            String key = iter.next();
            @SuppressWarnings("restriction")
			List values = request.getRequestHeaders().get(key);
            String s = key + " = " + values.toString() + "\r\n";
            headers+=s;
        }
        response.write(headers);
    }
    
    @Override
    public void doPost(Request request,Response response){
        response.setHttpHeader("Access-Control-Allow-Origin", "*");
         if (request.getReuestURI().getPath().equals( "/favicon.ico")) {
            response.write("");
            return;
        }
         System.out.println(request.getRequestBody());
    }
}
