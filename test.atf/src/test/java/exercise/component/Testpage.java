package exercise.component;

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

/**
 *
 * @author charl
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class Testpage {
    WebDriver driver;
    org.openqa.selenium.support.ui.Select select;
    public Testpage(WebDriver driver){
        this.driver=driver;
        
    }
    @FindBy(name = "test")
    WebElement element;
    
    public void click(String selectType,Object arg){
        select=new org.openqa.selenium.support.ui.Select(element); 
        switch(selectType){
            case "ByValue":
                dropDownSelectByValue((String)arg);
                    break;
            case "ByText":
                dropDownSelectByVisibleText((String)arg);
                    break;
            case "ByIndex":
                dropDownSelectByIndex((int)arg);
                    break;
            
        }
        
    }
    private void dropDownSelectByValue(String value){
        select.selectByValue(value);
    }
    
    private void dropDownSelectByVisibleText(String text){
        select.selectByVisibleText(text);
    }
    
    private void dropDownSelectByIndex(int index){
        select.selectByIndex(index);
    }
}
