/*package sample;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import codemantra.ADH.TestBase.BaseClass;
import codemantra.ADH.pages.AddProjectPage;
import codemantra.ADH.pages.ProcessElementViewerPage;
import junit.framework.Assert;

public class TestingPurpose extends BaseClass {

	public static void main(String[] args) throws InterruptedException, AWTException, IOException {
		
		
		
	
		
		 * String abc="Bitcoin_A2_AltText.xlsx"; int len=abc.length();
		 * System.out.println(len); String[] splitting=abc.split("_"); for(String
		 * a:splitting) { System.out.println(a); }
		 * 
		 * String extract= abc.substring(abc.lastIndexOf('_') + 1, abc.indexOf('.'));
		 * System.out.println(extract);
		 
		// String c=abc.substring(abc.indexOf(ch))
		
		 * int i=extract.indexOf(extract); System.out.println(i);
		 * 
		 * String[] sp=abc.split("AltText"); String first=sp[0]; String second=sp[1];
		 * System.out.println(first); int l=first.length(); String w=first.substring(0,
		 * l-1); System.out.println(w); System.out.println(w + ".pdf");
		 * System.out.println(second);
		 

		ClipboardOwner owner = null;
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
		WebDriverWait wait = new WebDriverWait(driver, 5000);
		Thread.sleep(2000);
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
		Thread.sleep(2000);
		// Actions action = new Actions(driver);

		// WebElement addfileicon =
		// driver.findElement(By.xpath("//button[@id='createMoreButtonAs22']"));

		// action.moveToElement(addfileicon).perform();
		//System.out.println("Element identified");

		driver.manage().timeouts().pageLoadTimeout(500, TimeUnit.SECONDS);
		Thread.sleep(15000);
		
		//WebElement process = driver.findElement(By.xpath("//span[@id='a97729-23a']"));
		//wait.until(ExpectedConditions.visibilityOf(process));

		//Thread.sleep(5000);
		
WebElement alttextfilecount=driver.findElement(By.xpath("//div[@id='a97729-25']//span[@class='project-folder-name-date-time fileCount01']/b"));
String d=alttextfilecount.getText();
System.out.println(d);
int filecount=Integer.parseInt(d);
System.out.println("file count " + filecount);
		System.out.println();
		Thread.sleep(2000);

		//process.click();

		//Thread.sleep(5000);

		
		 * Path path=Paths.get(prop.getProperty("filepath1")); Path
		 * filename=path.getFileName(); String name=filename.toString();
		 * System.out.println("Filename: " + name ); try { WebElement
		 * viewLog=driver.findElement(By.
		 * xpath("//span[@class='company-information-edit pull-right'][contains(text(),'View Log ')]"
		 * ));
		 * 
		 * if (!name.isEmpty() && viewLog.isDisplayed())
		 * 
		 * {
		 
		// hread.sleep(5000);
		// WebElement
		// co=driver.findElement(By.xpath("//div[@id='a97729-25']//span[@class='project-folder-name-date-time
		// fileCount02']/b"));
		// String coo=co.getText();

		// System.out.println("hello");
		// System.out.println(coo);
		// int coi=Integer.valueOf(coo);
		// System.out.println(coi);
		
		 * if (coi > 0) {
		 
		driver.findElement(By.xpath("//span[@id='a97729-25c']")).click();
		Thread.sleep(5000);

		//WebElement viewfile = driver.findElement(
			//	By.xpath("//span[@class='company-information-edit pull-right'][contains(text(),'View File')]"));
		//viewfile.click();
		//String parentWindow = driver.getWindowHandle();
		//Set<String> procwinhandles = driver.getWindowHandles();
		//for (String handle : procwinhandles) {

			//if (!handle.equals(parentWindow)) {
			//	driver.switchTo().window(handle);
				//ProcessElementViewerPage ob=new ProcessElementViewerPage();
				//Thread.sleep(5000);
				
			//	Actions action = new Actions(driver);
			//WebElement clearorder=driver.findElement(By.xpath("//i[@class='fa fa-minus-circle']"));
			//	action.moveToElement(clearorder).perform();
		      //  Thread.sleep(1000);
				//((JavascriptExecutor) driver).executeScript("arguments[0].click();", clearorder);
				// if((clearreadingorder != null) && (clearreadingorder.isDisplayed()))
				// {
				Thread.sleep(1000);
				WebElement yes=driver.findElement(By.xpath("//button[@id='modal-btn-si']"));
				action.moveToElement(yes).build().perform();
				yes.click();
				// }
				 WebElement reorder=driver.findElement(By.xpath("//div[@class='rdorder']"));
				if (!reorder.isDisplayed()) {
					Assert.assertTrue(true);
				}
				Thread.sleep(2000);

				// help button
				WebElement help=driver.findElement(By.xpath("//i[@class='glyphicon glyphicon-question-sign']"));
				action.moveToElement(help).perform();
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", help);
				Thread.sleep(2000);
				
				WebElement helpmodalbox=driver.findElement(By.xpath("//h3[contains(text(),'Help - Shortcuts')]"));
				action.dragAndDropBy(helpmodalbox, 900, 10).build().perform();
				WebElement helpshortcut=driver.findElement(By.xpath("//div[@id='showHelp']//h3"));
				String expected_h=helpshortcut.getText();
				String actual_h="Help - Shortcuts";
				Assert.assertEquals("Validation of shortcut keys", expected_h, actual_h);
				Thread.sleep(2000);

				// reorder number in zones

				action.keyDown(Keys.CONTROL).keyDown(Keys.SHIFT).sendKeys("A").keyUp(Keys.CONTROL).keyUp(Keys.SHIFT).build()
						.perform();
				System.out.println("Zones are reordered by pressing Shortcut key CTRL+SHIFT+A");

				if (reorder.isDisplayed()) {
					Assert.assertTrue(true);
				}

				// metadata shortcut key

				action.keyDown(Keys.CONTROL).keyDown(Keys.ALT).sendKeys("M").build().perform();
			WebElement metabox=driver.findElement(By.xpath("//div[@id='metaDetails']"));
				//WebDriverWait wait = new WebDriverWait(driver, 90);
				wait.until(ExpectedConditions.visibilityOf(metabox));

				System.out.println("Metadata modal box is displayed by pressing shortcut key CTRL+Alt+M");

				action.keyUp(Keys.CONTROL).keyUp(Keys.ALT).build().perform();
				Thread.sleep(1000);
			WebElement metaclose=driver.findElement(By.xpath("//div[@id='closeMeta']"));
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", metaclose);
				Thread.sleep(2000);

				// taglist shortcut key

				action.keyDown(Keys.CONTROL).keyDown(Keys.ALT).sendKeys("T").build().perform();
				WebElement tagList=driver.findElement(By.xpath("//div[@id='TagList']"));
				wait.until(ExpectedConditions.visibilityOf(tagList));
				System.out.println("Tag List modal box is displayed by pressing keys CTRL+Alt+T");
				action.keyUp(Keys.CONTROL).keyUp(Keys.ALT).build().perform();
				action.dragAndDropBy(tagList, 60, 80).build().perform();
				Thread.sleep(1000);
				WebElement taglistclose=driver.findElement(By.xpath("//div[@id='closeTgList']"));
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", taglistclose);

				Thread.sleep(2000);

				// inspect shortcut key

				action.keyDown(Keys.CONTROL).keyDown(Keys.ALT).sendKeys("I").build().perform();
				WebElement inspectmodalbox=driver.findElement(By.xpath("//div[@id='inspct']"));
				wait.until(ExpectedConditions.visibilityOf(inspectmodalbox));
				System.out.println("Tag List modal box is displayed by pressing keys CTRL+Alt+I");
				action.keyUp(Keys.CONTROL).keyUp(Keys.ALT).build().perform();
				
				Thread.sleep(1000);
				WebElement inspectclose=driver.findElement(By.xpath("//div[@id='closeinspct']"));
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", inspectclose);

				Thread.sleep(2000);
				
				// Zoom In Zoom Out shortcut key
				//zoom out
				for (int z = 1; z <= 2; z++)
				{
				action.keyDown(Keys.CONTROL).keyDown(Keys.ALT).sendKeys("-").pause(Duration.ofSeconds(2)).build().perform();
				action.keyUp(Keys.CONTROL).keyUp(Keys.ALT).build().perform();
				}
				System.out.println("Zoom Out is performed by pressing keys CTRL+ Alt+ -");
				
					
				Thread.sleep(2000);
				//zoom in
				for (int z = 1; z <= 2; z++)
				{
				action.keyDown(Keys.CONTROL).keyDown(Keys.ALT).sendKeys("+").pause(Duration.ofSeconds(2)).build().perform();
				action.keyUp(Keys.CONTROL).keyUp(Keys.ALT).build().perform();
				}
				System.out.println("Zoom In is performed by pressing keys CTRL+Alt+ +");
				
					Thread.sleep(2000);
					//Save button shortcut key
					
					action.keyDown(Keys.CONTROL).keyDown(Keys.ALT).sendKeys("S").build().perform();
					action.keyUp(Keys.CONTROL).keyUp(Keys.ALT).build().perform();
					driver.manage().timeouts().pageLoadTimeout(1000, TimeUnit.SECONDS);
					System.out.println("Save is performed by pressing keys CTRL+Alt+ S");
					
					//Approve Button
					
					action.keyDown(Keys.CONTROL).keyDown(Keys.ALT).sendKeys("A").build().perform();
					action.keyUp(Keys.CONTROL).keyUp(Keys.ALT).build().perform();
					WebElement approvecancel=driver.findElement(By.xpath("//button[contains(text(),'Cancel')]"));
					
					
					wait.until(ExpectedConditions.elementToBeClickable(approvecancel));
					Thread.sleep(1000);
					approvecancel.click();
					System.out.println("Save is performed by pressing keys CTRL+Alt+ A");
					
					//shortcut keys for move box up , down,left ,right
					
					try {
					List<WebElement> l = driver.findElements(By.xpath("//div[@class='elementx']"));

					int no_of_elements = l.size();
					System.out.println("Number of elements found on current page is  " + no_of_elements);
					for (int e = 0; e < no_of_elements; e++) {
						String element = l.get(e).getText();
						//if(e==0)
						//{
						//((JavascriptExecutor) driver).executeScript("arguments[0].click();", l.get(e));
						//shortcut key to move box left
						for (int p=0;p<=5;p++)
						{
										
							action.keyDown(l.get(e), Keys.CONTROL).keyDown(l.get(e), Keys.ALT).sendKeys(l.get(e),Keys.ARROW_LEFT).pause(Duration.ofSeconds(2)).build().perform();
						
						}
						System.out.println("Zoned element box is moved left by pressing keys CTRL+Alt+ Left Arrow");
						Thread.sleep(1000);
						//shortcut key to move box right
						for (int p=0;p<=5;p++)
						{
										
							action.keyDown(l.get(e), Keys.CONTROL).keyDown(l.get(e), Keys.ALT).sendKeys(l.get(e),Keys.ARROW_RIGHT).pause(Duration.ofSeconds(2)).build().perform();
						
						}
						System.out.println("Zoned element box is moved right by pressing keys CTRL+Alt+ Right Arrow");
						Thread.sleep(1000);
						//shortcut key to move box up
						for (int p=0;p<=5;p++)
						{
										
							action.keyDown(l.get(e), Keys.CONTROL).keyDown(l.get(e), Keys.ALT).sendKeys(l.get(e),Keys.ARROW_UP).pause(Duration.ofSeconds(2)).build().perform();
						
						}
						System.out.println("Zoned element box is moved up by pressing keys CTRL+Alt+ Up Arrow");
						Thread.sleep(1000);
						//shortcut key to move box down
						for (int p=0;p<=5;p++)
						{
										
							action.keyDown(l.get(e), Keys.CONTROL).keyDown(l.get(e), Keys.ALT).sendKeys(l.get(e),Keys.ARROW_DOWN).pause(Duration.ofSeconds(2)).build().perform();
						
						}
						System.out.println("Zoned element box is moved right by pressing keys CTRL+Alt+ DOWN Arrow");
						Thread.sleep(1000);
			
												
						//}
						
						if (element.equalsIgnoreCase("Figure") || (element.equalsIgnoreCase("Table")) || (element.equalsIgnoreCase("Formula")))
								{
							
							((JavascriptExecutor) driver).executeScript("arguments[0].click();", l.get(e));
							Thread.sleep(1000);
							System.out.println("The selected element to remove zone is  : " + element);
							action.sendKeys(Keys.DELETE).build().perform();
							//action.keyUp(Keys.DELETE).build().perform();
							Alert alert=driver.switchTo().alert();
							
							System.out.println("The alert message is :" + alert.getText());
							Thread.sleep(2000);
							alert.accept();
							if (l.get(e).isDisplayed())
							{
								System.out.println("Selected zone for " + element + " is not removed");
							}
							
							//Assert.assertNotNull("zone is not deleted", l.get(e));
							
								//}
						if(element.equalsIgnoreCase("P")) 
						{ 
							((JavascriptExecutor) driver).executeScript("arguments[0].click();", l.get(e));
							action.sendKeys(Keys.DELETE).build().perform();
							
								System.out.println("Selected zone for " + element + " is  removed");
							
							//action.keyUp(Keys.DELETE).build().perform();
							//Assert.assertNull("zone is deleted", l.get(e));
							
						}
						
						
						break;
			}
					}
					catch(NoSuchElementException e)
					{
						System.out.println("Unable to locate element");
					}

					
					
					
		}

				
				//Alert simpleAlert = driver.switchTo().alert();
				//ob.clickClearOrder();
				//WebElement target = driver.findElement(By.xpath("//*[@id='myCanvas']"));
				//Actions action = new Actions(driver);
				//action.moveToElement(target).build().perform();
			driver.manage().timeouts().pageLoadTimeout(200, TimeUnit.SECONDS);
				Thread.sleep(5000);
				
				//ob.clickClearOrder();

				WebElement bkbtn = driver.findElement(By.xpath("//button[@id='bmarkbtn']"));
				wait.until(ExpectedConditions.visibilityOf(bkbtn));
				Actions action=new Actions(driver);
				action.moveToElement(bkbtn).build().perform();

				wait.until(ExpectedConditions.elementToBeClickable(bkbtn));
				Thread.sleep(5000);
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", bkbtn);
				// bkbtn.click();
				Thread.sleep(2000);

				WebElement bookmark = driver
						.findElement(By.xpath("//div[@class='container2']//div[@class='form-group']"));

			
				// action.keyDown(Keys.CONTROL).click(bookmark).dragAndDrop(bookmark,
				// target).keyUp(Keys.CONTROL).build().perform();
//Actions action=new Actions(driver);
				action.dragAndDropBy(bookmark, 250, 110).build().perform();
				Thread.sleep(2000);
				
				List <WebElement> txt=driver.findElements(By.xpath("//div[@class='ro']//input"));
				int numebroftxtbox=txt.size();
				System.out.println("Number of bookmarks present " + numebroftxtbox);
				for (int k=0;k < numebroftxtbox; k++)
				{
					//boolean flag=false;
					String textboxvalue=txt.get(k).getAttribute("value");
					System.out.println(textboxvalue);
					if(!textboxvalue.isEmpty());
					{	
						//Assert.assertTrue(true);
					}
						
					
					
				}
				
				Thread.sleep(2000);
				WebElement savebookmark=driver.findElement(By.xpath("//button[@id='saveBM']"));
				//Actions action=new Actions(driver);
				
				savebookmark.click();
				Thread.sleep(1000);
				WebElement bookmarkclose=driver.findElement(By.xpath("//div[@id='closeBM']"));
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", bookmarkclose);
				//bookmarkclose.click();
				
				WebElement zoomin=driver.findElement(By.xpath("//button[@id='zoomin']"));
				System.out.println("About to zoom in");
				for (int z=1;z<=3;z++)
				{
					Thread.sleep(1000);
					zoomin.click();
				}
				
				Thread.sleep(2000);
				WebElement zoomout=driver.findElement(By.xpath("//button[@id='zoomout']"));
				System.out.println("About to zoom out");
				for (int z=1;z<=3;z++)
				{
					Thread.sleep(1000);
					zoomout.click();
				}
				
				//Thread.sleep(3000);
				//To set the browser to default zoom level ie., 100%
				
				
				
				//inpect tool 
				
				
				//click on inspect
				WebElement inspect=driver.findElement(By.xpath("//button[@id='insMenu']"));
				action.moveToElement(inspect).build().perform();
				Thread.sleep(2000);
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", inspect);
				
				List <WebElement> l=driver.findElements(By.xpath("//div[@class='elementx']"));
				
				
				
				
				
				
				int no_of_elements=l.size();
				System.out.println("Number of elements found on current page is  " + no_of_elements);
				for (int e=0; e < no_of_elements;e++ )
				{
					String element=l.get(e).getText();
					if(element.equalsIgnoreCase("Figure"))
					{	
						WebElement figure=driver.findElement(By.xpath("//div[@class='elementx'][contains(text(),'Figure')]"));
						figure.click();
						
												
						String tagname=driver.findElement(By.xpath("//div[@class='insLt']/b")).getText();
						System.out.println("The element predicted is with tagname :" + tagname);
											
						
						String expected_ce="NO PERMISSION";
						WebElement actualCE=driver.findElement(By.xpath("//div[@class='insLt']//span"));
						String actual_ce=actualCE.getText();
						Assert.assertEquals(expected_ce, actual_ce);
						Thread.sleep(2000);
					}
						else if(element.equalsIgnoreCase("Table"))
						{
							WebElement table=driver.findElement(By.xpath("//div[@class='elementx'][contains(text(),'table')]"));
							
						table.click();
						String tagname=driver.findElement(By.xpath("//div[@class='insLt']/b")).getText();
						System.out.println("The element predicted is with tagname :" + tagname);
											
						
						String expected_ce="NO PERMISSION";
						WebElement actualCE=driver.findElement(By.xpath("//div[@class='insLt']//span"));
						String actual_ce=actualCE.getText();
						Assert.assertEquals(expected_ce, actual_ce);
						Thread.sleep(2000);
						
						}
					
						else if(element.equalsIgnoreCase("Formula"))
						{
							WebElement formula=driver.findElement(By.xpath("//div[@class='elementx'][contains(text(),'Formula')]"));
							formula.click();
						String tagname=driver.findElement(By.xpath("//div[@class='insLt']/b")).getText();
						System.out.println("The element predicted is with tagname :" + tagname);
											
						
						String expected_ce="NO PERMISSION";
						WebElement actualCE=driver.findElement(By.xpath("//div[@class='insLt']//span"));
						String actual_ce=actualCE.getText();
						Assert.assertEquals(expected_ce, actual_ce);
						Thread.sleep(2000);
						
						}
						else
						{
							
							
							((JavascriptExecutor) driver).executeScript("arguments[0].click();",l.get(e)) ;
							Thread.sleep(2000);
							String tagname=driver.findElement(By.xpath("//div[@class='insLt']/b")).getText();
							System.out.println("The predicted element with tagname :" + tagname);
						}
					
							
					}
					
				}
				
				
		
				
				
				
				
			
		
				
				
				
				 * action.moveToElement(bookmark).build().perform(); Thread.sleep(1000);
				 * action.clickAndHold(bookmark) .pause(Duration.ofSeconds(20))
				 * .moveToElement(target) .pause(Duration.ofSeconds(20)) .release() .build()
				 * .perform();
				 

				
				 * Robot robot = new Robot(); robot.mouseMove(141, 104); // move mouse point to
				 * specific location robot.delay(1500); // delay is to make code wait for
				 * mentioned milliseconds before executing next step
				 * robot.mousePress(InputEvent.BUTTON1_DOWN_MASK); // press left click
				 * robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK); // release left click
				 * robot.delay(1500);
				 
				// robot.keyPress(KeyEvent.VK_DOWN); // press keyboard arrow key to select Save
				// radio button
				// Thread.sleep(2000);
				// robot.keyPress(KeyEvent.VK_ENTER);

			



		
		
		// }

		
		 * } }catch(ElementNotVisibleException e) {
		 * System.out.println("View Log not generated"); }
		 

		
		// WebElement alttextfile=driver.findElement(By.xpath("//span[@class='accBodyFile']//span[@class='project-folder-name nocap ng-binding'][contains(text(),'xlsx')]")); 
		// String altfile=alttextfile.getText(); 
		// int length=altfile.length();
		// System.out.println("The alt text file is  "+ altfile); 
		// String[] at=altfile.split("AltText"); String first=at[0]; String second=at[1];
		// System.out.println(first); 
		// int l=first.length(); String
		// expfilename=first.substring(0, l-1); String pdffile=expfilename + ".pdf";
		// System.out.println("The pdf file is "+ pdffile); 
		String parentWindow = driver.getWindowHandle();
		Actions action=new Actions(driver);
		WebElement process=driver.findElement(By.xpath("//span[@id='a97729-23c']"));
		wait.until(ExpectedConditions.elementToBeClickable(process));
		Thread.sleep(5000);
		process.click();
		WebElement viewfilebtn=driver.findElement(By.xpath("//span[@class='company-information-edit pull-right'][contains(text(),'View File')]"));
		wait.until(ExpectedConditions.elementToBeClickable(viewfilebtn));
		Thread.sleep(2000);
		viewfilebtn.click();
Set<String> procwinhandles = driver.getWindowHandles();
		
		for (String handle : procwinhandles) {
		
		

			if (!handle.equals(parentWindow)) {
				driver.switchTo().window(handle);
				//ProcessElementViewerPage ob=new ProcessElementViewerPage();
				driver.manage().timeouts().pageLoadTimeout(500, TimeUnit.SECONDS);
				Thread.sleep(5000);

				// for (int count = 1; count <= pgcount; count++) {
				// Thread.sleep(8000);
				//int count = 1;
				List <WebElement> next =driver.findElements(By.xpath("//button[@id='nxt']"));
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='nxt']")));
				while(!next.isEmpty())
				{
				if(next.get(0).isEnabled() && (next.size() > 0))
				{					
								
					Thread.sleep(5000);
					//next.click();
					((JavascriptExecutor) driver).executeScript("arguments[0].click();", next.get(0));
					
					// driver.manage().timeouts().pageLoadTimeout(500, TimeUnit.SECONDS);

					//Thread.sleep(2000);
					// WebElement modal =
					// driver.findElement(By.xpath("//h4[@id='myModalLabel'][contains(text(),'OVERLAPPING
					// FOUND')]"));
					WebElement modalcontent = driver.findElement(By.xpath("//div[@class='modal-content']"));

					WebElement ignore_yes = driver.findElement(By.xpath("//button[@id='modal-btn-si']"));

					if ((modalcontent != null) && (modalcontent.isDisplayed()))

					{

						action.moveToElement(ignore_yes).perform();
						ignore_yes.click();
					}
					

					//break;
				}


		
				}
		
		 
		WebElement Alttext = driver.findElement(By.xpath("//span[@class='ng-binding ng-scope'][contains(text(),'Alt text Writing')]"));
		wait.until(ExpectedConditions.elementToBeClickable(Alttext));
		Thread.sleep(2000);
		Alttext.click();
		
		Thread.sleep(5000);
		
		  //WebDriverWait wait = new WebDriverWait(driver, 90); 
		 // WebElement editAlttext = driver.findElement(By.xpath("//span[@class='company-information-edit pull-right ng-scope']"));
		 WebElement editAlttext = driver.findElement(By.xpath("//span[@class='company-information-edit pull-right ng-scope'][contains(text(),'Edit alt text')]"));
		  //WebDriverWait wait=new WebDriverWait(driver,90);
		wait.until(ExpectedConditions.elementToBeClickable(editAlttext));
		
		 
		 Thread.sleep(10000); 
		 editAlttext.click();
		driver.manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
		 
		 //PDDocument pd; pd = PDDocument.load(new
		 //File("D:\\Project\\Accessibility\\Input\\Figure and Formula no box.pdf"));
		 //int pgcount = pd.getNumberOfPages(); 
		 //System.out.println("Number of pages " + pgcount); 
		 Set<String> alttextwinhandles = driver.getWindowHandles(); 
		 for(String alttexthandle : alttextwinhandles)
		 {  
			// Actions action = new Actions(driver);
		 
		 String parentWindow = driver.getWindowHandle();
		 
		// if (!alttexthandle.equals(parentWindow)) 
		 //{
		// driver.switchTo().window(alttexthandle); Thread.sleep(5000);
		 
		// for (int count = 1; count <= pgcount; count++) // {
		 
		 //WebElement alttextcountbtn=driver.findElement((By.xpath("//li[@id='Count']"))); 
		 //alttextcountbtn.click();
		
		// WebElement fig=driver.findElement(By.xpath("//div[@class='modal-body']//div[@class='imgContm // ng-scope']/div[2]"));
		 
		// WebElement alttext = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@id='gotoAltTxt']"))); // action.moveToElement(alttext).perform();
		 
		// AddProjectPage addprojobj = new AddProjectPage(); //
		//addprojobj.scrolldown();
		 
		 //Thread.sleep(5000); 
		//List <WebElement> fwd =driver.findElements(By.xpath("//button[@id='nxtclkimg']")); 
		// boolean hasNextPage=true;

		    
		
		 List <WebElement> fwd =driver.findElements(By.xpath("//button[@class='next']"));
		 System.out.println(fwd.size());
		List <WebElement>fwd_dis=driver.findElements(By.xpath("//button[@class='next'][@disabled='disabled']"));
		System.out.println(fwd_dis.size());
		while(!fwd.isEmpty())
		{
		if(fwd.get(0).isEnabled() && (fwd.size() > 0))
		
		
		{ driver.findElement(By.xpath("//textarea[@id='taLong02']")).clear();
		
		Thread.sleep(2000);
			 driver.findElement(By.xpath("//textarea[@id='taLong02']")).sendKeys("dummy text");
			 Thread.sleep(2000); 
			 fwd.get(0).click(); 
			 
			 
		}
		}
		//else if(fwd_dis.size() > 0)
		else
		{
			System.out.println("No more Pages Available");
			hasNextPage=false;
			
            break;
		}
		    
		 do {
		driver.findElement(By.xpath("//textarea[@id='taLong02']")).clear();
		Thread.sleep(2000);
		 driver.findElement(By.xpath("//textarea[@id='taLong02']")).sendKeys("dummy text");
		 Thread.sleep(2000); 
		 fwd.get(0).click(); 
		 
		 
		 }
		 //while(fwd.getAttribute("disabled").contains("disabled"));
		 //while(!fwd.isEnabled() && (fwd.isDisplayed()));
		 while((fwd.size() < 0) && (!fwd.get(0).isEnabled()));
		
		
		 
		 while(!fwd.isEnabled() && (fwd.isDisplayed()))
		 {
			 driver.findElement(By.xpath("//textarea[@id='taLong02']")).sendKeys("dummy text");
			 Thread.sleep(2000); 
			 fwd.click(); 
		 }
		 
		 // wait.until(ExpectedConditions.elementToBeClickable(fwd));
		
		
	
		
		 Thread.sleep(3000);
		 WebElement alttxtsavebtn =driver.findElement(By.xpath("//button[@id='saveAltbut']")); 
		 wait.until(ExpectedConditions.elementToBeClickable(alttxtsavebtn));
		 
		 //Actions action = new Actions(driver); 
		 action.moveToElement(alttxtsavebtn).perform();
		 Thread.sleep(2000);
		 alttxtsavebtn.click();
		 
		 Thread.sleep(2000);
	
		 WebElement preview =driver.findElement((By.xpath("//li[@id='gotoPreviewAltTxt']"))); 
		 action.moveToElement(preview).perform(); preview.click();
		 
		 WebElement approveallbtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='aprvallbtn']"))); Thread.sleep(5000); approveallbtn.click();
		 
		 WebElement completebtn =driver.findElement(By.xpath("//li[@id='completeAltTxt']"));
		 }
		 }
		 }
}
	}
//}


		// Thread.sleep(5000);
		 // action.moveToElement(completebtn).perform();
			// completebtn.click();
		//Thread.sleep(5000);

		// Thread.sleep(2000);
		// addfileicon.click();
		// ((JavascriptExecutor) driver).executeScript("arguments[0].click();",
		// addfileicon);
		
		 * Robot robot = new Robot(); robot.setAutoDelay(2000);
		 * 
		 * StringSelection stringselection = new
		 * StringSelection("D:\\Project\\Accessibility\\Input\\Code_continued.pdf");
		 * Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringselection,
		 * owner); robot.setAutoDelay(5000); robot.keyPress(KeyEvent.VK_CONTROL);
		 * robot.keyPress(KeyEvent.VK_V); robot.keyRelease(KeyEvent.VK_CONTROL);
		 * robot.keyRelease(KeyEvent.VK_V); robot.setAutoDelay(5000);
		 * robot.keyPress(KeyEvent.VK_ENTER); robot.keyRelease(KeyEvent.VK_ENTER);
		 
		// search name later

		// File repository

	



// Thread.sleep(5000);
// WebElement
// logout=driver.findElement(By.xpath("//a[@class='active-nav']/em[contains(text(),'log
// out')]"));
// WebElement logout=driver.findElement(By.xpath("//em[contains(text(),'log
// out')]"));
// WebElement
// logout=driver.findElement(By.xpath("//ul[@id='main-menu-c']/li[5]/a/em"));

// WebDriverWait wait=new WebDriverWait(driver,2000);
// wait.until(ExpectedConditions.visibilityOf(logout));
// Thread.sleep(10000);
// logout.sendKeys(" ");
// Actions action=new Actions(driver);
// action.moveToElement(logout);

// ((JavascriptExecutor) driver).executeScript("arguments[0].click();", logout);
// Thread.sleep(2000);
// driver.quit();
// WebElement wb = driver.findElement(By.xpath("//input[@id='search']"));

// Thread.sleep(3000);

// WebDriverWait wait=new WebDriverWait(driver,30);
*/