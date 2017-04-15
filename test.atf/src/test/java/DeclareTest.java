
/**
	*@author charlse
	*@version 
	*@time 2017年3月28日 上午11:44:03
	*@desption
*/

import org.testng.annotations.Test;

import com.atf.support.compile.ClassGenerator;
import com.atf.support.compile.FieldGenerator;
import com.atf.support.compile.factor.Scope;
import com.atf.support.compile.types.TypeString;

public class DeclareTest {

	@Test
	public void runTest() {
		
		ClassGenerator clzz=new ClassGenerator(Scope.PUBLIC,"TestClass");
		FieldGenerator field=new FieldGenerator(new TypeString("field"));
		clzz.append(field);
		System.out.println(clzz);
		
	}

}
