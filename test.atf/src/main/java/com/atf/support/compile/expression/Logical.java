package com.atf.support.compile.expression;

import com.atf.support.compile.syntax.Operator;

/**
	*@author charlse
	*@version 
	*@time 2017年3月29日 上午10:21:53
	*@desption
*/
public class Logical {
	
	public static String getExpNot(String obj){
		return Operator.NOT+obj;
	}
	
	public static String getExpAnd(String exp1,String exp2){
		return exp1+Operator.AND+exp2;
	}
	
	public static String getExpOr(String exp1,String exp2){
		return exp1+Operator.OR+exp2;
	}

}
