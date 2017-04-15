package com.atf.restful.generator;

import com.atf.support.compile.factor.Scope;
import com.atf.support.compile.types.TypeRefer;

/**
 * @author charlse
 * @version
 * @time 2017年3月30日 下午6:36:06
 * @desption
 */
public class RestfulPostEntityGenerator extends RestfulEntityGenerator {

	public RestfulPostEntityGenerator(Scope scope, String name) {
		super(scope, name);
	}

	protected void addBaseInterface() {
		this.addInterfs("PostEntity");
	}

	protected void addBaseImport() {
		super.addBaseImport();
		this.addImport("com.atf.restful.PostEntity");
		this.addImport("org.apache.http.entity.StringEntity");
	}

	protected void addBaseMethod() {
		super.addBaseMethod();
	}

	protected void addBaseProperty() {
		super.addBaseProperty();
		TypeRefer tf = new TypeRefer("StringEntity", "entity");
		RestfulEntityFieldGenerator property = new RestfulEntityFieldGenerator(tf);
		property.addAnnotation("JsonIgnore");
		RestfulEntityMethodGenerator method = new RestfulEntityMethodGenerator(Scope.PUBLIC, "StringEntity", "getEntity");
		method.addThrows("JsonProcessingException");
		method.append("StringEntity entity=new StringEntity(toJson(),\"UTF-8\")");
		method.append("return entity");
		property.setGetter(method);
		this.append(property);
	}
}
