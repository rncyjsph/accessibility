package examplepackage;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class Base {
	public static WebDriver driver;
	public static void init()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.get("http://www.google.com");
	}
	
	public void fail(String testmethodname) throws IOException {
		File srcfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//FileHandler.copy(srcfile, dest);
		
		//FileUtils.copyFile(srcfile, new File("C:\\Users\\codemantra\\gitnew\\accessibility-qa-script\\screenshot\\testfailure.jpg"));
		FileUtils.copyFile(srcfile, new File("C:\\Users\\codemantra\\gitnew\\accessibility-qa-script\\screenshot\\" +testmethodname));
	}
	
	
}
