package com.atf.restful.context;

import java.util.List;

import org.apache.http.Header;
import org.apache.http.message.BasicHeader;

import com.atf.restful.httpclient.HttpMethodType;

/**
 * @author charlse
 * @version
 * @time 2017年4月24日 上午10:05:01
 * @desption
 */
public class OrientContext {
	String path;
	HttpMethodType type;
	Header[] headers;
	
	public OrientContext(){
		
	}

	public OrientContext(String path, HttpMethodType type, Header... headers) {
		this.path = path;
		this.type = type;
		this.headers = headers;
	}
	

	public OrientContext(String path, HttpMethodType type, List<Header> headers) {
		int size = headers.size();
		Header[] headersParseFromList = headers.toArray(new Header[size]);
		this.path = path;
		this.type = type;
		this.headers = headersParseFromList;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public HttpMethodType getType() {
		return type;
	}

	public void setType(HttpMethodType type) {
		this.type = type;
	}

	public Header[] getHeaders() {
		return headers;
	}

	public void setHeaders(Header[] headers) {
		this.headers = headers;
	}

	public void setHeaders(List<Header> headers) {
		int size = headers.size();
		Header[] headersParseFromList = headers.toArray(new Header[size]);
		this.headers = headersParseFromList;
	}

	public void addHeader(Header header) {
		if (this.headers == null) {
			this.headers = new Header[] { header };
		} else {
			int size = this.headers.length;
			Header[] newHeaders = new Header[size + 1];
			System.arraycopy(this.headers, 0, newHeaders, 0, size);
			newHeaders[size] = header;
			this.headers = newHeaders;
		}
	}

	public void addHeader(String name, String value) {
		BasicHeader header = new BasicHeader(name, value);
		addHeader(header);
	}
	
	public Header getHeader(String name){
		for(Header h:this.headers){
			if(h.getValue().equals(name))
				return h;
		}
		return null;
	}
}
