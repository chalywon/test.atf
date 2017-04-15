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
package app;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 *
 * @author charl
 */
public class TestAppium {

    //private static AppiumDriver<WebElement> driver;
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        File app = new File("D:/jxddapp.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName","Android Emulator");
        capabilities.setCapability("automationName","Selendroid");
        capabilities.setCapability("app", app.getAbsolutePath());
   
        capabilities.setCapability("appPackage", "com.jxdd");
        capabilities.setCapability("appActivity", "io.dcloud.PandoraEntryActivity");
        AppiumDriver driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        Set<String> contextNames = driver.getContextHandles();
        for (String contextName : contextNames) {
          System.out.println(contextName);
          if (contextName.contains("WEBVIEW")){
            driver.context(contextName);
            List<WebElement> inputField = driver.findElements(By.xpath("//input"));
            for(WebElement e:inputField){
                System.out.println(e.getText());
            }
          }
        }
        
    }

}
