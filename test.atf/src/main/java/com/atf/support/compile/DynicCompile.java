package com.atf.support.compile;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * @author charlse
 * @version
 * @time 2017年3月29日 下午6:06:27
 * @desption
 */
public class DynicCompile {
	String srcPath;
	String desPath;
	ClassGenerator classw;

	public DynicCompile(String srcPath, String desPath) {
		this.srcPath = srcPath;
		this.desPath = desPath;
	}

	public void writeFile(ClassGenerator classWriter) throws IOException {
		StringWriter writer = new StringWriter();
		PrintWriter out = new PrintWriter(writer);
		out.println(classw.toString());
		out.flush();
		out.close();
		
		
	}

}
