package step_definitions;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.FilePage;
import utilities.BrowserUtilities;
import utilities.Driver;

public class file_delete_file_folder {
    FilePage filePage=new FilePage();
    @Then("Verify the deleted file is displayed on the page")
    public void verifyTheDeletedFileIsDisplayedOnThePage() {
        BrowserUtilities.highlight(filePage.deletedFilter);
        filePage.deletedFilter.click();
        String fileName = FilePage.getFileNameHolder();
        WebElement element = Driver.getDriver().findElement(By.xpath("(//td//*[.='"+fileName+"'])[1]"));
        BrowserUtilities.highlight(element);
        Assert.assertTrue(element.isDisplayed());
        BrowserUtilities.highlight(filePage.restoreBtn);
        filePage.restoreBtn.click();

    }
}
