/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package suppliers;

import suppliers.testcase.VerifyLogin;
import org.dom4j.DocumentException;

import com.atf.support.assembly.interfaces.TestCase;
import com.atf.webtest.testengine.TestEngine;

/**
 *
 * @author charl
 */
public class WebtestRun {

    /**
     * @param args the command line arguments
     * @throws java.lang.InterruptedException
     * @throws org.dom4j.DocumentException
     */
    public static void main(String[] args) throws InterruptedException, DocumentException, Exception {
        // TODO code application logic here
        String configFile="TestConfigForSuitA";
        TestCase login = new VerifyLogin();
        TestEngine testBuilder = new TestEngine(configFile,"web");
        login = testBuilder.buildTest(VerifyLogin.class);
        testBuilder.runTest(login.getTestCaseName());
    }
}
