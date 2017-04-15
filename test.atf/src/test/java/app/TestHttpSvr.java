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

import com.atf.hybird.testbuilder.TestBuilder;
import com.atf.hybird.server.httpsvr.HttpService;

/**
 *
 * @author charl
 */
public class TestHttpSvr {

    public static void main(String[] args) throws Exception {
        /*
        SocketService server=new SocketService("D:/webroot",8080);
        server.service();
         */
        String configFile="TestConfigForSuitA";
        TestBuilder testBuilder = new TestBuilder(configFile,"app");
        HttpService service=new HttpService("D:\\workspace\\Netbeans\\test.atf\\src\\main\\java\\com\\atf\\server\\httpsvr\\context\\context.xml",8080);
        service.start();
    }
}
