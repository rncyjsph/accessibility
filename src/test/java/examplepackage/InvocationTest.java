package examplepackage;

import org.testng.annotations.Test;

public class InvocationTest {
	/*@Test(invocationCount=2)
	public void sum()
	{
		int a=10;
		int b=20;
		int sum=a+b;
		System.out.println(sum);
	}*/
	
	@Test(expectedExceptions=NumberFormatException.class)
	public void ma()
	{
		String x="xxx";
		Integer.parseInt(x);
	}
}


