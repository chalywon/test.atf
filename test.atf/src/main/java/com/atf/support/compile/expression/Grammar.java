package com.atf.support.compile.expression;

import com.atf.support.compile.syntax.Keyword;
import com.atf.support.compile.syntax.Operator;
import com.atf.support.compile.syntax.Symbol;

/**
	*@author charlse
	*@version 
	*@time 2017年3月29日 上午10:39:23
	*@desption
*/
public class Grammar {
	
	public static String getExpReturn(String value)
	{
		return Keyword.RETURN+Symbol.SPACE+value+Symbol.SEMICOLON;
	}
	
	public static String getExpDot(String obj,String value){
		return obj+Operator.DOT+value;
	}
	
	public static String getExpAssign(String obj,String value){
		return obj+Operator.ASSIGN+value;
	}
	
	public static String getExpGenericType(String clazz,String genericType){
		return clazz+Symbol.LEFT_ANGLEBRACKET+genericType+Symbol.RIGHT_ANGLEBRACKET;
	}

}
