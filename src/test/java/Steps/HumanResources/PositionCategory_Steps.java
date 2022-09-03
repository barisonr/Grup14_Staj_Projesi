package Steps.HumanResources;

import Pages.HumanResources.PositionCategories_Page;
import Pages.SideNav;
import Utils.DriverManager;
import Utils.Tools;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class PositionCategory_Steps {

    SideNav sideNav = new SideNav();
    PositionCategories_Page page = new PositionCategories_Page();
    WebDriver driver = DriverManager.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
    static String randomName;

    @And("navigated to Position Category page")
    public void navigatedToPositionCategoryPage() {

        Tools.navigateToMenu(sideNav.HumanResources);
        Tools.navigateToMenu(sideNav.HumanResources_Setup);
        Tools.navigateToMenu(sideNav.HumanResources_Setup_PositionCategories);
        Tools.waitUntilLoading();
    }

    @When("a new position category is created")
    public void aNewPositionCategoryIsCreated() {
        wait.until(ExpectedConditions.elementToBeClickable(page.addButton)).click();
        Tools.waitPopUp();

        randomName = RandomStringUtils.randomAlphanumeric(8);
        page.nameInput.sendKeys(randomName);
        page.saveButton.click();
        Tools.waitUntilLoading();
    }

    @Then("the position category should appear in the list")
    public void thePositionCategoryShouldAppearInTheList() {
        page.searchBarInput.sendKeys(randomName);
        page.searchButton.click();
        Tools.waitUntilLoading();

        Assert.assertEquals(page.searchResultNoMatch.size(), 0);
    }

    @When("an existing position category edited")
    public void anExistingPositionCategoryEdited() {
        wait.until(ExpectedConditions.elementToBeClickable(page.searchBarInput)).sendKeys(randomName);
        page.searchButton.click();
        Tools.waitUntilLoading();

        page.editButton.click();
        Tools.waitPopUp();

        randomName = RandomStringUtils.randomAlphanumeric(8);
        page.nameInput.clear();
        page.nameInput.sendKeys(randomName);

        page.saveButton.click();
        Tools.waitUntilLoading();

        page.searchBarInput.clear();
        page.searchBarInput.sendKeys(randomName);
        page.searchButton.click();
        Tools.waitUntilLoading();
    }

    @Then("the position category should have changed")
    public void thePositionCategoryShouldHaveChanged() {
        Assert.assertEquals(page.searchResultNoMatch.size(), 0);
    }

    @When("an existing position category deleted")
    public void anExistingPositionCategoryDeleted() {
        wait.until(ExpectedConditions.elementToBeClickable(page.searchBarInput)).sendKeys(randomName);
        page.searchButton.click();
        Tools.waitUntilLoading();

        page.deleteButton.click();
        Tools.waitPopUp();
        page.deleteButtonConfirm.click();
        Tools.waitUntilLoading();
    }

    @Then("the position category should be removed from the list")
    public void thePositionCategoryShouldBeRemovedFromTheList() {
        page.searchButton.click();
        Tools.waitUntilLoading();

        wait.until(ExpectedConditions.visibilityOfAllElements(page.searchResultNoMatch));
        Assert.assertEquals(page.searchResultNoMatch.size(), 1);
    }
}
