package codemantra.ADH.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import codemantra.ADH.TestBase.BaseClass;

import junit.framework.Assert;

public class AllProjectsPage extends BaseClass{
	//Object Repository
	//@FindBy(xpath="//div[@class='col-md-6 col-sm-6']/h2//b[@class='ng-binding']")
	@FindBy(xpath="//*[@id='jch_dashboard']/div[1]/div/div/div[1]/div[1]/h2/b")
	WebElement allprojectsPageText;
	
	
	@FindBy(xpath="//button[@id='createMoreButtonA']")
	WebElement AddProjectbtn;
	
	@FindBy(xpath = "//input[@id='search']")
	WebElement searchbox;

	@FindBy(xpath = "//input[@id='search_submit']")
	WebElement searchbtn;
	
	@FindBy(xpath="//div[@id='myproject']//table[@class='table']/tbody")
	WebElement table;
	
	@FindBy(xpath="//div[@id='myproject']//table[@class='table']/tbody/tr")
	List <WebElement> rows;
	
	@FindBy(xpath="//body//div[@id='jch_dashboard']//div[@id='jch_dashboard']//th")
	List <WebElement> cols;
	
	@FindBy(xpath="//div[@id='myproject']//table[@class='table']/tbody/tr/td/a")
	List <WebElement> rowvalue;
	
	@FindBy(xpath="//em[contains(text(),'log out')]")
	WebElement logout;
	
	
	
	//Initializing the page Objects
	public AllProjectsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String projectsPageDisplayText() throws InterruptedException
	{ 
		
		driver.manage().timeouts().pageLoadTimeout(200,TimeUnit.SECONDS);
			
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
	public void searchProjectForExistence(String proj) throws InterruptedException
	{boolean flag=false;
		WebDriverWait wait=new WebDriverWait(driver, 900);
		wait.until(ExpectedConditions.visibilityOf(searchbox));
		Thread.sleep(5000);
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.CONTROL).sendKeys(Keys.HOME).perform();
		//Thread.sleep(3000);
			
			Thread.sleep(5000);
			searchbox.sendKeys(" ");
			searchbox.sendKeys(proj);
			Thread.sleep(5000);
			 wait.until(ExpectedConditions.visibilityOf(searchbtn));         
					
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", searchbtn);
			Thread.sleep(2000);

			WebDriverWait tablewait = new WebDriverWait(driver, 20000);
			tablewait.until(ExpectedConditions.visibilityOfAllElements(rowvalue));

			int row=rows.size();
			
			for (int i=0;i<=row;i++)
			{
				if(rowvalue.get(i).getText().equalsIgnoreCase(proj))
				{
					flag=true;
					tablewait.until(ExpectedConditions.elementToBeClickable(rowvalue.get(i)));
					Actions action=new Actions(driver);
					action.moveToElement(rowvalue.get(i)).perform();
					Thread.sleep(1000);
					searchbox.clear();
					
					
					break;
				}
			}
		
	}
	
	//public AddProjectPage clickAddProject(String projectname) throws InterruptedException
	public AddProjectPage clickAddProject() throws InterruptedException
		{
		/*boolean flag=false;
		WebDriverWait wait=new WebDriverWait(driver, 900);
		wait.until(ExpectedConditions.visibilityOf(searchbox));
		Thread.sleep(5000);
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.CONTROL).sendKeys(Keys.HOME).perform();
		//Thread.sleep(3000);
			
			Thread.sleep(5000);
			searchbox.sendKeys(" ");
			//searchbox.sendKeys(proj);
			Thread.sleep(5000);
			 wait.until(ExpectedConditions.visibilityOf(searchbtn));         
					
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", searchbtn);
			Thread.sleep(2000);

			WebDriverWait tablewait = new WebDriverWait(driver, 20000);
			tablewait.until(ExpectedConditions.visibilityOfAllElements(rowvalue));

			int row=rows.size();
			for (int i=0;i<=row;i++)
			{
				if(rowvalue.get(i).getText().equalsIgnoreCase(projectname))
				{
					
					break;
				}
			}*/
			
		AddProjectbtn.sendKeys("");
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", AddProjectbtn);
		
		
		return new AddProjectPage();
	}
	
	
	//search
		public FileRepoPage search(String proj) throws InterruptedException
		{boolean flag = false;
		//driver.manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
		//Thread.sleep(10000);
		WebDriverWait wait=new WebDriverWait(driver, 900);
		wait.until(ExpectedConditions.visibilityOf(searchbox));
		Thread.sleep(5000);
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.CONTROL).sendKeys(Keys.HOME).perform();
		//Thread.sleep(3000);
			
			Thread.sleep(4000);
			searchbox.sendKeys(" ");
			searchbox.sendKeys(proj);
			Thread.sleep(5000);
			 wait.until(ExpectedConditions.visibilityOf(searchbtn));         
					
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", searchbtn);
			Thread.sleep(2000);
try {
			WebDriverWait tablewait = new WebDriverWait(driver, 20000);
			tablewait.until(ExpectedConditions.visibilityOfAllElements(rowvalue));


			int row=rows.size();
			
			for (int i=0;i<=row;i++)
			{
				if(rowvalue.get(i).getText().equalsIgnoreCase(proj))
				{
					flag=true;
					tablewait.until(ExpectedConditions.elementToBeClickable(rowvalue.get(i)));
					Actions action=new Actions(driver);
					action.moveToElement(rowvalue.get(i)).perform();
					Thread.sleep(1000);
					((JavascriptExecutor) driver).executeScript("arguments[0].click();", rowvalue.get(i));
					break;
				}
			}
}
catch(org.openqa.selenium.StaleElementReferenceException e)
{
	System.out.println("Element is not attached to the page document");
}


			return new FileRepoPage();
			
		}
		
		public void logOut() throws InterruptedException
		{
			
			
			
			WebDriverWait wait=new WebDriverWait(driver,2000);
			wait.until(ExpectedConditions.visibilityOf(logout));
			Thread.sleep(10000);
			
			Actions action=new Actions(driver);
			action.moveToElement(logout);
			Thread.sleep(1000);
			
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", logout);
			Thread.sleep(2000);
			driver.quit();

		}
		
		/*public void selectvalue(String p)
		{
			int row=rows.size();
			int col=cols.size();
			System.out.println("Number of rows in a table " + row);
			System.out.println("Number of columns in a table " + col);
			
			for (int i=1;i<=row;i++)
			{
				String value=rowvalue.get(i).getText();
				System.out.println(value);
				Assert.assertEquals(p, value);
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", value);
				break;
			}
			boolean flag = false;
			//List<WebElement> listBoxItems = driver.findElements(By.tagName("li"));			            
			for(WebElement item : rowvalue)
			{
				if(item.getText().equals(p))      		
					flag=true;
				System.out.println(item.getText());
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", item);
				break;
			}
			
		}*/
	
}

