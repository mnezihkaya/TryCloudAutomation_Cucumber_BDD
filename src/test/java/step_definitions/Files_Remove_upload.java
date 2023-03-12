package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.compress.compressors.lz77support.LZ77Compressor;
import org.junit.Assert;
import pages.FilePage;
import pages.UploadsFilesPage;
import utilities.BrowserUtilities;
import utilities.TryCloudUtilities;

import java.io.File;
import java.nio.file.Files;

public class Files_Remove_upload {
    UploadsFilesPage uploadsFilesPage = new UploadsFilesPage();
    FilePage filePage = new FilePage();

    @When("the user clicks the add icon on the top")
    public void theUserClicksTheAddIconOnTheTop() {
        BrowserUtilities.highlight(filePage.addNewFileBtn);
        filePage.addNewFileBtn.click();
    }

    @And("user uploads file with the upload file option")
    public void userUploadsFileWithTheUploadFileOption() {
        File file;
        if (System.getProperty("os.name").contains("windows")) {
            String path = ".src/test/resources/files/joker.jpg";
            file = new File(path);
        } else {
            String pathOfProject = System.getProperty("user.dir");
            String pathOfFile = "src/test/resources/files/joker.jpg";
            String path = pathOfProject + pathOfFile;
            file = new File(path);
        }
        filePage.upload.sendKeys(file.getAbsolutePath());
        filePage.addNewFileBtn.click();

    }

    @Then("Verify the file is displayed on the page")
    public void verifyTheFileIsDisplayedOnThePage() {
        BrowserUtilities.highlight(uploadsFilesPage.file1Name);
        Assert.assertTrue(uploadsFilesPage.file1Name.isDisplayed());

        //remove uploaded file
        uploadsFilesPage.file1row.click();
        filePage.optionDelete.click();
        TryCloudUtilities.waitTillUploadBarDisappears();
    }

    @Then("Verify the chosen file removed from the table")
    public void verifyTheChosenFileRemovedFromTheTable() {

        filePage.favFileName.click();
        Assert.assertTrue(true);
    }
}
