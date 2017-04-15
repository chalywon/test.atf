package com.atf.support.compile.layout;

import java.util.ArrayList;
import java.util.List;

import com.atf.support.compile.syntax.Symbol;
import com.atf.support.compile.types.base.ResolvedType;

/**
 * @author charlse
 * @version
 * @time 2017年4月2日 下午9:28:19
 * @desption
 */
public  class AbstractLayout implements Section {
	protected final String _indent = Symbol.TAB;
	protected Section _parent=null;
	protected List<Object> _content = new ArrayList<Object>();

	@Override
	public void append(ResolvedType variable) {
		_content.add(variable);
	}

	@Override
	public void append(String statement) {
		_content.add(statement);
	}

	@Override
	public void append(Section section) {
		section.setParent(this);
		_content.add(section);
	}
	
	@Override
	public String getIndent() {
		return this._parent==null?this._indent:this._parent.getIndent()+this._indent;
	}

	@Override
	public void setParent(Section parent) {
		this._parent=parent;
	}

	@Override
	public Section getParent() {
		return this._parent;
	}
}
