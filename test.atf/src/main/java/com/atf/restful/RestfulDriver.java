package com.atf.restful;

import java.io.IOException;

import com.atf.restful.httpclient.HttpEndpoint;

/**
 * @author charlse
 * @version
 * @time 2017年3月21日 下午3:01:57
 * @desption
 */
public interface RestfulDriver {
	public RestfulDriver orientService(HttpEndpoint endpoint) throws Exception;

	public String request() throws IOException, Exception;

	public String request(RestfulEntity entity) throws Exception;

}
