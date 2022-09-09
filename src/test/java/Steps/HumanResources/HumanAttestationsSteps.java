package Steps.HumanResources;


import Pages.HumanResources.HumanAttestationsPage;
import Pages.LoginPage;
import Pages.SideNav;
import Utils.DriverManager;
import Utils.Tools;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class HumanAttestationsSteps {

    SideNav sn=new SideNav();
    LoginPage loginPage = new LoginPage();


    WebDriver driver = DriverManager.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    HumanAttestationsPage hp=new HumanAttestationsPage();

    @And("navigated to Attestations page")
    public void navigatedToAttestationsPage() {
        Tools.navigateToMenu(
                sn.HumanResources,
                sn.HumanResources_Setup,
                sn.HumanResources_Setup_Attestations);
        Tools.waitUntilLoading();
    }
    @Then("User should be able to add Attestations")
    public void UserShouldBeAbleToAddAttestations() {
        wait.until(ExpectedConditions.elementToBeClickable(hp.addButton)).click();



        Tools.waitPopUp();

        hp.nameInput.sendKeys("ahmet135");
        hp.saveButton.click();

        Tools.waitUntilLoading();

    }

    @Then("User should be able to edit Attestations")
    public void UserShouldBeAbleToEditAttestations() {
        hp.searchBarInput.sendKeys("Ahmet135");
        hp.searchButton.click();
        Tools.waitUntilLoading();
        hp.editButton.click();
        Tools.waitPopUp();
        hp.nameInput.clear();
        Tools.waitUntilLoading();
        hp.nameInput.sendKeys("Mutlu135");
        hp.saveButton.click();
        Tools.waitUntilLoading();

    }

    @Then("User should be able to delete Attestations")
    public void UserShouldBeAbleToDeleteAttestations() {
        hp.searchBarInput.clear();
        wait.until(ExpectedConditions.elementToBeClickable(hp.searchBarInput)).sendKeys("Mutlu135");
        hp.searchButton.click();
        Tools.waitUntilLoading();

        wait.until(ExpectedConditions.elementToBeClickable(hp.deleteButton));
        hp.deleteButton.click();
        Tools.waitPopUp();
        hp.deleteButtonConfirm.click();
        Tools.waitUntilLoading();

    }


    @And("Attestation success message should be displayed")
    public void successMessageShouldBeDisplayed() {
        wait.until(ExpectedConditions.visibilityOfAllElements(hp.successMessage));
        Assert.assertTrue(hp.successMessage.getText().contains("success"));
    }
}
