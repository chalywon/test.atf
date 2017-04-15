package com.atf.support.compile.dynamic;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.ToolProvider;
import javax.tools.JavaCompiler.CompilationTask;

import com.atf.support.compile.ClassGenerator;

public class DynamicCompileEngine {

	String buildpath;
	String classpath;
	String sourcepath;
	String jars="";

	public DynamicCompileEngine(String buildpath,String classpath,String sourcepath) {
		this.buildpath = buildpath;
		this.classpath=classpath;
		this.sourcepath=sourcepath;
		

	}

	public void compile(ClassGenerator clazzw) throws Exception {
		List<JavaFileObject> jfiles = new ArrayList<JavaFileObject>();
		jfiles.add(new JavaStringObject(clazzw.getName(), clazzw.toString()));
		jars=getJarFiles(classpath);
		Iterable<String> options= Arrays.asList("-encoding", "UTF-8", "-classpath", jars, "-d", buildpath, "-sourcepath", jars);
		JavaCompiler javaCompiler = ToolProvider.getSystemJavaCompiler();
		CompilationTask task = javaCompiler.getTask(null, null, null, options, null, jfiles);
		task.call();
	}
	
	private String getJarFiles(String jarPath) throws Exception {
        File sourceFile = new File(jarPath);
        if (sourceFile.exists()) {
            if (sourceFile.isDirectory()) {
                File[] childrenFiles = sourceFile.listFiles(new FileFilter() {
                    public boolean accept(File pathname) {
                        if (pathname.isDirectory()) {
                            return true;
                        } else {
                            String name = pathname.getName();
                            if (name.endsWith(".jar") ? true : false) {
                                jars = jars + pathname.getPath() + ":";
                                return true;
                            }
                            return false;
                        }
                    }
                });
            }
        }
        return jars;
    }
}