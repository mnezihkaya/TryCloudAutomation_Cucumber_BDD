package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.FilePage;
import utilities.BrowserUtilities;

import java.io.File;

public class FilesAddedToFavorites {

    FilePage filePage = new FilePage();

    @When("the user clicks action-icon from any file on the page")
    public void theUserClicksActionIconFromAnyFileOnThePage() {
        BrowserUtilities.highlight(filePage.triDots);
        filePage.triDots.click();
    }

    @And("user choose the {string} option")
    public void userChooseTheOption(String option) {

        String currentFileName = filePage.fileName.getText();

        if (option.contains("favorites") && !filePage.firstOption.getText().equals(option)) {
            filePage.firstOption.click();
            BrowserUtilities.highlight(filePage.triDots);
            filePage.triDots.click();
        }
        FilePage.setFileNameHolder(currentFileName);
        FilePage.chooseOption(option);
    }

    @And("user click the {string} sub-module")
    public void userClickTheSubModule(String module) {
        FilePage.clickSubModule(module);
    }

    @Then("Verify the chosen file is listed on the table")
    public void verifyTheChosenFileIsListedOnTheTable() {
        BrowserUtilities.highlight(filePage.favFileName);
        Assert.assertEquals(FilePage.getFileNameHolder(), filePage.favFileName.getText());
    }
}
