/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package suppliers.pageobject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.atf.support.assembly.annotations.DataValidate;

import java.util.List;

import org.openqa.selenium.interactions.Actions;

/**
 *
 * @author charl
 */
public class PageLogin  {

    WebDriver driver;

    public PageLogin(WebDriver driver) {
        this.driver = driver;
    }
    @FindBy(tagName = "input")
    List<WebElement> input;

    @FindBy(name = "username")
    @DataValidate(className = String.class, name = "")
    WebElement username;

    
    @FindBy(name = "password_m")
    WebElement password;

    @FindBy(name = "loginBtn")
    WebElement loginbtn;

    public void inputUserName(String usrName) {
        username.sendKeys(usrName);

    }

    public void inputPassword(String password) {
        this.password.sendKeys(password);
    }

    public void clickLoginButton() {
        Actions act=new Actions(driver);
        act.moveToElement(loginbtn);
        act.click().perform();
    }
}
