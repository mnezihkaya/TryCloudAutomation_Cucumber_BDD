package step_definitions;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.LoginPage;
import utilities.BrowserUtilities;

public class Login_Negative {
    LoginPage loginPage=new LoginPage();
    @Then("verify {string} message should be displayed")
    public void verifyMessageShouldBeDisplayed(String expected) {
        BrowserUtilities.highlight(loginPage.warningMessage);
        Assert.assertEquals(expected,loginPage.warningMessage.getText());
    }
}
