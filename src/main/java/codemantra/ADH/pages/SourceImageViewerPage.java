package codemantra.ADH.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import codemantra.ADH.TestBase.BaseClass;
import junit.framework.Assert;

public class SourceImageViewerPage extends BaseClass {

	@FindBy(xpath = "//button[@id='insMenu']")
	WebElement inspect;

	@FindBy(xpath = "//div[@class='elementx']")
	List<WebElement> l;
	@FindBy(xpath = "//div[@class='insLt']/b")
	WebElement tag;
	@FindBy(xpath = "//div[@class='elementx'][contains(text(),'Figure')]")
	WebElement figure;

	@FindBy(xpath = "//div[@class='elementx'][contains(text(),'table')]")
	WebElement table;

	@FindBy(xpath = "//div[@class='elementx'][contains(text(),'Formula')]")
	WebElement formula;
	@FindBy(xpath = "//div[@id='closeinspct']")
	WebElement closeinspect;

	@FindBy(xpath = "//select[@id='selecTag']")
	WebElement selectfield;

	public SourceImageViewerPage() {
		PageFactory.initElements(driver, this);
	}

	public void clickinspect() throws InterruptedException {
		Actions action = new Actions(driver);

		action.moveToElement(inspect).build().perform();
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", inspect);

		int no_of_elements = l.size();
		System.out.println("Number of elements found on current page is  " + no_of_elements);
		for (int e = 0; e < no_of_elements; e++) {
			String element = l.get(e).getText();
			if (element.equalsIgnoreCase("Figure")) {

				figure.click();

				String tagname = tag.getText();
				System.out.println("The element predicted is with tagname :" + tagname);
				Select select = new Select(selectfield);
				List<WebElement> selvalues = select.getOptions();
				int selectsize = selvalues.size();
				System.out.println(" Number of options present in Change Element Field :" + selectsize);
				for (int s = selectsize-1; s > 0; s--) {
					String sValue = selvalues.get(s).getText();
					System.out.println("The options are " + sValue);
					select.selectByVisibleText(sValue);
					Thread.sleep(1000);
					String newelement1 = l.get(e).getText();
					if(sValue.equalsIgnoreCase(newelement1))
							{
					System.out.println("Element is changed to :" + newelement1);
							}
					
					//Assert.assertEquals(sValue, element);
					//System.out.println("The selected element is changed to " + sValue);

				}
				

			}

			else if (element.equalsIgnoreCase("Table")) {

				table.click();
				String tagname = tag.getText();
				System.out.println("The element predicted is with tagname :" + tagname);
				Select select = new Select(selectfield);
				List<WebElement> selvalues = select.getOptions();
				int selectsize = selvalues.size();
				for (int s = 0; s < selectsize; s++) {
					String sValue = selvalues.get(s).getText();
					System.out.println("The options are " + sValue);
					select.selectByVisibleText(sValue);
					Thread.sleep(1000);
					String newelement1 = l.get(e).getText();
					System.out.println("the selected element is changed to " + newelement1);
					Assert.assertEquals(sValue, newelement1);

				}
			}

			else if (element.equalsIgnoreCase("Formula")) {

				formula.click();
				String tagname = tag.getText();
				System.out.println("The element predicted is with tagname :" + tagname);
				Select select = new Select(selectfield);
				List<WebElement> selvalues = select.getOptions();
				int selectsize = selvalues.size();
				for (int s = 0; s < selectsize; s++) {
					String sValue = selvalues.get(s).getText();
					System.out.println("The options are " + sValue);
					select.selectByVisibleText(sValue);
					Thread.sleep(1000);
					String newelement1 = l.get(e).getText();
					System.out.println("the selected element is changed to " + newelement1);
					Assert.assertEquals(sValue, newelement1);

				}
			}
			Thread.sleep(1000);

			((JavascriptExecutor) driver).executeScript("arguments[0].click();", closeinspect);

		}
	}
}
