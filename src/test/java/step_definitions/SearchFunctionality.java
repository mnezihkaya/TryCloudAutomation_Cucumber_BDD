package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import pages.BasePage;
import utilities.BrowserUtilities;
import utilities.Driver;

public class SearchFunctionality {
    BasePage basePage = new BasePage();
    @When("the user clicks the magnifier icon on the right top")
    public void theUserClicksTheMagnifierIconOnTheRightTop() {
        BrowserUtilities.highlight(basePage.searchBtn);
        basePage.searchBtn.click();
    }

    @And("users search any existing {string} file_folder_user name")
    public void usersSearchAnyExistingFile_folder_userName(String search) {
        BrowserUtilities.highlight(basePage.searchInput);
        basePage.searchInput.sendKeys(search+ Keys.ENTER);
    }

    @Then("verify the app displays {string} the expected result option")
    public void verifyTheAppDisplaysTheExpectedResultOption(String result) {
        WebElement displayedResult = Driver.getDriver().findElement(By.xpath("//*[.='"+result+"']"));
        BrowserUtilities.highlight(displayedResult);
        Assert.assertTrue(displayedResult.isDisplayed());
    }
}
