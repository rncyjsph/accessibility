package codemantra.ADH.testRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="D:\\ADH_Workspace\\codemantra.ADH\\src\\test\\java\\codemantra\\ADH\\feature\\filerepository.feature",
		glue= {"codemantra.ADH.stepDefintion"},
		monochrome=true,
		dryRun=true,
		//OR {","} //tags comma separated
		//AND {"",""}//Tags which are passed in separate quotes 
		tags={"~@login_positive","~@login_negative","~@Savebtn_Cancelbtn_EnableCheck","~@AddProject","@AddFiles"},
		format= {"pretty","html:html-output","json:json-output/report.json"}

)
	

public class Runner {

}
