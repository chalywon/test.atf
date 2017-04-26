package com.atf.support;
/**
	*@author charlse
	*@version 
	*@time 2017年3月10日 下午1:36:07
	*@desption
*/

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


public class Generics {
	
	@SuppressWarnings("unchecked")
	public static Class getSuperClassGenricType(Class clazz, int index) {

		Type genType = clazz.getGenericSuperclass();// 得到泛型父类

		if (!(genType instanceof ParameterizedType)) {

			return Object.class;
		}

		Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
		if (index >= params.length || index < 0) {

			throw new RuntimeException("你输入的索引"
					+ (index < 0 ? "不能小于0" : "超出了参数的总数"));
		}
		if (!(params[index] instanceof Class)) {

			return Object.class;
		}
		return (Class) params[index];
	}

	/**
	 * 通过反射,获得指定类的父类的第一个泛型参数的实际类型. 如DaoSupport<Buyer>
	 */
	@SuppressWarnings("unchecked")
	public static Class getSuperClassGenricType(Class clazz) {

		return getSuperClassGenricType(clazz, 0);
	}

	/**
	 * 通过反射,获得方法返回值泛型参数的实际类型. 如: public Map<String, Buyer> getNames(){}
	 */
	@SuppressWarnings("unchecked")
	public static Class getMethodGenericReturnType(Method method, int index) {

		Type returnType = method.getGenericReturnType();

		if (returnType instanceof ParameterizedType) {

			ParameterizedType type = (ParameterizedType) returnType;
			Type[] typeArguments = type.getActualTypeArguments();

			if (index >= typeArguments.length || index < 0) {

				throw new RuntimeException("你输入的索引"
						+ (index < 0 ? "不能小于0" : "超出了参数的总数"));
			}
			return (Class) typeArguments[index];
		}
		return Object.class;
	}

	/**
	 * 通过反射,获得方法返回值第一个泛型参数的实际类型. 如: public Map<String, Buyer> getNames(){}
	 */
	@SuppressWarnings("unchecked")
	public static Class getMethodGenericReturnType(Method method) {

		return getMethodGenericReturnType(method, 0);
	}

	/**
	 * 通过反射,获得方法输入参数第index个输入参数的所有泛型参数的实际类型. 如: public void add(Map<String,
	 */
	@SuppressWarnings("unchecked")
	public static List<Class> getMethodGenericParameterTypes(Method method,
			int index) {

		List<Class> results = new ArrayList<Class>();
		Type[] genericParameterTypes = method.getGenericParameterTypes();

		if (index >= genericParameterTypes.length || index < 0) {

			throw new RuntimeException("你输入的索引"
					+ (index < 0 ? "不能小于0" : "超出了参数的总数"));
		}
		Type genericParameterType = genericParameterTypes[index];

		if (genericParameterType instanceof ParameterizedType) {

			ParameterizedType aType = (ParameterizedType) genericParameterType;
			Type[] parameterArgTypes = aType.getActualTypeArguments();
			for (Type parameterArgType : parameterArgTypes) {
				Class parameterArgClass = (Class) parameterArgType;
				results.add(parameterArgClass);
			}
			return results;
		}
		return results;
	}

	/**
	 * 通过反射,获得方法输入参数第一个输入参数的所有泛型参数的实际类型. 如: public void add(Map<String, Buyer>
	 */
	@SuppressWarnings("unchecked")
	public static List<Class> getMethodGenericParameterTypes(Method method) {

		return getMethodGenericParameterTypes(method, 0);
	}

	/**
	 * 通过反射,获得Field泛型参数的实际类型. 如: public Map<String, Buyer> names;
	 */
	@SuppressWarnings("unchecked")
	public static Class getFieldGenericType(Field field, int index) {

		Type genericFieldType = field.getGenericType();

		if (genericFieldType instanceof ParameterizedType) {

			ParameterizedType aType = (ParameterizedType) genericFieldType;
			Type[] fieldArgTypes = aType.getActualTypeArguments();
			if (index >= fieldArgTypes.length || index < 0) {

				throw new RuntimeException("你输入的索引"
						+ (index < 0 ? "不能小于0" : "超出了参数的总数"));
			}
			return (Class) fieldArgTypes[index];
		}
		return Object.class;
	}

	/**
	 * 通过反射,获得Field泛型参数的实际类型. 如: public Map<String, Buyer> names;
	 */
	@SuppressWarnings("unchecked")
	public static Class getFieldGenericType(Field field) {

		return getFieldGenericType(field, 0);
	}
}