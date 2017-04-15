package com.atf.support.compile.layout;

import java.util.ArrayList;
import java.util.List;

import com.atf.support.compile.factor.Function;
import com.atf.support.compile.syntax.Keyword;
import com.atf.support.compile.syntax.Symbol;
import com.atf.support.compile.types.base.ResolvedType;

/**
 * @author charlse
 * @version
 * @time 2017年3月28日 下午5:35:48
 * @desption
 */
public class ConditionSwitch extends AbstractLayout implements Compment {
	protected String _condition;

	public ConditionSwitch(String condition) {
		this._condition = condition;
	}

	public String _def() {
		StringBuilder def = new StringBuilder();
		def.append(this.getIndent().substring(0, this.getIndent().length() - 4) + Keyword.SWITCH + Symbol.BRACKETS
				+ Symbol.BRACE);
		int index = def.indexOf(Symbol.LEFT_BRACKET);
		def.insert(index + 1, this._condition);
		index = def.indexOf(Symbol.RIGHT_BRACE);
		def.insert(index, this.getIndent().substring(0, this.getIndent().length() - 4));
		return def.toString() + Symbol.RETURN;
	}

	@Override
	public String toString() {
		StringBuilder _this = new StringBuilder();
		int index = _def().indexOf(Symbol.LEFT_BRACE);
		_this.append(_def()).insert(index + 3, Function.getSections(this._content, this.getIndent()));
		return _this.toString();
	}
}
