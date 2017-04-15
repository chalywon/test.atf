package compile;
/**
	*@author charlse
	*@version 
	*@time 2017年3月30日 下午2:01:46
	*@desption
*/
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import org.testng.annotations.Test;

import com.atf.restful.generator.RestfulPostEntityGenerator;
import com.atf.support.compile.dynamic.DynamicCompileEngine;
import com.atf.support.compile.factor.Scope;
import com.atf.support.compile.syntax.Symbol;
import com.atf.support.compile.types.TypeInt;
import com.atf.support.compile.types.TypeRefer;
import com.atf.support.compile.types.TypeString;
import com.atf.restful.generator.RestfulEntityFieldGenerator;

public class DynamicBuildTest {
	@Test
	public void runTest() throws Exception {
		RestfulPostEntityGenerator clazz=new RestfulPostEntityGenerator(Scope.PUBLIC,"Restful");
		RestfulEntityFieldGenerator property=new RestfulEntityFieldGenerator(new TypeString("row_start_number","\"120\""));
		clazz.append(property);
		property=new RestfulEntityFieldGenerator(new TypeString("row_count","\"240\""));	
		clazz.append(property);
		property=new RestfulEntityFieldGenerator(new TypeInt("goods_commonid","12000021"));	
		clazz.append(property);
		property=new RestfulEntityFieldGenerator(new TypeString("goods_name","\"农夫山泉\""));
		clazz.append(property);
		property=new RestfulEntityFieldGenerator(new TypeString("goods_state","\"10\""));
		clazz.append(property);
		property=new RestfulEntityFieldGenerator(new TypeString("goods_verify","\"yes\""));	
		clazz.append(property);
		property=new RestfulEntityFieldGenerator(new TypeRefer("int[]","gc_ids","new int[]{100,200,300}"));	
		clazz.append(property);
		property=new RestfulEntityFieldGenerator(new TypeRefer("int[]","gc_ids_1","new int[]{12000,22000,23000}"));
		clazz.append(property);
		property=new RestfulEntityFieldGenerator(new TypeRefer("int[]","gc_ids_2","new int[]{22000,23000,24000}"));
		clazz.append(property);
		property=new RestfulEntityFieldGenerator(new TypeInt("brand_id","200010"));	
		clazz.append(property);
		property=new RestfulEntityFieldGenerator(new TypeString("brand_name","\"矿泉水\""));
		clazz.append(property);
		property=new RestfulEntityFieldGenerator(new TypeString("create_start_time","\"2016-12-11\""));	
		clazz.append(property);
		property=new RestfulEntityFieldGenerator(new TypeString("create_end_time","\"2017-12-11\""));
		clazz.append(property);
		clazz.setPkgName("com.atf.compile");
		
		System.out.println(clazz);
		DynamicCompileEngine dce=new DynamicCompileEngine("/Users/wangcheng/workspace/tomcat/wtpwebapps/APITest/WEB-INF/lib","/Users/wangcheng/workspace/tomcat/wtpwebapps/APITest/WEB-INF/lib","/Users/wangcheng/workspace/tomcat/wtpwebapps/APITest/WEB-INF/lib");
		dce.compile(clazz);
		URL[] urls = new URL[] { new URL("file:" + System.getProperty("user.dir") + "/") };
		@SuppressWarnings("resource")
		URLClassLoader classLoader = new URLClassLoader(urls);
		String clazzName = clazz.getPkgName() != null
				? clazz.getPkgName() + Symbol.DOT + clazz.getName() : clazz.getName();
		Class<?> clazz1 = classLoader.loadClass(clazzName);
		Object instance=clazz1.newInstance();
		Method method=clazz1.getDeclaredMethod("toJson",null);
		method.setAccessible(true);
		System.out.println(method.invoke(instance));
	}
	
	
	
	
	
	public static Method getMethod(Class clazz, String methodName,  
            final Class[] classes) throws Exception {  
        Method method = null;  
        try {  
            method = clazz.getDeclaredMethod(methodName, classes);  
        } catch (NoSuchMethodException e) {  
            try {  
                method = clazz.getMethod(methodName, classes);  
            } catch (NoSuchMethodException ex) {  
                if (clazz.getSuperclass() == null) {  
                    return method;  
                } else {  
                    method = getMethod(clazz.getSuperclass(), methodName,  
                            classes);  
                }  
            }  
        }  
        return method;  
    }  
}






