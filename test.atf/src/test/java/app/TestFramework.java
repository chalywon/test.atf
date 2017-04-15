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

import com.atf.hybird.By;
import com.atf.hybird.Element;
import com.atf.hybird.AppDriver;
import com.atf.hybird.implement.HybirdDriver;

/**
 *
 * @author charl
 */
public class TestFramework {

    public static void main(String[] args) throws Exception {
        AppDriver driver = new HybirdDriver();
        Element elementParent = driver.locateElement(By.className("parent"));
        Element child = elementParent.locateElement(By.className("childbutton"));
        child.click(5000);
        System.out.println(driver.getTestScript());
       

    }

}
