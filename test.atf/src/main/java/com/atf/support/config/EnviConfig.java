/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atf.support.config;

import org.openqa.selenium.WebDriver;

import com.atf.hybird.AppDriver;
import com.atf.hybird.implement.HybirdDriver;
import com.atf.support.excepiton.EnvironmentException;
import com.atf.webtest.factory.BrowserFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class EnviConfig {

    static Properties pro;
    static WebDriver driver;
    static AppDriver testDriver;

    public static void EnvInit(String config) {

        try {
            File src = new File(config);
            FileInputStream fis = new FileInputStream(src);
            pro = new Properties();
            pro.load(fis);
            

        } catch (FileNotFoundException e) {
            System.out.println("Configuration file not found, please verify");
            e.printStackTrace();

        } catch (IOException e) {
            System.out.println("Configuration file not loaded, please check the file");
            e.getMessage();
        }
    }

    public String getTestFolder() {
        return pro.getProperty("TestFolder");
    }

    public static void configBrowser() {
        driver = BrowserFactory.getChromeBrowser();
    }

    public static void configTest(String config) {
            EnvInit(config);
    }

    public static String getIEPath() {

        return pro.getProperty("IEPath");

    }

    public static String getChromePath() {

        return pro.getProperty("ChromePath");

    }

    public static String getTestCaseFolder() {
        return pro.getProperty("TestCaseFolder");
    }

    public static WebDriver getDriver() {
        return driver;
    }
    
    public static void configAppDriver(){
        testDriver=new HybirdDriver();
    }
    
    public static AppDriver getAppDriver(){
        return testDriver;
    }

    public String getBuildNumber() {
        String buildNumber = pro.getProperty("Version");
        return buildNumber;
    }

    public String getExtentReportsLocation() {
        String extentReportsLocation = pro.getProperty("ExtentReports");
        return extentReportsLocation;
    }

    public List<String> getXMLFiles() {
        String xmlfiles = pro.getProperty("TestXMLFiles");
        String[] arr = xmlfiles.split(",");
        List<String> list = new ArrayList<>();
        list.addAll(Arrays.asList(arr));
        return list;
    }

}
