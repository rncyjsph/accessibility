package examplepackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoogleTest {
	WebDriver driver;
	@BeforeMethod
	public void setUp()
	{
	 
	System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
	driver= new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	driver.get("http://www.google.com");
	

}
	@Test(priority=1,groups= {"title"})
	public void googleTitleTest()
	{
		String title=driver.getTitle();
		System.out.println(title);
	}
	
	@Test(priority=2,groups= {"Logo"})
	public void googlLogoTest()
	{
		boolean dis=driver.findElement(By.xpath("//img[@id='hplogo']")).isDisplayed();
		System.out.println(dis);
	}
	
	@Test(priority=3,groups= {"Link"})
	public void mailTest()
	{
		boolean g=driver.findElement(By.linkText("Gmail")).isDisplayed();
		System.out.println(g);
	}
	@Test(priority=5,groups= {"test"})
	public void test1() {
		System.out.println("Test1");
	}
	@Test(priority=4,groups= {"test"})
	public void test2() {
		System.out.println("Test2");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
