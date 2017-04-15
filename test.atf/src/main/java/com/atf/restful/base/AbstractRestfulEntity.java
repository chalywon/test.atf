package com.atf.restful.base;

import com.atf.restful.RestfulEntity;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
	*@author charlse
	*@version 
	*@time 2017年4月14日 下午3:33:07
	*@desption
*/
public class AbstractRestfulEntity implements RestfulEntity {

	@Override
	public String toJson() throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(this);
		return json;
	}

}
