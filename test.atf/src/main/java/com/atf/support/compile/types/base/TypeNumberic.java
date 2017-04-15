package com.atf.support.compile.types.base;

import com.atf.support.compile.factor.Modifier;
import com.atf.support.compile.factor.Scope;
import com.atf.support.compile.syntax.Operator;

/**
 * @author charlse
 * @version
 * @time 2017年4月1日 上午10:28:50
 * @desption
 */
public abstract class TypeNumberic extends TypeBase {
	public TypeNumberic(String name) {
		super(name);
	}

	public TypeNumberic(String name, String value) {
		super(name, value);
	}

	public TypeNumberic(Scope scope, String name) {
		super(scope, name);
	}

	public TypeNumberic(Scope scope, String name, String value) {
		super(scope, name, value);
	}

	public TypeNumberic(Modifier modifier, String name) {
		super(modifier, name);
	}

	public TypeNumberic(Modifier modifier, String name, String value) {
		super(modifier, name, value);
	}

	public TypeNumberic(Scope scope, Modifier modifier, String name) {
		super(scope, modifier, name);
	}

	public TypeNumberic(Scope scope, Modifier modifier, String name, String value) {
		super(scope, modifier, name, value);
	}

	public String add(String exp) {
		return this._name + Operator.PLUS + exp;
	}
	public String add_assign(String exp) {
		return this._name + Operator.PLUS + Operator.ASSIGN + exp;
	}
	public String minus(String exp){
		return this._name+Operator.MINUS+exp;
	}
	public String minus_assign(String exp){
		return this._name+Operator.MINUS+Operator.ASSIGN+exp;
	}
	public String multiple(String exp){
		return this._name+Operator.MULTIPLE+exp;
	}
	public String multiple_assign(String exp){
		return this._name+Operator.MULTIPLE+Operator.ASSIGN+exp;
	}
	public String divisor(String exp){
		return this._name+Operator.DIVISOR+exp;
	}
	public String divisor_assign(String exp){
		return this._name+Operator.DIVISOR+Operator.ASSIGN+exp;
	}
	public String mod(String exp){
		return this._name+Operator.MOD+exp;
	}
	public String mod_Assign(String exp){
		return this._name+Operator.MOD+exp+Operator.ASSIGN+exp;
	}
	
	public String greater(String exp){
		return this._name+Operator.GREATER+exp;
	}
	public String greater_equals(String exp){
		return this._name+Operator.GREATER_EQUALS+exp;
	}
	public String less(String exp){
		return this._name+Operator.LESS+exp;
	}
	public String less_equals(String exp){
		return this._name+Operator.LESS_EQUALS+exp;
	}

	public String incrementAfter() {
		return this._name + Operator.INCREMENT;
	}

	public String incrementBefore() {
		return Operator.INCREMENT + this._name;
	}

	public String decrementAfter() {
		return this._name + Operator.DECREMENT;
	}

	public String decrementBefore() {
		return Operator.DECREMENT + this._name;
	}

}
