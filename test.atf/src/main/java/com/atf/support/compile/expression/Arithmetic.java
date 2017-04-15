package com.atf.support.compile.expression;

import com.atf.support.compile.syntax.Operator;

/**
	*@author charlse
	*@version 
	*@time 2017年3月29日 上午10:21:13
	*@desption
*/
public class Arithmetic {
	
	public static String getExpPlus(String obj1,String obj2){
		return obj1+Operator.PLUS+obj2;
	}
	
	public static String getExpMinus(String obj1,String obj2){
		return obj1+Operator.MINUS+obj2;
	}
	
	public static String getExpMultiple(String obj1,String obj2){
		return obj1+Operator.MULTIPLE+obj2;
	}
	
	public static String getExpDivisor(String obj1,String obj2){
		return obj1+Operator.DIVISOR+obj2;
	}
	
	public static String getExpIncrementBefore(String obj){
		return obj+Operator.INCREMENT;
	}
	
	public static String getExpIncrementAfter(String obj){
		return Operator.INCREMENT+obj;
	}
	
	public static String getExpDecrementBefore(String obj){
		return obj+Operator.DECREMENT;
	}
	
	public static String getExpDecrementAfter(String obj){
		return Operator.DECREMENT+obj;
	}
	
	

}
