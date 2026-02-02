package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features", // Note the "s" in resources
    glue = { "stepDefinitions", "hooks" },
    plugin = {"pretty", "html:target/CucumberReports/CucumberReport.html"},
    publish = true,
    monochrome = true
)
public class TestRunner {
}
