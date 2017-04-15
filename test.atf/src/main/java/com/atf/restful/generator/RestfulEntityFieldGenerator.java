package com.atf.restful.generator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.atf.support.compile.FieldGenerator;
import com.atf.support.compile.syntax.Symbol;
import com.atf.support.compile.types.base.ResolvedType;

/**
 * @author charlse
 * @version
 * @time 2017年3月30日 下午2:35:52
 * @desption
 */
public class RestfulEntityFieldGenerator extends FieldGenerator {

	List<String> annos = new ArrayList<String>();

	public RestfulEntityFieldGenerator(ResolvedType type) {
		super(type);
	}

	@Override
	public String _def() {
		String def = super._def();
		def = getAnnotations() + def;
		return def;
	}

	public void addAnnotation(String anno) {
		String str = "@" + anno;
		this.annos.add(str);
	}

	private String getAnnotations() {
		String anno = "";
		Iterator<String> it = annos.iterator();
		while (it.hasNext()) {
			anno += this._parent.getIndent()+it.next() + Symbol.RETURN;
		}
		return anno;
	}
}
