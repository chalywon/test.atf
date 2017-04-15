/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atf.support.factory;

import java.util.*;
import java.util.Iterator;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

import com.atf.hybird.AppDriver;
import com.atf.restful.httpclient.HttpClient;
import com.atf.support.assembly.annotations.DataProvider;
import com.atf.support.assembly.compnents.DataField;
import com.atf.support.assembly.compnents.DataFieldGroup;

import org.openqa.selenium.WebDriver;

/**
 *
 * @author charl
 */
public class TestCaseFactory {
    /*
     * 
     * 初始化APP测试用例
     * @param driver 
     * @param caseClazz 定义测试用例的类型
     * 
     */
    public static<S> S initAppTestCase(AppDriver driver,Class<S> caseClazz) throws Exception{
        String caseName;
        
        caseName=caseClazz.getAnnotation(DataProvider.class).value();
        DataFieldGroup pageElements=TestDataFactory.initFields(caseName);
        Constructor<S> cons=caseClazz.getConstructor(AppDriver.class);
        S testcase=(S)cons.newInstance(driver);
        Field fieldTestName=caseClazz.getDeclaredField("testCaseName");
        fieldTestName.setAccessible(true);
        fieldTestName.set(testcase, caseName);
        for(Map.Entry<String,DataField> entry:pageElements.entrySet()){
            String key=entry.getKey();
            DataField p=entry.getValue();
            Field field=caseClazz.getDeclaredField(key);
            field.setAccessible(true);
            field.set(testcase, p.getValue());
            
        }
        return testcase;
    }
    
    /*
     * 
     * 初始化APP测试用例
     * @param client Restful API调用的http Client类 
     * @param caseClazz 定义测试用例的类型
     * 
     */
    
    public static<R> R initRestTestCase(HttpClient client,Class<R> caseClazz) throws Exception{
    	String caseName;
    	caseName=caseClazz.getAnnotation(DataProvider.class).value();
    	DataFieldGroup fieldGroup=TestDataFactory.initFields(caseName);
    	Constructor<R> cons=caseClazz.getConstructor();
    	R testCase=(R)cons.newInstance();
    	Field field=caseClazz.getDeclaredField("testCaseName");
    	field.setAccessible(true);
    	field.set(testCase, caseName);
    	for(Map.Entry<String, DataField> entry:fieldGroup.entrySet()){
    		String key=entry.getKey();
    		DataField value=entry.getValue();
    		Field f=caseClazz.getDeclaredField(key);
    		f.setAccessible(true);
    		f.set(testCase,value.getValue());
    	}
    	
    	return testCase;
    }
    
    
    /*
     * 
     * 初始化APP测试用例
     * @param driver 
     * @param caseClazz 定义测试用例的类型
     * 
     */
    public static <T> T initWebTestCase(WebDriver driver,Class<T> caseClass) throws Exception {
        String caseName;
        caseName = caseClass.getAnnotation(DataProvider.class).value();
        DataFieldGroup fieldGroup = TestDataFactory.initFields(caseName);
        Constructor<T> cons = caseClass.getConstructor();
        @SuppressWarnings("unchecked")
		T testCase = (T) cons.newInstance();
        Field field = caseClass.getDeclaredField("testCaseName");
        field.setAccessible(true);
        field.set(testCase, caseName);
        for (Map.Entry<String, DataField> entry : fieldGroup.entrySet()) {
            String key = entry.getKey();
            DataField p = entry.getValue();
            Field fd = caseClass.getDeclaredField(key);
            fd.setAccessible(true);
            fd.set(testCase, p.getValue());
        }
        return testCase;
    }
}
