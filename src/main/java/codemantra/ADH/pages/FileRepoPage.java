package codemantra.ADH.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
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

public class FileRepoPage extends BaseClass {

	AddProjectPage addprojobj = new AddProjectPage();

	// private WebDriver driver;
	// private WebDriverWait wait;

	@FindBy(id = "fileRepoA")
	// @FindBy(xpath = "//button[contains(text(),'File Repository')]")
	WebElement fileRepository;

	@FindBy(xpath = "//div[@class='col-md-9 col-sm-9 col-lg-9 col-xl-9 nopadding']//span[@class='ng-binding']")
	WebElement actualprojectName;

	@FindBy(xpath = "//button[@id='proInfoA']")
	WebElement projinfo;

	@FindBy(xpath = "//p[@class='project-user-name nocap ng-binding']")
	WebElement projectName;

	@FindBy(xpath = "//input[@id='project_info_title']")
	WebElement projinfo_title;

	@FindBy(xpath = "//span[@class='company-information-edit pull-right'][contains(text(),'Edit')]")
	WebElement edit;
	@FindBy(xpath = "//input[@id='custom_column_5']")
	WebElement projinfo_page;
	@FindBy(xpath = "//input[@id='custom_column_4']")
	WebElement projinfo_department;
	@FindBy(xpath = "//input[@id='custom_column_6']")
	WebElement projinfo_division;
	@FindBy(xpath = "//input[@id='custom_column_7']")
	WebElement projinfo_custID;
	@FindBy(xpath = "//input[@id='custom_column_11']")
	WebElement projinfo_instruction;
	@FindBy(xpath = "//button[@class='save-btn btn']")
	WebElement projinfo_savebtn;
	@FindBy(xpath = "//div[@class='tab-container-footer']//div[@class='edit-name-btn']//button[@class='cancel-btn'][contains(text(),'Cancel')]")
	WebElement projinfo_cancelbtn;

	@FindBy(xpath = "//span[@class='accBodyFile']//span[@class='project-folder-name nocap ng-binding'][contains(text(),'xlsx')]")
	WebElement alttextfile;

	@FindBy(xpath = "//span[@class='servDescFile ng-binding']")
	WebElement date;

	@FindBy(xpath = "//button[@id='createMoreButtonAs22']")
	WebElement addfileicon;

	// @FindBy(xpath = "//span[@id='a97729-22a']")
	// @FindBy(xpath = "//span[@id='a97845-22a']")
	@FindBy(xpath = "//span[@class='ng-binding ng-scope'][contains(text(),'Source')]")
	WebElement source;

	// @FindBy(xpath = "//span[@id='a97729-23a']")
	// @FindBy(xpath = "//span[@id='a97845-23a']")
	@FindBy(xpath = "//span[@class='ng-scope'][contains(text(),'Process')]")
	WebElement process;

	// @FindBy(xpath = "//span[@id='a97729-23c']")
	// @FindBy(xpath = "//span[@class='ng-scope'][contains(text(),'Process')]")
	// WebElement processplus;

	// @FindBy(xpath = "//span[@id='a97845-22c']")
	@FindBy(xpath = "//span[@id='a97729-22c']")
	WebElement sourceplus;

	// @FindBy(xpath = "//span[@id='a97729-33a']")
	@FindBy(xpath = "//span[@class='ng-binding ng-scope'][contains(text(),'QA')]")
	WebElement qa;

	@FindBy(xpath = "//span[@class='company-information-edit pull-right'][contains(text(),'View File')]")
	WebElement viewfilebtn;
	@FindBy(xpath = "//span[@class='company-information-edit pull-right ng-binding'][contains(text(),'Completed')]")
	WebElement completedtext;

	@FindBy(xpath = "//div[contains(@class,'col-md-7 col-sm-7 col-xs-7 no-padding')]//div[2]//a[1]//span[1]//span[2]")
	WebElement qa_downloadfile;

	@FindBy(xpath = "//body//div[contains(@class,'accordion-body')]//div[contains(@class,'accordion-body')]//div[3]//div[1]//a[1]")
	WebElement qa_downloadlog;

	@FindBy(xpath = "//span[@class='company-information-edit pull-right'][contains(text(),'View Log ')]")
	WebElement viewLog;

	@FindBy(xpath = "//div[@id='a97729-22']//span[@class='project-folder-name-date-time fileCount02']")
	WebElement source_filecount;

	// @FindBy(xpath="//span[@id='a97729-25c']")
	@FindBy(xpath = "//span[@class='ng-binding ng-scope'][contains(text(),'Alt text Writing')]")
	WebElement alttxticon;
	@FindBy(xpath = "//span[@class='accBodyFile']//span[@class='project-folder-name nocap ng-binding']")
	List<WebElement> source_files;

	@FindBy(xpath = "//span[@class='company-information-edit pull-right ng-scope']")
	WebElement editAlttext;

	@FindBy(xpath = "//div[@class='accordion-header collapsed'][@data-service-id='25']//span[@class='project-folder-name-date-time fileCount01']")
	WebElement alttext_filecountstatus;
	@FindBy(xpath = "//div[@class='accordion-header collapsed'][@data-service-id='25']//span[@class='project-folder-name-date-time fileCount01']/b")
	WebElement alttextfilecount;

	public FileRepoPage() {
		PageFactory.initElements(driver, this);
		// wait = new WebDriverWait(driver,60000);
	}

	public String displayfileRepo() throws InterruptedException {
		// Thread.sleep(1000);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		Actions action = new Actions(driver);
		action.keyDown(Keys.CONTROL).sendKeys(Keys.HOME);
		return fileRepository.getText();
	}

	public String displayProjectName() {
		String completeprojname = actualprojectName.getText();
		System.out.println("The Project name with date created " + completeprojname);
		String datevalue = date.getText();
		System.out.println(datevalue);
		String[] dateParts = datevalue.split(" ");
		String month = dateParts[0];
		System.out.println(month);
		int index = completeprojname.indexOf(month);
		System.out.println(index);
		String actualprojname = completeprojname.substring(0, index).trim();

		String s1 = actualprojname.substring(0, 1).toUpperCase();
		String nameCapitalized = s1 + actualprojname.substring(1);
		return nameCapitalized;

	}

	/*
	 * public void addFiles() throws InterruptedException {
	 * //driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
	 * //Thread.sleep(60000);
	 * 
	 * //WebDriverWait wait = new WebDriverWait(driver, 60);
	 * //wait.until(ExpectedConditions.presenceOfElementLocated(addfilebtn)).click()
	 * ;
	 * 
	 * //wait.until(ExpectedConditions.elementToBeClickable(addfilebtn));
	 * //wait.until(ExpectedConditions.visibilityOf(addfilebtn));
	 * //((JavascriptExecutor)
	 * driver).executeScript("return document.readyState").equals("complete");
	 * //boolean flag = addfilebtn.isEnabled(); //if (flag) {
	 * //System.out.println(flag); Actions action=new Actions(driver);
	 * action.moveToElement(addfileicon).perform();
	 * 
	 * Thread.sleep(2000); addfileicon.click(); }
	 */

	public void editProjInfo(String pg, String dept, String div, String cust, String inst) throws InterruptedException {
		projinfo.click();
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(edit));
		Thread.sleep(5000);
		edit.click();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		String projname = projectName.getText();
		// String projtitle=projinfo_title.getText();
		System.out.println(projname);
		// System.out.println(projtitle);
		// Assert.assertEquals(projname, projtitle);

		Thread.sleep(1000);
		projinfo_page.clear();
		projinfo_page.sendKeys(pg);

		Thread.sleep(1000);
		projinfo_department.clear();
		projinfo_department.sendKeys(dept);

		projinfo_division.clear();
		projinfo_division.sendKeys(div);
		Thread.sleep(1000);

		projinfo_custID.clear();
		projinfo_custID.sendKeys(cust);
		Thread.sleep(1000);

		projinfo_instruction.clear();
		projinfo_instruction.sendKeys(inst);
		Thread.sleep(1000);

		addprojobj.scrolldown();
		Actions action = new Actions(driver);
		action.moveToElement(projinfo_savebtn).perform();

		wait.until(ExpectedConditions.elementToBeClickable(projinfo_savebtn));
		projinfo_savebtn.click();

	}

	public void cancelEditProjInfo() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(edit));
		Thread.sleep(1000);
		edit.click();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		Actions action = new Actions(driver);
		action.moveToElement(projinfo_cancelbtn).perform();
		Thread.sleep(1000);
		projinfo_cancelbtn.click();

	}

	public void fileUpload() throws InterruptedException, AWTException, ClassNotFoundException, URISyntaxException

	{
		WebDriverWait wait = new WebDriverWait(driver, 20000);
		wait.until(ExpectedConditions.elementToBeClickable(addfileicon));
		ClipboardOwner owner = null;
		Actions action = new Actions(driver);
		action.moveToElement(addfileicon).perform();
		Thread.sleep(2000);
		addfileicon.click();

		Robot robot = new Robot();
		robot.setAutoDelay(2000);


//execute using maven
		// Load a file on the classpath as a resource using the ClassLoader.

		/*URL url = getClass().getClassLoader().getResource("MCCL11204_5.pdf");
		File file = Paths.get(url.toURI()).toFile();
		String p = file.getAbsolutePath();
		System.out.println(p);*/
		
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("MCCL11204_5.pdf").getFile());
		String p = file.getAbsolutePath();
		System.out.println(p);
		
		
		// To execute using junit
		//File resourcesDirectory = new File("src/test/resources");
		/*File f = new File("src/test/resources/MCCL11204_5.pdf");
		String p=f.getAbsolutePath();
        System.out.println(p);
		*/
		StringSelection stringselection = new StringSelection(p);
		// StringSelection stringselection = new StringSelection(prop.getProperty("filepath1"));
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringselection, owner);
		robot.setAutoDelay(5000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		//robot.setAutoDelay(500);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

	}

	public void click_Source() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, 900);
		wait.until(ExpectedConditions.elementToBeClickable(source));
		// Thread.sleep(20000);
		source.click();

		// Temporary fix as team member unable to add .
		/*
		 * Thread.sleep(2000); driver.navigate().refresh();
		 * driver.manage().timeouts().pageLoadTimeout(TestUtil.PageLoadTimeOut,
		 * TimeUnit.SECONDS); Thread.sleep(20000); sourceplus.click();
		 */
		// *******************************
		wait.until(ExpectedConditions.visibilityOf(viewfilebtn));

		Thread.sleep(5000);
		viewfilebtn.click();
	}

	/*
	 * public void click_Source() throws InterruptedException {
	 * 
	 * WebDriverWait wait = new WebDriverWait(driver, 900);
	 * wait.until(ExpectedConditions.elementToBeClickable(source)); source.click();
	 * 
	 * 
	 * Path path=Paths.get(prop.getProperty("filepath1")); Path
	 * filename=path.getFileName(); String name=filename.toString();
	 * System.out.println("Filename: " + name ); String
	 * src_file_counttxt=source_filecount.getText();
	 * System.out.println("files added " + src_file_counttxt); //String
	 * []count=src_file_counttxt.split(" "); //String
	 * first=src_file_counttxt.substring(0, 1); char c=src_file_counttxt.charAt(0);
	 * int num=Integer.parseInt(String.valueOf(c));
	 * System.out.println("No. of files in source folder " + num); for (int
	 * i=0;i<num;i++) { for (WebElement f : source_files ) {
	 * 
	 * String uploadedfile=f.getText();
	 * System.out.println("Files uploaded in source are " + uploadedfile); if
	 * (name.equals(uploadedfile)) {
	 * wait.until(ExpectedConditions.visibilityOf(viewfilebtn)); Thread.sleep(2000);
	 * 
	 * viewfilebtn.click(); }
	 * 
	 * }
	 * 
	 * } }
	 */

	public void click_Alttext() throws InterruptedException {

		// WebDriverWait a = new WebDriverWait(driver, 60000);
		// WebDriverWait a = new WebDriverWait(driver, 1000);
		WebDriverWait a = new WebDriverWait(driver, 2000);
		a.until(ExpectedConditions.visibilityOf(process));
		// a.until(ExpectedConditions.elementToBeClickable(process));

		// Thread.sleep(60000);
		// Thread.sleep(20000);
		
		process.click();

		Thread.sleep(5000);
		Path path = Paths.get(prop.getProperty("filepath1"));
		Path filename = path.getFileName();
		String name = filename.toString();
		System.out.println("Filename: " + name);
		try {
			if (!name.isEmpty() && viewLog.isDisplayed())

			{
				// WebElement
				// alttext_filecountstatus=driver.findElement(By.xpath("//div[@id='a97729-25']//span[@class='project-folder-name-date-time
				// fileCount01']"));
				driver.navigate().refresh();
				driver.manage().timeouts().pageLoadTimeout(TestUtil.PageLoadTimeOut, TimeUnit.SECONDS);
				a.until(ExpectedConditions.visibilityOf(alttext_filecountstatus));
				Thread.sleep(5000);
				// WebElement
				// alttextfilecount=driver.findElement(By.xpath("//div[@id='a97729-25']//span[@class='project-folder-name-date-time
				// fileCount01']/b"));
				String var = alttextfilecount.getText();
				System.out.println("Number of files in Alt text folder " + var);
				int filecount = Integer.parseInt(var);
				if (filecount > 0) {
					a.until(ExpectedConditions.elementToBeClickable(alttxticon));
					Thread.sleep(2000);
					alttxticon.click();
					Thread.sleep(2000);
					String altfile = alttextfile.getText();
					int length = altfile.length();
					System.out.println("The alt text file is  " + altfile);
					String[] at = altfile.split("AltText");
					String first = at[0];
					String second = at[1];
					System.out.println(first);
					int l = first.length();
					String expfilename = first.substring(0, l - 1);
					String pdffile = expfilename + ".pdf";
					System.out.println("The pdf file is " + pdffile);
					Assert.assertEquals(name, pdffile);
					// WebDriverWait wait = new WebDriverWait(driver, 60);

					a.until(ExpectedConditions.elementToBeClickable(editAlttext));

					Thread.sleep(5000);
					editAlttext.click();

				}
				/*
				 * else { click_Process(); }
				 */

			}
		} catch (NoSuchElementException e) {
			System.out.println("Unable to locate element");
		}

		/*
		 * Thread.sleep(2000); String altfile=alttextfile.getText(); int
		 * length=altfile.length(); System.out.println("The alt text file is  "+
		 * altfile); String[] at=altfile.split("AltText"); String first=at[0]; String
		 * second=at[1]; System.out.println(first); int l=first.length(); String
		 * expfilename=first.substring(0, l-1); String pdffile=expfilename + ".pdf";
		 * System.out.println("The pdf file is "+ pdffile); Assert.assertEquals(name,
		 * pdffile);
		 */
		// WebDriverWait wait = new WebDriverWait(driver, 60);

		// wait.until(ExpectedConditions.elementToBeClickable(editAlttext));

		// Thread.sleep(5000);
		// editAlttext.click();

	}

	public void click_Process() throws InterruptedException {
		String text = "Completed";

		WebDriverWait wait = new WebDriverWait(driver, 60000);

		// wait.until(ExpectedConditions.elementToBeClickable(source));
		wait.until(ExpectedConditions.visibilityOf(source));

		Thread.sleep(10000);

		source.click();
		// sourceplus.click();
		// wait.until(ExpectedConditions.visibilityOf(completedtext));

		wait.until(ExpectedConditions.elementToBeClickable(process));
		Thread.sleep(5000);
		process.click();

		wait.until(ExpectedConditions.elementToBeClickable(viewfilebtn));
		Thread.sleep(2000);
		viewfilebtn.click();
	}

	public void click_QA() throws InterruptedException, AWTException {

		WebDriverWait q = new WebDriverWait(driver, 10000);
		q.until(ExpectedConditions.visibilityOf(qa));
		addprojobj.scrolldown();
		//Thread.sleep(15000);
		qa.click();
		//Thread.sleep(5000);
		Actions action = new Actions(driver);
		q.until(ExpectedConditions.visibilityOf(qa_downloadfile));
		action.moveToElement(qa_downloadfile).perform();
		qa_downloadfile.click();
		//Thread.sleep(5000);
		q.until(ExpectedConditions.visibilityOf(qa_downloadlog));
		action.moveToElement(qa_downloadlog).perform();
		//Thread.sleep(2000);
		
		qa_downloadlog.click();
		// System.out.println("Files downloaded in target/qaoutput");
		// driver.quit();

	}
}
