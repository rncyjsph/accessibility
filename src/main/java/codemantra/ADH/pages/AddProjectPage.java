package codemantra.ADH.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import codemantra.ADH.TestBase.BaseClass;
import codemantra.ADH.util.TestUtil;
import junit.framework.Assert;

public class AddProjectPage extends BaseClass {
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
	@FindBy(xpath = "//input[@type='radio'][@class='radio ng-pristine ng-untouched ng-valid ng-empty']")
	List<WebElement> radiolist;
	@FindBy(xpath = "//button[@class='btn save-btn wizard_next_step1 nocap']")
	WebElement disabledSavbtn;

	/*
	 * @FindBy(xpath="//input[@id='custom_column_71_0']") WebElement radio1;
	 * 
	 * @FindBy(xpath="//input[@id='custom_column_71_1']") WebElement radio2;
	 * 
	 * @FindBy(xpath="//input[@id='custom_column_71_2']") WebElement radio3;
	 * 
	 * @FindBy(xpath="//input[@id='custom_column_71_3']") WebElement radio4;
	 */
	@FindBy(xpath = "//input[@id='custom_column_11']")
	WebElement instruction;
	@FindBy(xpath = "//input[@id='custom_column_5']")
	WebElement pages;
	@FindBy(xpath = "//input[@id='custom_column_7']")
	WebElement cust_id;
	@FindBy(xpath = "//input[@id='custom_column_6']")
	WebElement division;
	@FindBy(xpath = "//input[@id='custom_column_4']")
	WebElement department;

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

	/*
	 * public String displayprojlabelname() { return projlabelName.getText(); }
	 */

	public void inputProjectName(String projtitle) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(projectname));
		projectname.clear();
		projectname.sendKeys(" ");
		projectname.sendKeys(projtitle);
	}

	public void clickRadiobtn(String name) {
		int radiosize = radiolist.size();
		System.out.println(radiosize);
		for (int i = 0; i < radiosize; i++) {
			String radio = radiolist.get(i).getAttribute("value");
			System.out.println(radio);
			if (radio.equalsIgnoreCase(name)) {
				boolean selflag = radiolist.get(i).isSelected();
				if (selflag == false) {
					((JavascriptExecutor) driver).executeScript("arguments[0].click();", radiolist.get(i));
				}
			}

			break;
		}

	}
	/*
	 * String[] asset=new String[4]; asset[0]=mathmllbl.getText();
	 * asset[1]=mathDeslbl.getText(); asset[2]=mathmldeslbl.getText();
	 * asset[3]=nonelbl.getText(); return asset;
	 */

	public void enterValues(String i, String p, String c, String di, String dep) throws InterruptedException {
		// driver.manage().timeouts().implicitlyWait(TestUtil.implicit_wait,
		// TimeUnit.SECONDS);

		instruction.sendKeys(" ");
		instruction.sendKeys(i);
		Thread.sleep(500);

		pages.sendKeys(p);
		Thread.sleep(500);

		cust_id.sendKeys(c);
		Thread.sleep(500);

		division.sendKeys(di);
		Thread.sleep(500);

		department.sendKeys(dep);
		Thread.sleep(500);

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

	public FileRepoPage saveAndContinue() throws InterruptedException {
		Thread.sleep(2000);
		/*
		 * Actions actions= new Actions(driver);
		 * actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).build().perform(); new
		 * Actions(driver).moveToElement(savbtn).perform();
		 */
		savbtn.click();

		return new FileRepoPage();

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

}
