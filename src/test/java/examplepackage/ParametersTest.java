package examplepackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParametersTest {
	WebDriver driver;
	@Test
	@Parameters({"browser","url","emailid"})
	public void yahoologinTest(String browser,String url,String emailid)
	{
	 if(browser.equals("chrome"))
	 {
	System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
	driver= new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	 }
	driver.get(url);
	driver.findElement(By.id("login-username")).clear();
	driver.findElement(By.id("login-username")).sendKeys(emailid);
	driver.findElement(By.xpath("login-signin//input[@id='login-signin']")).click();
	

}

}
