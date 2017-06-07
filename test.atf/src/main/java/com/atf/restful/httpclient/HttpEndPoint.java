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
	OrientContext orient;
	List<HttpRequestParam> params;
	int port;

	public HttpEndPoint(String host, int port, OrientContext orient) {
		this.host = host;
		this.port = port;
	}

	public HttpEndPoint(String host, int port) {
		this.host = host;
		this.port = port;
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
		return this.orient.getPath();
	}

	public void setPath(String resource) {
		this.orient.setPath(resource);
	}

	public List<HttpRequestParam> getParams() {
		return this.params;
	}

	public void setParams(List<HttpRequestParam> params) {
		this.params = params;
	}

	public URI getUri() throws URISyntaxException {
		return this.formatURI();
	}

	public HttpMethodType getMethodType() {
		return this.orient.getType();
	}

	public void setMethodType(HttpMethodType methodType) {
		this.orient.setType(methodType);
	}

	public void addParam(HttpRequestParam para) {
		if (this.params == null)
			this.params = new ArrayList<HttpRequestParam>();
		this.params.add(para);
	}

	public void addHeader(String name, String value) {
		this.orient.addHeader(new BasicHeader(name, value));
	}

	public URI formatURI() throws URISyntaxException {
		String paramsStr = "";
		if (this.params != null)
			paramsStr = "?" + getParamsStr();
		String url = "";
		if (this.port != 80)
			url = "http://" + this.host + ":" + this.port + "/" + this.orient.getPath() + paramsStr;
		else
			url = "http://" + this.host + "/" + this.orient.getPath() + paramsStr;
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
		return Arrays.asList(this.orient.getHeaders());
	}

	public void setHeaders(List<Header> headers) {
		this.orient.setHeaders(headers);
	}

	public OrientContext getOrient() {
		return this.orient;
	}

	public void setOrient(OrientContext orient) {
		this.orient = orient;
	}

}
