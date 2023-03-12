package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.FilePage;
import utilities.BrowserUtilities;
import utilities.Driver;

public class File_writing_comments {
    FilePage filePage = new FilePage();

    @And("user write a {string} comment inside the input box")
    public void userWriteACommentInsideTheInputBox(String message) {
        BrowserUtilities.highlight(filePage.commentBtn);
        filePage.commentBtn.click();

        BrowserUtilities.highlight(filePage.commentInput);
        filePage.commentInput.sendKeys(message);
    }

    @And("user click the submit button to post it")
    public void userClickTheSubmitButtonToPostIt() {
        BrowserUtilities.highlight(filePage.commentSubmit);
        filePage.commentSubmit.click();
    }

    @Then("Verify the {string} comment is displayed in the comment section")
    public void verifyTheCommentIsDisplayedInTheCommentSection(String message) {
        WebElement element = Driver.getDriver().findElement(By.xpath("//*[.='" + message + "']"));
        BrowserUtilities.highlight(element);
        Assert.assertTrue(element.isDisplayed());
    }
}
