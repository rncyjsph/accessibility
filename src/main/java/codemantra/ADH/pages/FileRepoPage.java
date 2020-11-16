package codemantra.ADH.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
	AllProjectsPage allprojectsobj1 = new AllProjectsPage();

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

	@FindBy(xpath = "//p[@class='nocap ng-binding']")
	WebElement duplicate;

	@FindBy(xpath = "//div[@id='dupli01']//div[@class='modal-content']")
	WebElement duplicatemodal;

	@FindBy(xpath = "//div[@id='dupli01']//button[@id='delete_task_button001']")
	WebElement dup_cancelbtn;

	@FindBy(xpath = "//div[@class='accordion-header collapsed'][@data-service-id='22']//div[@class='repository-adding-files-symbol row ng-scope']//a//span[@class='delete-svg-plus']")
	WebElement source_filedelete;

	@FindBy(xpath = "//div[@class='modal-header'][@aria-label='Remove folder and files']")
	WebElement delete_message;

	@FindBy(xpath = "//div[@class='col-md-11 col-sm-10 col-xs-9 no-padding']/span[2]/span[1]")
	List<WebElement> files_tobe_deleted;

	@FindBy(xpath = "//button[@id='removeFold_button001']")
	WebElement f_delete;

	@FindBy(xpath = "//div[@class='checkbox checkbox-success']/input[@name='user_checkbox[]']")
	List<WebElement> checkbox;

	@FindBy(xpath = "//div[@class='validation-error']")
	WebElement validationError;

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

	@FindBy(xpath = "//span[@class='company-information-edit pull-right'][contains(text(),'View File')]")
	List<WebElement> multipleviewfile;

	@FindBy(xpath = "//span[@class='company-information-edit pull-right ng-binding'][contains(text(),'In Progress')]")
	List<WebElement> multipleinprogress;

	@FindBy(xpath = "//span[@class='company-information-edit pull-right ng-binding'][contains(text(),'File Error')]")
	List<WebElement> fileerror;

	@FindBy(xpath = "//a[@class='pull-right ng-scope']")
	List<WebElement> filestatus;

	@FindBy(xpath = "//span[@class='accBodyFile']//span[@class='project-folder-name nocap ng-binding']")
	List<WebElement> source_files;

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

	@FindBy(xpath = "//span[@class='company-information-edit pull-right ng-scope']")
	WebElement editAlttext;

	@FindBy(xpath = "//div[@class='accordion-header collapsed'][@data-service-id='25']//span[@class='project-folder-name-date-time fileCount01']")
	WebElement alttext_filecountstatus;
	@FindBy(xpath = "//div[@class='accordion-header collapsed'][@data-service-id='25']//span[@class='project-folder-name-date-time fileCount01']/b")
	WebElement alttextfilecount;

	@FindBy(xpath = "//div[@class='accordion-header collapsed'][@data-service-id='25']//div[@class='repository-adding-files-symbol row ng-scope']//a//span[@class='delete-svg-plus']")
	WebElement alttext_filedelete;

	@FindBy(xpath = "//div[@class='accordion-header collapsed'][@data-service-id='23']//div[@class='repository-adding-files-symbol row ng-scope']//a//span[@class='delete-svg-plus']")
	WebElement process_filedelete;

	@FindBy(xpath = "//div[@class='accordion-header collapsed'][@data-service-id='33']//div[@class='repository-adding-files-symbol row ng-scope']//a//span[@class='delete-svg-plus']")
	WebElement QA_filedelete;

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

	public void fileUpload()
			throws InterruptedException, AWTException, ClassNotFoundException, URISyntaxException, FileNotFoundException

	{
		WebDriverWait wait = new WebDriverWait(driver, 25000);
		wait.until(ExpectedConditions.elementToBeClickable(addfileicon));
		ClipboardOwner owner = null;
		Actions action = new Actions(driver);
		action.moveToElement(addfileicon).perform();
		Thread.sleep(2000);
		addfileicon.click();

		Robot robot = new Robot();
		robot.setAutoDelay(3000);

		// execute using maven
		// Load a file on the classpath as a resource using the ClassLoader.

		/*
		 * URL url = getClass().getClassLoader().getResource("MCCL11204_5.pdf"); File
		 * file = Paths.get(url.toURI()).toFile(); String p = file.getAbsolutePath();
		 * System.out.println(p);
		 */
		File f = new File(prop.getProperty("singlefile"));
		System.out.println(f.exists());
		FileInputStream stream = new FileInputStream(f);
		String pi = f.getName();

		ClassLoader classLoader = getClass().getClassLoader();
		// File file = new File(classLoader.getResource("MCCL11204_5.pdf").getFile());
		File file = new File(classLoader.getResource(pi).getFile());
		String p = file.getAbsolutePath();
		System.out.println(p);

		// To execute using junit
		// File resourcesDirectory = new File("src/test/resources");
		/*
		 * File f = new File("src/test/resources/MCCL11204_5.pdf"); String
		 * p=f.getAbsolutePath(); System.out.println(p);
		 */
		StringSelection stringselection = new StringSelection(p);
		// StringSelection stringselection = new
		// StringSelection(prop.getProperty("filepath1"));
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringselection, owner);
		robot.setAutoDelay(3000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.setAutoDelay(500);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(1000);

		// try {

		// String fileexists=duplicate.getText();

		// if(duplicatemodal.isDisplayed() && !fileexists.isEmpty())
		if (duplicatemodal != null && duplicatemodal.isDisplayed()) {
			duplicatefile_upload();
			allprojectsobj1.logOut();
		}
		// }catch(org.openqa.selenium.NoSuchElementException e)
		// else

		// {
		// source.click();
		// System.out.println("Duplicate file not uploaded");

		// }

	}

	public void duplicatefile_upload()
			throws ClassNotFoundException, InterruptedException, AWTException, URISyntaxException {

		String fileexists = duplicate.getText();
		System.out.println(fileexists);
		String dupactual = "File already exists. Please rename and upload!!";
		Assert.assertEquals(fileexists, dupactual);
		// WebDriverWait d = new WebDriverWait(driver, 2000);
		// d.until(ExpectedConditions.visibilityOf(dup_cancelbtn));
		Thread.sleep(5000);
		dup_cancelbtn.click();

	}

	public void click_Source() throws InterruptedException {
		long start = System.currentTimeMillis();
		// WebDriverWait s = new WebDriverWait(driver, 900);
		// WebDriverWait s = new WebDriverWait(driver, 2000);
		WebDriverWait s = new WebDriverWait(driver, 10000);
		// wait.until(ExpectedConditions.elementToBeClickable(source));
		s.until(ExpectedConditions.visibilityOf(source));
		// Thread.sleep(20000);
		source.click();

		// Thread.sleep(1000);
		try {
			WebDriverWait vi = new WebDriverWait(driver, 1000);

			vi.until(ExpectedConditions.visibilityOf(viewfilebtn));

			// Thread.sleep(5000);
			viewfilebtn.click();
			long finish = System.currentTimeMillis();

			long totalTime = finish - start;
			long time_sec = totalTime / 1000;
			System.out.println("Total Time for view file generation - " + totalTime + " milliseconds ");
			System.out.println("Total Time for view file generation - " + time_sec + " seconds ");
		} catch (org.openqa.selenium.StaleElementReferenceException e) {

		} catch (org.openqa.selenium.TimeoutException e) {

		} catch (org.openqa.selenium.NoSuchElementException e) {

		}

	}

	public void del_source_process_qa() throws InterruptedException {

		String removemssg = delete_message.getText();
		System.out.println(removemssg);
		int filecount = files_tobe_deleted.size();
		System.out.println("Number of files  :" + filecount);

		for (int fc = 0; fc < filecount; fc++) {

			// File f = new File("src/test/resources/MCCL11204_5.pdf");
			File f = new File(prop.getProperty("singlefile"));
			String p = f.getName();
			// System.out.println(p);

			String fullfilename = files_tobe_deleted.get(fc).getText();
			// System.out.println("Filename with upload date" + fullfilename);
			String[] div = fullfilename.split(" ");
			String first = div[0];
			String sec = div[1];
			int lenfirst = first.length();
			String onlyfile = fullfilename.substring(0, lenfirst);
			System.out.println("The required file to be deleted is :" + onlyfile);

			if (onlyfile.equals(p)) {
				WebDriverWait spq = new WebDriverWait(driver, 90);
				spq.until(ExpectedConditions.visibilityOfAllElements(checkbox));
				// String actualdelvalidatemssg = validationError.getText();
				// System.out.println(actualdelvalidatemssg);
				// String expecteddelvalidatemssg = "No Files and folder selected";
				// Assert.assertEquals(expecteddelvalidatemssg, actualdelvalidatemssg);
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkbox.get(fc));
				Thread.sleep(1000);
				try {
					f_delete.click();
				} catch (org.openqa.selenium.ElementNotInteractableException e) {

				}

			}

		}

	}

	public void delfiles() throws InterruptedException {
		try {
			WebDriverWait d = new WebDriverWait(driver, 900);
			d.until(ExpectedConditions.visibilityOf(source_filedelete));
			source_filedelete.click();
			del_source_process_qa();

			Thread.sleep(3000);

			// alt text delete

			d.until(ExpectedConditions.visibilityOf(alttext_filedelete));
			alttext_filedelete.click();

			int alt_filecount = files_tobe_deleted.size();
			System.out.println("Number of files in alt text folder  :" + alt_filecount);
			// for(WebElement f:files_tobe_deleted)
			for (int fc = 0; fc < alt_filecount; fc++) {

				// File f = new File("src/test/resources/Bitcoin_A2.pdf");
				File f = new File(prop.getProperty("singlefile"));
				String p = f.getName();
				// System.out.println(p);

				String fullfilename = files_tobe_deleted.get(fc).getText();
				// System.out.println("Filename with upload date in Alt text folder " +
				// fullfilename);
				String[] at = fullfilename.split("AltText");
				String first = at[0];
				String second = at[1];
				System.out.println(first);
				int l = first.length();
				String expfilename = first.substring(0, l - 1);
				String pdffile = expfilename + ".pdf";
				// System.out.println("The pdf file is " + pdffile);
				Assert.assertEquals(p, pdffile);

				if (pdffile.equals(p)) {

					d.until(ExpectedConditions.visibilityOfAllElements(checkbox));
					WebElement validationError = driver.findElement(By.xpath("//div[@class='validation-error']"));
					// String actualdelvalidatemssg = validationError.getText();
					// System.out.println(actualdelvalidatemssg);
					// String expecteddelvalidatemssg = "No Files and folder selected";
					// Assert.assertEquals(expecteddelvalidatemssg, actualdelvalidatemssg);
					((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkbox.get(fc));
					Thread.sleep(1000);
					try {
						f_delete.click();
					} catch (org.openqa.selenium.ElementNotInteractableException e) {

					}

				}

			}

			Thread.sleep(3000);
			// Process delete

			d.until(ExpectedConditions.visibilityOf(process_filedelete));
			process_filedelete.click();

			del_source_process_qa();

			Thread.sleep(3000);

			// QA Delete
			d.until(ExpectedConditions.visibilityOf(QA_filedelete));
			QA_filedelete.click();

			del_source_process_qa();
			Thread.sleep(5000);

			allprojectsobj1.logOut();

			// driver.quit();
		} catch (NullPointerException e) {
			System.out.println("NullPointerException thrown!");
		}
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

		long altstart = System.currentTimeMillis();
		long prostart = System.currentTimeMillis();
		// WebDriverWait a = new WebDriverWait(driver, 60000);
		// WebDriverWait a = new WebDriverWait(driver, 1000);
		WebDriverWait a = new WebDriverWait(driver, 2000);
		a.until(ExpectedConditions.visibilityOf(process));
		// a.until(ExpectedConditions.elementToBeClickable(process));

		// Thread.sleep(60000);
		// Thread.sleep(20000);

		process.click();
		Thread.sleep(1000);
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();

		long profinish = System.currentTimeMillis();
		long totalTime = profinish - prostart;
		long time_sec = totalTime / 1000;
		System.out.println("Time taken to display Process view file - " + totalTime + " milliseconds ");
		System.out.println("Time taken to display Process view file  - " + time_sec + " seconds ");
		Thread.sleep(5000);
		Path path = Paths.get(prop.getProperty("singlefile"));
		Path filename = path.getFileName();
		String name = filename.toString();
		System.out.println("Filename: " + name);
		try {
			a.until(ExpectedConditions.visibilityOf(viewLog));
			if (!name.isEmpty() && viewLog.isDisplayed())

			{
				long prologfinish = System.currentTimeMillis();
				long logtotalTime = prologfinish - prostart;
				long logtime_sec = logtotalTime / 1000;
				System.out.println("Time taken to display Process view log - " + logtotalTime + " milliseconds ");
				System.out.println("Time taken to display Process view log  - " + logtime_sec + " seconds ");
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
					
					long altfinish = System.currentTimeMillis();
					long alttotalTime = altfinish - altstart;
					long alttime_sec = alttotalTime / 1000;
					System.out.println("Time taken to view Alt text file  - " + alttotalTime + " milliseconds ");
					System.out.println("Time taken to view Alt text file - " + alttime_sec + " seconds ");

					
					Thread.sleep(2000);
					String altfile = alttextfile.getText();
					int length = altfile.length();
					System.out.println("The alt text file is  " + altfile);
					String[] at = altfile.split("AltText");
					String first = at[0];
					String second = at[1];
					// System.out.println(first);
					int l = first.length();
					String expfilename = first.substring(0, l - 1);
					String pdffile = expfilename + ".pdf";
					System.out.println("The pdf file is " + pdffile);
					Assert.assertEquals(name, pdffile);
					// WebDriverWait wait = new WebDriverWait(driver, 60);
					

					a.until(ExpectedConditions.elementToBeClickable(editAlttext));

					// Thread.sleep(5000);
					Thread.sleep(2000);
					editAlttext.click();
					
				}
				/*
				 * else { click_Process(); }
				 */

			}
		} catch (org.openqa.selenium.NoSuchElementException e) {

		} catch (org.openqa.selenium.TimeoutException e) {

		} catch (org.openqa.selenium.StaleElementReferenceException e) {

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

		WebDriverWait q = new WebDriverWait(driver, 60000);
		q.until(ExpectedConditions.visibilityOf(qa));
		long start = System.currentTimeMillis();
		// driver.navigate().refresh();
		//addprojobj.scrolldown();

		// q.until(ExpectedConditions.elementToBeClickable(qa));

		//

		//

		Thread.sleep(15000);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", qa);
		Thread.sleep(5000);
		addprojobj.scrolldown();
		// Thread.sleep(5000);
		
		try {
			q.until(ExpectedConditions.visibilityOf(qa_downloadfile));
			Actions action = new Actions(driver);
			action.moveToElement(qa_downloadfile).perform();
			qa_downloadfile.click();
			// Thread.sleep(5000);
			q.until(ExpectedConditions.visibilityOf(qa_downloadlog));
			action.moveToElement(qa_downloadlog).perform();
			// Thread.sleep(2000);

			qa_downloadlog.click();
			long finish = System.currentTimeMillis();

			long totalTime = finish - start;
			long time_sec = totalTime / 1000;
			System.out.println("Total Time to download pdf and log file - " + totalTime + " milliseconds ");
			System.out.println("Total Time to download pdf and log file - " + time_sec + " seconds ");
		} catch (org.openqa.selenium.StaleElementReferenceException e) {

		}
		Thread.sleep(1000);
		driver.navigate().refresh();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PageLoadTimeOut, TimeUnit.SECONDS);

		
		Thread.sleep(1000);

	}

	public void multiplefileUpload()
			throws InterruptedException, AWTException, ClassNotFoundException, URISyntaxException, FileNotFoundException

	{
		WebDriverWait wait = new WebDriverWait(driver, 25000);
		wait.until(ExpectedConditions.elementToBeClickable(addfileicon));
		ClipboardOwner owner = null;
		Actions action = new Actions(driver);
		action.moveToElement(addfileicon).perform();
		Thread.sleep(2000);
		addfileicon.click();
		long start = System.currentTimeMillis();

		Robot robot = new Robot();
		robot.setAutoDelay(3000);

		// execute using maven

		/*
		 * URL url = getClass().getClassLoader().getResource("MCCL11204_5.pdf");
		 * 
		 * File file = Paths.get(url.toURI()).toFile(); String j=file.toString();
		 * System.out.println(j);
		 * 
		 * String p = file.getAbsolutePath(); System.out.println(p);
		 */

		File f1 = new File(prop.getProperty("filepath1"));
		File f2 = new File(prop.getProperty("filepath2"));
		File f3 = new File(prop.getProperty("filepath3"));
		File f4 = new File(prop.getProperty("filepath4"));
		File f5 = new File(prop.getProperty("filepath5"));
		File f6 = new File(prop.getProperty("filepath6"));
		File f7 = new File(prop.getProperty("filepath7"));
		File f8 = new File(prop.getProperty("filepath8"));
		File f9 = new File(prop.getProperty("filepath9"));
		File f10 = new File(prop.getProperty("filepath10"));

		// System.out.println(f1.getAbsolutePath());
		String p1 = f1.getName();
		String p2 = f2.getName();
		String p3 = f3.getName();
		String p4 = f4.getName();
		String p5 = f5.getName();
		String p6 = f6.getName();
		String p7 = f7.getName();
		String p8 = f8.getName();
		String p9 = f9.getName();
		String p10 = f10.getName();

		ClassLoader classLoader = getClass().getClassLoader();

		// File file1 = new File(classLoader.getResource(pi).getFile());
		// File file2 = new File(classLoader.getResource(pj).getFile());
		// File file3 = new File(classLoader.getResource(pn).getFile());
		// String p=file1.getName();

		// String p = file1.getAbsolutePath() + " " + file2.getAbsolutePath();
		// String p = "\" "+file1.getAbsolutePath() +"\" " + "\" " +
		// file2.getAbsolutePath()+ "\" ";
		// String p = "\""+file1.getAbsolutePath() +"\"" + "\""
		// +file2.getAbsolutePath()+"\"" + file3.getAbsolutePath()+"\"";

		/*
		 * String p="\"" + p1 + "\"" + "\"" + p2 + "\"" + "\"" + p3 + "\"" + "\"" + p4 +
		 * "\"" + "\"" + p5 + "\"";
		 */

		//String p = "\"" + p1 + "\"" + "\"" + p2 + "\"";

		
		  String p = "\"" + p1 + "\"" + "\"" + p2 + "\"" + "\"" + p3 + "\"" + "\"" + p4
		  + "\"" + "\"" + p5 + "\"" + "\"" + p6 + "\"" + "\"" + p7 + "\"" + "\"" + p8 +
		  "\"" + "\"" + p9 + "\"" + "\"" + p10 + "\"";
		 

		// String newname= "\" " + p +" \"";

		// String p =
		// "\"C:\\Users\\codemantra\\gitnew\\accessibility-qa-script\\target\\test-classes\\Bitcoin_A2.pdf\""
		// + " " +
		// "\"C:\\Users\\codemantra\\gitnew\\accessibility-qa-script\\target\\test-classes\\MCCL11204_5.pdf\"";

		String newname = "\"C:\\Users\\codemantra\\gitnew\\accessibility-qa-script\\src\\test\\resources\\input\\*.pdf\"";

		// String p = file1.getAbsolutePath()+ "\n" + file2.getAbsolutePath();

		// Create instance of Clipboard class

		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

		StringSelection stringselection = new StringSelection(newname);
		// Copy the String to Clipboard

		clipboard.setContents(stringselection, null);

		// Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringselection,owner);

		// Use Robot class instance to simulate CTRL+C and CTRL+V key events :
		robot.setAutoDelay(3000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.setAutoDelay(1000);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(1000);

		StringSelection stringselection1 = new StringSelection(p);
		// Copy the String to Clipboard

		clipboard.setContents(stringselection1, null);

		robot.setAutoDelay(3000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.setAutoDelay(1000);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(5000);

		if (duplicatemodal != null && duplicatemodal.isDisplayed()) {
			multiple_duplicatefile_upload();
			Thread.sleep(3000);
			allprojectsobj1.logOut();
		}

		else {
			try {
				WebDriverWait m = new WebDriverWait(driver, 10000);
				m.until(ExpectedConditions.visibilityOf(source));
				source.click();

				try {
					m.until(ExpectedConditions.visibilityOfAllElements(source_files));

				} catch (org.openqa.selenium.StaleElementReferenceException vi) {

				}

				Thread.sleep(2000);
				int sourcelist = source_files.size();
				System.out.println("Number of files in source folder :" + sourcelist);
				try {
					for (int i = 0; i < sourcelist; i++) {
						System.out.println("Files in Source Folder :" + source_files.get(i).getText());

					}
				} catch (org.openqa.selenium.StaleElementReferenceException vs) {

				}
				while (true) {
					WebDriverWait wait1 = new WebDriverWait(driver, 5000);
					try {
						wait1.until(ExpectedConditions.visibilityOfAllElements(multipleviewfile));
					} catch (org.openqa.selenium.StaleElementReferenceException e) {

					}

					if (multipleviewfile.size() == sourcelist) {
						long finish = System.currentTimeMillis();
						long totalTime = finish - start;
						long time_sec = totalTime / 1000;
						System.out.println("Total Time taken for visibility of multiple view files  - " + totalTime
								+ " milliseconds ");
						System.out.println(
								"Total Time taken for visibility of multiple view files - " + time_sec + " seconds ");
						System.out.println("View Files for all uploaded files are generated ");
						break;
					}
				
						
					}
				
				try {
					for (WebElement element : filestatus) {
						
						if (element.getText() == "File Error") {
							System.out.println("File Error is displayed");
							//break;

						}
						
					}
					int displayedviewfilecount=multipleviewfile.size();
					System.out.println("Number of view file generated from " + sourcelist + " files are : " +displayedviewfilecount);


				} catch (org.openqa.selenium.StaleElementReferenceException e) {

				}
				
				
				
				

				/*
				 * WebDriverWait wait1 = new WebDriverWait(driver, 5000); try {
				 * wait1.until(ExpectedConditions.visibilityOfAllElements(multipleviewfile)); }
				 * catch (org.openqa.selenium.StaleElementReferenceException e) {
				 * 
				 * }
				 */

				// WebDriverWait wait1 = new WebDriverWait(driver, 5000);
				// wait1.until(ExpectedConditions.invisibilityOfAllElements(filestatus));
				// try {

				/*
				 * for (int f = 0; f < sourcelist; f++) {
				 * 
				 * try { if (filestatus.get(f).getText().contains("File Error")) {
				 * System.out.println("File error is displayed. System is not stable");
				 * 
				 * }
				 * 
				 * } catch (org.openqa.selenium.StaleElementReferenceException o) {
				 * 
				 * } catch (java.lang.IndexOutOfBoundsException o) { break; } }
				 * 
				 */

				// WebDriverWait wait2 = new WebDriverWait(driver, 1000);
				// wait2.until(ExpectedConditions.visibilityOfAllElements(multipleviewfile));
				Thread.sleep(3000);

				driver.navigate().refresh();

				driver.manage().timeouts().pageLoadTimeout(TestUtil.PageLoadTimeOut, TimeUnit.SECONDS);
				WebDriverWait de = new WebDriverWait(driver, 10000);
				de.until(ExpectedConditions.elementToBeClickable(source_filedelete));
				// Thread.sleep(10000);

				Thread.sleep(1000);
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", source_filedelete);
				// source_filedelete.click();

				Thread.sleep(1000);
				String removemssg = delete_message.getText();
				System.out.println(removemssg);

				// int filecount = files_tobe_deleted.size();
				// System.out.println("Number of files :" + filecount);

				WebDriverWait spq = new WebDriverWait(driver, 90);
				spq.until(ExpectedConditions.visibilityOfAllElements(checkbox));
				int chsize = checkbox.size();

				for (int ch = 0; ch < chsize; ch++) {
					((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkbox.get(ch));
					Thread.sleep(1000);

				}
				Thread.sleep(2000);
				f_delete.click();
				Thread.sleep(1000);
				allprojectsobj1.logOut();

			} catch (NullPointerException e) {

			}

		}

	}

	public void multiple_duplicatefile_upload()
			throws ClassNotFoundException, InterruptedException, AWTException, URISyntaxException {

		String fileexists = duplicate.getText();
		System.out.println(fileexists);
		String dupactual = "File already exists. Please rename and upload!!";
		Assert.assertEquals(fileexists, dupactual);
		// WebDriverWait d = new WebDriverWait(driver, 2000);
		// d.until(ExpectedConditions.visibilityOf(dup_cancelbtn));
		Thread.sleep(4000);
		dup_cancelbtn.click();
		Thread.sleep(4000);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", source_filedelete);
		WebDriverWait spq = new WebDriverWait(driver, 90);
		spq.until(ExpectedConditions.visibilityOfAllElements(checkbox));
		int chsize = checkbox.size();

		for (int ch = 0; ch < chsize; ch++) {
			Thread.sleep(1000);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkbox.get(ch));

		}
		Thread.sleep(2000);
		f_delete.click();

	}

}
