package codemantra.ADH.stepDefintion;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import codemantra.ADH.TestBase.BaseClass;
import codemantra.ADH.pages.AddProjectPage;
import codemantra.ADH.pages.AllProjectsPage;
import codemantra.ADH.pages.FileRepoPage;
import codemantra.ADH.pages.LoginPage;
import codemantra.ADH.pages.ProcessElementViewerPage;
import codemantra.ADH.pages.SourceImageViewerPage;
import codemantra.ADH.util.TestUtil;
import codemantra.ADH.util.Zoom;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class FileRepoSteps extends BaseClass {

	LoginPage loginobj;
	AllProjectsPage allprojectsobj = new AllProjectsPage();
	AddProjectPage addprojobj = new AddProjectPage();
	FileRepoPage filerepoobj = new FileRepoPage();

	ClipboardOwner owner = null;

	@Given("^User is on login page$")
	public void user_is_on_login_page() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		BaseClass.initialization();
	}

	@And("^user verifies Login page title$")
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
		// driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.CONTROL).sendKeys(Keys.HOME).build().perform();

		String projectsText = allprojectsobj.projectsPageDisplayText();
		String projectexpectedText = "All Projects";
		Assert.assertEquals(projectexpectedText, projectsText);
		System.out.println(projectsText);

	}

	// Create Project
	@When("^user selects Add Project$")
	public void user_selects_Add_Project() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		addprojobj = allprojectsobj.clickAddProject();
	}

	@Then("^navigate to Add Project page$")
	public void navigate_to_Add_Project_page() throws Throwable {
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.CONTROL).sendKeys(Keys.HOME).build().perform();
		String expectedaddprojtext = addprojobj.displayAddProjectText();
		String Actualtext = "Add Project";
		Assert.assertEquals(expectedaddprojtext, Actualtext);
		System.out.println(expectedaddprojtext);

	}

	@Then("^user enters \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_enters_and_and_and_and_and_and(String project, String assets, String instruction, String pages,
			String customer_ID, String division, String department) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		addprojobj.inputProjectDetails(project, assets, instruction, pages, customer_ID, division, department);
	}

	/*
	 * @And("^user click on Save and Continue button$") public void
	 * user_click_on_Save_and_Continue_button() throws Throwable {
	 * 
	 * addprojobj.saveAndContinue();
	 * 
	 * 
	 * }
	 */

	@Then("^File Repository page is displayed with \"([^\"]*)\"$")
	public void file_Repository_page_is_displayed_with(String project) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		addprojobj.saveAndContinue();
		/*
		 * Thread.sleep(5000); String actualreponame = filerepoobj.displayfileRepo();
		 * String expectedfilerepo = "File Repository";
		 * Assert.assertEquals(expectedfilerepo, actualreponame);
		 * System.out.println(actualreponame); // Check project name is correct String
		 * String actualfile = filerepoobj.displayProjectName();
		 * Assert.assertEquals(project, actualfile); System.out.println(actualfile);
		 */
	}
	// edit

	@Then("^user edits the details of project with pages and department and division and ID and inst$")
	public void user_edits_the_details_of_project_with_pages_and_department_and_division_and_ID_and_inst()
			throws Throwable {
		filerepoobj.editProjInfo(prop.getProperty("pages"), prop.getProperty("department"),
				prop.getProperty("division"), prop.getProperty("ID"), prop.getProperty("inst"));

	}

	@Then("^user click cancel to cancel the updates$")
	public void user_click_cancel_to_cancel_the_updates() throws Throwable {

		filerepoobj.cancelEditProjInfo();
	}

	/*
	 * @When("^user clicks on Add Files icon$") public void
	 * user_clicks_on_Add_Files_icon() throws Throwable { Thread.sleep(5000);
	 * filerepoobj.addFiles(); }
	 */

	/*
	 * @When("^enters the file path onto the file-selection input field$") public
	 * void enters_the_file_path_onto_the_file_selection_input_field() throws
	 * Throwable { Robot robot = new Robot(); robot.setAutoDelay(2000);
	 * 
	 * StringSelection stringselection = new
	 * StringSelection(prop.getProperty("filepath1"));
	 * Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringselection,
	 * owner); robot.setAutoDelay(2000); robot.keyPress(KeyEvent.VK_CONTROL);
	 * robot.keyPress(KeyEvent.VK_V); robot.keyRelease(KeyEvent.VK_CONTROL);
	 * robot.keyRelease(KeyEvent.VK_V); robot.setAutoDelay(2000);
	 * robot.keyPress(KeyEvent.VK_ENTER); robot.keyRelease(KeyEvent.VK_ENTER); }
	 */

	// Search project
	@When("^user search for required \"([^\"]*)\"$")
	public void user_search_for_required(String project) throws Throwable {

		filerepoobj = allprojectsobj.search(project);
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PageLoadTimeOut, TimeUnit.SECONDS);
		Thread.sleep(3000);

	}

	@Then("^user upload file$")
	public void user_upload_file() throws Throwable {

		// Thread.sleep(1000);

		filerepoobj.fileUpload();
	}

	@Then("^user validates and downloads the generated view file and log file$")
	public void user_validates_and_downloads_the_generated_view_file_and_log_file() throws Throwable {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 60000);
			Actions action = new Actions(driver);
			PDDocument pd;
			pd = PDDocument.load(new File(prop.getProperty("singlefile")));
			int pgcount = pd.getNumberOfPages();
			System.out.println("Number of pages " + pgcount);
			try {
				String parentWindow = driver.getWindowHandle();

				String parentCurrentlink = driver.getCurrentUrl();

				System.out.println(parentCurrentlink);
				// System.out.println("Parent window handle: " + parentWindow);

				filerepoobj.click_Source();

				Set<String> winhandles = driver.getWindowHandles();

				for (String handle : winhandles) {
					if (!handle.equals(parentWindow)) {
						driver.switchTo().window(handle);
						Thread.sleep(1000);
						// driver.manage().timeouts().pageLoadTimeout(TestUtil.PageLoadTimeOut,
						// TimeUnit.SECONDS);

						String s_viewlink = driver.getCurrentUrl();
						System.out.println("Source folder image viewer URL :" + s_viewlink);
						long start = System.currentTimeMillis();
						Thread.sleep(5000);
						// Zoom.std();

						// SourceImageViewerPage si = new SourceImageViewerPage();
						// Thread.sleep(5000);

						// si.clickinspect();
						// Thread.sleep(8000);
						int m = 1;
						// for (int m = 1; m <= pgcount; m++) {

						 while (m <= pgcount) {
						//while (true) {
							WebElement source_next = driver.findElement(By.xpath("//button[@id='nxt']"));
							WebDriverWait s = new WebDriverWait(driver, 25000);
							// WebElement source_next =
							// s.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='nxt']")));
							// Thread.sleep(5000);
							// Thread.sleep(1000);
							s.until(ExpectedConditions.visibilityOf(source_next));
							action.moveToElement(source_next).perform();

							// Thread.sleep(10000);
							Thread.sleep(15000);
							// if (source_next.isEnabled()) {

							((JavascriptExecutor) driver).executeScript("arguments[0].click();", source_next);
							Thread.sleep(1000);

							WebElement modalcontent = driver.findElement(By.xpath("//div[@class='modal-content']"));

							WebElement ignore_yes = driver.findElement(By.xpath("//button[@id='modal-btn-si']"));

							if ((modalcontent != null) && (modalcontent.isDisplayed()))

							{

								// action.moveToElement(ignore_yes).perform();
								// Thread.sleep(500);
								((JavascriptExecutor) driver).executeScript("arguments[0].click();", ignore_yes);
							}
							driver.manage().timeouts().pageLoadTimeout(TestUtil.PageLoadTimeOut, TimeUnit.SECONDS);
							// for loop}

							
							m = m + 1;

							// }

							if (m == pgcount) {
								
								Thread.sleep(2000);
								WebElement savebtn = driver.findElement(By.xpath("//button[@id='savebtn']"));

								wait.until(ExpectedConditions.elementToBeClickable(savebtn));
								action.moveToElement(savebtn).perform();
								Thread.sleep(5000);
								((JavascriptExecutor) driver).executeScript("arguments[0].click();", savebtn);

								driver.manage().timeouts().pageLoadTimeout(TestUtil.PageLoadTimeOut, TimeUnit.SECONDS);
								break;
							}
						}
						Thread.sleep(5000);

						WebElement approvebtn = driver
								.findElement(By.xpath("//button[@id='aprvbtn'][contains(text(),'Approve')]"));

						wait.until(ExpectedConditions.elementToBeClickable(approvebtn));
						action.moveToElement(approvebtn).perform();
						Thread.sleep(2000);
						((JavascriptExecutor) driver).executeScript("arguments[0].click();", approvebtn);
						Thread.sleep(2000);
						WebElement modalcontent = driver.findElement(By.xpath("//div[@class='modal-content']"));
						WebElement yes = driver.findElement(By.xpath("//button[@id='modal-btn-si']"));
						if ((modalcontent != null) && (modalcontent.isDisplayed()))

						{

							// action.moveToElement(yes).perform();
							((JavascriptExecutor) driver).executeScript("arguments[0].click();", yes);

							// yes.click();

						}

						WebElement approveconfirm = driver.findElement(By.xpath("//button[@id='Confirmx']"));
						Thread.sleep(5000);
						((JavascriptExecutor) driver).executeScript("arguments[0].click();", approveconfirm);

						Thread.sleep(5000);

						WebElement ok = wait.until(ExpectedConditions
								.visibilityOfElementLocated(By.xpath("//button[@id='modal-btn-sia']")));
						((JavascriptExecutor) driver).executeScript("arguments[0].click();", ok);

						long finish = System.currentTimeMillis();
						long totalTime = finish - start;
						long time_sec = totalTime / 1000;
						System.out.println("Total Time taken to approve in Source folder - " + totalTime + " milliseconds ");
						System.out.println("Total Time taken to approve in Source folder - " + time_sec + " seconds ");

						Thread.sleep(3000);

						driver.close();

					}
				}

				driver.switchTo().window(parentWindow);

				// driver.navigate().refresh();
				// driver.manage().timeouts().pageLoadTimeout(TestUtil.PageLoadTimeOut,
				// TimeUnit.SECONDS);
				Thread.sleep(5000);

				// Alttext

				filerepoobj.click_Alttext();

				Set<String> alttextwinhandles = driver.getWindowHandles();

				for (String alttexthandle : alttextwinhandles) { // Actions action = new Actions(driver);

					if (!alttexthandle.equals(parentWindow)) {
						driver.switchTo().window(alttexthandle);
						driver.manage().timeouts().pageLoadTimeout(TestUtil.PageLoadTimeOut, TimeUnit.SECONDS);

						Thread.sleep(5000);
						String a_viewlink = driver.getCurrentUrl();
						System.out.println("Alt text folder URL :" + a_viewlink);
						long start = System.currentTimeMillis();
						// Zoom.std();

						WebElement alttext = wait.until(
								ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@id='gotoAltTxt']")));
						Thread.sleep(2000);
						action.moveToElement(alttext).perform();
						addprojobj.scrolldown();

						Thread.sleep(1000);
						// WebElement fwd = driver.findElement(By.xpath("//button[@id='nxtclkimg']"));
						WebElement img = driver.findElement(By.xpath("//span[@id='imgName']"));
						String imagetxt = img.getText();
						// System.out.println("The displayed image's name : " + imagetxt);

						int imglen = imagetxt.length();

						String[] at = imagetxt.split("/");
						String part1 = at[0];
						String part2 = at[1];
						// System.out.println("first part is " +part1);
						// System.out.println("second part is " +part2);
						int part2len = part2.length();
						// System.out.println(part2len);
						String reqc = part2.substring(0, part2len - 1);
						System.out.println("Image count is " + reqc);
						int reqcount = Integer.parseInt(reqc);

						WebElement fwd = driver.findElement(By.xpath("//button[@class='next']"));

						WebElement prev = driver.findElement(By.xpath("//button[@class='previous']"));
						WebElement alttextbox = driver.findElement(By.xpath("//textarea[@id='taLong02']"));

						for (int count = 1; count <= reqcount; count++) {

							// WebElement im=driver.findElement(By.xpath("//*[@id='imgHead']/img"));
							// wait.until(ExpectedConditions.visibilityOf(im));

							// WebElement alttextbox =
							// driver.findElement(By.xpath("//textarea[@id='taLong02']"));

							// alttextbox.sendKeys(" ");

							// String ta =
							// driver.findElement(By.xpath("//textarea[@id='taLong02']")).getAttribute("value");
							// WebElement alttextbox =
							// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@id='taLong02']")));
							// WebElement alttextbox =
							// driver.findElement(By.xpath("//textarea[@id='taLong02']"));
							Thread.sleep(3000);

							String ta = alttextbox.getAttribute("value");

							if (ta.isEmpty()) {
								alttextbox.sendKeys(" ");
								alttextbox.click();
								alttextbox.clear();
								alttextbox.sendKeys("dummy text");

								System.out.println("Alt Text manually entered");

							}

							else if (!ta.isEmpty()) {

								System.out.println("Automatically regenerated text :" + ta);

							}

							// driver.manage().timeouts().pageLoadTimeout(TestUtil.PageLoadTimeOut,TimeUnit.SECONDS);
							// Thread.sleep(5000);
							WebDriverWait al = new WebDriverWait(driver, 1000);
							al.until(ExpectedConditions.elementToBeClickable(fwd));

							Thread.sleep(3000);
							((JavascriptExecutor) driver).executeScript("arguments[0].click();", fwd);

							driver.manage().timeouts().pageLoadTimeout(TestUtil.PageLoadTimeOut, TimeUnit.SECONDS);

							Thread.sleep(1000);

							if ((count == reqcount) && (prev.isEnabled())) {

								// Thread.sleep(2000);
								((JavascriptExecutor) driver).executeScript("arguments[0].click();", prev);
								driver.manage().timeouts().pageLoadTimeout(TestUtil.PageLoadTimeOut, TimeUnit.SECONDS);

								System.out.println("previous button is clicked to save the last page");

							}

						}

						// temporarly save not working
						/*
						 * WebElement alttxtsavebtn =
						 * driver.findElement(By.xpath("//button[@id='saveAltbut']"));
						 * action.moveToElement(alttxtsavebtn).perform(); alttxtsavebtn.click();
						 */
						Thread.sleep(2000);
						WebElement missingalttext = driver.findElement(By.xpath("//li[@id='gotoMissingAltTxt']"));
						action.moveToElement(missingalttext).perform();
						Thread.sleep(1000);
						missingalttext.click();

						List<WebElement> missingimg = driver
								.findElements(By.xpath("//div[@id='MissingAlt']//div[@class='ng-scope']"));
						int missingcount = missingimg.size();
						if (!missingimg.isEmpty()) {
							for (int i = 0; i < missingcount; i++) {
								try {
									missingimg.get(i).click();
									Thread.sleep(1000);
									addprojobj.scrolldown();
									alttextbox.sendKeys(" ");
									alttextbox.click();
									alttextbox.clear();
									alttextbox.sendKeys("Missing alt text entered");

									WebDriverWait al = new WebDriverWait(driver, 1000);
									al.until(ExpectedConditions.elementToBeClickable(fwd));

									Thread.sleep(3000);
									((JavascriptExecutor) driver).executeScript("arguments[0].click();", fwd);

									driver.manage().timeouts().pageLoadTimeout(TestUtil.PageLoadTimeOut,
											TimeUnit.SECONDS);

									Thread.sleep(1000);

									if ((i == missingcount) && (prev.isEnabled())) {

										// Thread.sleep(2000);
										((JavascriptExecutor) driver).executeScript("arguments[0].click();", prev);
										driver.manage().timeouts().pageLoadTimeout(TestUtil.PageLoadTimeOut,
												TimeUnit.SECONDS);

									}

								}

								catch (org.openqa.selenium.ElementNotInteractableException e) {
									
								}
							}
						}

						Thread.sleep(2000);

						WebElement preview = driver.findElement(By.xpath("//li[@id='gotoPreviewAltTxt']"));
						action.moveToElement(preview).perform();
						Thread.sleep(1000);
						preview.click();

						WebElement approveallbtn = wait.until(
								ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='aprvallbtn']")));
						Thread.sleep(1000);
						approveallbtn.click();

						WebElement completebtn = driver.findElement(By.xpath("//li[@id='completeAltTxt']"));
						action.moveToElement(completebtn).perform();
						Thread.sleep(2000);
						completebtn.click();
						driver.manage().timeouts().pageLoadTimeout(900, TimeUnit.SECONDS);

						long finish = System.currentTimeMillis();
						long totalTime = finish - start;
						long time_sec = totalTime / 1000;
						System.out
								.println("Total Time to approve in Alt text folder - " + totalTime + " milliseconds ");
						System.out.println("Total Time to approve in Alt text folder - " + time_sec + " seconds ");
						Thread.sleep(2000);
						driver.close();

					}
				}
				driver.switchTo().window(parentWindow);
				driver.navigate().refresh();

				driver.manage().timeouts().pageLoadTimeout(900, TimeUnit.SECONDS);
				Thread.sleep(10000);

				filerepoobj.click_Process();

				// Actions action = new Actions(driver);

				Set<String> procwinhandles = driver.getWindowHandles();

				for (String handle : procwinhandles) {

					if (!handle.equals(parentWindow)) {

						driver.switchTo().window(handle);
						Thread.sleep(1000);
						String p_viewlink = driver.getCurrentUrl();
						System.out.println("Process folder element viewer URL :" + p_viewlink);
						long start = System.currentTimeMillis();
						Zoom.std();
						ProcessElementViewerPage ob = new ProcessElementViewerPage();
						Thread.sleep(5000);

						for (int c = 1; c <= pgcount; c++) {
							// Thread.sleep(1000);
							WebDriverWait p = new WebDriverWait(driver, 5000);
							WebElement process_next = p.until(
									ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='nxt']")));

							// action.moveToElement(process_next).perform();

							Thread.sleep(5000);

							((JavascriptExecutor) driver).executeScript("arguments[0].click();", process_next);

							Thread.sleep(1000);

							WebElement modalcontent = driver.findElement(By.xpath("//div[@class='modal-content']"));

							WebElement ignore_yes = driver.findElement(By.xpath("//button[@id='modal-btn-si']"));

							if ((modalcontent != null) && (modalcontent.isDisplayed()))

							{

								// action.moveToElement(ignore_yes).perform();
								// Thread.sleep(1000);
								((JavascriptExecutor) driver).executeScript("arguments[0].click();", ignore_yes);

							}
							driver.manage().timeouts().pageLoadTimeout(TestUtil.PageLoadTimeOut, TimeUnit.SECONDS);
						}
						// if (po <= pgcount) {
						Thread.sleep(2000);
						WebElement savebtn = driver.findElement(By.xpath("//button[@id='savebtn']"));

						wait.until(ExpectedConditions.elementToBeClickable(savebtn));
						// action.moveToElement(savebtn).build().perform();
						Thread.sleep(5000);
						((JavascriptExecutor) driver).executeScript("arguments[0].click();", savebtn);

						driver.manage().timeouts().pageLoadTimeout(TestUtil.PageLoadTimeOut, TimeUnit.SECONDS);

						// }
						// }

						// Metadata
						Thread.sleep(5000);
						WebElement metabtn = wait
								.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='metaBut']")));
						action.moveToElement(metabtn).perform();
						// Thread.sleep(5000);
						((JavascriptExecutor) driver).executeScript("arguments[0].click();", metabtn);
						WebElement title = driver.findElement(By.xpath("//input[@id='field_text_244']"));
						Thread.sleep(3000);
						// if (title.getText().isEmpty())
						String textinsidetitle = title.getAttribute("value");
						if (textinsidetitle.isEmpty()) {
							title.sendKeys(" ");
							title.sendKeys(prop.getProperty("metatitle"));
							Thread.sleep(5000);
							WebElement savemeta = driver.findElement(By.xpath("//button[@id='saveMeta']"));
							((JavascriptExecutor) driver).executeScript("arguments[0].click();", savemeta);
							Thread.sleep(3000);
							WebElement metaclose = driver.findElement(By.xpath("//div[@id='closeMeta']"));
							((JavascriptExecutor) driver).executeScript("arguments[0].click();", metaclose);

						} else { // System.out.println(title.getText());
							String text = title.getAttribute("value");
							System.out.println("Existing Mandatory value in metadata is :" + text);
							WebElement metaclose = driver.findElement(By.xpath("//div[@id='closeMeta']"));
							Thread.sleep(1000);
							((JavascriptExecutor) driver).executeScript("arguments[0].click();", metaclose);
						}

						// Bookmarks button
						WebElement bkbtn = driver.findElement(By.xpath("//button[@id='bmarkbtn']"));

						action.moveToElement(bkbtn).build().perform();

						wait.until(ExpectedConditions.elementToBeClickable(bkbtn));
						Thread.sleep(2000);
						((JavascriptExecutor) driver).executeScript("arguments[0].click();", bkbtn);
						// bkbtn.click();
						Thread.sleep(2000);

						WebElement bookmark = driver
								.findElement(By.xpath("//div[@class='container2']//div[@class='form-group']"));
						wait.until(ExpectedConditions.visibilityOf(bookmark));

						// action.dragAndDropBy(bookmark, 15, 120).build().perform();

						Thread.sleep(2000);

						List<WebElement> txt = driver.findElements(By.xpath("//div[@class='ro']//input"));
						if (!txt.isEmpty())
						{
						int numebroftxtbox = txt.size();
						System.out.println("Number of bookmarks present :" + numebroftxtbox);
						for (int k = 0; k < numebroftxtbox; k++) {
							String textboxvalue = txt.get(k).getAttribute("value");
							System.out.println(textboxvalue);
							if (!textboxvalue.isEmpty())

							{
								Assert.assertTrue(true);
							}
							else
							{
								txt.get(k).sendKeys("Bookmark content entered by the user");
								
							}

						}
						}

						Thread.sleep(2000);
						WebElement savebookmark = driver.findElement(By.xpath("//button[@id='saveBM']"));
						// action.moveToElement(savebookmark).perform();
						wait.until(ExpectedConditions.visibilityOf(savebookmark));
						((JavascriptExecutor) driver).executeScript("arguments[0].click();", savebookmark);

						Thread.sleep(1000);
						WebElement bookmarkclose = driver.findElement(By.xpath("//div[@id='closeBM']"));
						((JavascriptExecutor) driver).executeScript("arguments[0].click();", bookmarkclose);

						// click on inspect
						WebElement inspect = driver.findElement(By.xpath("//button[@id='insMenu']"));
						action.moveToElement(inspect).build().perform();
						Thread.sleep(2000);
						((JavascriptExecutor) driver).executeScript("arguments[0].click();", inspect);
						try {
							List<WebElement> l = driver.findElements(By.xpath("//div[@class='elementx']"));
							wait.until(ExpectedConditions.visibilityOfAllElements(l));
							int no_of_elements = l.size();
							System.out.println("Number of elements found on current page is  " + no_of_elements);
							for (int e = 0; e < no_of_elements; e++) {
								String element = l.get(e).getText();
								if (element.equalsIgnoreCase("Figure")) {
									WebElement figure = driver.findElement(
											By.xpath("//div[@class='elementx'][contains(text(),'Figure')]"));
									((JavascriptExecutor) driver).executeScript("arguments[0].click();", figure);

									String tagname = driver.findElement(By.xpath("//div[@class='insLt']/b")).getText();
									System.out.println("The element predicted is with tagname :" + tagname);

									String expected_ce = "NO PERMISSION";
									WebElement actualCE = driver.findElement(By.xpath("//div[@class='insLt']//span"));
									String actual_ce = actualCE.getText();
									Assert.assertEquals(expected_ce, actual_ce);
									Thread.sleep(2000);
								} else if (element.equalsIgnoreCase("Table")) {
									WebElement table = driver.findElement(
											By.xpath("//div[@class='elementx'][contains(text(),'table')]"));

									((JavascriptExecutor) driver).executeScript("arguments[0].click();", table);
									String tagname = driver.findElement(By.xpath("//div[@class='insLt']/b")).getText();
									System.out.println("The element predicted is with tagname :" + tagname);

									String expected_ce = "NO PERMISSION";
									WebElement actualCE = driver.findElement(By.xpath("//div[@class='insLt']//span"));
									String actual_ce = actualCE.getText();
									Assert.assertEquals(expected_ce, actual_ce);
									Thread.sleep(2000);

								}

								else if (element.equalsIgnoreCase("Formula")) {
									WebElement formula = driver.findElement(
											By.xpath("//div[@class='elementx'][contains(text(),'Formula')]"));
									((JavascriptExecutor) driver).executeScript("arguments[0].click();", formula);
									String tagname = driver.findElement(By.xpath("//div[@class='insLt']/b")).getText();
									System.out.println("The element predicted is with tagname :" + tagname);

									String expected_ce = "NO PERMISSION";
									WebElement actualCE = driver.findElement(By.xpath("//div[@class='insLt']//span"));
									String actual_ce = actualCE.getText();
									Assert.assertEquals(expected_ce, actual_ce);
									Thread.sleep(2000);

								} else {

									((JavascriptExecutor) driver).executeScript("arguments[0].click();", l.get(e));
									Thread.sleep(2000);
									String tagname = driver.findElement(By.xpath("//div[@class='insLt']/b")).getText();
									System.out.println("The predicted element with tagname :" + tagname);
								}

							}
						} catch (org.openqa.selenium.StaleElementReferenceException se) {
							se.printStackTrace();
						}
						Thread.sleep(1000);
						WebElement closeinspect = driver.findElement(By.xpath("//div[@id='closeinspct']"));
						((JavascriptExecutor) driver).executeScript("arguments[0].click();", closeinspect);

						// zoom in and zoom out

						WebElement zoomin = driver.findElement(By.xpath("//button[@id='zoomin']"));

						for (int z = 1; z <= 3; z++) {
							Thread.sleep(1000);
							((JavascriptExecutor) driver).executeScript("arguments[0].click();", zoomin);
						}
						System.out.println("Page zoom in");

						Thread.sleep(2000);
						WebElement zoomout = driver.findElement(By.xpath("//button[@id='zoomout']"));

						for (int z = 1; z <= 3; z++) {
							Thread.sleep(1000);
							((JavascriptExecutor) driver).executeScript("arguments[0].click();", zoomout);
						}
						System.out.println("Page Zoom out");

						// validate the shortcut keys
						System.out.println("Keyboard shortcut keys validation");
						ob.shortCutKeys();

						// Approve button

						// Thread.sleep(10000);
						WebElement approvebtn = driver
								.findElement(By.xpath("//button[@id='aprvbtn'][contains(text(),'Approve')]"));
						wait.until(ExpectedConditions.elementToBeClickable(approvebtn));
						// Thread.sleep(10000);
						// action.moveToElement(approvebtn).perform();
						Thread.sleep(1000);

						((JavascriptExecutor) driver).executeScript("arguments[0].click();", approvebtn);
						// Thread.sleep(3000);
						Thread.sleep(1000);

						WebElement ignore_yes = driver.findElement(By.xpath("//button[@id='modal-btn-si']"));
						WebElement modalcontent = driver.findElement(By.xpath("//div[@class='modal-content']"));
						if ((modalcontent != null) && (modalcontent.isDisplayed())) {

							// action.moveToElement(ignore_yes).perform();
							// Thread.sleep(500);
							((JavascriptExecutor) driver).executeScript("arguments[0].click();", ignore_yes);
							// ignore_yes.click();
						}

						WebElement confirm = driver.findElement(By.xpath("//button[@id='Confirmx']"));
						Thread.sleep(5000);
						// action.moveToElement(confirm).perform();
						((JavascriptExecutor) driver).executeScript("arguments[0].click();", confirm);
						// confirm.click();
						WebElement ok = wait.until(ExpectedConditions
								.visibilityOfElementLocated(By.xpath("//button[@id='modal-btn-sia']")));
						// action.moveToElement(ok).perform();
						Thread.sleep(5000);
						WebElement msg = driver.findElement(By.xpath("//div[@class='modal-body ng-binding']"));

						String approvemssg = msg.getText();
						System.out.println(approvemssg);
						((JavascriptExecutor) driver).executeScript("arguments[0].click();", ok);

						long finish = System.currentTimeMillis();

						long totalTime = finish - start;
						long time_sec = totalTime / 1000;
						System.out.println("Total Time to approve in Process folder - " + totalTime + " milliseconds ");
						System.out.println("Total Time to approve in Process folder - " + time_sec + " seconds ");

						Thread.sleep(5000);
						driver.close();

					}
				}

				// Thread.sleep(5000);

				driver.switchTo().window(parentWindow);
				driver.navigate().refresh();
				// driver.manage().timeouts().pageLoadTimeout(TestUtil.PageLoadTimeOut,TimeUnit.SECONDS);

				// addprojobj.scrolldown();

				Thread.sleep(6000);
				filerepoobj.click_QA();
			} catch (org.openqa.selenium.NoSuchSessionException n) {

			}
		} catch (

		NullPointerException e) {
			System.out.println("NullPointerException thrown!");
		}

	}

	@Then("^user deletes the files in all folders$")
	public void user_deletes_the_files_in_all_folders() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		filerepoobj.delfiles();
	}

	// Multiple file upload

	@Then("^user searches for the required \"([^\"]*)\"$")
	public void user_searches_for_the_required(String project) throws InterruptedException {
		filerepoobj = allprojectsobj.search(project);
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PageLoadTimeOut, TimeUnit.SECONDS);
		Thread.sleep(3000);

	}

	@And("^uploads multiple file to the selected project$")
	public void uploads_multiple_file_to_the_selected_project() throws ClassNotFoundException, FileNotFoundException,
			InterruptedException, AWTException, URISyntaxException {
		filerepoobj.multiplefileUpload();

	}

}
