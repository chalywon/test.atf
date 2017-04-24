package com.atf.restful.httpclient;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.apache.http.Header;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.message.BasicHeader;

import com.atf.restful.context.OrientContext;
import com.google.common.net.HttpHeaders;

/**
 * @author charlse
 * @version
 * @time 2017年3月20日 下午3:55:48
 * @desption
 */
public class HttpEndPoint {

	String host;
	String path;
	OrientContext orient;
	List<Header> headers;
	List<HttpRequestParam> params;
	int port;
	HttpMethodType methodType;

	public HttpEndPoint(String host, int port, String path, HttpMethodType methodType) throws URISyntaxException {
		this.host = host;
		this.port = port;
		this.path = path;
		this.methodType = methodType;
		this.headers = new ArrayList<Header>();
		headers.add(new BasicHeader(HttpHeaders.CONTENT_TYPE, "application/json"));
	}
	
	public HttpEndPoint(String host,int port,OrientContext orient){
		this.host=host;
		this.port=port;
		this.path=orient.getPath();
		this.headers=Arrays.asList(orient.getHeaders());
	}
	
	public HttpEndPoint(String host,int port){
		this.host=host;
		this.port=port;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String endpoint) {
		this.host = endpoint;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String resource) {
		this.path = resource;
	}

	public List<HttpRequestParam> getParams() {
		return params;
	}

	public void setParams(List<HttpRequestParam> params) {
		this.params = params;
	}

	public URI getUri() throws URISyntaxException {
		return this.formatURI();
	}

	public HttpMethodType getMethodType() {
		return methodType;
	}

	public void setMethodType(HttpMethodType methodType) {
		this.methodType = methodType;
	}

	public void addParam(HttpRequestParam para) {
		if (this.params == null)
			this.params = new ArrayList<HttpRequestParam>();
		this.params.add(para);
	}

	public void addHeader(String name, String value) {
		if (this.headers == null)
			this.headers = new ArrayList<Header>();
		this.headers.add(new BasicHeader(name, value));
	}

	public URI formatURI() throws URISyntaxException {
		String paramsStr = "";
		if (this.params != null)
			paramsStr = "?" + getParamsStr();
		String url="";
		if (this.port != 80)
			url = "http://"+this.host + ":" + this.port + "/" + this.path + paramsStr;
		else
			url = "http://"+this.host + "/" + this.path + paramsStr;
		URIBuilder builder = new URIBuilder(url.trim()).setCharset(Charset.forName("UTF-8"));
		return builder.build();
	}

	private String getParamsStr() {
		String paramStr = "";

		Iterator<HttpRequestParam> it = this.params.iterator();
		while (it.hasNext()) {
			HttpRequestParam param = it.next();
			paramStr += param.getParaPair() + "&";
		}
		return paramStr.substring(0, paramStr.length() - 1);
	}

	public List<Header> getHeaders() {
		return headers;
	}

	public void setHeaders(List<Header> headers) {
		this.headers = headers;
	}

	public OrientContext getOrient() {
		return orient;
	}

	public void setOrient(OrientContext orient) {
		this.orient = orient;
		this.methodType=orient.getType();
		this.path=orient.getPath();
		this.headers=Arrays.asList(orient.getHeaders());
	}

}
