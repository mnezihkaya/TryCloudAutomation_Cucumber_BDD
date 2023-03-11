package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import pages.FilePage;
import utilities.BrowserUtilities;
import utilities.Driver;
import utilities.TryCloudUtilities;

public class File_Module {
    FilePage filePage = new FilePage();

    @When("the user clicks the {string} module")
    public void theUserClicksTheModule(String pageName) {
        TryCloudUtilities.navigateTo(pageName);
    }

    @Then("verify the page title is {string}")
    public void verifyThePageTitleIs(String expectedTitle) {

        BrowserUtilities.titleVerify(expectedTitle);
    }

    @And("user click the top-left checkbox of the table")
    public void userClickTheTopLeftCheckboxOfTheTable() {
        BrowserUtilities.highlight(filePage.firstCheckbox);
        filePage.firstCheckbox.click();
    }

    @Then("verify all the files are selected")
    public void verifyAllTheFilesAreSelected() {
        for (WebElement each : filePage.listCheckboxes) {
            BrowserUtilities.highlight(each);
            Assert.assertTrue(each.getAttribute("class").contains("selected"));

        }
    }
}
