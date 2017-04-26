package com.atf.restful.httpclient;

import java.util.Iterator;
import java.util.List;

import org.apache.http.Header;

/**
	*@author charlse
	*@version 
	*@time 2017年4月24日 下午5:48:17
	*@desption
*/
public class HttpResponse {
	List<Header> headers;
	String body;
	
	public HttpResponse(List<Header> headers,String body){
		this.headers=headers;
		this.body=body;
	}

	public List<Header> getHeaders() {
		return headers;
	}

	public void setHeaders(List<Header> headers) {
		this.headers = headers;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}
	

}
