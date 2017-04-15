package com.atf.support.compile.types;

import com.atf.support.compile.factor.Modifier;
import com.atf.support.compile.factor.Scope;
import com.atf.support.compile.syntax.JavaType;
import com.atf.support.compile.syntax.Operator;
import com.atf.support.compile.types.base.TypeBase;

/**
 * @author charlse
 * @version
 * @time 2017年4月1日 上午11:33:13
 * @desption
 */
public class TypeByte extends TypeBase {
	public TypeByte(String name) {
		super(name);
		this._type = JavaType.BYTE;
	}

	public TypeByte(String name, String value) {
		super(name, value);
		this._type = JavaType.BYTE;
	}

	public TypeByte(Scope scope, String name) {
		super(scope, name);
		this._type = JavaType.BYTE;
	}

	public TypeByte(Scope scope, String name, String value) {
		super(scope, name, value);
		this._type = JavaType.BYTE;
	}

	public TypeByte(Modifier modifier, String name) {
		super(modifier, name);
		this._type = JavaType.BYTE;
	}

	public TypeByte(Modifier modifier, String name, String value) {
		super(modifier, name, value);
		this._type = JavaType.BYTE;
	}

	public TypeByte(Scope scope, Modifier modifier, String name) {
		super(scope, modifier, name);
		this._type = JavaType.BYTE;
	}

	public TypeByte(Scope scope, Modifier modifier, String name, String value) {
		super(scope, modifier, name, value);
		this._type = JavaType.BYTE;
	}
	
	public String incrementAfter() {
		return this._name + Operator.INCREMENT;
	}

	public String incrementBefore() {
		return Operator.INCREMENT + this._name;
	}

	public String decrementAfter() {
		return this._name + Operator.DECREMENT;
	}

	public String decrementBefore() {
		return Operator.DECREMENT + this._name;
	}
	
}
