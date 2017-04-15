package com.atf.support.compile.factor;

import java.util.Iterator;
import java.util.List;

import com.atf.support.compile.FieldGenerator;
import com.atf.support.compile.layout.Compment;
import com.atf.support.compile.layout.Section;
import com.atf.support.compile.syntax.Keyword;
import com.atf.support.compile.syntax.Symbol;
import com.atf.support.compile.types.base.ResolvedType;

/**
 * @author charlse
 * @version
 * @time 2017年3月28日 下午3:59:39
 * @desption
 */
public class Function {

	public static String getScope(Scope scope) {
		String _scope = null;
		switch (scope) {
		case PUBLIC:
			_scope = Keyword.PUBLIC;
			break;
		case PRIVATE:
			_scope = Keyword.PRIVATE;
			break;
		case PROTECTED:
			_scope = Keyword.PROTECTED;
			break;
		default:
			break;
		}
		return _scope;
	}

	public static String getModifier(Modifier modifier) {
		String _modifier = null;
		switch (modifier) {
		case STATIC:
			_modifier = Keyword.STATIC;
			break;
		case FINAL:
			_modifier = Keyword.FINAL;
			break;
		case ABSTRACT:
			_modifier = Keyword.ABSTRACT;
			break;
		case STATIC_FINAL:
			_modifier = Keyword.STATIC + Symbol.SPACE + Keyword.FINAL;
			break;
		}
		return _modifier;
	}

	public static String getSections(List<?> list, String format) {
		StringBuilder sb = new StringBuilder();
		if (list == null)
			return sb.toString();
		Iterator<?> it = list.iterator();
		while (it.hasNext()) {
			Object obj = it.next();
			if (Section.class.isAssignableFrom(obj.getClass()) || Compment.class.isAssignableFrom(obj.getClass()))
				sb = sb.append(obj.toString() + Symbol.RETURN);
			else
				sb = sb.append(format + obj.toString() + Symbol.SEMICOLON + Symbol.RETURN);
		}
		return sb.toString();
	}

	public static String firstUpper(String str) {
		char[] cs = str.toCharArray();
		cs[0] -= 32;
		return String.valueOf(cs);

	}
}
