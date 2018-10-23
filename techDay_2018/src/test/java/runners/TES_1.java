package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import common.functions.AbstractTestNGCucumberTestsEdit;

public class TES_1 {
	 @CucumberOptions(features = "src/test/java/features/TES_1.feature",
			   glue = {"steps"},
			   plugin = {"json:Cucumber_Output/TES_1/cucumber.json", "junit:Cucumber_Output/TES_1/junit-Cucumber.xml"})
			 public class Test extends AbstractTestNGCucumberTestsEdit { 
			 
	 }
}
