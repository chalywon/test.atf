package com.atf.restful;

import com.atf.restful.context.OrientContext;
import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * @author charlse
 * @version
 * @time 2017年3月30日 下午2:55:15
 * @desption
 */
public interface RestfulGetEntity extends RestfulEntity {

	public String getParams() throws JsonProcessingException;

	public RestfulEntity get(Class<?> clazz) throws Exception;

	public String get() throws Exception;

	public RestfulDriver getDriver();

	public void setDriver(RestfulDriver driver);
	
	public void setOrientContext(OrientContext orientContext);
	
	public OrientContext getOrientContext(OrientContext orientContext);
}
