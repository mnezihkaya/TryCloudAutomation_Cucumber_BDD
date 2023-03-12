package step_definitions;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import pages.ContactsPage;
import utilities.BrowserUtilities;

public class Contacts_view_list {
    ContactsPage contactsPage = new ContactsPage();
    @Then("verify the contact names are in the list")
    public void verifyTheContactNamesAreInTheList() {
        for (WebElement each : contactsPage.contactList) {
            BrowserUtilities.highlight(each);
            Assert.assertTrue(each.isDisplayed());
        }
    }
}
