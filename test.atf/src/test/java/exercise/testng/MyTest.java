package exercise.testng;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.Assert;

/**
	*@author charlse
	*@version 
	*@time 2017年3月8日 下午5:49:31
	*@desption
*/
public class MyTest {
	
	public boolean isBetween(int n,int lower,int upper){
		return n>lower && n<upper;
	}
	
	@Test(dataProvider="range-provider")
	public void testForisBetween(int n,int lower,int upper,boolean expect){
		
		System.out.println(n+":"+lower+"-"+upper+":"+expect);
		Assert.assertEquals(expect, isBetween(n,lower,upper));
		
	}
	
	@DataProvider(name="range-provider")
	public Object[][] rangeData(){
		int lower=5;
		int upper=10;
		return new Object[][]{
				{lower-1,lower,upper,false},
				{lower,lower,upper,false},
				{lower+1,lower,upper,true},
		};
	}

}
