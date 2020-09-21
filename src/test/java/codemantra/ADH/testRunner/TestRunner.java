package codemantra.ADH.testRunner;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

//import com.cucumber.listener.Reporter;

//import com.cucumber.listener.Reporter;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)

@CucumberOptions(
		//features="D:/ADH_Workspace/codemantra.ADH/src/test/java/codemantra/ADH/feature/filerepositoryTest.feature",
		//features="C:\\Users\\codemantra\\git\\accessibility-qa-script\\src\\test\\resources\\codemantra\\ADH\\feature\\filerepository.feature",
		features="src/test/resources/codemantra/ADH/feature/filerepository.feature",
		
		glue= {"codemantra.ADH.stepDefintion"},
		monochrome=true,
		dryRun=false,
		//OR {","} //tags comma separated
		//AND {"",""}//Tags which are passed in separate quotes 
		tags={"~@login_positive","~@login_negative","~@Savebtn_Cancelbtn_EnableCheck","~@AddProject","~@AddFilesOnProjectcreation","@AddFilesOnSearchProject","~@EditProjectDetails"},
		format= {"pretty","html:html-output","json:json-output/report.json"},
		//plugin= {"com.vimalselvam.cucumber.ExtentCucumberFormatter:target/cucumber-reports/report.html"}
			
		//plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/report.html"},
		//plugin = {"com.aventstack.
		//extentreports.cucumber.adapter.ExtentCucumberAdapter:", "json:target/cucumber-report.json"},
				plugin ={"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})

	

public class TestRunner {
	/* public static void main(String[] args) throws Throwable {
	        cucumber.api.cli.Main.main(args );
	    }*/
	
	}


