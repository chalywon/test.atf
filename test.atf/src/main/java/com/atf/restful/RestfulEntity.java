package com.atf.restful;

import java.util.List;

import org.apache.http.Header;

import com.atf.restful.context.OrientContext;
import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * @author charlse
 * @version
 * @time 2017年3月22日 上午10:42:37
 * @desption
 */
public interface RestfulEntity {

	public String toJson() throws JsonProcessingException;

	public void setOrientContext(OrientContext orientContext);

	public OrientContext getOrientContext();
	
	public List<Header> getHeaders();
	
	public void setHeaders(List<Header> headers);
}
