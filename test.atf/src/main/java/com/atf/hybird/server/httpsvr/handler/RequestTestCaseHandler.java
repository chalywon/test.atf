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
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author charl
 */
public class RequestTestCaseHandler implements Handler {

    String url;

    public static String WEB_ROOT;
    private final String CREATESESSIONSTORAGEITEM = "window.sessionStorage.setItem(\"uuid\",\"00000000-0000-0000-0000-000000000000\");\n";
    private final String TESTSUITEID = "00000000-0000-0000-0000-000000000000";
    private int port;
    final String MIMEType = "text/html";
    private byte[] header;
    Map<String, String> testSession = new HashMap();

    public RequestTestCaseHandler(String url) {
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
                Logger.getLogger(RequestTestCaseHandler.class.getName()).log(Level.SEVERE, null, ex);
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
        if (query.contains("uuid")) {
            String testSuiteId = query.split("=")[1];
            if ("null".equals(testSuiteId)) {
                System.out.println("RequestTestCase:doGet");
                String uuid = UUID.randomUUID().toString().toUpperCase();
                testSession.put(uuid, uuid);
                int index = CREATESESSIONSTORAGEITEM.indexOf(TESTSUITEID);
                int length = TESTSUITEID.length();
                String testScript = new StringBuilder(CREATESESSIONSTORAGEITEM).replace(index, index + length, uuid).toString();
                //执行测试用例
                System.out.println("Testcase request,create new test suite testid=" + uuid);
                System.out.println("Generate test Script!");
                AppDriver driver=new HybirdDriver();
                TestCaseStep1 testcase=TestCaseFactory.initAppTestCase(driver, TestCaseStep1.class);
                testScript += testcase.runTest();
                response.write(testScript);
                System.out.println("Run test Script!");
            } else {
                System.out.println("Testcase request," + testSuiteId + " is exists,continue test!");
                System.out.println("Generate test Script!");
                //执行测试用例
                AppDriver driver=new HybirdDriver();
                TestCaseStep2 testcase = TestCaseFactory.initAppTestCase(driver,TestCaseStep2.class);
                String testScript = testcase.runTest();
                response.write(testScript);
                System.out.println("Run test Script!");
            }
        }
    }

    @Override
    public void doPost(Request request, Response response) {
        System.out.println("RequestTestCase:doPost");
    }
}
