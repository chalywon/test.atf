package com.atf.restful.base;

import java.util.Iterator;
import java.util.List;

import org.apache.http.Header;

import com.atf.restful.RestfulDriver;
import com.atf.restful.RestfulEntity;
import com.atf.restful.context.OrientContext;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author charlse
 * @version
 * @time 2017年4月14日 下午3:33:07
 * @desption
 */
public class AbstractRestfulEntity implements RestfulEntity {
	@JsonIgnore
	protected RestfulDriver driver;
	@JsonIgnore
	protected List<Header> headers;

	@Override
	public String toJson() throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(this);
		return json;
	}


	@Override
	public List<Header> getHeaders() {
		return this.headers;
	}

	@Override
	public void setHeaders(List<Header> headers) {
		this.headers = headers;
	}

	public Header getHeader(String headerName) {
		Iterator<Header> it = this.headers.iterator();
		while (it.hasNext()) {
			Header header = it.next();
			if (header.getName().equals(headerName))
				return header;
		}
		return null;
	}

}
