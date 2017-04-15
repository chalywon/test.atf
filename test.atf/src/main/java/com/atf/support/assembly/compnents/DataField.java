/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atf.support.assembly.compnents;

/**
 *
 * @author charl
 */
public class DataField {
    String featureName;
    String featureType;
    String featureValue;
    public  DataField(String proName,String proType,String proValue){
        this.featureName=proName;
        this.featureType=proType;
        this.featureValue=proValue;
    }
    
    public String getName(){
        return this.featureName;
    }
    
    public String getType(){
        return this.featureType;
    }
    
    public String getValue(){
        return this.featureValue;
    }
}
