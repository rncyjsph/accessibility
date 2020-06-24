package codemantra.ADH.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import codemantra.ADH.util.TestUtil;

public class BaseClass {
	public static WebDriver driver;
	public static Properties prop;
	
	public BaseClass()
	{
		try {
			prop=new Properties();
			FileInputStream ip=new FileInputStream("D:\\ADH_Workspace\\codemantra.ADH\\src\\main\\java\\codemantra\\ADH\\configuration\\config.properties");
			prop.load(ip);
			
		} catch (FileNotFoundException e) {
						e.printStackTrace();
		} catch (IOException e) {
						e.printStackTrace();
		}
	}
		
		
		public static void initialization()
		{
			String browsername=prop.getProperty("browser");
			if (browsername.equals("chrome"))
			{
				System.setProperty("webdriver.chrome.driver","D:\\chromedriver_win32\\chromedriver.exe");
				driver=new ChromeDriver();
			}
			
			else
				
				if (browsername.equals("IE"))
				{
					System.setProperty("webdriver.ie.driver","driverpath_IE");
					driver = new InternetExplorerDriver();
				}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PageLoadTimeOut, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.implicit_wait,TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
				
		
	}
	
}
