package com.atf.restful.generator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.atf.support.compile.MethodGenerator;
import com.atf.support.compile.factor.Scope;
import com.atf.support.compile.syntax.Symbol;

/**
 * @author charlse
 * @version
 * @time 2017年3月30日 下午5:38:53
 * @desption
 */
public class RestfulEntityMethodGenerator extends MethodGenerator {

	List<String> annos = new ArrayList<String>();

	public RestfulEntityMethodGenerator(String type, String name) {
		super(type, name);
	}

	public RestfulEntityMethodGenerator(Scope scope, String type, String name) {
		super(scope, type, name);
	}

	public void addAnnotation(String anno) {
		String str = "@" + anno;
		this.annos.add(str);
	}

	@Override
	public String _def() {
		String def = super._def();
		def = getAnnotations() + def;
		return def;
	}

	private String getAnnotations() {
		String anno = "";
		Iterator<String> it = annos.iterator();
		while (it.hasNext()) {
			anno += this.getIndent().substring(0, this.getIndent().length() - 4) + it.next() + Symbol.RETURN;
		}
		return anno;
	}
}
