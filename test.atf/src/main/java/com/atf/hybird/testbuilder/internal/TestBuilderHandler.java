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
package com.atf.hybird.testbuilder.internal;

import com.atf.hybird.AppDriver;
import com.atf.support.assembly.annotations.DataProvider;
import com.atf.support.assembly.annotations.TestType;
import com.atf.support.assembly.interfaces.TestCase;
import com.atf.support.excepiton.NotTestCaseException;
import com.atf.support.excepiton.WithoutDataProviderException;
import com.atf.support.factory.TestCaseFactory;

import org.openqa.selenium.WebDriver;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TestBuilderHandler<T> implements InvocationHandler {

    private final java.lang.Class<T> testCaseClass;
    private T testcase;
    private Object driver;

    public TestBuilderHandler(java.lang.Class<T> testCaseClass, Object driver) throws Exception {
        super();
        this.testCaseClass = testCaseClass;
        this.driver = driver;
        InitObject();
    }

    private void InitObject() throws Exception {
        if (!TestCase.class.isAssignableFrom(testCaseClass)) {
            throw new NotTestCaseException(testCaseClass.getTypeName());
        }

        if (testCaseClass.getAnnotation(DataProvider.class) == null) {
            throw new WithoutDataProviderException(testCaseClass.getTypeName());
        }

        DataProvider provider = testCaseClass.getAnnotation(DataProvider.class);
        TestType type = provider.testType();
        if (TestType.WEB.equals(type)) {
            testcase = TestCaseFactory.initWebTestCase((WebDriver) driver, testCaseClass);
        } else if (TestType.APP.equals(type)) {
            testcase = TestCaseFactory.initAppTestCase((AppDriver) driver, testCaseClass);
        }
    }

    @Override
    public Object invoke(Object object, Method method, Object[] args) throws Throwable {
        return method.invoke(testcase, args);
    }

}
