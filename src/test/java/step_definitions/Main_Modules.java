package step_definitions;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import pages.BasePage;
import utilities.BrowserUtilities;
import utilities.ConfigurationReader;

import java.util.ArrayList;
import java.util.List;

public class Main_Modules {
    BasePage basePage=new BasePage();
    @Then("Verify the user see the following modules:")
    public void verifyTheUserSeeTheFollowingModules(List<String> expected) {
        BrowserUtilities.waitForPageToLoad(ConfigurationReader.getNumber("timeout"));
        List<String>actual=new ArrayList<>();
        for (WebElement each:basePage.mainModules) {
            BrowserUtilities.hover(each);
            BrowserUtilities.highlight(each);
            actual.add(each.getText());

        }
        Assert.assertEquals(expected,actual);
    }
}
