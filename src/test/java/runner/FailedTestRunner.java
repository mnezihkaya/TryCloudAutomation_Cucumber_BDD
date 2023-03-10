package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = "rerun:target/rerun.txt",
        glue = "step_definitions",
        features = "@target/rerun.txt"
)

public class FailedTestRunner {
}
