package com.atf.restful.httpclient;

import java.util.Map;

/**
	*@author charlse
	*@version 
	*@time 2017年3月21日 上午11:19:30
	*@desption
*/
public class HttpRequestParam{
	
	private String name;
	private String value;
	
	public HttpRequestParam(){
		
	}
	
	public HttpRequestParam(String name,String value){
		this.name=name;
		this.value=value;
	}
	
	public String getParaPair(){
		return this.name+"="+this.value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	

}
