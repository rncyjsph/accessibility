package codemantra.ADH.stepDefintion;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import codemantra.ADH.TestBase.BaseClass;
import codemantra.ADH.pages.AddProjectPage;
import codemantra.ADH.pages.AllProjectsPage;
import codemantra.ADH.pages.FileRepoPage;
import codemantra.ADH.pages.LoginPage;
import codemantra.ADH.util.TestUtil;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class AllProjectsSteps extends BaseClass {
	LoginPage loginobj;
	AllProjectsPage allprojectsobj = new AllProjectsPage();
	AddProjectPage addprojobj = new AddProjectPage();
	FileRepoPage filerepoobj = new FileRepoPage();
	

	@Given("^User is on login page$")
	public void user_is_on_login_page() throws Throwable {

		BaseClass.initialization();
	}

	@Given("^user verifies Login page title$")
	public void user_verifies_Login_page_title() throws Throwable {
		loginobj = new LoginPage();
		String logintitle = loginobj.displayTitle();
		String expectedTitle = "Welcome to codemantra Login Page";
		Assert.assertEquals(expectedTitle, logintitle);
		System.out.println(logintitle);
	}

	@Given("^user verify text on the page$")
	public void user_verify_text_on_the_page() throws Throwable {
		String logintext = loginobj.displayText();
		String expectedText = "WELCOME!";
		Assert.assertEquals(expectedText, logintext);
		System.out.println(logintext);

	}

	@When("^user types in emailaddress and password$")
	public void user_types_in_emailaddress_and_password() throws Throwable {
		allprojectsobj = loginobj.login(prop.getProperty("emailaddress"), prop.getProperty("password"));

	}

	@Then("^user is navigated to project page$")
	public void user_is_navigated_to_project_page() throws Throwable {
		Thread.sleep(3000);
		Actions actions= new Actions(driver);
		actions.keyDown(Keys.CONTROL).sendKeys(Keys.HOME).build().perform();
		String projectsText = allprojectsobj.projectsPageDisplayText();
		String projectexpectedText = "All Projects";
		Assert.assertEquals(projectexpectedText, projectsText);
		System.out.println(projectsText);
			

	}

	@When("^user clicks on Add Project$")
	public void user_clicks_on_Add_Project() throws Throwable {

		addprojobj = allprojectsobj.clickAddProject();
	}

	@Then("^user navigates to Add Project page$")
	public void user_navigates_to_Add_Project_page() throws Throwable {
		Actions actions= new Actions(driver);
		actions.keyDown(Keys.CONTROL).sendKeys(Keys.HOME).build().perform();
		String expectedaddprojtext = addprojobj.displayAddProjectText();
		String Actualtext = "Add Project";
		Assert.assertEquals(expectedaddprojtext, Actualtext);
		System.out.println(expectedaddprojtext);
	}

	@Then("^user enters \"([^\"]*)\"$")
	public void user_enters(String project) throws Throwable {
		// String label=addprojobj.displayprojlabelname();
		// System.out.println("Project name label is " + label );
		
		addprojobj.inputProjectName(project);
	}

	@Then("^user clicks on Save and Continue button$")
	public void user_clicks_on_Save_and_Continue_button() throws Throwable {
		
		filerepoobj = addprojobj.saveAndContinue();
	}

	@Then("^user navigates to File Repository page with \"([^\"]*)\"$")
	public void user_navigates_to_File_Repository_page_with(String project) throws Throwable {
		Thread.sleep(2000);
		String actualreponame = filerepoobj.displayfileRepo();
		String expectedfilerepo = "File Repository";
		Assert.assertEquals(expectedfilerepo, actualreponame);
		System.out.println(actualreponame);
		// Check project name is correct
		String actualfile = filerepoobj.displayProjectName();
		//Assert.assertEquals(project, actualfile);
		System.out.println(actualfile);

	}
	
	
	//Save and Continue and Cancel button enable check functionality
	
	
	@When("^user selects \"([^\"]*)\" asset$")
	public void user_selects_asset(String assets) throws Throwable {
		addprojobj.clickRadiobtn(assets);
	   /*String expectedAsset1="MathML";
	   String[] actualAsset=addprojobj.displayradiolabels();
		Assert.assertEquals(expectedAsset1, actualAsset[1]);*/
		
	    
	}
	

	@When("^user enters \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_enters_and_and_and_and(String instruction, String pages, String customer_ID, String division, String department) throws Throwable {
		addprojobj.enterValues(instruction, pages, customer_ID, division, department);
		
	    
	}

	@Then("^press cancel button if Save and Continue button is disabled$")
	public void press_cancel_button_if_Save_and_Continue_button_is_disabled() throws Throwable {
		allprojectsobj=addprojobj.checkSavebtn_disabled();
		//driver.manage().timeouts().pageLoadTimeout(TestUtil.PageLoadTimeOut,TimeUnit.SECONDS);
		Thread.sleep(3000);
		Actions actions= new Actions(driver);
		actions.keyDown(Keys.CONTROL).sendKeys(Keys.HOME).build().perform(); 
	    
	}

	

	/*@Then("^user returns to All Projects page$")
	public void user_returns_to_All_Projects_page() throws Throwable {
		
		String projectsText = allprojectsobj.projectsPageDisplayText();
		String projectexpectedText = "All Projects";
		Assert.assertEquals(projectexpectedText, projectsText);
		System.out.println(projectsText);
	    
	}*/


}
