package codemantra.ADH.stepDefintion;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import codemantra.ADH.TestBase.BaseClass;
import codemantra.ADH.pages.LoginPage;
import codemantra.ADH.pages.AllProjectsPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class LoginSteps extends BaseClass {

	LoginPage loginobj;
	AllProjectsPage projectsobj = new AllProjectsPage();

	@Given("^User in on login page$")
	public void user_in_on_login_page() throws Throwable {

		BaseClass.initialization();
	}

	@Given("^verify Login page title$")
	public void verify_Login_page_title() throws Throwable {
		loginobj = new LoginPage();
		String logintitle = loginobj.displayTitle();
		String expectedTitle = "Welcome to codemantra Login Page";
		Assert.assertEquals(expectedTitle, logintitle);
		System.out.println(logintitle);

	}

	@Given("^verify text on the page$")
	public void verify_text_on_the_page() throws Throwable {
		String logintext = loginobj.displayText();
		String expectedText = "WELCOME!";
		Assert.assertEquals(expectedText, logintext);
		System.out.println(logintext);

	}

	@When("^user enters emailaddress and  password$")
	public void user_enters_emailaddress_and_password() throws Throwable {
		projectsobj = loginobj.login(prop.getProperty("emailaddress"), prop.getProperty("password"));
		
	

	}

	@Then("^user navigates to project page$")
	public void user_navigates_to_project_page() throws Throwable {
		Thread.sleep(3000);
		Actions actions= new Actions(driver);
		actions.keyDown(Keys.CONTROL).sendKeys(Keys.HOME).build().perform();
		String projectsText = projectsobj.projectsPageDisplayText();
		String projectexpectedText = "All Projects";
		Assert.assertEquals(projectexpectedText, projectsText);
		System.out.println(projectsText);

	}
//negative cases
	@When("^user enters \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_enters_and(String e, String p) throws Throwable {
		loginobj = new LoginPage();
		projectsobj = loginobj.login(e, p);

	}

	@Then("^user should not be navigated to project page$")
	public void user_should_not_be_navigated_to_project_page() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		String logintext = loginobj.displayText();
		String expectedtext = "WELCOME!";
		Assert.assertEquals(expectedtext, logintext);
	}

	@Then("^verify the \"([^\"]*)\" and \"([^\"]*)\" displayed$")
	public void verify_the_and_displayed(String errormessage1, String errormessage2) throws Throwable {
		
		String invalidpassword = loginobj.displayErrorMssgforInvalid_UserOrPwd();
		Assert.assertEquals(errormessage1, invalidpassword);
		System.out.println("Displayed error message for invalid emailaddress or password is " + invalidpassword);
		
		Thread.sleep(1000);
		
		String invaliduser = loginobj.displayErrorMssgforInvalid_UserOrPwd();
		Assert.assertEquals(errormessage1, invaliduser);
		System.out.println("Displayed error message for invalid emailaddress or password is " + invaliduser);
		Thread.sleep(1000);
		
		String blankpassword = loginobj.displayErrorMssgforblankpwd();
		Assert.assertEquals(errormessage1,blankpassword);
		System.out.println("Displayed error message for blank password is " + blankpassword);
		
		Thread.sleep(1000);

		String blankemail = loginobj.displayErrorMssgforblankemail();
		Assert.assertEquals(errormessage1, blankemail);
		System.out.println("Displayed error message for blank email is " + blankemail);
		Thread.sleep(1000);
		
		

		String[] blank_emailpwd = loginobj.displayErrorMessageForBlank_Email_pwd();
		Assert.assertEquals(errormessage1, blank_emailpwd[0]);
		Assert.assertEquals(errormessage2, blank_emailpwd[1]);
		System.out.println(blank_emailpwd[0]);
		System.out.println(blank_emailpwd[1]);
	
	}
}
