package examplepackage;

import org.testng.annotations.Test;

public class DepTest {

	@Test
	public void loginTest() {
		System.out.println("Login");
	}
	
	@Test(dependsOnMethods="loginTest")
	public void hompageTest() 
	{
		System.out.println("Home page");
	}
	
}
