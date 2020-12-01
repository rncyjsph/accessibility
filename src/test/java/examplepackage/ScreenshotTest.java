 package examplepackage;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import junit.framework.Assert;

@Listeners(ListenerTest.class)
public class ScreenshotTest extends Base {
	
	@BeforeMethod
	public void setup()
	{
		init();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	@Test
	public void loginTest()
	{
		Assert.assertEquals(true, false);
	}
	@Test
	public void searchTest()
	{
		Assert.assertEquals(true, false);
	}
	@Test
	public void logoutTest()
	{
		Assert.assertEquals(true, false);
	}

}
