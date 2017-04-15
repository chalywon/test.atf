package com.atf.support.engine;
/**
	*@author charlse
	*@version 
	*@time 2017年3月28日 上午9:12:47
	*@desption
*/
public interface Segment {
	public void addStatement(String statement);
	public void addSegment(Segment segment);

}
