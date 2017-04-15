/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atf.support.factory;
import java.util.*;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.atf.support.assembly.compnents.DataFieldGroup;
import com.atf.support.config.EnviConfig;
import com.atf.support.util.XmlUtils;


/**
 *
 * @author charl
 */
public class TestDataFactory {
    /*
     * 返回测试对象的所有属性定义
     * @param fileClassDefine 测试对象类型定义
     * 
     */
    public static DataFieldGroup initFields(String fileClassDefine) throws Exception{
        String file=EnviConfig.getTestCaseFolder()+fileClassDefine;
        Document document=XmlUtils.load(file);
        Element root=document.getDocumentElement();
        Element elementPage=XmlUtils.getChildByTagName(root, "properties");
        DataFieldGroup fieldGroup=XmlUtils.getProperties(elementPage);
        return fieldGroup;
    }
    
}
