package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "", features = "src/test/resources/features/", glue = "steps",
        plugin = {"pretty", "html:target/cucumber.html"})

public class CucumberRunnerTests extends AbstractTestNGCucumberTests {
}