package com.atf.restful.base;

import java.io.IOException;

import org.apache.http.entity.StringEntity;

import com.atf.restful.RestfulEntity;
import com.atf.restful.RestfulGetEntity;
import com.atf.restful.RestfulPostEntity;
import com.atf.restful.engine.RestfulHttpDriver;
import com.atf.restful.RestfulDriver;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author charlse
 * @version
 * @time 2017年3月23日 下午3:13:24
 * @desption
 */
public abstract class AbstractRestfulGetEntity extends AbstractRestfulEntity implements RestfulGetEntity {

	@JsonIgnore
	protected RestfulDriver driver;

	public AbstractRestfulGetEntity() {
	}

	public AbstractRestfulGetEntity(RestfulDriver driver) {
		this.driver = driver;
	}

	@JsonIgnore
	public String getParams() throws JsonProcessingException {
		return null;
	}

	@JsonIgnore
	public RestfulEntity get(Class<?> clazz) throws Exception {
		String json = this.driver.request(this).getBody();
		ObjectMapper mapper = new ObjectMapper();
		RestfulEntity entity = (RestfulEntity) mapper.readValue(json, clazz);
		return entity;
	}

	@JsonIgnore
	public String get() throws Exception {
		String json = this.driver.request(this).getBody();
		return json;

	}

	@JsonIgnore
	public RestfulDriver getDriver() {
		return this.driver;
	}

	public void setDriver(RestfulDriver driver) {
		this.driver = driver;
	}

}
