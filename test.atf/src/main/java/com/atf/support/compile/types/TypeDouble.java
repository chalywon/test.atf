package com.atf.support.compile.types;

import com.atf.support.compile.factor.Modifier;
import com.atf.support.compile.factor.Scope;
import com.atf.support.compile.syntax.JavaType;
import com.atf.support.compile.types.base.TypeNumberic;

/**
	*@author charlse
	*@version 
	*@time 2017年4月1日 上午11:19:59
	*@desption
*/
public class TypeDouble extends TypeNumberic {
	public TypeDouble(String name) {
		super(name);
		this._type=JavaType.DOUBLE;
	}

	public TypeDouble(String name, String value) {
		super(name, value);
		this._type=JavaType.DOUBLE;
	}

	public TypeDouble(Scope scope, String name) {
		super(scope, name);
		this._type=JavaType.DOUBLE;
	}

	public TypeDouble(Scope scope, String name, String value) {
		super(scope, name, value);
		this._type=JavaType.DOUBLE;
	}

	public TypeDouble(Modifier modifier, String name) {
		super(modifier, name);
		this._type=JavaType.DOUBLE;
	}

	public TypeDouble(Modifier modifier, String name, String value) {
		super(modifier, name, value);
		this._type=JavaType.DOUBLE;
	}

	public TypeDouble(Scope scope, Modifier modifier, String name) {
		super(scope, modifier, name);
		this._type=JavaType.DOUBLE;
	}

	public TypeDouble(Scope scope, Modifier modifier, String name, String value) {
		super(scope, modifier, name, value);
		this._type=JavaType.DOUBLE;
	}

}
