package com.atf.support.compile.types.base;
/**
	*@author charlse
	*@version 
	*@time 2017年3月31日 下午9:01:10
	*@desption
*/
public interface ResolvedType {
	public String assign(String exp);
	public String equals(String exp);
	public String unequals(String exp);
	public String getName();
	public String getType();
}
