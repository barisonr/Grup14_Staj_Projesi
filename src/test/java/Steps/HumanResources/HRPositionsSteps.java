package Steps.HumanResources;

import Pages.HRPositionsPage;
import Pages.SideNav;
import Utils.DriverManager;
import Utils.Tools;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static Utils.Tools.waitUntilLoading;

public class HRPositionsSteps {
    WebDriver driver = DriverManager.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    SideNav sideNav = new SideNav();
    HRPositionsPage hrPositionsPage = new HRPositionsPage();
    @And("User navigate to HRPositions Page")
    public void userNavigateToHRPositionsPage() {

        Tools.navigateToMenu(sideNav.HumanResources,
                             sideNav.HumanResources_Setup,
                             sideNav.HumanResources_Setup_Positions);
        waitUntilLoading();
    }
    @When("User Create a new position")
    public void userCreateANewPosition() {

        wait.until(ExpectedConditions.elementToBeClickable(hrPositionsPage.addButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(hrPositionsPage.nameInput)).sendKeys("grup14");
        wait.until(ExpectedConditions.elementToBeClickable(hrPositionsPage.shortNameInput)).sendKeys("group14");
        wait.until(ExpectedConditions.elementToBeClickable(hrPositionsPage.saveButton)).click();
    }
    @Then("Success message should be displayed")
    public void successMessageShouldBeDisplayed() {

        Tools.waitUntilLoading();
        wait.until(ExpectedConditions.visibilityOf(hrPositionsPage.successMessage));
        Assert.assertTrue(hrPositionsPage.successMessage.getText().contains("success"));
    }
    @When("User Edit the old position")
    public void userEditTheOldPosition() {

        wait.until(ExpectedConditions.elementToBeClickable(hrPositionsPage.searchNameInput)).click();
        wait.until(ExpectedConditions.elementToBeClickable(hrPositionsPage.searchNameInput)).sendKeys("grup14");
        wait.until(ExpectedConditions.elementToBeClickable( hrPositionsPage.searchButton)).click();
        Tools.waitUntilLoading();
        wait.until(ExpectedConditions.elementToBeClickable(hrPositionsPage.editButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(hrPositionsPage.nameInput)).clear();
        hrPositionsPage.nameInput.sendKeys("Grup14");
        wait.until(ExpectedConditions.elementToBeClickable(hrPositionsPage.shortNameInput)).clear();
        hrPositionsPage.shortNameInput.sendKeys("Group14");
        wait.until(ExpectedConditions.elementToBeClickable(hrPositionsPage.saveButton)).click();
    }
    @When("User delete the position")
    public void userDeleteThePosition() {

        wait.until(ExpectedConditions.elementToBeClickable(hrPositionsPage.searchNameInput)).click();
        wait.until(ExpectedConditions.elementToBeClickable(hrPositionsPage.searchNameInput)).sendKeys("Grup14");
        wait.until(ExpectedConditions.elementToBeClickable(hrPositionsPage.searchButton)).click();
        Tools.waitUntilLoading();
        wait.until(ExpectedConditions.elementToBeClickable(hrPositionsPage.deleteButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(hrPositionsPage.hrPageDeleteButton)).click();
    }


}
