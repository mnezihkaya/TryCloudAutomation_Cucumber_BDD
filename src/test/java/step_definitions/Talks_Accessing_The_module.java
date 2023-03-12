package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import pages.TalksPage;
import utilities.BrowserUtilities;
import utilities.Driver;

public class Talks_Accessing_The_module {
    TalksPage talksPage = new TalksPage();
    @And("user search {string} user from the search box")
    public void userSearchUserFromTheSearchBox(String user) {
        BrowserUtilities.highlight(talksPage.searchInput);
        talksPage.searchInput.sendKeys(user+ Keys.ENTER);

        WebElement conversation = Driver.getDriver().findElement(By.xpath("//a[@aria-label='Conversation, "+user+"']"));
        BrowserUtilities.highlight(conversation);
        conversation.click();
    }

    @And("user write a {string} to the message")
    public void userWriteAToTheMessage(String string) {
        String message=string+"-"+Driver.getDriver();
        BrowserUtilities.highlight(talksPage.messageInput);
        talksPage.messageInput.sendKeys(message);
    }

    @And("user clicks to submit button")
    public void userClicksToSubmitButton() {
        BrowserUtilities.highlight(talksPage.submitBtn);
        talksPage.submitBtn.click();
    }

    @Then("the user should be able to see the {string} message is displayed on the conversation log")
    public void theUserShouldBeAbleToSeeTheMessageIsDisplayedOnTheConversationLog(String string) {
        String message = string + " - " + Driver.getDriver();
        WebElement postedMessage = Driver.getDriver().findElement(By.xpath("//*[.='"+message+"']"));
        Assert.assertTrue(postedMessage.isDisplayed());
    }
}
