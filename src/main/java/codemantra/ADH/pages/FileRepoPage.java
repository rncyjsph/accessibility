package codemantra.ADH.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import codemantra.ADH.TestBase.BaseClass;
import codemantra.ADH.util.TestUtil;

public class FileRepoPage extends BaseClass {
	@FindBy(id="fileRepoA")
	WebElement fileRepository;
	
	@FindBy(xpath="//div[@class='col-md-9 col-sm-9 col-lg-9 col-xl-9 nopadding']//span[@class='ng-binding']")
	WebElement actualprojectName;
	
	@FindBy(xpath="//span[@class='servDescFile ng-binding']")
	WebElement date;
	@FindBy(xpath="//div[@class='col-md-4 col-sm-4 col-lg-4 col-xl-4']//button[@id='createMoreButtonAs22']")
	WebElement addfilebtn;
	
	public FileRepoPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String displayfileRepo() throws InterruptedException
	{   Thread.sleep(1000);
		//driver.manage().timeouts().pageLoadTimeout(TestUtil.PageLoadTimeOut,TimeUnit.SECONDS);
		return fileRepository.getText();
	}
	public String displayProjectName()
	{   
		String completeprojname= actualprojectName.getText(); 
		System.out.println("The Project name with date created " +completeprojname );
		String datevalue= date.getText();
		System.out.println(datevalue);
		String[] dateParts = datevalue.split(" ");
		String month=dateParts[0];
		System.out.println(month);
		int index=completeprojname.indexOf(month);
		System.out.println(index);
		String actualprojname=completeprojname.substring(0,index).trim();
		
		String s1=actualprojname.substring(0, 1).toUpperCase();
		String nameCapitalized = s1 + actualprojname.substring(1);
				return nameCapitalized;

	}
	
	public void addFiles()
	{
		
	}
}
