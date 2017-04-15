package com.atf.support.engine.internal;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;

import com.atf.restful.httpclient.HttpClient;
import com.atf.support.assembly.annotations.DataProvider;
import com.atf.support.assembly.annotations.TestType;
import com.atf.support.assembly.interfaces.TestCase;
import com.atf.support.excepiton.NotTestCaseException;
import com.atf.support.factory.TestCaseFactory;
import com.atf.hybird.AppDriver;

/**
	*@author charlse
	*@version 
	*@time 2017年3月21日 下午5:31:31
	*@desption
*/
public class TestEngineHandler<T> implements InvocationHandler {
	
	private final Class<T> caseClazz;
	private T testCase;
	private Object obj;
	
	public TestEngineHandler(Class<T> caseClazz,Object obj) throws Exception{
		
		super();
		this.caseClazz=caseClazz;
		this.obj=obj;
		initObject();
	}
	
	private void initObject() throws Exception{
		if(!TestCase.class.isAssignableFrom(caseClazz)){
			throw new NotTestCaseException(caseClazz.getTypeName());
		}
		
		DataProvider provider=caseClazz.getAnnotation(DataProvider.class);
		switch(provider.testType()){
		case WEB:
			testCase=TestCaseFactory.initWebTestCase((WebDriver)obj, caseClazz);
			break;
		case APP:
			testCase=TestCaseFactory.initAppTestCase((AppDriver)obj, caseClazz);
		case API:
			testCase=TestCaseFactory.initRestTestCase((HttpClient)obj, caseClazz);
		}
		
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		return method.invoke(testCase, args);
	}

}
