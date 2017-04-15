package com.atf.restful.util;

import java.lang.reflect.Field;
import java.util.Arrays;

public class RestUtil {

    /**
     * 获取类相对于classpath的路径，如类型为a.b.c.D，则返回a/b/c
     * @param classz
     * @return
     */
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
    
    public boolean equals(Object src,Object target) {
		Class<?> clazz = src.getClass();
		Class<?> clazzTarget = target.getClass();
		if (clazz != clazzTarget)
			return false;
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			if (!ClassParser.comparable(field.getType())) {
				try {
					throw new Exception("class " + this.getClass().getSimpleName()
							+ " hava field need to override method equals,you need to implement a method to compare object!"
							+ "class: " + this.getClass().getSimpleName() + " field: " + field.getName() + ","
							+ "field type: " + field.getType().getSimpleName());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			try {

				field.setAccessible(true);
				Object value1 = field.get(this);
				Object value2 = field.get(target);
				boolean diff = true;
				if (field.getType().isArray())
					diff = Arrays.equals((Object[]) value1, (Object[]) value2);
				else
					diff = value1.equals(value2);
				if (!diff)
					return false;
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return true;
	}

}
