package Steps;

import Pages.DescriptionPage;
import Pages.LoginPage;
import Pages.SideNav;
import Utils.DriverManager;
import Utils.Tools;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Description_Steps {
    DescriptionPage dp=new DescriptionPage();
    SideNav sn=new SideNav();
    WebDriver driver = DriverManager.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    @And("navigated to Discounts page")
    public void navigatedToDiscountsPage() {
        Tools.navigateToMenu(
                sn.Setup,
                sn.Setup_Parameters,
                sn.Setup_Parameters_Discounts);
        Tools.waitUntilLoading();
    }

    @When("User should be able to add Discounts")
    public void userShouldBeAbleToAddDiscounts() {
        wait.until(ExpectedConditions.elementToBeClickable(dp.addButton)).click();

        dp.descriptionInput.sendKeys("Ahmet Mutlu");
        dp.descriptionCodeInput.sendKeys("Aile");
        dp.priorityInput.clear();
        dp.priorityInput.sendKeys("10");
        dp.saveButton.click();

    }



    @When("User should be able to edit Discounts")
    public void userShouldBeAbleToEditDiscounts() {
        dp.descriptionSearchInput.sendKeys("Ahmet Mutlu");
        dp.codeSearchInput.sendKeys("Aile");
        dp.searchButton.click();
        Tools.waitUntilLoading();
        dp.editButton.click();

        dp.descriptionInput.clear();
        dp.descriptionInput.sendKeys("Mutlu Ahmet");
        dp.descriptionCodeInput.clear();
        dp.descriptionCodeInput.sendKeys("tanidik");
        dp.priorityInput.clear();
        dp.priorityInput.sendKeys("15");
        dp.saveButton.click();

    }

    @When("User should be able to delete Discounts")
    public void userShouldBeAbleToDeleteDiscounts() {
        Tools.waitUntilLoading();
        dp.descriptionSearchInput.clear();
        wait.until(ExpectedConditions.elementToBeClickable(dp.descriptionSearchInput)).sendKeys("Mutlu Ahmet");
        dp.searchButton.click();
        Tools.waitUntilLoading();
        wait.until(ExpectedConditions.elementToBeClickable(dp.deleteButton)).click();

        Tools.waitPopUp();
        dp.deleteButtonConfirm.click();
        Tools.waitUntilLoading();
    }


    @Then("Description success message should be displayed")
    public void descriptionSuccessMessageShouldBeDisplayed() {
        wait.until(ExpectedConditions.visibilityOfAllElements(dp.successMessage));
        Assert.assertTrue(dp.successMessage.getText().contains("success"));
    }
}