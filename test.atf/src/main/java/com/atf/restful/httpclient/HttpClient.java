package com.atf.restful.httpclient;
/**
	*@author charlse
	*@version 
	*@time 2017年3月20日 上午11:31:04
	*@desption
*/

import java.net.URI;
import java.security.cert.CertificateException;

import javax.net.ssl.SSLContext;
import javax.swing.text.html.FormSubmitEvent.MethodType;

import java.security.cert.X509Certificate;
import java.util.Iterator;
import java.util.List;
import java.io.IOException;

import org.apache.http.entity.EntityTemplate;

import org.apache.http.Header;
import org.apache.http.HttpStatus;
import org.apache.http.ParseException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.ssl.TrustStrategy;
import org.apache.http.util.EntityUtils;

import com.atf.restful.RestfulEntity;
import com.atf.restful.RestfulPostEntity;
import com.atf.restful.context.SessionContext;
import com.atf.restful.exception.MethodTypeMatchException;
import com.fasterxml.jackson.core.JsonProcessingException;

public class HttpClient {
	private HttpEndpoint endpoint;
	private CloseableHttpClient DEFAULT_HTTP_CLIENT = null;
	private RequestConfig REQUEST_CONFIG = RequestConfig.custom().setSocketTimeout(5000).setConnectTimeout(5000)
			.build();

	public HttpClient() throws Exception {
		initHttpClient();
	}

	public HttpClient(HttpEndpoint endpoint) throws Exception {
		initHttpClient();
		this.endpoint = endpoint;
	}

	public void initHttpClient() throws Exception {
		SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy() {
			public boolean isTrusted(X509Certificate[] chain, String authType) throws CertificateException {
				return true;
			}
		}).build();
		SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext);

		DEFAULT_HTTP_CLIENT = HttpClients.custom().setDefaultRequestConfig(REQUEST_CONFIG).setSSLSocketFactory(sslsf)
				.setUserAgent(
						"Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/49.0.2623.112 Safari/537.36 ")
				.disableRedirectHandling().build();
	}

	public HttpRequestBase doGet(URI uri) {
		HttpGet get = new HttpGet(uri);
		return get;
	}

	public HttpRequestBase doDelete(URI uri) {
		HttpDelete delete = new HttpDelete(uri);
		return delete;
	}

	public HttpRequestBase doPut(URI uri, RestfulEntity entity) throws JsonProcessingException {
		HttpPut put = new HttpPut(uri);
		put.setEntity(((RestfulPostEntity)entity).getPostEntity());
		return put;
	}

	public HttpRequestBase doPost(URI uri, RestfulEntity entity) throws JsonProcessingException {
		HttpPost post = new HttpPost(uri);
		post.setEntity(((RestfulPostEntity)entity).getPostEntity());
		return post;

	}

	public String invoke() throws Exception, IOException {

		if (this.endpoint.getMethodType() == HttpMethodType.POST || endpoint.getMethodType() == HttpMethodType.PUT)
			throw new MethodTypeMatchException("POST或者PUT请求没有HttpEntity！");

		HttpRequestBase request = null;
		CloseableHttpResponse response = null;
		String responseStr;
		URI uri = this.endpoint.getUri();
		try {
			switch (this.endpoint.getMethodType()) {
			case GET:
				request = doGet(uri);
				break;
			case DELETE:
				request = doDelete(uri);
				break;
			default:
				break;
			}
			if (endpoint.headers != null)
				request.setHeaders(
						(Header[]) this.endpoint.getHeaders().toArray(new Header[endpoint.getHeaders().size()]));
			response = DEFAULT_HTTP_CLIENT.execute(request, SessionContext.currentContext());

			if (HttpStatus.SC_OK != response.getStatusLine().getStatusCode()) {
				throw new Exception("HTTP请求失败，HTTP状态码=[" + response.getStatusLine() + "]");
			}

			responseStr = EntityUtils.toString(response.getEntity());
			return responseStr;
		} finally {
			if (response != null)
				closeHttpResponse(response);
			if (request != null)
				request.releaseConnection();
		}
	}

	public String invoke(RestfulEntity entity) throws Exception {
		if (this.endpoint.getMethodType() == HttpMethodType.GET || endpoint.getMethodType() == HttpMethodType.DELETE)
			throw new MethodTypeMatchException("GET或者DELETE不能带有HttpEntity！");

		HttpRequestBase request = null;
		CloseableHttpResponse response = null;
		String responseStr;
		URI uri = this.endpoint.getUri();
		try {
			switch (this.endpoint.getMethodType()) {
			case POST:
				request = doPost(uri, entity);
				break;
			case PUT:
				request = doPut(uri, entity);
				break;
			default:
				break;
			}
			request.setHeaders((Header[]) this.endpoint.getHeaders().toArray(new Header[endpoint.getHeaders().size()]));
			response = DEFAULT_HTTP_CLIENT.execute(request, SessionContext.currentContext());

			if (HttpStatus.SC_OK != response.getStatusLine().getStatusCode()) {
				throw new Exception("HTTP请求失败，HTTP状态码=[" + response.getStatusLine() + "]");
			}
			responseStr = EntityUtils.toString(response.getEntity());
			return responseStr;
		} finally {
			if (response != null)
				closeHttpResponse(response);
			if (request != null)
				request.releaseConnection();
		}
	}

	private void closeHttpResponse(CloseableHttpResponse resp) {
		if (resp != null) {
			try {
				resp.close();
			} catch (IOException e) {

			}
		}
	}

	public HttpEndpoint getEndpoint() {
		return endpoint;
	}

	public void setEndpoint(HttpEndpoint endpoint) {
		this.endpoint = endpoint;
	}
}
