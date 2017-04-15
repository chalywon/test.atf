package com.atf.restful.generator;

import com.atf.support.compile.ClassGenerator;
import com.atf.support.compile.factor.Scope;
import com.atf.support.compile.types.TypeString;

/**
 * @author charlse
 * @version
 * @time 2017年3月30日 下午2:33:53
 * @desption
 */
public class RestfulEntityGenerator extends ClassGenerator {

	public RestfulEntityGenerator(Scope scope, String name) {
		super(scope, name);
		addBaseImport();
		addBaseInterface();
		addBaseMethod();
		addBaseProperty();
	}

	protected void addBaseInterface() {
		this.addInterfs("Entity");
	}

	protected void addBaseImport() {
		super.addImport("com.atf.restful.Entity");
		super.addImport("com.fasterxml.jackson.annotation.JsonIgnore");
		super.addImport("com.fasterxml.jackson.core.JsonProcessingException");
		super.addImport("com.fasterxml.jackson.databind.ObjectMapper");
	}

	protected void addBaseMethod() {
		RestfulEntityMethodGenerator method = new RestfulEntityMethodGenerator(Scope.PUBLIC, "String", "toJson");
		method.setParent(this);
		method.addThrows("JsonProcessingException");
		method.append("ObjectMapper mapper=new ObjectMapper()");
		method.append("this.json=mapper.writeValueAsString(this)");
		method.append("return this.json");
		this.append(method);
	}

	protected void addBaseProperty() {
		TypeString ts = new TypeString("json");
		RestfulEntityFieldGenerator property = new RestfulEntityFieldGenerator(ts);
		property.addAnnotation("JsonIgnore");
		property.setParent(this);
		this.append(property);
	}

}
