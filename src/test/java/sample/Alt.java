package sample;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Alt {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://accessibilityptuat.codemantra.com/login");
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

		WebDriverWait wait = new WebDriverWait(driver, 8000);
		WebElement alttext = wait.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("//span[@class='ng-binding ng-scope'][contains(text(),'Alt text Writing')]")));

		Thread.sleep(5000);
		alttext.click();
		String parentWindow = driver.getWindowHandle();
		Thread.sleep(5000);
		WebElement editAlttext = driver.findElement(By.xpath(
				"//span[@class='company-information-edit pull-right ng-scope'][contains(text(),'Edit alt text')]"));
		// WebDriverWait wait=new WebDriverWait(driver,90);

		wait.until(ExpectedConditions.elementToBeClickable(editAlttext));

		Thread.sleep(10000);
		editAlttext.click();
		driver.manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
		Set<String> alttextwinhandles = driver.getWindowHandles();
		for (String alttexthandle : alttextwinhandles) {

			if (!alttexthandle.equals(parentWindow)) {
				driver.switchTo().window(alttexthandle);
				Thread.sleep(5000);

				// WebElement
				// fig=driver.findElement(By.xpath("//div[@class='modal-body']//div[@class='imgContm
				// // ng-scope']/div[2]"));

				// WebElement alttex =
				// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@id='gotoAltTxt']")));
				// // action.moveToElement(alttext).perform();

				// Thread.sleep(5000);
				WebElement img = driver.findElement(By.xpath("//span[@id='imgName']"));
				String imagetxt = img.getText();
				// System.out.println("The displayed image's name : " + imagetxt);

				int imglen = imagetxt.length();

				String[] at = imagetxt.split("/");
				String part1 = at[0];
				String part2 = at[1];
				// System.out.println("first part is " +part1);
				// System.out.println("second part is " +part2);
				int part2len = part2.length();
				// System.out.println(part2len);
				String reqc = part2.substring(0, part2len - 1);
				System.out.println("Image count is " + reqc);
				int reqcount = Integer.parseInt(reqc);

				WebElement fwd = driver.findElement(By.xpath("//button[@class='next']"));

				WebElement prev = driver.findElement(By.xpath("//button[@class='previous']"));
				for (int count = 1; count <= reqcount; count++) {
					
					int form = 0;
					WebElement alttextbox = driver.findElement(By.xpath("//textarea[@id='taLong02']"));
					String val = alttextbox.getAttribute("class");
					
					if (!val.contains("not")) {
						driver.findElement(By.xpath("//textarea[@id='taLong02']")).clear();
						driver.findElement(By.xpath("//textarea[@id='taLong02']")).sendKeys("dummy text");
					} 
					else {
						form = form + 1;
					}
					
					System.out.println(form);
					//driver.findElement(By.xpath("//textarea[@id='taLong02']")).sendKeys(" ");
					//driver.findElement(By.xpath("//textarea[@id='taLong02']")).clear();
					Thread.sleep(2000);
					//driver.findElement(By.xpath("//textarea[@id='taLong02']")).sendKeys("dummy text");
					Thread.sleep(2000);
					((JavascriptExecutor) driver).executeScript("arguments[0].click();", fwd);

					System.out.println("next clicked");
					driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
					Thread.sleep(1000);

					if ((count == 4) && (prev.isEnabled())) {

						((JavascriptExecutor) driver).executeScript("arguments[0].click();", prev);

						System.out.println("prev clicked");
						System.out.println(form);

					}

				}

				/*
				 * WebElement fwd = driver.findElement(By.xpath("//button[@class='next']"));
				 * 
				 * WebElement prev =
				 * driver.findElement(By.xpath("//button[@class='previous']")); int count = 1;
				 * // while ((prev != null) && (prev.isDisplayed())) { while ((fwd != null) &&
				 * (fwd.isDisplayed())) { if ((fwd.isEnabled() && (count <12))) {
				 * 
				 * Thread.sleep(2000);
				 * 
				 * driver.findElement(By.xpath("//textarea[@id='taLong02']")).sendKeys(" ");
				 * driver.findElement(By.xpath("//textarea[@id='taLong02']")).clear();
				 * Thread.sleep(2000);
				 * driver.findElement(By.xpath("//textarea[@id='taLong02']")).
				 * sendKeys("dummy text");
				 * 
				 * Thread.sleep(2000); ((JavascriptExecutor)
				 * driver).executeScript("arguments[0].click();", fwd); // fwd.get(0).click();
				 * System.out.println("next clicked");
				 * driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
				 * Thread.sleep(2000); count++;
				 * 
				 * } if ((count == 12) && (prev.isEnabled())){
				 * 
				 * ((JavascriptExecutor) driver).executeScript("arguments[0].click();", prev);
				 * count++; System.out.println("prev clicked" +count);
				 * 
				 * } }
				 * 
				 */ /*
					 * if ((prev.isEnabled())) { wait.until(ExpectedConditions.visibilityOf(prev));
					 * Thread.sleep(2000); prev.sendKeys(""); ((JavascriptExecutor)
					 * driver).executeScript("arguments[0].click();", prev);
					 * System.out.println("prev clicked");
					 * driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
					 * Thread.sleep(5000); }
					 */
				// break;

				/*
				 * if ((prev.get(0).isEnabled())) {
				 * wait.until(ExpectedConditions.visibilityOfAllElements(prev));
				 * Thread.sleep(2000); prev.get(0).sendKeys(""); ((JavascriptExecutor)
				 * driver).executeScript("arguments[0].click();", prev.get(0));
				 * System.out.println("prev clicked");
				 * driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
				 * Thread.sleep(5000); }
				 * 
				 * 
				 * 
				 * }
				 */
				/*
				 * List<WebElement> fwd =
				 * driver.findElements(By.xpath("//button[@class='next']")); List<WebElement>
				 * dirbutton = driver.findElements(By.xpath("//div[@class='dirButton']"));
				 * List<WebElement> prev =
				 * driver.findElements(By.xpath("//button[@class='previous']")); int
				 * f=fwd.size(); int p=fwd.size();
				 * 
				 * 
				 * System.out.println(f); System.out.println(p);
				 * 
				 * wait.until(ExpectedConditions.visibilityOfAllElements(fwd));
				 * 
				 * while(!prev.isEmpty()) {
				 * 
				 * while (!fwd.isEmpty()) {
				 * 
				 * //if ((fwd.get(0).isEnabled()) && (f > 0)) if ((fwd.get(0).isEnabled()))
				 * 
				 * { Thread.sleep(2000);
				 * 
				 * driver.findElement(By.xpath("//textarea[@id='taLong02']")).sendKeys(" ");
				 * driver.findElement(By.xpath("//textarea[@id='taLong02']")).clear();
				 * Thread.sleep(2000);
				 * driver.findElement(By.xpath("//textarea[@id='taLong02']")).
				 * sendKeys("dummy text");
				 * 
				 * Thread.sleep(2000); ((JavascriptExecutor)
				 * driver).executeScript("arguments[0].click();", fwd.get(0)); //
				 * fwd.get(0).click(); System.out.println("next clicked");
				 * driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
				 * Thread.sleep(2000);
				 * 
				 * } }
				 * 
				 * if ((prev.get(0).isEnabled())) {
				 * wait.until(ExpectedConditions.visibilityOfAllElements(prev));
				 * Thread.sleep(2000); prev.get(0).sendKeys(""); ((JavascriptExecutor)
				 * driver).executeScript("arguments[0].click();", prev.get(0));
				 * System.out.println("prev clicked");
				 * driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
				 * Thread.sleep(5000); }
				 * 
				 * 
				 * 
				 * }
				 * 
				 * 
				 * 
				 * 
				 * 
				 * /* Thread.sleep(2000); List<WebElement> prev =
				 * driver.findElements(By.xpath("//button[@class='previous']")); for(WebElement
				 * eachEle : prev) { // Checking whether the element is enabled or not
				 * if(eachEle.isEnabled()) { eachEle.click(); } }
				 */

				/*
				 * List<WebElement> prev =
				 * driver.findElements(By.xpath("//button[@class='previous']"));
				 * System.out.println(prev.size());
				 * wait.until(ExpectedConditions.visibilityOfAllElements(prev)); while
				 * (!prev.isEmpty()) { if ((prev.get(0).isEnabled()) && (prev.size() > 0)) {
				 * Thread.sleep(1000);
				 * 
				 * 
				 * 
				 * prev.get(0).click(); System.out.println("prev clicked");
				 * driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
				 * Thread.sleep(2000); //break; } }
				 */

				// Thread.sleep(1000);
				// List<WebElement> prev =
				// driver.findElements(By.xpath("//button[@class='previous']"));
				// wait.until(ExpectedConditions.visibilityOfAllElements(prev));

				// while (!prev.isEmpty()) {

				// if ((prev.get(0).isEnabled()) && (fwd.size() > 0))

				// {
				// Thread.sleep(2000);

				// prev.get(0).click();
				// driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
				// Thread.sleep(2000);

				// }
				// break;
				// }

				Thread.sleep(5000);
				WebElement preview = driver.findElement((By.xpath("//li[@id='gotoPreviewAltTxt']")));
				wait.until(ExpectedConditions.visibilityOf(preview));
				Actions action = new Actions(driver);
				action.moveToElement(preview).perform();
				Thread.sleep(1000);
				preview.click();

				WebElement approveallbtn = wait
						.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='aprvallbtn']")));
				Thread.sleep(1000);
				approveallbtn.click();

				// WebElement completebtn =
				// driver.findElement(By.xpath("//li[@id='completeAltTxt']"));
				WebElement completebtn = wait
						.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@id='completeAltTxt']")));

				action.moveToElement(completebtn).perform();
				Thread.sleep(1000);
				completebtn.click();
				Thread.sleep(5000);
				driver.close();

			}
		}

	}
}
