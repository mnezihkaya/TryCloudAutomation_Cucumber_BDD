package step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.BrowserUtilities;
import utilities.Driver;

public class Hooks {
    @Before
    public void setupDriver(Scenario scenario){
        // To run before each method
        System.out.println(">> Scenario name: "+scenario.getName());
    }

    @After
    public void tearDown(Scenario scenario){

        if (scenario.isFailed()){
            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }

        Driver.closeDriver();
        BrowserUtilities.sleep(1);
    }
}
