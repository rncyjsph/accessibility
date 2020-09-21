package codemantra.ADH.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import codemantra.ADH.TestBase.BaseClass;

import junit.framework.Assert;

public class AddProjectPage extends BaseClass {
	AllProjectsPage allprojectsobj = new AllProjectsPage();
	@FindBy(xpath = "//div[@id='vendor-add-project-tab']//div[@class='col-md-6 col-sm-6']/h2/b[@class='ng-binding']")
	WebElement addProjectText;

	// @FindBy(xpath="//label[@for='title2']")
	@FindBy(xpath = "//label[contains(text(),'Project Name')]")
	WebElement projlabelName;

	@FindBy(xpath = "//div[@class='col-xs-12 col-sm-6 col-md-6 col-lg-6 ng-scope']/div[1]/input[@id='title2']")
	WebElement projectname;

	@FindBy(xpath = "//span[@class='redios-btn ng-binding'][text()='MathML']")
	WebElement mathmllbl;
	@FindBy(xpath = "//span[@class='redios-btn ng-binding'][text()='Math Description']")
	WebElement mathDeslbl;
	@FindBy(xpath = "//span[@class='redios-btn ng-binding'][text()='MathML/Math Description']")
	WebElement mathmldeslbl;
	@FindBy(xpath = "//span[@class='redios-btn ng-binding'][text()='None']")
	WebElement nonelbl;
	// @FindBy(xpath = "//input[@class='radio ng-pristine ng-untouched ng-valid
	// ng-empty'][@type='radio']")
	@FindBy(xpath = "//input[@name='math_custom_column_71']")
	List<WebElement> radiolist;

	@FindBy(xpath = "//button[@class='btn save-btn wizard_next_step1 nocap']")
	WebElement disabledSavbtn;
	/*@FindBy(xpath = "//span[contains(text(),'Project name Already exists')]")
	WebElement projectErrormssg;*/

	@FindBy(xpath = "//input[@id='custom_column_11']")
	WebElement instruction;
	@FindBy(xpath = "//input[@id='custom_column_5']")
	WebElement page;
	@FindBy(xpath = "//input[@id='custom_column_7']")
	WebElement cust_id;
	@FindBy(xpath = "//input[@id='custom_column_6']")
	WebElement divisiontxt;
	@FindBy(xpath = "//input[@id='custom_column_4']")
	WebElement departmenttxt;

	@FindBy(xpath = "//button[@class='btn save-btn wizard_next_step1 nocap']")
	WebElement savbtn;

	@FindBy(xpath = "//*[@id=\"metadatafrm\"]/div[2]/div/button[1]")
	WebElement cancelbtn;

	public AddProjectPage() {
		PageFactory.initElements(driver, this);
	}

	public String displayAddProjectText() {
		return addProjectText.getText();
	}


	public void inputProjectDetails(String projtitle, String assetname, String inst, String pages, String id,
			String div, String dept) throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver, 900);
		wait.until(ExpectedConditions.visibilityOf(projectname));

		projectname.clear();
		projectname.sendKeys(" ");
		projectname.sendKeys(projtitle);
		Thread.sleep(2000);
		int radiosize = radiolist.size();
		System.out.println(radiosize);
		for (int i = 0; i < radiosize; i++) {
			String radio = radiolist.get(i).getAttribute("value");
			System.out.println(radio);

			if (radio.equalsIgnoreCase(assetname)) {

				radiolist.get(i).sendKeys("");
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", radiolist.get(i));
			}

		}

		instruction.sendKeys(" ");
		instruction.sendKeys(inst);
		Thread.sleep(1000);

		page.sendKeys(pages);
		Thread.sleep(1000);

		cust_id.sendKeys(id);
		Thread.sleep(1000);

		divisiontxt.sendKeys(div);
		Thread.sleep(1000);

		departmenttxt.sendKeys(dept);
		Thread.sleep(1000);

		Actions actions = new Actions(driver);
		actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).build().perform();

		Thread.sleep(2000);
		Actions action = new Actions(driver);

		action.moveToElement(savbtn).perform();

	}

	public AllProjectsPage checkSavebtn_disabled() throws InterruptedException {
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).build().perform();
		new Actions(driver).moveToElement(disabledSavbtn).build().perform();
		// Assert.assertFalse("Save and Continue button is disabled",
		// diabledSavbtn.isEnabled());
		boolean flag = disabledSavbtn.isEnabled();
		if (flag == false) {
			System.out.println("Save and Continue Button is disabled unless mandatory field value is entered");
			new Actions(driver).moveToElement(cancelbtn).build().perform();
			Thread.sleep(1000);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", cancelbtn);

		}

		return new AllProjectsPage();

	}

	public void scrollup() throws InterruptedException {
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(900, TimeUnit.SECONDS);
		Thread.sleep(2000);
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.CONTROL).sendKeys(Keys.HOME).build().perform();

	}

	public void scrolldown() throws InterruptedException {
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(900, TimeUnit.SECONDS);
		Thread.sleep(2000);
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).build().perform();

	}

	public FileRepoPage gotofileRepo() {
		return new FileRepoPage();

	}

	public void gotoAllProjects() throws InterruptedException

	{// driver.navigate().refresh();
		scrolldown();
		Actions action = new Actions(driver);
		action.moveToElement(cancelbtn).perform();
		WebDriverWait wait = new WebDriverWait(driver, 900);

		wait.until(ExpectedConditions.elementToBeClickable(cancelbtn));
		Thread.sleep(1000);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", cancelbtn);

		scrollup();
		// driver.close();
	}

	// public FileRepoPage saveAndContinue() throws InterruptedException {
	public void saveAndContinue() throws InterruptedException {

		Thread.sleep(2000);
		Actions action = new Actions(driver);

		action.moveToElement(savbtn).perform();

		savbtn.click();

		scrollup();
		// Thread.sleep(500);
		/*
		 * try { WebDriverWait wait=new WebDriverWait(driver,2);
		 * wait.until(ExpectedConditions.visibilityOf(projectErrormssg));
		 */

		try {
			WebElement projectErrormssg=driver.findElement(By.xpath("//span[contains(text(),'Project name Already exists')]"));
			
			if ((projectErrormssg.isDisplayed()) && projectErrormssg.toString().length() > 0) {
				System.out.println(projectErrormssg.getText());
				gotoAllProjects();
			}

			else {
				gotofileRepo();
			}
		} catch (NoSuchElementException e) {
			System.out.println("Error message is not displayed");
		}

	}/*
		 * catch (TimeoutException e) {
		 * 
		 * System.out.println("WebDriver couldn’t find this element visible"); }
		 */
}

/*
 * public AllProjectsPage cancel() throws InterruptedException {
 * driver.manage().timeouts().pageLoadTimeout(TestUtil.PageLoadTimeOut,
 * TimeUnit.SECONDS);
 * 
 * 
 * 
 * Thread.sleep(3000);
 * 
 * return new AllProjectsPage(); }
 */
