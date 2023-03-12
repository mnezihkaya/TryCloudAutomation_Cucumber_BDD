package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import pages.FilePage;
import pages.UploadsFilesPage;
import utilities.BrowserUtilities;
import utilities.Driver;
import utilities.TryCloudUtilities;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class Files_Update_Settings {
    FilePage filePage = new FilePage();
    UploadsFilesPage uploadsFilesPage = new UploadsFilesPage();

    String beforeStorage, afterStorage;
    @Then("the user should be able to click any buttons")
    public void theUserShouldBeAbleToClickAnyButtons() {
        int i=0;
        for (WebElement each : filePage.settingsCheckboxesBtn) {
            BrowserUtilities.highlight(each);
            boolean beforeClick = filePage.settingsCheckboxes.get(i).isSelected();
            each.click();
            boolean afterClick = filePage.settingsCheckboxes.get(i).isSelected();
            Assert.assertNotEquals(beforeClick, afterClick);
            i++;
        }
    }

    @And("user checks the current storage usage")
    public void userChecksTheCurrentStorageUsage() {
        beforeStorage = filePage.storageStatus.getText();
    }

    @And("user uploads file with the upload file option")
    public void userUploadsFileWithTheUploadFileOption() {
        public void user_uploads_file_with_the_upload_file_option() {

            String path;
            if (System.getProperty("os.name").contains("Windows")){
                path="./src/test/resources/files/testing.png";
            }else {
                String pathOfProject=System.getProperty("user.dir");
                String pathOfFile="/src/test/resources/files/testing.png";
                path=pathOfProject+pathOfFile;
            }
            File file = new File(path);
            Assert.assertTrue(">>>>>>> FILE NOT FOUND",file.exists());
            filePage.upload.sendKeys(file.getAbsolutePath());

            // Check if upload failed due to Not Enough Space and retry
            try{
                Driver.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
                Assert.assertTrue(filePage.notEnoughSpaceBtn.isDisplayed());
                BrowserUtilities.highlight(filePage.notEnoughSpaceBtn);
                filePage.notEnoughSpaceBtn.click();
                BrowserUtilities.sleep(1);
                filePage.upload.sendKeys(file.getAbsolutePath());
                TryCloudUtilities.waitTillUploadBarDisappears();
            } catch (Exception e){
                Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                TryCloudUtilities.waitTillUploadBarDisappears();
            }
        }


    }

    @Then("the user should be able to see storage usage is increased")
    public void theUserShouldBeAbleToSeeStorageUsageIsIncreased() {
        afterStorage = filePage.storageStatus.getText();
        Assert.assertNotEquals(beforeStorage, afterStorage);

        uploadsFilesPage.file3row.click();
        filePage.optionDelete.click();
        TryCloudUtilities.waitTillUploadBarDisappears();
    }
}
