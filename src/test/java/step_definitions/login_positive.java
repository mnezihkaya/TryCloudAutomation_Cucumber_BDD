package step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.LoginPage;
import utilities.BrowserUtilities;
import utilities.ConfigurationReader;

public class login_positive {
    LoginPage loginPage = new LoginPage();

    @When("user enters username {string} and password {string}")
    public void user_enters_username_and_password(String username, String password) {
        BrowserUtilities.highlight(loginPage.usernameInput);
        loginPage.usernameInput.sendKeys(username);
        BrowserUtilities.highlight(loginPage.passwordInput);
        loginPage.passwordInput.sendKeys(password);
    }

    @When("user click the login button")
    public void user_click_the_login_button() {
        BrowserUtilities.highlight(loginPage.loginBtn);
        loginPage.loginBtn.click();
    }

    @Then("verify the user should be at the dashboard page")
    public void verify_the_user_should_be_at_the_dashboard_page() {
        BrowserUtilities.waitForPageToLoad(ConfigurationReader.getNumber("timeout"));
        BrowserUtilities.highlight(loginPage.mainLogo);
        Assert.assertTrue(loginPage.mainLogo.isDisplayed());
    }
}
