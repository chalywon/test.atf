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
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author charl
 */
public class PageLoadHandler implements Handler {

    String url;

    public PageLoadHandler(String url) {
        this.url = url;
    }

    @Override
    public String getUrl() {
        return this.url;
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        if (exchange.getRequestMethod().equalsIgnoreCase(Request.GET)) {
            Request request = new HttpRequest(exchange);
            Response response = new HttpResponse(exchange);
            try {
                doGet(request, response);
            } catch (Exception ex) {
                Logger.getLogger(PageLoadHandler.class.getName()).log(Level.SEVERE, null, ex);
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
    public void doGet(Request request, Response response) throws IOException, Exception {
        if (request.getReuestURI().getPath().equals("/favicon.ico")) {
            response.write("");
            return;
        }
        System.out.println("PageLoad:doGet(),init page for test!");
        response.write(getTestScript().toString());
    }

    @Override
    public void doPost(Request request, Response response) {
        System.out.println("PageLoad:doPost");
    }

    public StringBuilder getTestScript() throws Exception {
        String str = "";
        try {
            FileReader reader = new FileReader("D:/webroot/test.js");
            BufferedReader br = new BufferedReader(reader);
            String line = "";
            while ((line = br.readLine()) != null) {
                str += (line + "\n");
            }
            br.close();
            reader.close();
            return new StringBuilder(str);
        } catch (Exception ex) {
            throw ex;
        }

    }

}
