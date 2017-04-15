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

import com.atf.hybird.server.httpsvr.Response;
import java.io.IOException;
import java.io.OutputStream;

import com.sun.net.httpserver.HttpExchange;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author charl
 */
public class HttpResponse implements Response {

    @SuppressWarnings("restriction")
	private final HttpExchange httpExchange;

    public HttpResponse(@SuppressWarnings("restriction") HttpExchange httpExchange) {
        this.httpExchange = httpExchange;
    }

    @Override
    public void write(String result) {
        try {
            byte[] byteOut = result.getBytes("utf-8");
            write(byteOut);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(HttpResponse.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("restriction")
	@Override
    public void write(byte[] result) {
        try {
            httpExchange.sendResponseHeaders(200, result.length);// 设置响应头属性及响应信息的长度  
            OutputStream out = httpExchange.getResponseBody(); // 获得输出流  
            out.write(result);
            out.flush();
            httpExchange.close();
        } catch (IOException e) {
        }
    }

    @SuppressWarnings("restriction")
	@Override
    public void setHttpHeader(String key, String value) {
        httpExchange.getResponseHeaders().set(key, value);
    }

    @SuppressWarnings("restriction")
	@Override
    public void addHttpHeader(String key, String value) {
        httpExchange.getResponseHeaders().add(key, value);
    }

    @SuppressWarnings("restriction")
	@Override
    public void sendResponseHeaders(int code, long length) throws IOException {
        httpExchange.sendResponseHeaders(code, length);
    }

}
