package com.atf.support.compile.layout;

import com.atf.support.compile.types.base.ResolvedType;

/**
 * @author charlse
 * @version
 * @time 2017年3月28日 下午5:51:38
 * @desption
 */
public class ExceptionFinally implements Section {
	String format = "";

	public void setIndent(String format) {
		this.format += format;
	}

	public String getIndent() {
		return this.format;
	}

	@Override
	public void append(Section segment) {
		// TODO Auto-generated method stub

	}

	@Override
	public void append(String statement) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void append(ResolvedType type) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setParent(Section parent) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Section getParent() {
		// TODO Auto-generated method stub
		return null;
	}

}
