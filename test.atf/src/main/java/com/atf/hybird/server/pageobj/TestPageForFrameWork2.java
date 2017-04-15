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
package com.atf.hybird.server.pageobj;

import com.atf.hybird.By;
import com.atf.hybird.Element;
import com.atf.hybird.AppDriver;
import com.atf.hybird.annotations.FindBy;

/**
 *
 * @author charl
 */
public class TestPageForFrameWork2 {
    AppDriver driver;
    
    @FindBy(id="name")
    Element name;
    
    @FindBy(id="mobile")
    Element mobile;
    
    @FindBy(id="storeNum")
    Element storeNum;
       
    @FindBy(id="product")
    Element product;
    
    public TestPageForFrameWork2(AppDriver driver){
        this.driver=driver;
    }
    
    public void inputName(String name){
        System.out.println(this.name.getLocateScript());
        this.name.input(name,2000);
    }
    
    public void inputMobile(String mobile){
        System.out.println(this.mobile.getLocateScript());
        this.mobile.input(mobile,4000);
    }
    
    public void inputstoreNum(String storeNum){
        System.out.println(this.storeNum.getLocateScript());
        this.storeNum.input(storeNum,6000);
    }
    
    public void inputProduct(String product){
        System.out.println(this.product.getLocateScript());
        this.product.input(product,8000);
    }
    
    public String getTestScript(){
        
        return this.driver.getTestScript();
    }

    
}
