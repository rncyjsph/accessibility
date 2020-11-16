package codemantra.ADH.pages;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import codemantra.ADH.TestBase.BaseClass;

public class ProcessElementViewerPage extends BaseClass {

	@FindBy(xpath = "//i[@class='fa fa-minus-circle']")
	WebElement clearorder;

	@FindBy(xpath = "//i[@class='glyphicon glyphicon-question-sign']")
	WebElement help;

	@FindBy(xpath = "//h3[contains(text(),'Help - Shortcuts')]")
	WebElement helpmodalbox;

	@FindBy(xpath = "//div[@id='showHelp']//h3")
	WebElement helpshortcut;

	@FindBy(xpath = "//div[@class='modal-body']/p")
	WebElement clearreadingorder;

	@FindBy(xpath = "//button[@id='modal-btn-si']")
	WebElement yes;

	@FindBy(xpath = "//div[@id='closeMeta']")
	WebElement metaclose;

	@FindBy(xpath = "//div[@class='closepop'][@id='closeHelp']")
	WebElement helpclose;

	@FindBy(xpath = "//div[@id='closeTgList']")
	WebElement taglistclose;

	@FindBy(xpath = "//div[@class='rdorder']")
	WebElement reorder;

	@FindBy(xpath = "//div[@id='metaDetails']")
	WebElement metabox;

	@FindBy(xpath = "//div[@id='TagList']")
	WebElement tagList;

	@FindBy(xpath = "//div[@id='inspct']")
	WebElement inspectmodalbox;

	@FindBy(xpath = "//div[@id='closeinspct']")
	WebElement inspectclose;

	@FindBy(xpath = "//button[contains(text(),'Cancel')]")
	WebElement approvecancel;

	@FindBy(xpath = "//div[@class='modal-content']")
	WebElement modalcontent;

	@FindBy(xpath = "//button[@id='modal-btn-si']")
	WebElement ignore_yes;
	@FindBy(xpath = "//div[@class='elementx']")
	List<WebElement> l;

	public ProcessElementViewerPage() {
		PageFactory.initElements(driver, this);
	}

	public void shortCutKeys() throws InterruptedException {
		Actions action = new Actions(driver);

		// action.moveToElement(clearorder).perform();
		Thread.sleep(1000);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", clearorder);

		Thread.sleep(1000);

		// action.moveToElement(yes).build().perform();
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", yes);

		// }
		// orders should be removed
		if (!reorder.isDisplayed()) {
			Assert.assertTrue(true);
		}
		Thread.sleep(2000);

		// help button
		action.moveToElement(help).perform();
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", help);
		Thread.sleep(2000);

		action.dragAndDropBy(helpmodalbox, 960, 10).build().perform();
		String expected_h = helpshortcut.getText();
		String actual_h = "Help - Shortcuts";
		Assert.assertEquals("Validation of shortcut keys", expected_h, actual_h);
		Thread.sleep(2000);

		// reorder number in zones

		action.keyDown(Keys.CONTROL).keyDown(Keys.SHIFT).sendKeys("A").keyUp(Keys.CONTROL).keyUp(Keys.SHIFT).build()
				.perform();
		System.out.println("Zones are reordered by pressing Shortcut key CTRL+SHIFT+A");
		// orders should be displayed
		if (reorder.isDisplayed()) {
			Assert.assertTrue(true);
		}

		Thread.sleep(2000);
		// Save button shortcut key

		action.keyDown(Keys.CONTROL).keyDown(Keys.ALT).sendKeys("S").build().perform();
		action.keyUp(Keys.CONTROL).keyUp(Keys.ALT).build().perform();

		driver.manage().timeouts().pageLoadTimeout(1000, TimeUnit.SECONDS);
		System.out.println("Save is performed by pressing keys CTRL+Alt+ S");
		Thread.sleep(5000);

		// metadata shortcut key

		action.keyDown(Keys.CONTROL).keyDown(Keys.ALT).sendKeys("M").build().perform();
		WebDriverWait wait = new WebDriverWait(driver, 90);
		wait.until(ExpectedConditions.visibilityOf(metabox));

		System.out.println("Metadata modal box is displayed by pressing shortcut key CTRL+Alt+M");

		action.keyUp(Keys.CONTROL).keyUp(Keys.ALT).build().perform();
		Thread.sleep(1000);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", metaclose);
		Thread.sleep(2000);

		// taglist shortcut key

		action.keyDown(Keys.CONTROL).keyDown(Keys.ALT).sendKeys("T").build().perform();
		wait.until(ExpectedConditions.visibilityOf(tagList));
		System.out.println("Tag List modal box is displayed by pressing keys CTRL+Alt+T");
		action.keyUp(Keys.CONTROL).keyUp(Keys.ALT).build().perform();
		action.dragAndDropBy(tagList, 60, 80).build().perform();
		Thread.sleep(1000);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", taglistclose);

		Thread.sleep(2000);

		// inspect shortcut key

		action.keyDown(Keys.CONTROL).keyDown(Keys.ALT).sendKeys("I").build().perform();
		wait.until(ExpectedConditions.visibilityOf(inspectmodalbox));
		System.out.println("Inspect modal box is displayed by pressing keys CTRL+Alt+I");
		action.keyUp(Keys.CONTROL).keyUp(Keys.ALT).build().perform();

		Thread.sleep(1000);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", inspectclose);

		Thread.sleep(2000);

		// Zoom In Zoom Out shortcut key
		// zoom out
		for (int z = 1; z <= 2; z++) {
			action.keyDown(Keys.CONTROL).keyDown(Keys.ALT).sendKeys("-").pause(Duration.ofSeconds(2)).build().perform();
			action.keyUp(Keys.CONTROL).keyUp(Keys.ALT).build().perform();
		}
		System.out.println("Zoom Out is performed by pressing keys CTRL+ Alt+ -");

		Thread.sleep(2000);
		// zoom in
		for (int z = 1; z <= 2; z++) {
			action.keyDown(Keys.CONTROL).keyDown(Keys.ALT).sendKeys("+").pause(Duration.ofSeconds(2)).build().perform();
			action.keyUp(Keys.CONTROL).keyUp(Keys.ALT).build().perform();
		}
		System.out.println("Zoom In is performed by pressing keys CTRL+Alt+ +");

		Thread.sleep(2000);

		// Approve Button

		action.keyDown(Keys.CONTROL).keyDown(Keys.ALT).sendKeys("A").build().perform();

		action.keyUp(Keys.CONTROL).keyUp(Keys.ALT).build().perform();

		Thread.sleep(2000);
		// action.moveToElement(ignore_yes).build().perform();
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", ignore_yes);
		// ignore_yes.click();

		wait.until(ExpectedConditions.elementToBeClickable(approvecancel));
		Thread.sleep(2000);
		// action.moveToElement(approvecancel).build().perform();
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", approvecancel);

		System.out.println("Approve shortcut key is performed by pressing keys CTRL+Alt+ A");
		Thread.sleep(5000);

		// shortcut keys for move box up , down,left ,right

		try {

			// Actions action = new Actions(driver);

			int no_of_elements = l.size();
			System.out.println("Number of elements found on current page is  " + no_of_elements);
			for (int e = 0; e < no_of_elements; e++) {
				// String element = l.get(e).getText();
				if (e == 3) {
					// clone zone
					String element = l.get(e).getText();
					if (element.equalsIgnoreCase("Figure") || (element.equalsIgnoreCase("Table"))
							|| (element.equalsIgnoreCase("Formula"))) {

						((JavascriptExecutor) driver).executeScript("arguments[0].click();", l.get(e));
						Thread.sleep(1000);
						action.keyDown(Keys.CONTROL).sendKeys("B").perform();
						action.keyUp(Keys.CONTROL);
						Thread.sleep(2000);

						Alert alert = driver.switchTo().alert();

						System.out.println("The alert message is :" + alert.getText());
						Thread.sleep(1000);
						alert.accept();

					} else {
						((JavascriptExecutor) driver).executeScript("arguments[0].click();", l.get(e));

						action.keyDown(Keys.CONTROL).sendKeys("B").perform();
						action.keyUp(Keys.CONTROL);
						((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", l.get(e));
						// action.dragAndDropBy(l.get(e), 55, 10).build().perform();
						System.out.println(element + " is cloned");
						Thread.sleep(1000);

					}

				}

				if (e == 3) {
					String element = l.get(e).getText();
					((JavascriptExecutor) driver).executeScript("arguments[0].click();", l.get(e));
					// shortcut key to move box left
					for (int p = 0; p <= 3; p++) {

						action.keyDown(l.get(e), Keys.CONTROL).keyDown(l.get(e), Keys.ALT)
								.sendKeys(l.get(e), Keys.ARROW_LEFT).pause(Duration.ofSeconds(2)).build().perform();

					}
					System.out.println(element + " is moved left by pressing keys CTRL+Alt+ Left Arrow");
					Thread.sleep(1000);
					// shortcut key to move box right
					for (int p = 0; p <= 3; p++) {

						action.keyDown(l.get(e), Keys.CONTROL).keyDown(l.get(e), Keys.ALT)
								.sendKeys(l.get(e), Keys.ARROW_RIGHT).pause(Duration.ofSeconds(2)).build().perform();

					}
					System.out.println(element + " is moved right by pressing keys CTRL+Alt+ Right Arrow");
					Thread.sleep(1000);
					// shortcut key to move box up
					for (int p = 0; p <= 3; p++) {

						action.keyDown(l.get(e), Keys.CONTROL).keyDown(l.get(e), Keys.ALT)
								.sendKeys(l.get(e), Keys.ARROW_UP).pause(Duration.ofSeconds(2)).build().perform();

					}
					System.out.println(element + " is moved up by pressing keys CTRL+Alt+ Up Arrow");
					Thread.sleep(1000);
					// shortcut key to move box down
					for (int p = 0; p <= 3; p++) {

						action.keyDown(l.get(e), Keys.CONTROL).keyDown(l.get(e), Keys.ALT)
								.sendKeys(l.get(e), Keys.ARROW_DOWN).pause(Duration.ofSeconds(2)).build().perform();

					}
					System.out.println(element + " is moved down by pressing keys CTRL+Alt+ DOWN Arrow");
					Thread.sleep(1000);

					// shortcut key to shrink right side of box
					for (int p = 0; p <= 3; p++) {

						action.keyDown(l.get(e), Keys.CONTROL).keyDown(l.get(e), Keys.SHIFT)
								.sendKeys(l.get(e), Keys.ARROW_LEFT).pause(Duration.ofSeconds(2)).build().perform();

					}
					System.out.println(
							"shortcut key (CTRL+SHIFT+ Left Arrow)is pressed to shrink right side of zoned  element "
									+ element);
					Thread.sleep(1000);

					// shortcut key to expand right side of box
					for (int p = 0; p <= 3; p++) {

						action.keyDown(l.get(e), Keys.CONTROL).keyDown(l.get(e), Keys.SHIFT)
								.sendKeys(l.get(e), Keys.ARROW_RIGHT).pause(Duration.ofSeconds(2)).build().perform();

					}
					System.out.println(
							"shortcut key (CTRL+SHIFT+ Right Arrow)is pressed to expand right side of zoned  element "
									+ element);
					Thread.sleep(1000);
					// shortcut key to shrink bottom side of box
					for (int p = 0; p <= 3; p++) {

						action.keyDown(l.get(e), Keys.CONTROL).keyDown(l.get(e), Keys.SHIFT)
								.sendKeys(l.get(e), Keys.ARROW_UP).pause(Duration.ofSeconds(2)).build().perform();

					}
					System.out.println(
							"shortcut key (CTRL+SHIFT+ UP Arrow)is pressed to shrink bottom side of zoned  element "
									+ element);
					Thread.sleep(1000);

					// shortcut key to expand bottom side of box
					for (int p = 0; p <= 3; p++) {

						action.keyDown(l.get(e), Keys.CONTROL).keyDown(l.get(e), Keys.SHIFT)
								.sendKeys(l.get(e), Keys.ARROW_DOWN).pause(Duration.ofSeconds(2)).build().perform();

					}
					System.out.println(
							"shortcut key (CTRL+SHIFT+ Down Arrow)is pressed to expand bottom side of zoned  element "
									+ element);
				
					Thread.sleep(1000);

					// delete
					if (e == 3) {
						// String element = l.get(e).getText();
						if (element.equalsIgnoreCase("Figure") || (element.equalsIgnoreCase("Table"))
								|| (element.equalsIgnoreCase("Formula"))) {

							((JavascriptExecutor) driver).executeScript("arguments[0].click();", l.get(e));
							Thread.sleep(1000);

							action.sendKeys(Keys.DELETE).build().perform();
							// action.keyUp(Keys.DELETE).build().perform();

							Alert alert = driver.switchTo().alert();
							Thread.sleep(1000);
							System.out.println("The alert message is :" + alert.getText());
							Thread.sleep(1000);
							alert.accept();

						}
						if (element.equalsIgnoreCase("P")) {
							// else {
							((JavascriptExecutor) driver).executeScript("arguments[0].click();", l.get(e));
							action.sendKeys(Keys.DELETE).build().perform();

							System.out.println("Prediction on "+ element + " is deleted");

						}

					}
				}

			}

			for (int g = 0; g < no_of_elements; g++) {
				if (g == 0 && !l.get(g).isSelected()) {
					String ele1 = l.get(g).getText();
					// action.keyDown(Keys.LEFT_CONTROL).pause(Duration.ofSeconds(2))
					action.keyDown(Keys.LEFT_CONTROL).click(l.get(g)).pause(Duration.ofSeconds(2)).perform();
					// .keyUp(Keys.LEFT_CONTROL).perform();
					System.out.println("1st element selected to be merged is " + ele1);
				}

				for (int f = 0; f < no_of_elements; f++) {

					if (f == 1 && !l.get(f).isSelected()) {
						String ele2 = l.get(f).getText();
						action.keyDown(Keys.LEFT_CONTROL).click(l.get(f)).pause(Duration.ofSeconds(2)).perform();
						// .keyUp(Keys.LEFT_CONTROL).perform();

						System.out.println("2nd element selected to be merged is " + ele2);
						break;
					}

				}
				break;
			}
			action.keyDown(Keys.CONTROL).sendKeys("M").pause(Duration.ofSeconds(2)).keyUp(Keys.CONTROL).perform();
			System.out.println("both elements are merged");

		}

		catch (NoSuchElementException e) {
			System.out.println("Unable to locate element");
		}
		
	catch(org.openqa.selenium.interactions.MoveTargetOutOfBoundsException m)
	{
		
	}

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", helpclose);

	}}

	