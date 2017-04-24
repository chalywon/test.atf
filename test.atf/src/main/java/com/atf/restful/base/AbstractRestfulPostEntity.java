package com.atf.restful.base;

import org.apache.http.entity.StringEntity;
import com.atf.restful.RestfulEntity;
import com.atf.restful.RestfulPostEntity;
import com.atf.restful.context.OrientContext;
import com.atf.restful.RestfulDriver;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author charlse
 * @version
 * @time 2017年3月23日 下午3:13:24
 * @desption
 */
public abstract class AbstractRestfulPostEntity extends AbstractRestfulEntity implements RestfulPostEntity {

	public AbstractRestfulPostEntity() {
	}

	public AbstractRestfulPostEntity(RestfulDriver driver) {
		this.driver = driver;
	}

	@JsonIgnore
	public StringEntity getPostEntity() throws JsonProcessingException {
		StringEntity entity = new StringEntity(toJson(), "UTF-8");
		return entity;
	}

	@JsonIgnore
	public RestfulEntity post(Class<?> clazz) throws Exception {
		String json = this.driver.request(this);
		ObjectMapper mapper = new ObjectMapper();
		RestfulEntity entity = (RestfulEntity) mapper.readValue(json, clazz);
		return entity;
	}

	@JsonIgnore
	public String post() throws Exception {
		String json = this.driver.request(this);
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
