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
package com.atf.hybird;

/**
 *
 * @author charl
 */
public interface Element {
    
    public void click();
    public void click(int time);
    public void input(String value);
    public void input(String value,int time);
    public void setBy(By by);
    public By getBy();
    public AppDriver getTestDriver();
    public Element getParentElement();
    public void setParentElement(Element element);
    public Element locateElement(By by);
    public String getLocateScript();
    
    
}
