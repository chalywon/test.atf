package com.atf.support.engine;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.openqa.selenium.WebDriver;

import com.atf.restful.httpclient.HttpClient;
import com.atf.support.assembly.annotations.DataProvider;
import com.atf.support.assembly.annotations.TestType;
import com.atf.support.assembly.interfaces.TestCase;
import com.atf.support.config.EnviConfig;
import com.atf.support.engine.internal.TestEngineHandler;
import com.atf.support.excepiton.NotAPITestCaseException;
import com.atf.support.excepiton.NotAPPTestCaseException;
import com.atf.support.excepiton.NotTestCaseException;
import com.atf.support.excepiton.NotWEBTestCaseException;
import com.atf.support.factory.TestCaseFactory;
import com.atf.hybird.AppDriver;

/**
 * @author charlse
 * @version
 * @time 2017年3月21日 下午5:31:31
 * @desption
 */
public class TestEngine {
	
	/*
	 * 创建API测试
	 * @param caseClazz 测试对象类型
	 * @param client 用于restful测试的http请求
	 */
	@SuppressWarnings("unchecked")
	public <T> T buildTest(Class<T> caseClazz,HttpClient client) throws Exception{
		DataProvider provider = caseClazz.getAnnotation(DataProvider.class);
		if(provider.testType()!=TestType.API)
			throw new NotAPITestCaseException(caseClazz.getTypeName());
		T testCase=null;
		TestEngineHandler<T> handler=handler = new TestEngineHandler<T>(caseClazz, client);
		testCase=(T)Proxy.newProxyInstance(caseClazz.getClassLoader(),caseClazz.getInterfaces(), handler);
		return testCase;
	}
	
	/*
	 * 创建Web测试
	 * @param caseClazz 测试对象类型
	 * @param driver selenium WebDriver
	 */
	@SuppressWarnings("unchecked")
	public <T> T buildTest(Class<T> caseClazz,WebDriver driver) throws Exception{
		DataProvider provider = caseClazz.getAnnotation(DataProvider.class);
		if(provider.testType()!=TestType.WEB)
			throw new NotWEBTestCaseException(caseClazz.getTypeName());
		T testCase=null;
		TestEngineHandler<T> handler=new TestEngineHandler<T>(caseClazz, driver);
		testCase=(T)Proxy.newProxyInstance(caseClazz.getClassLoader(),caseClazz.getInterfaces(), handler);
		return testCase;
	}
	
	/*
	 * 创建Web测试
	 * @param caseClazz 测试对象类型
	 * @param driver Hybird AppDriver
	 */
	
	@SuppressWarnings("unchecked")
	public <T> T buildTest(Class<T> caseClazz,AppDriver driver) throws Exception{
		DataProvider provider = caseClazz.getAnnotation(DataProvider.class);
		if(provider.testType()!=TestType.API)
			throw new NotAPPTestCaseException(caseClazz.getTypeName());
		T testCase=null;
		TestEngineHandler<T> handler=new TestEngineHandler<T>(caseClazz, driver);
		testCase=(T)Proxy.newProxyInstance(caseClazz.getClassLoader(),caseClazz.getInterfaces(), handler);
		return testCase;
	}

}
