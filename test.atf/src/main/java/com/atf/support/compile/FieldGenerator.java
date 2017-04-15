package com.atf.support.compile;

import com.atf.support.compile.expression.Grammar;
import com.atf.support.compile.factor.Function;
import com.atf.support.compile.factor.Paramter;
import com.atf.support.compile.factor.Scope;
import com.atf.support.compile.layout.Compment;
import com.atf.support.compile.layout.Section;
import com.atf.support.compile.syntax.Keyword;
import com.atf.support.compile.syntax.Symbol;
import com.atf.support.compile.types.base.ResolvedType;

/**
 * @author charlse
 * @version
 * @time 2017年3月28日 下午8:52:07
 * @desption
 */
public class FieldGenerator implements Compment {
	ResolvedType _type = null;
	MethodGenerator _getter;
	MethodGenerator _setter;
	protected String _indent = Symbol.TAB;
	protected Section _parent = null;

	public FieldGenerator(ResolvedType type) {
		this._type = type;
		this._getter = getter();
		this._setter = setter();
	}

	
	@Override
	public String _def() {
		return this._parent.getIndent()+this._type.toString();
	}

	private MethodGenerator getter() {
		StringBuilder getter = new StringBuilder(Keyword.GET);
		getter = getter.append(Function.firstUpper(this._type.getName()));
		MethodGenerator method = new MethodGenerator(Scope.PUBLIC, this._type.getType(), getter.toString());
		method.setParent(this._parent);
		method.append(Keyword.RETURN + Symbol.SPACE + Grammar.getExpDot(Keyword.THIS, this._type.getName()));
		this._getter=method;
		return method;
	}

	private MethodGenerator setter() {
		StringBuilder setter = new StringBuilder(Keyword.SET);
		setter = setter.append(Function.firstUpper(this._type.getName()));
		MethodGenerator method = new MethodGenerator(Scope.PUBLIC, setter.toString());
		method.setParent(this._parent);
		method.addParam(new Paramter(this._type.getType(), this._type.getName()));
		method.append(
				Grammar.getExpAssign(Grammar.getExpDot(Keyword.THIS, this._type.getName()), this._type.getName()));
		this._setter=method;
		return method;
	}

	public void setGetter(MethodGenerator method) {
		this._getter = method;
		this._getter.setParent(this._parent);
	}

	public void setSetter(MethodGenerator method) {
		this._setter = method;
		this._setter.setParent(this._parent);
	}

	public MethodGenerator getGetter() {
		return this._getter;
	}

	public MethodGenerator getSetter() {
		return this._setter;
	}

	@Override
	public String toString() {
		return this._def() + Symbol.SEMICOLON + Symbol.RETURN + setter() + Symbol.RETURN
				+getter();
	}

	public Section getParent() {
		return this._parent;
	}

	public void setParent(Section parent) {
		this._parent = parent;
	}


	@Override
	public String getIndent() {
		return this._parent.getIndent();
	}

}
