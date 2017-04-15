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
import com.atf.support.config.EnviConfig;
import com.atf.hybird.AppDriver;
import com.atf.hybird.factory.HtmlPageFactory;
import com.atf.hybird.server.pageobj.TestPageForFrameWork2;

/**
 *
 * @author charl
 */
@DataProvider(value="DetailPage",testType=TestType.APP)
public class TestCaseStep2 {
    AppDriver driver;
    TestPageForFrameWork2 testpage;
    String name;
    String mobile;
    String storeNum;
    String product;
    String testCaseName;
    
    public TestCaseStep2(AppDriver dirver) throws Exception{
        this.driver=dirver;
        testpage=HtmlPageFactory.initPageElements(driver, TestPageForFrameWork2.class);
    }
    
    public String getTestCaseName(){
        return this.testCaseName;
    }
    public String runTest(){
        testpage.inputName(this.name);
        testpage.inputMobile(this.mobile);
        testpage.inputstoreNum(this.storeNum);
        testpage.inputProduct(this.product);
        System.out.println(testpage.getTestScript());
        return testpage.getTestScript();
       
    }
    
    
}
