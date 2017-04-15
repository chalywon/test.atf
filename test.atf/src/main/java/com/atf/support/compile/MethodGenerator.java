package com.atf.support.compile;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.atf.support.compile.factor.Function;
import com.atf.support.compile.factor.Modifier;
import com.atf.support.compile.factor.Paramter;
import com.atf.support.compile.factor.Scope;
import com.atf.support.compile.syntax.Keyword;
import com.atf.support.compile.syntax.Symbol;
import com.atf.support.compile.layout.AbstractLayout;
import com.atf.support.compile.layout.Compment;

/**
 * @author charlse
 * @version
 * @time 2017年3月27日 下午6:10:16
 * @desption
 */
public class MethodGenerator extends AbstractLayout  implements Compment{
	Scope _scope = null;
	Modifier _modifier = null;
	String _type = null;
	String _name = null;
	Paramter[] _paramters;
	List<String> _throwz;

	public MethodGenerator(String name) {
		this._name = name;
	}

	public MethodGenerator(Scope scope, String name) {
		this._scope = scope;
		this._name = name;
	}

	public MethodGenerator(String name, Paramter[] paramters) {
		this._name = name;
		this._paramters = paramters;
	}

	public MethodGenerator(Scope scope, String name, Paramter[] paramters) {
		this._name = name;
		this._scope = scope;
		this._paramters = paramters;
	}

	public MethodGenerator(String type, String name) {
		this._name = name;
		this._type = type;
	}

	public MethodGenerator(Scope scope, String type, String name) {
		this._scope = scope;
		this._type = type;
		this._name = name;
	}

	public MethodGenerator(String type, String name, Paramter[] paramters) {
		this._type = type;
		this._name = name;
		this._paramters = paramters;
	}

	public MethodGenerator(Scope scope, String type, String name, Paramter[] paramters) {
		this._scope = scope;
		this._scope = scope;
		this._type = type;
		this._name = name;
		this._paramters = paramters;
	}

	public MethodGenerator(Scope scope, Modifier modifier, String name) {
		this._scope = scope;
		this._modifier = modifier;
		this._name = name;
	}

	public MethodGenerator(Scope scope, Modifier modifier, String type, String name) {
		this._scope = scope;
		this._modifier = modifier;
		this._type = type;
		this._name = name;
	}

	public MethodGenerator(Scope scope, Modifier modifier, String type, String name, Paramter[] paramters) {
		this._scope = scope;
		this._modifier = modifier;
		this._type = type;
		this._name = name;
		this._paramters = paramters;
	}
	
	@Override
	public String toString() {
		StringBuilder _this = new StringBuilder();
		int index = _def().indexOf(Symbol.RETURN);
		_this.append(_def()).insert(index + 2, Function.getSections(this._content,this.getIndent()));
		return _this.toString();
	}

	public String invoke(String... args) {
		StringBuilder invoke = new StringBuilder(this._name + Symbol.BRACKETS);
		for (String s : args) {
			invoke.insert(invoke.indexOf(Symbol.RIGHT_BRACKET), s + Symbol.COMMA);
		}
		return invoke.replace(invoke.length() - 2, invoke.length() - 1, "").toString();
	}

	public void addParam(Paramter param) {
		if (_paramters == null) {
			_paramters = new Paramter[1];
			_paramters[0] = param;
		} else {
			Paramter[] tempParams = new Paramter[_paramters.length + 1];
			System.arraycopy(_paramters, 0, tempParams, 0, _paramters.length);
			tempParams[_paramters.length] = param;
			_paramters = tempParams;
		}
	}

	public void addThrows(String throwz) {
		if (_throwz == null)
			_throwz = new ArrayList<String>();
		this._throwz.add(throwz);
	}

	private String getParams() {
		StringBuilder params = new StringBuilder(Symbol.BRACKETS);
		if (_paramters == null)
			return params.toString();
		int index = params.indexOf(Symbol.LEFT_BRACKET) + 1;
		for (int i = 0; i < _paramters.length; i++) {
			params = params.insert(index, _paramters[i].toString() + Symbol.COMMA);
		}
		return params.replace(params.length() - 2, params.length() - 1, "").toString();
	}

	private String getThrows() {
		StringBuilder throwz = new StringBuilder();
		if (this._throwz == null)
			return throwz.toString();
		Iterator<String> it = this._throwz.iterator();
		while (it.hasNext()) {
			throwz = throwz.append(it.next() + Symbol.COMMA);
		}
		throwz.insert(0, Symbol.SPACE + Keyword.THROWS + Symbol.SPACE);
		return throwz.replace(throwz.length() - 1, throwz.length(), "").toString();
	}

	public String _def() {
		StringBuilder def = new StringBuilder();
		def = this._scope == null ? def : def.append(Function.getScope(_scope) + Symbol.SPACE);
		def = this._modifier == null ? def : def.append(Function.getModifier(_modifier) + Symbol.SPACE);
		def = this._type == null ? def.append(Keyword.VOID + Symbol.SPACE) : def.append(this._type + Symbol.SPACE);
		def = def.append(this._name);
		def = def.append(this.getParams());
		def = def.append(getThrows());
		def = def.append(Symbol.BRACE);
		int index = def.indexOf(Symbol.RIGHT_BRACE);
		def.insert(index, this.getIndent().substring(0, this.getIndent().length() - 4));
		return this.getIndent().substring(0, this.getIndent().length() - 4) + def.toString();
	}
}
