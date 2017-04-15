package com.atf.support.compile.types.base;

import com.atf.support.compile.factor.Function;
import com.atf.support.compile.factor.Modifier;
import com.atf.support.compile.factor.Scope;
import com.atf.support.compile.syntax.Operator;
import com.atf.support.compile.syntax.Symbol;

/**
	*@author charlse
	*@version 
	*@time 2017年4月1日 上午10:02:11
	*@desption
*/
public abstract class TypeBase implements ResolvedType {

	protected String _name=null;
	protected String _value=null;
	protected Scope _scope=null;
	protected Modifier _modifier=null;
	protected String _type=null;
	
	public TypeBase(String name){
		this._name=name;
	}
	
	public TypeBase(String name,String value){
		this._name=name;
		this._value=value;
	}
	
	
	public TypeBase(Scope scope,String name){
		this._scope=scope;
		this._name=name;
	}
	public TypeBase(Scope scope,String name,String value){
		this._scope=scope;
		this._name=name;
		this._value=value;
	}
	
	public TypeBase(Modifier modifier,String name){
		this._modifier=modifier;
		this._name=name;
	}
	public TypeBase(Modifier modifier,String name,String value){
		this._modifier=modifier;
		this._name=name;
		this._value=value;
	}
	
	public TypeBase(Scope scope,Modifier modifier,String name){
		this._scope=scope;
		this._modifier=modifier;
		this._name=name;
	}
	public TypeBase(Scope scope,Modifier modifier,String name,String value){
		this._scope=scope;
		this._modifier=modifier;
		this._name=name;
		this._value=value;
	}
	
	public String getName(){
		return this._name;
	}
	
	public String getType(){
		return this._type;
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
}
