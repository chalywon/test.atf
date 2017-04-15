package com.atf.restful;

import com.fasterxml.jackson.core.JsonProcessingException;

/**
	*@author charlse
	*@version 
	*@time 2017年3月22日 上午10:42:37
	*@desption
*/
public interface RestfulEntity {
	
	public String toJson() throws JsonProcessingException;
}
