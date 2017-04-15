/*
 * Copyright 2016 charl.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.atf.hybird.testbuilder;

import com.atf.support.assembly.interfaces.TestCase;
import com.atf.support.config.EnviConfig;
import com.atf.webtest.testengine.internal.TestBuilderHandler;

import java.lang.reflect.Proxy;
import java.lang.reflect.Field;
import java.util.HashMap;


/**
 *
 * @author charl
 * @param <T>
 */
public class TestBuilder extends HashMap<String,TestCase> {
    //static TestCase testcase;
    public TestBuilder(String configFile,String type){
        super();
       // String configFile1="./src/test/java/suppliers/configuration/frameworkConfig.properties";
       if("app".equals(type)){
        buildAppTestEnv(configFile);
       }else
       {
           buildWebTestEnv(configFile);
       }
    }
    
    public void ValidateDataFields(Class<?> pageObjectClass){
        Field[] fields=pageObjectClass.getDeclaredFields();
        for(Field field:fields){
            
        }
    }
    
    
    public static void buildWebTestEnv(String configFile){
      //String configFile="./src/test/java/suppliers/configuration/frameworkConfig.properties";
      EnviConfig.configTest(configFile); 
      EnviConfig.configBrowser();
    }
    
    public static void buildAppTestEnv(String configFile){
        EnviConfig.configTest(configFile); 
        EnviConfig.configAppDriver();
    }
   
    public  void buildTests(TestCase[] testcases){
        
    }
    
    public  void buildTests(String folder){
        
    }
    
    public <T> T buildTest(java.lang.Class<T> testCaseClass) throws Exception{
        TestBuilderHandler  handler=new TestBuilderHandler(testCaseClass,EnviConfig.getDriver());
        T testcase=(T)Proxy.newProxyInstance(testCaseClass.getClassLoader(), testCaseClass.getInterfaces(), handler);
        this.put(((TestCase)testcase).getTestCaseName(), (TestCase)testcase);
        return testcase;
    }
        
    public  void runTest(String testCaseName) throws Exception{
        TestCase testcase=this.get(testCaseName);
        runTest(testcase);
    }
    
    public void runTest(TestCase testCase){
        testCase.runTest();
    }
    
}
