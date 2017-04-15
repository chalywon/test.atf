package com.atf.support.compile.layout;

import java.util.ArrayList;
import java.util.List;
import com.atf.support.compile.factor.Function;
import com.atf.support.compile.syntax.Keyword;
import com.atf.support.compile.syntax.Symbol;

/**
 * @author charlse
 * @version
 * @time 2017年3月28日 下午5:37:25
 * @desption
 */
public class ConditionIF extends AbstractLayout implements Compment{
	protected String _condition;
	protected  ClauseElse _elze=null;
	protected List<Object> _elzeif = new ArrayList<Object>();

	public ConditionIF(String condition) {
		this._condition = condition;
	}
	

	public void append(ClauseElse elze) {
		elze.setParent(this);
		this._elze=elze;
	}

	public void append(ClauseElseIF elzeif) {
		elzeif.setParent(this);;
		this._elzeif.add(elzeif);
	}

	public String _def() {
		StringBuilder def = new StringBuilder();
		def.append(this.getIndent().substring(0, this.getIndent().length() - 4)+Keyword.IF + Symbol.BRACKETS + Symbol.BRACE);
		int index = def.indexOf(Symbol.LEFT_BRACKET);
		def.insert(index + 1, this._condition);
		index = def.indexOf(Symbol.RIGHT_BRACE);
		def.insert(index, this.getIndent().substring(0, this.getIndent().length() - 4));
		return def.toString()+Symbol.RETURN;
	}

	@Override
	public String toString() {
		StringBuilder _this = new StringBuilder();
		int index = _def().indexOf(Symbol.RETURN);
		_this.append(_def()).insert(index +2, Function.getSections(this._content,this.getIndent()));
		_this=this._elzeif==null?_this:_this.append(Function.getSections(this._elzeif,this.getIndent()));
		_this=this._elze==null?_this:_this.append(this._elze.toString());
		return _this.toString();
	}

}
