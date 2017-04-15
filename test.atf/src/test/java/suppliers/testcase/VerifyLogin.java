/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package suppliers.testcase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.atf.support.assembly.annotations.DataProvider;
import com.atf.support.assembly.interfaces.TestCase;
import com.atf.support.config.EnviConfig;

import suppliers.pageobject.PageLogin;

import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author charl
 */
@DataProvider(value="TC_VerfyLogin")
public class VerifyLogin implements TestCase {
    public WebDriver driver;
    PageLogin pageLogin;
    String testCaseName;
    String username;
    String password;
    public VerifyLogin()
    {
        super();
        this.driver=EnviConfig.getDriver();
        pageLogin=PageFactory.initElements(driver, PageLogin.class); 
    }
   
    @Override
    public boolean validate(){
        System.out.println("validate test");
        return false;
    }

    @Override
    public String getTestCaseName(){
        return this.testCaseName;
    }
    @Override
    public String runTest(){
       
        driver.get("http://suppliers.jxdd.com");
        pageLogin.inputUserName(this.username);
        pageLogin.inputPassword(this.password);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException ex) {
            Logger.getLogger(VerifyLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        pageLogin.clickLoginButton();
        return "";
    }
    
    public void setPassword(String password){
        this.password=password;
    }
    
    public String getPassword(){
        return this.password;
    }
    
    public void setUsername(String username){
        this.username=username;
    }
    
    public String getUsername(){
        return this.username;
    }
}
