package com.atf.support.compile.types;

import com.atf.support.compile.factor.Modifier;
import com.atf.support.compile.factor.Scope;
import com.atf.support.compile.syntax.JavaType;
import com.atf.support.compile.syntax.Operator;
import com.atf.support.compile.syntax.Symbol;
import com.atf.support.compile.types.base.ResolvedType;
import com.atf.support.compile.types.base.TypeBase;

/**
	*@author charlse
	*@version 
	*@time 2017年3月31日 下午9:30:06
	*@desption
*/
public  class TypeString extends TypeBase implements ResolvedType {
	
	public TypeString(String name){
		super(name);
		this._type=JavaType.STRING;
	}
	
	public TypeString(String name,String value){
		super(name,value);
		this._type=JavaType.STRING;
	}
	
	
	public TypeString(Scope scope,String name){
		super(scope,name);
		this._type=JavaType.STRING;
	}
	public TypeString(Scope scope,String name,String value){
		super(scope,name,value);
		this._type=JavaType.STRING;
	}
	
	public TypeString(Modifier modifier,String name){
		super(modifier,name);
		this._type=JavaType.STRING;
	}
	public TypeString(Modifier modifier,String name,String value){
		super(modifier,name,value);
		this._type=JavaType.STRING;
	}
	
	public TypeString(Scope scope,Modifier modifier,String name){
		super(scope,modifier,name);
		this._type=JavaType.STRING;
	}
	public TypeString(Scope scope,Modifier modifier,String name,String value){
		super(scope,modifier,name,value);
		this._type=JavaType.STRING;
	}
	
	
	
	public String add(String exp){
		return this._name+Operator.PLUS+exp;
	}
	
	public String add_assign(String exp){
		return this._name+Operator.PLUS+Operator.ASSIGN+exp;
	}
	
	public static String escape(String exp){
		return Symbol.QUOTES+exp+Symbol.QUOTES;
	}
}
