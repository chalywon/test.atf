package compile;

import org.testng.annotations.Test;

import com.atf.support.compile.ClassGenerator;
import com.atf.support.compile.FieldGenerator;
import com.atf.support.compile.MethodGenerator;
import com.atf.support.compile.factor.Scope;
import com.atf.support.compile.layout.ClauseCaseOfSwitch;
import com.atf.support.compile.layout.ClauseElse;
import com.atf.support.compile.layout.ClauseElseIF;
import com.atf.support.compile.layout.ConditionIF;
import com.atf.support.compile.layout.ConditionSwitch;
import com.atf.support.compile.layout.IterationFor;
import com.atf.support.compile.layout.LoopFor;
import com.atf.support.compile.layout.LoopWhile;
import com.atf.support.compile.types.TypeString;

public class ClauseTest {
	@Test
	public void f() {

		ClassGenerator clazz = new ClassGenerator(Scope.PUBLIC, "TestClass");
		MethodGenerator method = new MethodGenerator(Scope.PRIVATE, "Test");
		method.append("int i=0");
		System.out.println(method);
		clazz.append(method);
		System.out.println(clazz);
		ConditionIF iif = new ConditionIF("i==100");
		iif.append("String s=if test");
		System.out.println(iif);
		method.append(iif);
		System.out.println(clazz);
		ConditionIF iiif = new ConditionIF("i==2000");
		iiif.append("String IIIF");
		iif.append(iiif);
		System.out.println(clazz);
		ClauseElse elze = new ClauseElse();
		elze.append("System.out.println(hello world)");
		iiif.append(elze);
		ClauseElseIF eif = new ClauseElseIF("i==999");
		eif.append("String s=else if");
		iiif.append(eif);
		System.out.println(clazz);
		LoopFor lfor = new LoopFor("int i=0", "i<=100", "i++");
		lfor.append("String s=For Test");
		clazz.append(lfor);
		System.out.println(clazz);
		lfor.append(iif);
		System.out.println(clazz);

		IterationFor itf = new IterationFor("String f", "strings");
		itf.append("i++");
		itf.append(lfor);
		clazz.append(itf);
		System.out.println(clazz);

		LoopWhile lw = new LoopWhile("i<=100");
		lw.append("i++");
		clazz.append(lw);
		System.out.println(clazz);
		
		ClauseCaseOfSwitch scase=new ClauseCaseOfSwitch("PRO");
		ConditionSwitch sw=new ConditionSwitch("PROPERTY");
		sw.append("String str=\"hello world\"");
		scase.append("System.out.println(str)");
		sw.append(scase);
		clazz.append(sw);
		System.out.println(clazz);

	}
}
