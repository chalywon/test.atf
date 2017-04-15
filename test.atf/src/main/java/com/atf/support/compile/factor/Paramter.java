package com.atf.support.compile.factor;

import com.atf.support.compile.syntax.Symbol;

/**
	*@author charlse
	*@version 
	*@time 2017年3月27日 下午6:07:08
	*@desption
*/
public class Paramter {
	String type;
	String name;
	
	public Paramter(String type,String name){
		this.type=type;
		this.name=name;
	}
	
	@Override
	public String toString(){
		return this.type+Symbol.SPACE+this.name;
	}
}
