package com.atf.support.compile.layout;

import java.util.ArrayList;
import java.util.List;

import com.atf.support.compile.factor.Function;
import com.atf.support.compile.syntax.Keyword;
import com.atf.support.compile.syntax.Symbol;

/**
 * @author charlse
 * @version
 * @time 2017年3月28日 下午5:33:21
 * @desption
 */
public class LoopFor extends AbstractLayout implements Compment {
	String _factor;
	String _condition;
	String _pattern;
	List<Section> content = new ArrayList<Section>();

	public LoopFor(String factor, String condition, String pattern) {
		this._factor = factor;
		this._condition = condition;
		this._pattern = pattern;
	}

	@Override
	public String toString() {
		StringBuilder _this = new StringBuilder();
		int index = _def().indexOf(Symbol.RETURN);
		_this.append(_def()).insert(index + 2, Function.getSections(this._content,this.getIndent()));
		return _this.toString();
	}

	@Override
	public String _def() {
		StringBuilder def = new StringBuilder();
		def.append(this.getIndent().substring(0, this.getIndent().length() - 4)+Keyword.FOR + Symbol.BRACKETS + Symbol.BRACE);
		int index = def.indexOf(Symbol.LEFT_BRACKET);
		def.insert(index + 1, this._factor+";"+this._condition+";"+this._pattern);
		index = def.indexOf(Symbol.RIGHT_BRACE);
		def.insert(index, this.getIndent().substring(0, this.getIndent().length() - 4));
		return def.toString()+Symbol.RETURN;
	}
}
