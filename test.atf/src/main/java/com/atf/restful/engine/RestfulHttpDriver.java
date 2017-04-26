package com.atf.restful.engine;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;

import org.apache.http.entity.StringEntity;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.atf.restful.RestfulEntity;
import com.atf.restful.RestfulPostEntity;
import com.atf.restful.context.OrientContext;
import com.atf.restful.RestfulDriver;
import com.atf.restful.httpclient.HttpClient;
import com.atf.restful.httpclient.HttpEndPoint;
import com.atf.restful.httpclient.HttpMethodType;
import com.atf.restful.httpclient.HttpRequestParam;
import com.atf.restful.httpclient.HttpResponse;
import com.atf.restful.util.ClassParser;
import com.atf.support.Generics;

/**
 * @author charlse
 * @version
 * @time 2017年3月15日 下午3:24:02
 * @desption
 */
public class RestfulHttpDriver implements RestfulDriver {
	private HttpClient httpClient;
	private HttpEndPoint endpoint;

	public RestfulHttpDriver(String host, int port) {
		this.endpoint = new HttpEndPoint(host, port);
	}

	public HttpClient getClient() {
		return httpClient;
	}

	public void setClient(HttpClient client) {
		this.httpClient = client;
	}

	@Override
	public RestfulDriver orientService(OrientContext orientContext) throws Exception {
		this.endpoint.setPath(orientContext.getPath());
		this.endpoint.setMethodType(orientContext.getType());
		this.endpoint.setHeaders(Arrays.asList(orientContext.getHeaders()));
		return this;
	}

	@Override
	public HttpResponse request() throws IOException, Exception {
		this.httpClient = new HttpClient(this.endpoint);
		return this.httpClient.invoke();
	}

	@Override
	public HttpResponse request(RestfulEntity entity) throws Exception {
		this.httpClient = new HttpClient(this.endpoint);
		return this.httpClient.invoke(entity);
	}

	public void setHttpEndPoint(HttpEndPoint endpoint) throws Exception {
		httpClient = new HttpClient(endpoint);
	}

}
