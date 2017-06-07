package com.atf.restful;

import java.io.IOException;

import com.atf.restful.context.OrientContext;
import com.atf.restful.httpclient.HttpEndPoint;
import com.atf.restful.httpclient.HttpResponse;

/**
 * @author charlse
 * @version
 * @time 2017年3月21日 下午3:01:57
 * @desption
 */
public interface RestfulDriver {
	public RestfulDriver orientService(OrientContext request) throws Exception;

	public HttpEndPoint getEndpoint();

	public HttpResponse request() throws IOException, Exception;

	public HttpResponse request(RestfulEntity entity) throws Exception;

}
