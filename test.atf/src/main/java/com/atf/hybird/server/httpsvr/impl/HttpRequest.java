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
package com.atf.hybird.server.httpsvr.impl;
import com.atf.hybird.server.httpsvr.Request;
import com.sun.net.httpserver.Headers;
import java.io.BufferedReader;  
import java.io.IOException;  
import java.io.InputStream;  
import java.io.InputStreamReader;  
import java.net.URI;  
import java.util.HashMap;  
import java.util.List;  
import java.util.Map;  
import com.sun.net.httpserver.HttpExchange;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author charl
 */
public class HttpRequest implements Request {  
    private HttpExchange httpExchange;  
    private Map<String, String> paramMap = new HashMap<String, String>();  
    private Map<String, List<String>> headMap = new HashMap<String, List<String>>();  
    private String requestBody = "";  
  
    public HttpRequest(HttpExchange httpExchange) {  
        this.httpExchange = httpExchange; 
        this.initRequestHeader();
        this.initRequestParam();
        this.initRequestBody();
    }  
  
    @Override  
    public String getParamter(String param) {  
        return paramMap.get(param);  
    }  
  
    @Override  
    public String getMethod() {  
        return httpExchange.getRequestMethod().trim().toUpperCase();  
    }  
  
    @Override  
    public URI getReuestURI() {  
        return httpExchange.getRequestURI();  
    }  
    
    @Override
    public Headers getRequestHeaders(){
        return httpExchange.getRequestHeaders();
    }
  
    private void initRequestParam() {
        String query = getReuestURI().getQuery();
        if (query != null) {
            String[] arrayStr = query.split("&");
            for (String str : arrayStr) {
                paramMap.put(str.split("=")[0], str.split("=")[1]);
            }
        }

    } 
  
    @SuppressWarnings("restriction")
	private void initRequestHeader() {  
        for(String s : httpExchange.getRequestHeaders().keySet()){  
            headMap.put(s, httpExchange.getRequestHeaders().get(s));  
        }  
    }  
  
    private void initRequestBody()  {  
        InputStreamReader inSR = null;  
        try {  
            @SuppressWarnings("restriction")
			InputStream in = httpExchange.getRequestBody(); // 获得输入流
            inSR = new InputStreamReader(in,"UTF-8");
            BufferedReader br = new BufferedReader(inSR);
            String temp = null;
            try {  
                while ((temp = br.readLine()) != null) {
                    requestBody += temp+"\n";
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (UnsupportedEncodingException ex) {  
            Logger.getLogger(HttpRequest.class.getName()).log(Level.SEVERE, null, ex);  
        } finally {
            try {
                inSR.close();
            } catch (IOException ex) {
                Logger.getLogger(HttpRequest.class.getName()).log(Level.SEVERE, null, ex);
            }
        }  
    }  
  
    @Override  
    public String getRequestBody() {  
        return requestBody;  
    }  
}  
