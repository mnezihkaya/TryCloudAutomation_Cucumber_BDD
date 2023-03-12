package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.FilePage;
import pages.UploadsFilesPage;
import utilities.BrowserUtilities;
import utilities.Driver;
import utilities.TryCloudUtilities;

import java.io.File;

public class File_folder_create_and_upload {
    FilePage filePage=new FilePage();
    UploadsFilesPage uploadsFilesPage=new UploadsFilesPage();
    @And("user click the {string} top-module")
    public void userClickTheTopModule(String module) {
        WebElement topModule=Driver.getDriver().findElement(By.xpath("//div[@class='newFileMenu popovermenu bubble menu open menu-left']//*[normalize-space(.)='"+module+"']"));
        BrowserUtilities.highlight(topModule);
        topModule.click();
    }

    @And("the user write a {string} to folder name")
    public void theUserWriteAToFolderName(String folderName) {
        BrowserUtilities.highlight(filePage.newFolderInput);
        String customFolder=folderName+ Driver.getDriver();
        filePage.newFolderInput.sendKeys(customFolder);

    }

    @When("the user click submit icon")
    public void theUserClickSubmitIcon() {
        BrowserUtilities.highlight(filePage.submitFolderNameBtn);
        filePage.submitFolderNameBtn.click();
    }

    @Then("Verify the {string} folder is displayed on the page")
    public void verifyTheFolderIsDisplayedOnThePage(String folder) {
        String customFolder = folder+Driver.getDriver();
        WebElement folderName = Driver.getDriver().findElement(By.xpath("//span[@class='innernametext' and .='" + customFolder + "']"));
        BrowserUtilities.highlight(folderName);
        Assert.assertTrue(folderName.isDisplayed());

        // Remove created folder
        WebElement actionsForUploaded = Driver.getDriver().findElement(By.xpath("(//span[@class='innernametext' and .='" + customFolder + "']/../..//a[2])[1]"));
        BrowserUtilities.highlight(actionsForUploaded);
        actionsForUploaded.click();
        BrowserUtilities.sleep(0.2);
        FilePage.chooseOption("Delete");

    }

    @And("the user choose a {string} folder from the page")
    public void theUserChooseAFolderFromThePage(String folder) {
        WebElement folderName = Driver.getDriver().findElement(By.xpath("//span[@class='innernametext' and .='" + folder + "']"));
        BrowserUtilities.highlight(folderName);
        folderName.click();
    }


    @When("user uploads file with the upload file option")
    public void userUploadsFileWithTheUploadFileOption() {
        File file;
        if (System.getProperty("os.name").contains("Windows")){
            String path="./src/test/resources/files/TryCloud.txt";
            file=new File(path);
        }else {
            String pathOfProject=System.getProperty("user.dir");
            String pathOfFile="/src/test/resources/files/TryCloud.txt";
            String path=pathOfProject+pathOfFile;
            file=new File(path);
        }
        filePage.upload.sendKeys(file.getAbsolutePath());
        filePage.addNewFileBtn.click();

    }

}
