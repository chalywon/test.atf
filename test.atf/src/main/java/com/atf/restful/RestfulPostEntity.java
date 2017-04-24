package com.atf.restful;

import org.apache.http.entity.StringEntity;

import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * @author charlse
 * @version
 * @time 2017年3月30日 下午2:55:15
 * @desption
 */
public interface RestfulPostEntity extends RestfulEntity {

	public StringEntity getPostEntity() throws JsonProcessingException;

	public RestfulEntity post(Class<?> clazz) throws Exception;

	public String post() throws Exception;

	public RestfulDriver getDriver();

	public void setDriver(RestfulDriver driver);

}
