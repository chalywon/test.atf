package com.atf.support.compile.types;

import com.atf.support.compile.factor.Modifier;
import com.atf.support.compile.factor.Scope;
import com.atf.support.compile.syntax.JavaType;
import com.atf.support.compile.syntax.Symbol;
import com.atf.support.compile.types.base.TypeBase;

/**
	*@author charlse
	*@version 
	*@time 2017年4月1日 上午11:33:13
	*@desption
*/
public class TypeChar extends TypeBase {
	public TypeChar(String name){
		super(name);
		this._type=JavaType.CHAR;
	}
	
	public TypeChar(String name,String value){
		super(name,value);
		this._type=JavaType.CHAR;
	}
	
	
	public TypeChar(Scope scope,String name){
		super(scope,name);
		this._type=JavaType.CHAR;
	}
	public TypeChar(Scope scope,String name,String value){
		super(scope,name,value);
		this._type=JavaType.CHAR;
	}
	
	public TypeChar(Modifier modifier,String name){
		super(modifier,name);
		this._type=JavaType.CHAR;
	}
	public TypeChar(Modifier modifier,String name,String value){
		super(modifier,name,value);
		this._type=JavaType.CHAR;
	}
	
	public TypeChar(Scope scope,Modifier modifier,String name){
		super(scope,modifier,name);
		this._type=JavaType.CHAR;
	}
	public TypeChar(Scope scope,Modifier modifier,String name,String value){
		super(scope,modifier,name,value);
		this._type=JavaType.CHAR;
	}
	
	public static String escape(String exp){
		return Symbol.SINGLEQUOTE+exp+Symbol.SINGLEQUOTE;
	}

}
