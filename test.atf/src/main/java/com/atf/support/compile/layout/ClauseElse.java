package com.atf.support.compile.layout;

import com.atf.support.compile.factor.Function;
import com.atf.support.compile.syntax.Keyword;
import com.atf.support.compile.syntax.Symbol;

/**
 * @author charlse
 * @version
 * @time 2017年3月28日 下午5:38:42
 * @desption
 */
public class ClauseElse extends AbstractLayout implements Compment {
	protected String _condition;

	public ClauseElse() {
	}

	public ClauseElse(ConditionIF owner) {
		owner.append(this);
	}

	public String _def() {
		StringBuilder def = new StringBuilder();
		def.append(Keyword.ELSE + Symbol.BRACE);
		int index = def.indexOf(Symbol.RIGHT_BRACE);
		def.insert(index, this.getIndent().substring(0, this.getIndent().length() - 4));
		return def.toString();
	}
	
	@Override
	public String getIndent(){
		return this._parent.getIndent();
	}

	@Override
	public String toString() {
		StringBuilder _this = new StringBuilder();
		int index = _def().indexOf(Symbol.RETURN);
		_this.append(_def()).insert(index + 2, Function.getSections(this._content,this.getIndent()));
		return this.getIndent().substring(0, this.getIndent().length() - 4) + _this.toString();
	}

}
