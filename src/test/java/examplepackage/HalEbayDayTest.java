package examplepackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import codemantra.ADH.util.Utility;

public class HalEbayDayTest {
	WebDriver driver;
	@BeforeMethod
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		 
		driver.get("https://signup.ebay.com/pa/crte?ru=https%3A%2F%2Fcommunity.ebay.com%2Ft5%2FArchive-eBay-Stores%2Fhttp-scgi-ebay-com-ws-eBayISAPI-dll-UserAgreement-amp-agrid-11%2Ftd-p%2F17468773");
	}
	//fetch data from excel file
	@DataProvider
	public Iterator<Object[]> getdataTest() 
	{
		ArrayList<Object[]> data=Utility.getDataFromExcel();
		return data.iterator(); //iterate in sequence
	}
	
	@Test(dataProvider="getdataTest")
	public void halfEbayRegTest(String firstname,String lastname,String email,String password)
	{
		driver.findElement(By.xpath("//input[@id='firstname']")).clear();
		driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys(firstname);
		driver.findElement(By.xpath("//input[@id='lastname']")).clear();
		driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys(lastname);
		driver.findElement(By.xpath("//input[@id='Email']")).clear();
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@id='password']")).clear();
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
		
		
		
		
		
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
