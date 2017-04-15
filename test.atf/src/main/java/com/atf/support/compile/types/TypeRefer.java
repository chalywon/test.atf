package com.atf.support.compile.types;

import com.atf.support.compile.factor.Function;
import com.atf.support.compile.factor.Modifier;
import com.atf.support.compile.factor.Scope;
import com.atf.support.compile.syntax.Operator;
import com.atf.support.compile.syntax.Symbol;
import com.atf.support.compile.types.base.ResolvedType;

/**
	*@author charlse
	*@version 
	*@time 2017年4月1日 下午12:52:33
	*@desption
*/
public class TypeRefer implements ResolvedType {
	protected String _type=null;
	protected String _name=null;
	protected String _value=null;
	protected Scope _scope=null;
	protected Modifier _modifier=null;
	public TypeRefer(Scope scope,Modifier modifier,String type,String name,String value){
		this._scope=scope;
		this._modifier=modifier;
		this._type=type;
		this._name=name;
		this._value=value;
	}
	public String getType(){
		return this._type;
	}
	
	public TypeRefer(String type,String name){
		this._type=type;
		this._name=name;
	}
	
	public TypeRefer(String type,String name,String value){
		this._type=type;
		this._name=name;
		this._value=value;
	}

	@Override
	public String assign(String exp) {
		return this._name+Operator.ASSIGN+exp;
	}

	@Override
	public String equals(String exp) {
		return this._name+Operator.EQUALS+exp;
	}

	@Override
	public String unequals(String exp) {
		return this._name+Operator.UNEQUALS+exp;
	}

	@Override
	public String getName() {
		return this._name;
	}
	
	@Override
	public String toString(){
		StringBuilder sb=new StringBuilder();
		sb=this._scope==null?sb:sb.append(Function.getScope(_scope)+Symbol.SPACE);
		sb=this._modifier==null?sb:sb.append(Function.getModifier(_modifier)+Symbol.SPACE);
		sb=sb.append(this._type+Symbol.SPACE+this._name);
		sb=this._value==null?sb:sb.append(Operator.ASSIGN+this._value);
		return sb.toString();
	}

}
