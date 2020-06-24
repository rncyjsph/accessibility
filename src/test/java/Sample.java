import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sample {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "D:\\\\chromedriver_win32\\\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://staging.codemantra.com/login");
		driver.findElement(By.id("user001")).sendKeys("rincy@codemantra.in");
		driver.findElement(By.id("pas001")).sendKeys("Test#123");
		driver.findElement(By.id("save_sla")).click();
		Thread.sleep(2000);
		WebElement add=driver.findElement(By.xpath("//button[@id='createMoreButtonA']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", add);
		Thread.sleep(2000);
		driver.findElement(By.id("title2")).sendKeys("test");
		

	}

}
