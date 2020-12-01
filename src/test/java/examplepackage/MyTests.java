package examplepackage;

import org.testng.annotations.Test;

import junit.framework.Assert;

public class MyTests {
	
	//@Test(retryAnalyzer=analyzer.RetryAnalyzer.class) //test level 
	@Test
	public void test1()
	{
		Assert.assertEquals(true, false);
	}

	@Test
	public void test2()
	{
		Assert.assertEquals(true, false);
	}
}
