package sample;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import codemantra.ADH.TestBase.BaseClass;

public class Source extends BaseClass{

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://staging.codemantra.com/login");
		driver.manage().window().maximize();
		driver.findElement(By.id("user001")).sendKeys("rincy@codemantra.in");
		driver.findElement(By.id("pas001")).sendKeys("Test#123");
		// click login button
		driver.findElement(By.id("save_sla")).click();
		
		driver.manage().timeouts().pageLoadTimeout(1000, TimeUnit.SECONDS);
		Thread.sleep(5000);
		
		WebElement wb = driver.findElement(By.xpath("//input[@id='search']"));
		Thread.sleep(5000);
		wb.sendKeys(" ");
		wb.sendKeys("chennai1993");
		Thread.sleep(3000);

		WebElement c = driver.findElement(By.xpath("//input[@id='search_submit']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", c);
		Thread.sleep(5000);
		WebElement t = driver
				.findElement(By.xpath("//div[@id='myproject']//table[@class='table']/tbody/tr[1]/td[1]/a[1]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", t);

		driver.manage().timeouts().pageLoadTimeout(5000, TimeUnit.SECONDS);
		Thread.sleep(10000);
		WebElement source=driver.findElement(By.xpath("//span[@id='a97729-22a']"));
		WebDriverWait wait = new WebDriverWait(driver, 5000);
		
		wait.until(ExpectedConditions.elementToBeClickable(source));
		Thread.sleep(10000);
		WebElement sourceplus=driver.findElement(By.xpath("//span[@id='a97729-22c']"));
		
		sourceplus.click();
				
		Thread.sleep(2000);
        WebElement viewfilebtn=driver.findElement(By.xpath("//span[@class='company-information-edit pull-right'][contains(text(),'View File')]"));
        wait.until(ExpectedConditions.visibilityOf(viewfilebtn));
		viewfilebtn.click();
		String parentWindow=driver.getWindowHandle();
		Set<String> winhandles = driver.getWindowHandles();
		// Iterator<String> i=winhandles.iterator();
		// while(i.hasNext())
		// {
		// String handle = i.next();
		for (String handle : winhandles) 
		{
			if (!handle.equals(parentWindow)) 
			{
				driver.switchTo().window(handle);
				driver.manage().timeouts().pageLoadTimeout(500, TimeUnit.SECONDS);
				Thread.sleep(1000);
				String s_viewlink = driver.getCurrentUrl();
				System.out.println(s_viewlink);
				int count=1;
			
				List <WebElement> next =driver.findElements(By.xpath("//button[@id='nxt']"));
				
					Actions action=new Actions(driver);
				while((!next.isEmpty()) && (count <=5))
				{
				//if(next.get(0).isEnabled() && (next.size() > 0))
				//{					
					Thread.sleep(1000);
					action.moveToElement(next.get(0)).perform();
					wait.until(ExpectedConditions.elementToBeClickable(next.get(0)));
					Thread.sleep(5000);
					//next.click();
					((JavascriptExecutor) driver).executeScript("arguments[0].click();", next.get(0));
					
					
					WebElement modalcontent = driver.findElement(By.xpath("//div[@class='modal-content']"));

					WebElement ignore_yes = driver.findElement(By.xpath("//button[@id='modal-btn-si']"));

					if ((modalcontent != null) && (modalcontent.isDisplayed()))

					{

						action.moveToElement(ignore_yes).perform();
						ignore_yes.click();
					}
					

					
				//}
count=count+1;

		
				}
				WebElement savebtn = driver.findElement(By.xpath("//button[@id='savebtn']"));
				//Actions action = new Actions(driver);

				action.moveToElement(savebtn).build().perform();

				wait.until(ExpectedConditions.elementToBeClickable(savebtn));	
				Thread.sleep(5000);
				savebtn.click();
				
				}
		}

			
			
	}

}

