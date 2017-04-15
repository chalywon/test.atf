/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atf.webtest.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.browser.chrome.ChromeDriver;
import org.openqa.selenium.browser.firefox.FirefoxDriver;
import org.openqa.selenium.browser.ie.InternetExplorerDriver;

import com.atf.support.config.EnviConfig;

/**
 *
 * @author charl
 */
public class BrowserFactory {

    static WebDriver driver;

    public static WebDriver getChromeBrowser() {
        System.setProperty("webdriver.chrome.driver", EnviConfig.getChromePath());
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }

    public static WebDriver getIEBrowser() {
        System.setProperty("webdriver.InternetExplorer.driver", EnviConfig.getIEPath());
        driver = new InternetExplorerDriver();
        return driver;
    }

    public static WebDriver getFirefoxBrowser() {
        driver = new FirefoxDriver();
        return driver;
    }
    /* use new method getFirefoxBrowser getChromeBrowser and getIEBrowser
    public static WebDriver getBrowser(String browserName){
        if(browserName.equalsIgnoreCase("Firefox")){
            driver=new FirefoxDriver();
        }
        
        if(browserName.equalsIgnoreCase("IE")){
            System.setProperty("webdriver.InternetExplorer.driver", DataProviderFactory.getConfig("").getIEPath());
            driver=new InternetExplorerDriver();
        }
        
        
        if(browserName.equalsIgnoreCase("Chrome")){
            System.setProperty("webdriver.chrome.driver", DataProviderFactory.getConfig().getChromePath());
            driver=new ChromeDriver();
            driver.manage().window().maximize();
            
        }

        return driver;
        
        
    }
     */

}
