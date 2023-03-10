package step_definitions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import utilities.BrowserUtilities;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.TryCloudUtilities;

public class Base_definitions {
    @When("the users log in with valid credentials")
    public void the_users_log_in_with_valid_credentials() {
        TryCloudUtilities.login();
    }

    @Given("user on the dashboard page")
    public void user_on_the_dashboard_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        TryCloudUtilities.login();
    }

    @Given("user on the login page")
    public void user_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
    }

    @When("user refresh the page")
    public void user_refresh_the_page() {
        Driver.getDriver().navigate().refresh();
    }
}
