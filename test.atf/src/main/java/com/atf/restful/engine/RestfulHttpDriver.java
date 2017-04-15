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
import com.atf.restful.RestfulDriver;
import com.atf.restful.httpclient.HttpClient;
import com.atf.restful.httpclient.HttpEndpoint;
import com.atf.restful.httpclient.HttpRequestParam;
import com.atf.restful.util.ClassParser;
import com.atf.support.util.Generics;

/**
 * @author charlse
 * @version
 * @time 2017年3月15日 下午3:24:02
 * @desption
 */
public class RestfulHttpDriver implements RestfulDriver {
	private HttpClient httpClient;

	public RestfulHttpDriver() {

	}

	public RestfulHttpDriver(HttpEndpoint endpoint) throws Exception {
		httpClient = new HttpClient(endpoint);
	}


	public HttpClient getClient() {
		return httpClient;
	}

	public void setClient(HttpClient client) {
		this.httpClient = client;
	}

	@Override
	public RestfulDriver orientService(HttpEndpoint endpoint) throws Exception {
		httpClient = new HttpClient(endpoint);
		return this;
	}

	@Override
	public String request() throws IOException, Exception {
		return this.httpClient.invoke();
	}

	@Override
	public String request(RestfulEntity entity) throws Exception {
		return this.httpClient.invoke(entity);
	}

}
