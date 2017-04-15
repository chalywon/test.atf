package com.atf.support.compile.expression;

import com.atf.support.compile.syntax.Operator;

/**
 * @author charlse
 * @version
 * @time 2017年3月29日 上午10:18:07
 * @desption
 */
public class Comparison {

	public static String getExpEqual(String obj1, String obj2) {
		return obj1 + Operator.EQUALS + obj2;
	}

	public static String getExpUnEqual(String obj1, String obj2) {
		return obj1 + Operator.UNEQUALS + obj2;
	}

	public static String getExpGreater(String obj1, String obj2) {
		return obj1 + Operator.GREATER + obj2;
	}

	public static String getExpGE(String obj1, String obj2) {
		return obj1 + Operator.GREATER_EQUALS + obj2;
	}

	public static String getExpLess(String obj1, String obj2) {
		return obj1 + Operator.LESS + obj2;
	}

	public static String getExpLE(String obj1, String obj2) {
		return obj1 + Operator.LESS_EQUALS + obj2;
	}
}
