package com.atf.hybird.server.httpsvr;

import com.atf.hybird.server.httpsvr.handler.Handler;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpServer;

public class HttpService {

    HttpServer server;

    public HttpService(String contextPath, int port) throws Exception {
        Context.createContext(contextPath);
        InetSocketAddress addr = new InetSocketAddress(8080);
        server = HttpServer.create(addr, port);
        Handler[] handlers=Context.getAllHandlers();
        for (Handler h : handlers) {
            server.createContext(h.getUrl(), h);
        }
        server.setExecutor(null);

    }

    public void start() {
        server.start();
        System.out.println("Service started!");
    }

}
