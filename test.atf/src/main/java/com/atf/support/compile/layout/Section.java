package com.atf.support.compile.layout;

import com.atf.support.compile.types.base.ResolvedType;

/**
	*@author charlse
	*@version 
	*@time 2017年3月28日 上午9:12:47
	*@desption
*/
public interface Section {
	public void append(String statement);
	public void append(Section section);
	public void append(ResolvedType type);
	public String getIndent();
	public void setParent(Section parent);
	public Section getParent();
}
