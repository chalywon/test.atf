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
package com.atf.hybird.server.testcase;

import com.atf.hybird.server.pageobj.TestPageForFramework;
import com.atf.support.assembly.annotations.DataProvider;
import com.atf.support.assembly.annotations.TestType;
import com.atf.support.assembly.interfaces.TestCase;
import com.atf.support.config.EnviConfig;
import com.atf.hybird.AppDriver;
import com.atf.hybird.factory.HtmlPageFactory;

/**
 *
 * @author charl
 */
@DataProvider(value="TC_TestForFramework1",testType=TestType.APP)
public class TestCaseStep1 implements TestCase {
    AppDriver driver;
    String testCaseName;
    TestPageForFramework testpage;
    String userName;
    String password;
    
    
    
    public TestCaseStep1(AppDriver driver) throws Exception{
        this.driver=driver;
        testpage=HtmlPageFactory.initPageElements(driver, TestPageForFramework.class);
    }
    
    @Override
    public String runTest(){
        testpage.inputUserName(this.userName);
        testpage.inputPassword(this.password);
        testpage.login();
        System.out.println(testpage.getTestScript());
        return testpage.getTestScript();
    }
    
    @Override
    public String getTestCaseName(){
        return this.testCaseName;
    }
    
    public boolean validate()
    {
        return false;
    }
    
    
}
