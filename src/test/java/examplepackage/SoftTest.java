package examplepackage;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import junit.framework.Assert;

public class SoftTest {
	
	SoftAssert softassert=new SoftAssert();
		
	@Test
	public void test1()
	{
		System.out.println("open browser");
		Assert.assertEquals(true, true);
		System.out.println("enter username");
		System.out.println("enter password");
		System.out.println("click next");
		
		Assert.assertEquals(true, true);
		System.out.println("validate home page");
		//Assert.assertEquals(true, false); //hard assertions
		
		softassert.assertEquals(true, false,"home page title is missing"); //soft assertions
		
		System.out.println("go to deals page");
		System.out.println("create deals");
		softassert.assertEquals(true, false,"not able to create a deal");//soft assertion
		
		System.out.println("go to contacts page");
		System.out.println("create contacts");
		softassert.assertEquals(true, false,"not able to find contact");//soft assertion
		
		
		softassert.assertAll();
		
		
	}

}
