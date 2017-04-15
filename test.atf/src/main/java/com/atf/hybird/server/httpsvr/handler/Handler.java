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
import com.sun.net.httpserver.HttpHandler;
/**
 *
 * @author charl
 */
public interface Handler extends HttpHandler{
    public void doGet(Request request,Response response) throws Exception;
    public void doPost(Request request,Response response);
     public String getUrl();
    
}