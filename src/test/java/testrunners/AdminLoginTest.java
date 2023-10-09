package testrunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(features = "featurefiles/adminlogin.feature",glue = "stepdefinitions",dryRun = false,plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})
public class AdminLoginTest extends AbstractTestNGCucumberTests{

}
