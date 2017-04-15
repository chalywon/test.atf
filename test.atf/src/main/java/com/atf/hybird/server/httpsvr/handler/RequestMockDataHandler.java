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

import com.atf.hybird.AppDriver;
import com.atf.hybird.implement.HybirdDriver;
import com.atf.hybird.server.httpsvr.Request;
import com.atf.hybird.server.httpsvr.Response;
import com.atf.hybird.server.httpsvr.impl.HttpRequest;
import com.atf.hybird.server.httpsvr.impl.HttpResponse;
import com.atf.hybird.server.testcase.TestCaseStep1;
import com.atf.hybird.server.testcase.TestCaseStep2;
import com.atf.support.factory.TestCaseFactory;
import com.sun.net.httpserver.HttpExchange;
import java.io.FileInputStream;
import java.io.IOException;
import static java.lang.System.in;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author charl
 */
public class RequestMockDataHandler implements Handler {

    String url;
    final String MIMEType = "text/html";
    Map<String, String> testSession = new HashMap<String, String>();

    public RequestMockDataHandler(String url) {
        this.url = url;
    }

    @Override
    public String getUrl() {
        return this.url;
    }

    @SuppressWarnings("restriction")
	@Override
    public void handle(@SuppressWarnings("restriction") HttpExchange exchange) throws IOException {
        if (exchange.getRequestMethod().equalsIgnoreCase(Request.GET)) {
            Request request = new HttpRequest(exchange);
            Response response = new HttpResponse(exchange);
            try {
                doGet(request, response);
            } catch (Exception ex) {
                Logger.getLogger(RequestMockDataHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (exchange.getRequestMethod().equalsIgnoreCase(Request.POST)) {
            Request request = new HttpRequest(exchange);
            Response response = new HttpResponse(exchange);
            doPost(request, response);
        } else {
            try {
                throw new Exception("missing method!");
            } catch (Exception ex) {
                Logger.getLogger(PageLoadHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    @Override
    public void doGet(Request request, Response response) throws Exception {
        if (request.getReuestURI().getPath().equals("/favicon.ico")) {
            response.write("");
            return;
        }
        
        String query = request.getReuestURI().getQuery();
        if (query.contains("api")) {
            String apiName = query.split("=")[1];
            if (!"null".equals(apiName)) {
            
            FileInputStream in = new FileInputStream("D:\\jason.txt");
            byte[] tempbytes = new byte[in.available()];
            in.read(tempbytes);
            response.write(tempbytes);
            in.close();
            } 
        }
    }

    @Override
    public void doPost(Request request, Response response) {
        System.out.println("RequestTestCase:doPost");
    }
}
