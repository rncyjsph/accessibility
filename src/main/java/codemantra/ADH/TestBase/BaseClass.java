package codemantra.ADH.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;



public class BaseClass {
	public static WebDriver driver;
	public static Properties prop;
	
	public BaseClass()
	{
		try {
			prop=new Properties();
			//FileInputStream ip=new FileInputStream("C:\\Users\\codemantra\\git\\accessibility-qa-script\\src\\main\\java\\codemantra\\ADH\\configuration\\config.properties");
			FileInputStream ip=new FileInputStream("src/main/java/codemantra/ADH/configuration/config.properties");
			prop.load(ip);
			
		} catch (FileNotFoundException e) {
						e.printStackTrace();
		} catch (IOException e) {
						e.printStackTrace();
		}
	}
		
		
		public static void initialization() throws ClassNotFoundException
		{
			String browsername=prop.getProperty("browser");
			//ChromeOptions options = new ChromeOptions();
			
			if (browsername.equals("chrome"))
			{
				//String os=System.getProperty("os.name").toLowerCase();
				//ChromeOptions options = new ChromeOptions();
				//if(os.contains("linux"))
				//{
				//	System.setProperty("webdriver.chrome.driver","/usr/bin/chromedriver");
					//options.setBinary("/usr/bin/google-chrome");
					
					//options.addArguments("window-size=1400,800");
					//options.addArguments("--headless");
					
					//options.addArguments("--headless");
					//options.setHeadless(true);
					
					//final DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
					//desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, options);
					
				//System.setProperty("webdriver.chrome.driver","chromedriver_win32/chromedriver.exe");
					
				String path = System.getProperty("user.dir");
				
				String driverPath = path + "\\chromedriver_win32\\chromedriver.exe";
					System.setProperty("webdriver.chrome.driver",driverPath);
					//driver=new ChromeDriver();
					
					//Map<String, Object> prefs = new HashMap<String, Object>();
					HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
					chromePrefs.put("profile.default_content_settings.popups", 0);
					
					//prefs.put("download.default_directory", "D:\\Project\\qaoutput");
					String downloadpath=path + "\\src\\test\\resources\\downloads";
					System.out.println("The path where files are downloaded from QA folder :" + downloadpath);
					chromePrefs.put("download.default_directory", downloadpath);
					ChromeOptions options = new ChromeOptions();
					
					options.setExperimentalOption("prefs", chromePrefs);
					

					 driver = new ChromeDriver(options);
					
				}
				
				
								
								
				
			
			
			else if (browsername.equals("IE"))
				
				{
					System.setProperty("webdriver.ie.driver","driverpath_IE");
					driver = new InternetExplorerDriver();
				}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(200,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		
		
	}
	
}

