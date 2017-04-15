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

import com.atf.hybird.Element;
import com.atf.hybird.AppDriver;
import com.atf.hybird.annotations.FindBy;

/**
 *
 * @author charl
 */
public class TestPageForFramework {
    AppDriver driver;
    
    @FindBy(className="userName")
    Element userName;
    
    @FindBy(className="password")
    Element password;
    
    @FindBy(className="btnLogin")
    Element btnLogin;
       
    @FindBy(className="btnCancel")
    Element btnCancel;
    public TestPageForFramework(AppDriver driver){
        this.driver=driver;
    }
    
    public void inputUserName(String id){
        System.out.println(userName.getLocateScript());
        userName.input(id,50000);
    }
    
    public void inputPassword(String password){
        System.out.println(this.password.getLocateScript());
        this.password.input(password,10000);
    }
    
   
    
    public void login(){
       System.out.println(btnLogin.getLocateScript());
       btnLogin.click(15000);
    }
    
    public String getTestScript(){
        return this.driver.getTestScript();
    }

    
}
