package sample;

import java.io.File;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
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
		driver.get("https://accessibilityptuat.codemantra.com/login");
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
		wb.sendKeys("MathProject");
		Thread.sleep(3000);

		WebElement c = driver.findElement(By.xpath("//input[@id='search_submit']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", c);
		Thread.sleep(5000);
		WebElement t = driver
				.findElement(By.xpath("//div[@id='myproject']//table[@class='table']/tbody/tr[1]/td[1]/a[1]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", t);

		driver.manage().timeouts().pageLoadTimeout(5000, TimeUnit.SECONDS);
		//Thread.sleep(10000);
		//WebElement source=driver.findElement(By.xpath("//span[@class='ng-binding ng-scope'][contains(text(),'Source')]"));
		//WebDriverWait wait = new WebDriverWait(driver, 5000);
		
		//wait.until(ExpectedConditions.elementToBeClickable(source));
		//Thread.sleep(10000);
		//WebElement sourceplus=driver.findElement(By.xpath("//span[@id='a97729-22c']"));
		
		//source.click();
				
		//Thread.sleep(10000);
		
		//source delete
		
		/*WebElement source_filedelete=driver.findElement(By.xpath("//div[@class='accordion-header collapsed'][@data-service-id='22']//div[@class='repository-adding-files-symbol row ng-scope']//a//span[@class='delete-svg-plus']"));
			WebDriverWait d=new WebDriverWait(driver,10000);
			 d.until(ExpectedConditions.visibilityOf(source_filedelete));
			 source_filedelete.click(); 
			WebElement delete_message=driver.findElement(By.xpath("//div[@class='modal-header'][@aria-label='Remove folder and files']"));
			 String removemssg=delete_message.getText();
			 
			 System.out.println(removemssg); 
			 List<WebElement> files_tobe_deleted=driver.findElements(By.xpath("//div[@class='col-md-11 col-sm-10 col-xs-9 no-padding']/span[2]/span[1]"));
			 int filecount=files_tobe_deleted.size();
			 System.out.println("Number of files uploaded in source folder  :" + filecount);
			//for(WebElement f:files_tobe_deleted) 
			 for(int fc=0;fc<filecount;fc++) {
			 
			File f = new File("src/test/resources/Bitcoin_A2.pdf"); 
			//	 File f = new File(prop.getProperty("filepath1")); 
				 String p=f.getName();
			System.out.println(p); 
			String fullfilename=files_tobe_deleted.get(fc).getText();
			System.out.println("Filename with upload date" + fullfilename); 
			String[] div=fullfilename.split(" "); 
			String first = div[0]; 
			String sec = div[1]; 
			int lenfirst=first.length(); 
			String onlyfile=fullfilename.substring(0, lenfirst);
			System.out.println("The required file to be deleted is :" + onlyfile);
			
			
			if(onlyfile.equals(p)) {
				List <WebElement> checkbox=driver.findElements(By.xpath("//div[@class='checkbox checkbox-success']/input[@name='user_checkbox[]']"));
			d.until(ExpectedConditions.visibilityOfAllElements(checkbox)); 
		//WebElement validationError=driver.findElement(By.xpath("//div[@class='validation-error']"));
		//	String actualdelvalidatemssg=validationError.getText();
		//System.out.println(actualdelvalidatemssg); 
			//String expecteddelvalidatemssg="No Files and folder selected";
			//Assert.assertEquals(expecteddelvalidatemssg, actualdelvalidatemssg);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();",checkbox.get(fc)); 
			Thread.sleep(1000); 
			WebElement f_delete= driver.findElement(By.xpath("//button[@id='removeFold_button001']"));
			f_delete.click(); 
			
			}
			
			 }*/
			 
			Thread.sleep(10000);
			
			//alt text delete
			WebElement alttext_filedelete=driver.findElement(By.xpath("//div[@class='accordion-header collapsed'][@data-service-id='25']//div[@class='repository-adding-files-symbol row ng-scope']//a//span[@class='delete-svg-plus']"));
			WebDriverWait a=new WebDriverWait(driver,5000);
			 a.until(ExpectedConditions.visibilityOf(alttext_filedelete));
			 alttext_filedelete.click();
			// ((JavascriptExecutor) driver).executeScript("arguments[0].click();",alttext_filedelete); 
			 // alttext_filedelete.click(); 
			WebElement altdelete_message=driver.findElement(By.xpath("//div[@class='modal-header'][@aria-label='Remove folder and files']"));
			String altremovemssg=altdelete_message.getText();
			 
			System.out.println(altremovemssg); 
			 List<WebElement> files_tobe_deleted=driver.findElements(By.xpath("//div[@class='col-md-11 col-sm-10 col-xs-9 no-padding']/span[2]/span[1]"));
			 //Thread.sleep(1000);
			a.until(ExpectedConditions.visibilityOfAllElements(files_tobe_deleted));
			 int alt_filecount=files_tobe_deleted.size();
			 System.out.println("Number of files uploaded :" + alt_filecount);
			 /*File f = new File("src/test/resources/Bitcoin_A2.pdf"); 
				//	 File f = new File(prop.getProperty("filepath1")); 
					 String p=f.getName();
				System.out.println(p); */
			//for(WebElement f:files_tobe_deleted) 
			 for(int fc=0;fc<alt_filecount;fc++) {
			 
				 File f = new File("src/test/resources/Bitcoin_A2.pdf"); 
					//	 File f = new File(prop.getProperty("filepath1")); 
						 String p=f.getName();
					System.out.println(p); 
			//List<WebElement> afiles_tobe_deleted=driver.findElements(By.xpath("//div[@class='col-md-11 col-sm-10 col-xs-9 no-padding']/span[2]/span[1]"));
			String fullfilename=files_tobe_deleted.get(fc).getText();
			System.out.println("Filename with upload date" + fullfilename); 
			String[] at = fullfilename.split("AltText");
			String first = at[0];
			//String second = at[1];
			System.out.println(first);
			int l = first.length();
			String expfilename = first.substring(0, l - 1);
			String pdffile = expfilename + ".pdf";
			System.out.println("The pdf file is " + pdffile);
			//Assert.assertEquals(p, pdffile);
			
			
			if(pdffile.equals(p)) {
				List <WebElement> checkbox=driver.findElements(By.xpath("//div[@class='checkbox checkbox-success']/input[@name='user_checkbox[]']"));
			a.until(ExpectedConditions.visibilityOfAllElements(checkbox)); 
		//WebElement validationError=driver.findElement(By.xpath("//div[@class='validation-error']"));
		//	String actualdelvalidatemssg=validationError.getText();
		//System.out.println(actualdelvalidatemssg); 
			//String expecteddelvalidatemssg="No Files and folder selected";
			//Assert.assertEquals(expecteddelvalidatemssg, actualdelvalidatemssg);
			Thread.sleep(1000); 
			((JavascriptExecutor) driver).executeScript("arguments[0].click();",checkbox.get(fc)); 
			Thread.sleep(1000); 
			WebElement f_delete= driver.findElement(By.xpath("//button[@id='removeFold_button001']"));
			f_delete.click(); 
			
			}
			
			 }	 
			 
			 Thread.sleep(10000);
			 //Process delete
			 
			 WebElement process_filedelete=driver.findElement(By.xpath("//div[@class='accordion-header collapsed'][@data-service-id='23']//div[@class='repository-adding-files-symbol row ng-scope']//a//span[@class='delete-svg-plus']"));
				WebDriverWait pi=new WebDriverWait(driver,10000);
				 pi.until(ExpectedConditions.visibilityOf(process_filedelete));
				 //process_filedelete.click(); 
				  process_filedelete.click();
				//WebElement delete_message=driver.findElement(By.xpath("//div[@class='modal-header'][@aria-label='Remove folder and files']"));
				// String removemssg=delete_message.getText();
				 
				// System.out.println(removemssg); 
				 List<WebElement> pfiles_tobe_deleted=driver.findElements(By.xpath("//div[@class='col-md-11 col-sm-10 col-xs-9 no-padding']/span[2]/span[1]"));
				 //pi.until(ExpectedConditions.visibilityOfAllElements(pfiles_tobe_deleted));
				 Thread.sleep(5000);
				 int pfilecount=pfiles_tobe_deleted.size();
				 System.out.println("Number of files uploaded in process folder  :" + pfilecount);
				//for(WebElement f:files_tobe_deleted) 
				 for(int fc=0;fc<pfilecount;fc++) {
				 
				File fi = new File("src/test/resources/Bitcoin_A2.pdf"); 
				//	 File f = new File(prop.getProperty("filepath1")); 
					 String pr=fi.getName();
				System.out.println(pr); 
				String fullfilename=pfiles_tobe_deleted.get(fc).getText();
				System.out.println("Filename with upload date" + fullfilename); 
				String[] div=fullfilename.split(" "); 
				String first = div[0]; 
				String sec = div[1]; 
				int lenfirst=first.length(); 
				String only=fullfilename.substring(0, lenfirst);
				System.out.println("The required file to be deleted is :" + only);
				
				
				if(only.equals(pr)) {
					List <WebElement> checkbox=driver.findElements(By.xpath("//div[@class='checkbox checkbox-success']/input[@name='user_checkbox[]']"));
				pi.until(ExpectedConditions.visibilityOfAllElements(checkbox)); 
			//WebElement validationError=driver.findElement(By.xpath("//div[@class='validation-error']"));
			//	String actualdelvalidatemssg=validationError.getText();
			//System.out.println(actualdelvalidatemssg); 
				//String expecteddelvalidatemssg="No Files and folder selected";
				//Assert.assertEquals(expecteddelvalidatemssg, actualdelvalidatemssg);
				((JavascriptExecutor) driver).executeScript("arguments[0].click();",checkbox.get(fc)); 
				Thread.sleep(1000); 
				WebElement f_delete= driver.findElement(By.xpath("//button[@id='removeFold_button001']"));
				f_delete.click(); 
			
				}
				
				 }
				 
			 
			 

		}


		
		
		
		
        /*WebElement viewfilebtn=driver.findElement(By.xpath("//span[@class='company-information-edit pull-right'][contains(text(),'View File')]"));
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

			
*/			
	}



