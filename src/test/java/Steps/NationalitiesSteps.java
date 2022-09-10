package Steps;


import Pages.NationalityPage;
import Pages.SideNav;
import Utils.DriverManager;
import Utils.Tools;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static Utils.Tools.waitUntilLoading;

public class NationalitiesSteps {

    WebDriver driver = DriverManager.getDriver();
    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
    SideNav sideNav = new SideNav();
    NationalityPage nationalityPage = new NationalityPage();
    static String randomName;


    @And("User navigate to Nationalities Page")
    public void userNavigateToNationalitiesPage() {
        Tools.navigateToMenu(sideNav.Setup,
                sideNav.Setup_Parameters,
                sideNav.Setup_Parameters_Nationalities);
        waitUntilLoading();
    }

    @When("User create a new Nationality")
    public void userCreateANewNationality() {
        wait.until(ExpectedConditions.elementToBeClickable(nationalityPage.addButton)).click();
        Tools.waitUntilLoading();
        randomName = RandomStringUtils.randomAlphanumeric(8);
        nationalityPage.nameInput.sendKeys(randomName);
        wait.until(ExpectedConditions.elementToBeClickable(nationalityPage.saveButton)).click();
        Tools.waitUntilLoading();
    }

    @Then("Nationality transaction success message should be displayed")
    public void nationalityTransactionSuccessMessageShouldBeDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(nationalityPage.successMessage));
        Assert.assertTrue(nationalityPage.successMessage.getText().contains("success"));
    }

    @When("User edit old Nationality so can change personal data")
    public void userEditOldNationalitySoCanChangePersonalData() {
        wait.until(ExpectedConditions.elementToBeClickable(nationalityPage.searchNameInput)).sendKeys(randomName);
        wait.until(ExpectedConditions.elementToBeClickable(nationalityPage.searchButton)).click();
        Tools.waitUntilLoading();
        wait.until(ExpectedConditions.elementToBeClickable(nationalityPage.editButton)).click();
        Tools.waitPopUp();
        randomName=RandomStringUtils.randomAlphanumeric(8);
        wait.until(ExpectedConditions.elementToBeClickable(nationalityPage.nameInput)).clear();
        nationalityPage.nameInput.sendKeys(randomName);
        wait.until(ExpectedConditions.elementToBeClickable(nationalityPage.saveButton)).click();
        Tools.waitUntilLoading();

    }

    @When("User delete Nationality so can clean personal data")
    public void userDeleteNationalitySoCanCleanPersonalData() {
        wait.until(ExpectedConditions.elementToBeClickable(nationalityPage.searchNameInput)).sendKeys(randomName);
        nationalityPage.searchButton.click();
        Tools.waitUntilLoading();
        wait.until(ExpectedConditions.elementToBeClickable(nationalityPage.deleteButton)).click();
        nationalityPage.nationalityPageDeleteButton.click();
        Tools.waitUntilLoading();

    }
}
