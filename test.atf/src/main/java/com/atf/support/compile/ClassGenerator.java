package com.atf.support.compile;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.atf.support.compile.factor.Function;
import com.atf.support.compile.factor.Modifier;
import com.atf.support.compile.factor.Scope;
import com.atf.support.compile.syntax.Keyword;
import com.atf.support.compile.syntax.Symbol;
import com.atf.support.compile.layout.AbstractLayout;

/**
 * @author charlse
 * @version
 * @time 2017年3月29日 下午1:00:43
 * @desption
 */
public class ClassGenerator extends AbstractLayout {

	String _packageName = null;
	String _baseClass = null;
	String _name;
	List<String> _interfs;
	List<String> _imports;
	Scope _scope = null;
	Modifier _modifier = null;

	public ClassGenerator(Scope scope, String name) {
		this._scope = scope;
		this._name = name;
	}

	public String getName() {
		return this._name;
	}

	public void setName(String name) {
		this._name = name;
	}

	public ClassGenerator setBaseClass(String className) {
		_baseClass = className;
		return this;
	}

	public String getPkgName() {
		return this._packageName;
	}

	public void setPkgName(String packageName) {
		this._packageName = packageName;
	}

	public ClassGenerator addInterfs(String interfaceName) {
		if (this._interfs == null)
			this._interfs = new ArrayList<String>();
		_interfs.add(interfaceName);
		return this;
	}

	public String _def() {
		StringBuilder def = new StringBuilder();
		def = this._scope == null ? def : def.append(Function.getScope(_scope) + Symbol.SPACE);
		def = this._modifier == null ? def : def.append(Function.getModifier(_modifier) + Symbol.SPACE);
		def = def.append(Keyword.CLASS + Symbol.SPACE + this._name);
		def = this._baseClass == null ? def
				: def.append(Symbol.SPACE + Keyword.EXTENDS + Symbol.SPACE + this._baseClass + Symbol.SPACE);
		def = this.interfs() == null ? def : def.append(this.interfs());
		def = def.append(Symbol.BRACE);
		int index = def.indexOf(Symbol.RIGHT_BRACE);
		def.insert(index, this.getIndent().substring(0, this.getIndent().length() - 4));
		return this.getIndent().substring(0, this.getIndent().length() - 4) + def.toString();
	}

	public void addImport(String imporp) {
		if (this._imports == null)
			this._imports = new ArrayList<String>();
		this._imports.add(imporp);
	}

	public void append(FieldGenerator field) {
		field.setParent(this);
		_content.add(field);
	}

	@Override
	public String toString() {
		StringBuilder _this = new StringBuilder();
		_this.append(_def());
		int index = _this.indexOf(Symbol.RETURN);
		_this.insert(index + 2, Function.getSections(this._content,this.getIndent()));
		_this.insert(0,this.imports());
		_this = this._packageName == null ? _this
				: _this.insert(0,Keyword.PACKAGE + Symbol.SPACE + this._packageName + Symbol.SEMICOLON + Symbol.RETURN);
		return _this.toString();
	}

	private String imports() {
		StringBuilder imporp = new StringBuilder();
		if (this._imports == null)
			return imporp.toString();
		Iterator<String> it = this._imports.iterator();
		while (it.hasNext()) {
			imporp = imporp.append(Keyword.IMPORT + Symbol.SPACE + it.next() + Symbol.SEMICOLON + Symbol.RETURN);
		}
		return imporp.toString();
	}

	private String interfs() {
		StringBuilder interfs = new StringBuilder();
		if (this._interfs == null)
			return interfs.toString();
		Iterator<String> it = this._interfs.iterator();
		while (it.hasNext()) {
			interfs.append(it.next() + Symbol.COMMA);
		}
		interfs.insert(0, Symbol.SPACE + Keyword.IMPLEMENTS + Symbol.SPACE);
		return interfs.substring(0, interfs.length() - 1);
	}

}
