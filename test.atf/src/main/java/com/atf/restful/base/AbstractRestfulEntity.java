package com.atf.restful.base;

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
	protected OrientContext orient;
	@JsonIgnore
	protected RestfulDriver driver;

	@Override
	public String toJson() throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(this);
		return json;
	}

	@Override
	public OrientContext getOrient() {
		return orient;
	}

	@Override
	public void setOrient(OrientContext orient) {
		this.orient = orient;
	}

}
