package cucumberOptions;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/features", glue = "stepDefinitions", monochrome = true, plugin = {
		"html:target/cucumber.html", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
		"rerun:target/failed_scenarios.txt"}, tags = "@Employee")
public class EmployeeTestRunner extends AbstractTestNGCucumberTests {

	@Override
	@DataProvider()
	public Object[][] scenarios() {
		return super.scenarios();
	}
}
