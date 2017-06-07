package com.atf.restful.base;

import org.apache.http.entity.StringEntity;
import com.atf.restful.RestfulEntity;
import com.atf.restful.RestfulPostEntity;
import com.atf.restful.context.OrientContext;
import com.atf.restful.httpclient.HttpResponse;
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

	public AbstractRestfulPostEntity(RestfulDriver driver) throws Exception {
		this.driver = driver;
	}

	@JsonIgnore
	public StringEntity getPostEntity() throws JsonProcessingException {
		StringEntity entity = new StringEntity(toJson(), "UTF-8");
		return entity;
	}

	@JsonIgnore
	public RestfulEntity post(Class<?> clazz) throws Exception {
		HttpResponse reponse=this.driver.request(this);
		String json = reponse.getBody();
		ObjectMapper mapper = new ObjectMapper();
		RestfulEntity entity = (RestfulEntity) mapper.readValue(json, clazz);
		entity.setHeaders(reponse.getHeaders());
		return entity;
	}

	@JsonIgnore
	public String post() throws Exception {
		String json = this.driver.request(this).getBody();
		return json;

	}

	@JsonIgnore
	public RestfulDriver getDriver() {
		return this.driver;
	}

	public void setDriver(RestfulDriver driver) throws Exception {
		this.driver = driver;
	}

}
