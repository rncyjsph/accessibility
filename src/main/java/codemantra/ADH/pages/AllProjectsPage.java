package codemantra.ADH.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import codemantra.ADH.TestBase.BaseClass;
import codemantra.ADH.util.TestUtil;

public class AllProjectsPage extends BaseClass{
	//Object Repository
	//@FindBy(xpath="//div[@class='col-md-6 col-sm-6']/h2//b[@class='ng-binding']")
	@FindBy(xpath="//*[@id='jch_dashboard']/div[1]/div/div/div[1]/div[1]/h2/b")
	WebElement allprojectsPageText;
	
	
	@FindBy(xpath="//button[@id='createMoreButtonA']")
	WebElement AddProjectbtn;
	
	//Initializing the page Objects
	public AllProjectsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String projectsPageDisplayText() throws InterruptedException
	{ 
		
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PageLoadTimeOut,TimeUnit.SECONDS);
			
		return allprojectsPageText.getText();
	}
	/*public void scrollUp()
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		 js.executeScript("window.scrollBy(0,-1000)", "");
		//JavascriptExecutor jse = (JavascriptExecutor)driver;
		//jse.executeScript("scroll(0, 500);");
		//jse.executeScript("window.scrollBy(0,-250)", "");
		//Actions actions = new Actions(driver);

	      // Scroll Down using Actions class
	     // actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();

	      // Scroll Up using Actions class
	      //actions.keyDown(Keys.CONTROL).sendKeys(Keys.HOME).perform();
		//System.out.println("Window is scrolled up");
		
		
	}*/
	
	public AddProjectPage clickAddProject()
	{
		AddProjectbtn.sendKeys("");
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", AddProjectbtn);
		
		
		return new AddProjectPage();
	}
}

