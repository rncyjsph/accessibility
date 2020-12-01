package sample;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import codemantra.ADH.TestBase.BaseClass;
import codemantra.ADH.util.TestUtil;
import codemantra.ADH.util.Zoom;
import junit.framework.Assert;

public class Pro extends BaseClass {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://staging.codemantra.com/login");
		driver.manage().window().maximize();
		driver.findElement(By.id("user001")).sendKeys("rincy@codemantra.in");
		driver.findElement(By.id("pas001")).sendKeys("Test#123");
		// click login button
		driver.findElement(By.id("save_sla")).click();

		driver.manage().timeouts().pageLoadTimeout(1000, TimeUnit.SECONDS);
		Thread.sleep(7000);

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
		Thread.sleep(10000);

		WebDriverWait wait = new WebDriverWait(driver, 20000);
		WebElement process = driver.findElement(By.xpath("//span[@class='ng-scope'][contains(text(),'Process')]"));
		wait.until(ExpectedConditions.elementToBeClickable(process));
		Thread.sleep(15000);
		process.click();
		Thread.sleep(5000);
		WebElement viewfilebtn = driver.findElement(
				By.xpath("//span[@class='company-information-edit pull-right'][contains(text(),'View File')]"));
		wait.until(ExpectedConditions.elementToBeClickable(viewfilebtn));
		Thread.sleep(8000);
		viewfilebtn.click();
		Actions action = new Actions(driver);
		PDDocument pd;
		// pd = PDDocument.load(new File(prop.getProperty("filepath1")));
		// int pgcount = pd.getNumberOfPages();
		// System.out.println("Number of pages " + pgcount);
		String parentWindow = driver.getWindowHandle();
		Set<String> procwinhandles = driver.getWindowHandles();

		for (String handle : procwinhandles) {

			if (!handle.equals(parentWindow)) {
				driver.switchTo().window(handle);
				// ProcessElementViewerPage ob=new ProcessElementViewerPage();
				driver.manage().timeouts().pageLoadTimeout(500, TimeUnit.SECONDS);
				Thread.sleep(5000);
				JavascriptExecutor executor = (JavascriptExecutor) driver;
				executor.executeScript("document.body.style.zoom = '90%'");
				
				Thread.sleep(2000);
				
				WebElement bkbtn = driver.findElement(By.xpath("//button[@id='bmarkbtn']"));

				action.moveToElement(bkbtn).build().perform();

				wait.until(ExpectedConditions.elementToBeClickable(bkbtn));
				Thread.sleep(2000);
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", bkbtn);
				// bkbtn.click();
				Thread.sleep(2000);

				WebElement bookmark = driver
						.findElement(By.xpath("//div[@class='container2']//div[@class='form-group']"));
				wait.until(ExpectedConditions.visibilityOf(bookmark));

				// action.dragAndDropBy(bookmark, 15, 120).build().perform();

				Thread.sleep(2000);
				

				List<WebElement> txt = driver.findElements(By.xpath("//div[@class='ro']//input"));
				if (!txt.isEmpty())
				{
				int numebroftxtbox = txt.size();
				System.out.println("Number of bookmarks present :" + numebroftxtbox);
				for (int k = 0; k < numebroftxtbox; k++) {
					String textboxvalue = txt.get(k).getAttribute("value");
					System.out.println(textboxvalue);
					if (!textboxvalue.isEmpty())

					{
						Assert.assertTrue(true);
					}
					else
					{
						WebElement bookmarkclose = driver.findElement(By.xpath("//div[@id='closeBM']"));
						((JavascriptExecutor) driver).executeScript("arguments[0].click();", bookmarkclose);
					}

				}
				}

				Thread.sleep(2000);
				WebElement savebookmark = driver.findElement(By.xpath("//button[@id='saveBM']"));
				// action.moveToElement(savebookmark).perform();
				wait.until(ExpectedConditions.visibilityOf(savebookmark));
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", savebookmark);

				Thread.sleep(1000);
				WebElement bookmarkclose = driver.findElement(By.xpath("//div[@id='closeBM']"));
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", bookmarkclose);

				
				// driver.manage().timeouts().pageLoadTimeout(TestUtil.PageLoadTimeOut,
				// TimeUnit.SECONDS);
				// JavascriptExecutor executor = (JavascriptExecutor)driver;
				// executor.executeScript("document.body.style.zoom = '90%;");

				// List<WebElement> process_next
				// =wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//button[@id='nxt']")));
				/*for (int i = 0; i <= 5; i++) {
					WebDriverWait m = new WebDriverWait(driver, 60);
					WebElement process_next = wait
							.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='nxt']")));

					Thread.sleep(5000);
					// if(process_next != null) {
					// action.moveToElement(process_next).perform();

					((JavascriptExecutor) driver).executeScript("arguments[0].click();", process_next);
					Thread.sleep(1000);

					WebElement modalcontent = driver.findElement(By.xpath("//div[@class='modal-content']"));

					WebElement ignore_yes = driver.findElement(By.xpath("//button[@id='modal-btn-si']"));

					if ((modalcontent != null) && (modalcontent.isDisplayed()))

					{

						action.moveToElement(ignore_yes).perform();
						// Thread.sleep(1000);
						((JavascriptExecutor) driver).executeScript("arguments[0].click();", ignore_yes);

					}
					driver.manage().timeouts().pageLoadTimeout(500, TimeUnit.SECONDS);
				}
*/
				// if (!process_next.isEnabled()) {
				/*
				 * Thread.sleep(5000); WebElement savebtn =
				 * driver.findElement(By.xpath("//button[@id='savebtn']"));
				 * 
				 * wait.until(ExpectedConditions.elementToBeClickable(savebtn));
				 * action.moveToElement(savebtn).build().perform(); Thread.sleep(5000);
				 * ((JavascriptExecutor) driver).executeScript("arguments[0].click();",
				 * savebtn);
				 * 
				 * 
				 * driver.manage().timeouts().pageLoadTimeout(500, TimeUnit.SECONDS);
				 */

				// }
				// }
				// }

				Thread.sleep(5000);

				// try {
				// List<WebElement> l =
				// driver.findElements(By.xpath("//div[@class='elementx']"));
				// // Actions action = new Actions(driver);
				// int no_of_elements = l.size();
				// System.out.println("Number of elements found on current page is " +
				// no_of_elements);
				// for (int e = 0; e < no_of_elements; e++)
				// {
				// String element =

				/*
				 * * l.get(e).getText(); if (e == 3) { //clone zone String element =
				 * l.get(e).getText(); if (element.equalsIgnoreCase("Figure") ||
				 * (element.equalsIgnoreCase("Table")) || (element.equalsIgnoreCase("Formula")))
				 * {
				 * 
				 * ((JavascriptExecutor) driver).executeScript("arguments[0].click();",
				 * l.get(e)); Thread.sleep(1000);
				 * action.keyDown(Keys.CONTROL).sendKeys("B").perform();
				 * action.keyUp(Keys.CONTROL); Thread.sleep(2000);
				 * 
				 * Alert alert = driver.switchTo().alert();
				 * 
				 * System.out.println("The alert message is :" + alert.getText());
				 * Thread.sleep(1000); alert.accept();
				 * 
				 * 
				 * } else { ((JavascriptExecutor) driver).executeScript("arguments[0].click();",
				 * l.get(e));
				 * 
				 * action.keyDown(Keys.CONTROL).sendKeys("B").perform();
				 * action.keyUp(Keys.CONTROL); action.dragAndDropBy(l.get(e), 55,
				 * 10).build().perform(); System.out.println(element + " is cloned");
				 * Thread.sleep(1000);
				 * 
				 * }
				 * 
				 * }
				 * 
				 * if (e == 3) { String element = l.get(e).getText(); ((JavascriptExecutor)
				 * driver).executeScript("arguments[0].click();", l.get(e)); // shortcut key to
				 * move box left for (int p = 0; p <= 5; p++) {
				 * 
				 * action.keyDown(l.get(e), Keys.CONTROL).keyDown(l.get(e), Keys.ALT)
				 * .sendKeys(l.get(e), Keys.ARROW_LEFT).pause(Duration.ofSeconds(2)).build()
				 * .perform();
				 * 
				 * } System.out.println(element +
				 * " is moved left by pressing keys CTRL+Alt+ Left Arrow"); Thread.sleep(1000);
				 * // shortcut key to move box right for (int p = 0; p <= 5; p++) {
				 * 
				 * action.keyDown(l.get(e), Keys.CONTROL).keyDown(l.get(e), Keys.ALT)
				 * .sendKeys(l.get(e), Keys.ARROW_RIGHT).pause(Duration.ofSeconds(2)).build()
				 * .perform();
				 * 
				 * } System.out.println(element +
				 * " is moved right by pressing keys CTRL+Alt+ Right Arrow");
				 * Thread.sleep(1000); // shortcut key to move box up for (int p = 0; p <= 5;
				 * p++) {
				 * 
				 * action.keyDown(l.get(e), Keys.CONTROL).keyDown(l.get(e), Keys.ALT)
				 * .sendKeys(l.get(e), Keys.ARROW_UP).pause(Duration.ofSeconds(2)).build()
				 * .perform();
				 * 
				 * } System.out.println(element +
				 * " is moved up by pressing keys CTRL+Alt+ Up Arrow"); Thread.sleep(1000); //
				 * shortcut key to move box down for (int p = 0; p <= 5; p++) {
				 * 
				 * action.keyDown(l.get(e), Keys.CONTROL).keyDown(l.get(e), Keys.ALT)
				 * .sendKeys(l.get(e), Keys.ARROW_DOWN).pause(Duration.ofSeconds(2)).build()
				 * .perform();
				 * 
				 * } System.out.println(element +
				 * " is moved down by pressing keys CTRL+Alt+ DOWN Arrow"); Thread.sleep(1000);
				 * 
				 * // shortcut key to shrink right side of box for (int p = 0; p <= 5; p++) {
				 * 
				 * action.keyDown(l.get(e), Keys.CONTROL).keyDown(l.get(e), Keys.SHIFT)
				 * .sendKeys(l.get(e), Keys.ARROW_LEFT).pause(Duration.ofSeconds(2)).build()
				 * .perform();
				 * 
				 * } System.out.println(
				 * "shortcut key (CTRL+SHIFT+ Left Arrow)is pressed to shrink right side of zoned  element "
				 * + element); Thread.sleep(1000);
				 * 
				 * // shortcut key to expand right side of box for (int p = 0; p <= 5; p++) {
				 * 
				 * action.keyDown(l.get(e), Keys.CONTROL).keyDown(l.get(e), Keys.SHIFT)
				 * .sendKeys(l.get(e), Keys.ARROW_RIGHT).pause(Duration.ofSeconds(2)).build()
				 * .perform();
				 * 
				 * } System.out.println(
				 * "shortcut key (CTRL+SHIFT+ Right Arrow)is pressed to expand right side of zoned  element "
				 * + element); Thread.sleep(1000); // shortcut key to shrink bottom side of box
				 * for (int p = 0; p <= 5; p++) {
				 * 
				 * action.keyDown(l.get(e), Keys.CONTROL).keyDown(l.get(e), Keys.SHIFT)
				 * .sendKeys(l.get(e), Keys.ARROW_UP).pause(Duration.ofSeconds(2)).build()
				 * .perform();
				 * 
				 * } System.out.println(
				 * "shortcut key (CTRL+SHIFT+ UP Arrow)is pressed to shrink bottom side of zoned  element "
				 * + element); Thread.sleep(1000);
				 * 
				 * // shortcut key to expand bottom side of box for (int p = 0; p <= 5; p++) {
				 * 
				 * action.keyDown(l.get(e), Keys.CONTROL).keyDown(l.get(e), Keys.SHIFT)
				 * .sendKeys(l.get(e), Keys.ARROW_DOWN).pause(Duration.ofSeconds(2)).build()
				 * .perform();
				 * 
				 * } System.out.println(
				 * "shortcut key (CTRL+SHIFT+ Down Arrow)is pressed to expand bottom side zoned  element "
				 * + element); Thread.sleep(1000);
				 * 
				 * }
				 * 
				 * // delete if (e == 3) { String element = l.get(e).getText(); if
				 * (element.equalsIgnoreCase("Figure") || (element.equalsIgnoreCase("Table")) ||
				 * (element.equalsIgnoreCase("Formula"))) {
				 * 
				 * ((JavascriptExecutor) driver).executeScript("arguments[0].click();",
				 * l.get(e)); Thread.sleep(1000);
				 * 
				 * action.sendKeys(Keys.DELETE).build().perform(); //
				 * action.keyUp(Keys.DELETE).build().perform();
				 * 
				 * Alert alert = driver.switchTo().alert(); Thread.sleep(1000);
				 * System.out.println("The alert message is :" + alert.getText());
				 * Thread.sleep(1000); alert.accept();
				 * 
				 * if (l.get(e).isDisplayed()) { System.out.println("Selected zone for " +
				 * element + " is not removed"); }
				 * 
				 * 
				 * // Assert.assertNotNull("zone is not deleted", l.get(e));
				 * 
				 * } if (element.equalsIgnoreCase("P")) { // else { ((JavascriptExecutor)
				 * driver).executeScript("arguments[0].click();", l.get(e));
				 * action.sendKeys(Keys.DELETE).build().perform();
				 * 
				 * System.out.println(element + " is removed");
				 * 
				 * } }
				 * 
				 * // break; }
				 * 
				 */
				/*try {
					List<WebElement> l = driver.findElements(By.xpath("//div[@class='elementx']"));
					// Actions action = new Actions(driver);
					int no_of_elements = l.size();
					System.out.println("Number of elements found on current page is  " + no_of_elements);
					for (int e = 0; e < no_of_elements; e++) {
						if (e == 0) {
							String ele1 = l.get(e).getText();
							// action.keyDown(Keys.LEFT_CONTROL).pause(Duration.ofSeconds(2))
							action.keyDown(Keys.LEFT_CONTROL).click(l.get(e)).pause(Duration.ofSeconds(2)).perform();
							// .keyUp(Keys.LEFT_CONTROL).perform();
							System.out.println("1st element selected to be merged is " + ele1);
						}

						for (int f = 0; f < no_of_elements; f++) {

							if (f == 1) {
								String ele2 = l.get(f).getText();
								action.keyDown(Keys.LEFT_CONTROL).click(l.get(f)).pause(Duration.ofSeconds(2))
										.perform();
								// .keyUp(Keys.LEFT_CONTROL).perform();

								System.out.println("2nd element selected to be merged is " + ele2);
								break;
							}

						}
						break;
					}
					action.keyDown(Keys.CONTROL).sendKeys("M").pause(Duration.ofSeconds(2)).keyUp(Keys.CONTROL)
							.perform();
					System.out.println("both elements are merged");

				}

				catch (NoSuchElementException e) {
					System.out.println("Unable to locate element");
				}

			}

		}
*/
		/*
		 * try {
		 * action.keyDown(Keys.CONTROL).click(l.get(4)).click(l.get(5)).keyUp(Keys.
		 * CONTROL) .pause(Duration.ofSeconds(2))
		 * 
		 * .keyDown(Keys.CONTROL).sendKeys("M").keyUp(Keys.CONTROL).build().perform(); }
		 * catch (org.openqa.selenium.StaleElementReferenceException ex) {
		 * 
		 * }
		 * 
		 * }
		 */
		//Thread.sleep(8000);
		// driver.quit();

		/*
		 * * WebElement
		 * modalcontent=driver.findElement(By.xpath("//div[@class='modal-content']"));
		 * WebElement
		 * ignore_yes=driver.findElement(By.xpath("//button[@id='modal-btn-si']"));
		 * WebElement approvecancel=driver.findElement(By.xpath(
		 * "//button[contains(text(),'Cancel')]"));
		 * 
		 * 
		 * 
		 * action.keyDown(Keys.CONTROL).keyDown(Keys.ALT).sendKeys("A").build().perform(
		 * );
		 * 
		 * action.keyUp(Keys.CONTROL).keyUp(Keys.ALT).build().perform();
		 * 
		 * Thread.sleep(2000); action.moveToElement(ignore_yes).build().perform();
		 * ignore_yes.click();
		 * 
		 * 
		 * wait.until(ExpectedConditions.elementToBeClickable(approvecancel));
		 * Thread.sleep(2000); action.moveToElement(approvecancel).build().perform();
		 * approvecancel.click();
		 * 
		 * System.out.
		 * println("Approve shortcut key is performed by pressing keys CTRL+Alt+ A");
		 * Thread.sleep(2000); driver.navigate().refresh();
		 * driver.manage().timeouts().pageLoadTimeout(200, TimeUnit.SECONDS);
		 * 
		 */

	}
}
	}
}
