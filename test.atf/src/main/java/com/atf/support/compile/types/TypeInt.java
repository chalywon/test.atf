package com.atf.support.compile.types;

import com.atf.support.compile.factor.Modifier;
import com.atf.support.compile.factor.Scope;
import com.atf.support.compile.syntax.JavaType;
import com.atf.support.compile.types.base.TypeNumberic;

/**
	*@author charlse
	*@version 
	*@time 2017年4月1日 上午11:04:35
	*@desption
*/
public class TypeInt extends TypeNumberic {
	public TypeInt(String name) {
		super(name);
		this._type=JavaType.INT;
	}

	public TypeInt(String name, String value) {
		super(name, value);
		this._type=JavaType.INT;
	}

	public TypeInt(Scope scope, String name) {
		super(scope, name);
		this._type=JavaType.INT;
	}

	public TypeInt(Scope scope, String name, String value) {
		super(scope, name, value);
		this._type=JavaType.INT;
	}

	public TypeInt(Modifier modifier, String name) {
		super(modifier, name);
		this._type=JavaType.INT;
	}

	public TypeInt(Modifier modifier, String name, String value) {
		super(modifier, name, value);
		this._type=JavaType.INT;
	}

	public TypeInt(Scope scope, Modifier modifier, String name) {
		super(scope, modifier, name);
		this._type=JavaType.INT;
	}

	public TypeInt(Scope scope, Modifier modifier, String name, String value) {
		super(scope, modifier, name, value);
		this._type=JavaType.INT;
	}
}
