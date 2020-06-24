package codemantra.ADH.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import codemantra.ADH.TestBase.BaseClass;

public class LoginPage extends BaseClass {
	// object repository
	@FindBy(id = "user001")
	WebElement emailAddress;
	@FindBy(id = "pas001")
	WebElement password;
	@FindBy(id = "save_sla")
	WebElement lgnbtn;
	@FindBy(xpath = "//div[@class='signin-hdg']")
	WebElement loginpage_text;
	// error message when emailaddress or password is invalid
	@FindBy(xpath = "//div[@class='validation-error ng-active']//span[@class='ng-scope']")
	WebElement invaliduserOrpwderror_msg;
	
	// error message when password is empty
	@FindBy(xpath="//span[@id='pass002']")
	WebElement emptypwderror_msg;
	
	// error message when emailaddress is empty
	@FindBy(xpath="//span[@id='emailBlank']")
	WebElement emptyemailerror_msg;

	// page object initialization
	public LoginPage() {
		PageFactory.initElements(driver, this);

	}
	// Actions

	public AllProjectsPage login(String username, String pwd) throws InterruptedException {
		
		emailAddress.sendKeys(username);
		Thread.sleep(500);
		password.sendKeys(pwd);
		Thread.sleep(500);
		lgnbtn.click();

		return new AllProjectsPage();
	}

	public String displayTitle() {

		return driver.getTitle();
	}

	public String displayText() throws InterruptedException {
		Thread.sleep(2000);
		return loginpage_text.getText();
	}

	public String displayErrorMssgforInvalid_UserOrPwd() throws InterruptedException {
		Thread.sleep(2000);
		return invaliduserOrpwderror_msg.getText();

	}

	public String displayErrorMssgforblankpwd() throws InterruptedException {
		Thread.sleep(2000);
		return emptypwderror_msg.getText();

	}

	public String displayErrorMssgforblankemail() throws InterruptedException {
		Thread.sleep(2000);
		return emptyemailerror_msg.getText();

	}

	public String[] displayErrorMessageForBlank_Email_pwd() throws InterruptedException {
		Thread.sleep(2000);
		String[] names = new String[2];
		names[0] = emptyemailerror_msg.getText();
		names[1] = emptypwderror_msg.getText();

		return names;

	}

}