package cucumber.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/com/apiautomation/features",glue = "com.apiautomation.stepdefinitions",dryRun = true)
public class TestRunner {



}
