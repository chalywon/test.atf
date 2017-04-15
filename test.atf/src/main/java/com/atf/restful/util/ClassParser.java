package com.atf.restful.util;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.atf.restful.engine.RestfulHttpDriver;
import com.atf.support.util.Generics;

import java.lang.reflect.Field;

/**
 * @author charlse
 * @version
 * @time 2017年3月17日 下午2:35:15
 * @desption
 */
public class ClassParser {

	public static boolean compareble(Field field) {

		Class<?> fieldType = field.getType();
		Class<?> clazz;
		if (fieldType.isPrimitive() || fieldType == String.class)
			return true;
		else if (fieldType.isArray()) {
			clazz = Generics.getFieldGenericType(field);
		}
		else if(Map.class.isAssignableFrom(fieldType) || Set.class.isAssignableFrom(fieldType)){
			
		}
		else{
			
		}

		return false;
	}

	public static boolean comparable(Class<?> clazz) {
		if (clazz.isPrimitive())
			return true;
		if (clazz == String.class)
			return true;
		if (clazz.isArray()) {
			Class<?> subClazz = clazz.getComponentType();
			return comparable(subClazz);
		}

		do {
			if (clazz == RestfulHttpDriver.class)
				return true;
			clazz = clazz.getSuperclass();
		} while (clazz != Object.class);

		return false;
	}
	
	
	@SuppressWarnings("rawtypes")
    public static String getPackagePath(Class classz) {
        String path = classz.getName();
        path = path.replace("." + classz.getSimpleName(), "");
        path = path.replace(".", "/");

        return path;
    }

    public static String trimQuote(String str) {
        if (str != null) {
            str = str.replaceAll("\"", "");
        }

        return str;
    }

    public static boolean isBlank(String str) {
        if (str == null || str.trim().length() == 0) {
            return true;
        }

        return false;
    }

}
