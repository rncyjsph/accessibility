package codemantra.ADH.util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;

import codemantra.ADH.TestBase.BaseClass;

public class Zoom extends BaseClass{
	
	public static void std()
	{
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PageLoadTimeOut, TimeUnit.SECONDS);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("document.body.style.zoom = '90%'");
		//executor.executeScript(“document.body.style.zoom = ‘1’”);
	}

}
