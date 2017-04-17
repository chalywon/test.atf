package exercise.component;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author charl
 */
import exercise.component.Testcase;
import java.util.Iterator;

import com.atf.support.config.EnviConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class runner {

    static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {
        
        Testcase tc=new Testcase("file:///D:/test.html");
        tc.runTest();
        
    }
   
    public static void runTest() {
        String configFile="./src/test/java/suppliers/configuration/frameworkConfig.properties";
        System.setProperty("webdriver.chrome.driver", EnviConfig.getChromePath());
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("file:///D:/test.html");
        //Thread.sleep(2000);
        //selectCategoryDropdown("second");
    }

    public static void selectCategoryDropdown(String optionName) throws InterruptedException {
       
       WebElement category=driver.findElement(By.name("test"));
          java.util.List<WebElement> opts=category.findElements(By.tagName("option"));
          category.click();
          Iterator iter=opts.iterator();
           while(iter.hasNext()){
               WebElement opt=(WebElement)iter.next();
              if(opt.getAttribute("value").equals(optionName)){
               Actions act = new Actions(driver);
               act.moveToElement(opt).click().build().perform();
                  //opt.click();
                  try {
      Thread.sleep(1000);
     } catch (InterruptedException e) {
      e.printStackTrace();
     }
                  break;
              }
           }
  
    }
}
