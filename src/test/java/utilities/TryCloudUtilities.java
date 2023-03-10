package utilities;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.FilePage;
import pages.LoginPage;

public class TryCloudUtilities {
    public static void login(){
        LoginPage loginPage = new LoginPage();

        BrowserUtilities.highlight(loginPage.usernameInput);
        loginPage.usernameInput.sendKeys(ConfigurationReader.getProperty("user4"));

        BrowserUtilities.highlight(loginPage.passwordInput);
        loginPage.passwordInput.sendKeys(ConfigurationReader.getProperty("pass")+ Keys.ENTER);

        BrowserUtilities.waitForPageToLoad(ConfigurationReader.getNumber("timeout"));
        BrowserUtilities.highlight(loginPage.mainLogo);
        Assert.assertTrue(loginPage.mainLogo.isDisplayed());
    }

    public static void navigateTo(String pageName){
        WebElement pageLink = Driver.getDriver().findElement(By.xpath("//ul[@id='appmenu']//a[@aria-label='"+pageName+"']"));
        BrowserUtilities.highlight(pageLink);
        pageLink.click();
        BrowserUtilities.waitForPageToLoad(ConfigurationReader.getNumber("timeout"));
    }

    public static void waitTillUploadBarDisappears(){
        try{
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), ConfigurationReader.getNumber("timeout"));
            FilePage filePage = new FilePage();
            wait.until(ExpectedConditions.invisibilityOf(filePage.uploadBar));
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
