/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atf.webtest.factory;

import com.atf.support.config.EnviConfig;
public class DataProviderFactory {
                public static void getConfig(String configFile){
                    EnviConfig.configTest(configFile);
		}
}