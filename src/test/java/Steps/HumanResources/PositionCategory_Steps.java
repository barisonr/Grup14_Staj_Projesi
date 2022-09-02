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
    PositionCategories_Page positionCategoriesPage = new PositionCategories_Page();
    WebDriver driver = DriverManager.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
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
        wait.until(ExpectedConditions.elementToBeClickable
                        (positionCategoriesPage.addButton))
                .click();

        randomName = RandomStringUtils.randomAlphanumeric(8);
        wait.until(ExpectedConditions.elementToBeClickable
                        (positionCategoriesPage.nameInput))
                .sendKeys(randomName);

        positionCategoriesPage.saveButton.click();

        Tools.waitUntilLoading();
    }

    @Then("the position category should appear in the list")
    public void thePositionCategoryShouldAppearInTheList() {
        positionCategoriesPage.searchBarInput.sendKeys(randomName);
        positionCategoriesPage.searchButton.click();

        Tools.waitUntilLoading();

        Assert.assertEquals(positionCategoriesPage.searchResultNoMatch.size(), 0);
    }

    @When("an existing position category edited")
    public void anExistingPositionCategoryEdited() {
        wait.until(ExpectedConditions.elementToBeClickable
                        (positionCategoriesPage.searchBarInput))
                .sendKeys(randomName);

        positionCategoriesPage.searchButton.click();

        Tools.waitUntilLoading();

        positionCategoriesPage.editButton.click();

        randomName = RandomStringUtils.randomAlphanumeric(8);

        wait.until(ExpectedConditions.elementToBeClickable
                        (positionCategoriesPage.nameInput))
                .clear();

        positionCategoriesPage.nameInput.sendKeys(randomName);

        positionCategoriesPage.saveButton.click();

        Tools.waitUntilLoading();

        positionCategoriesPage.searchBarInput.clear();
        positionCategoriesPage.searchBarInput.sendKeys(randomName);
        positionCategoriesPage.searchButton.click();

        Tools.waitUntilLoading();
    }

    @Then("the position category should have changed")
    public void thePositionCategoryShouldHaveChanged() {
        Assert.assertEquals(positionCategoriesPage.searchResultNoMatch.size(), 0);
    }

    @When("an existing position category deleted")
    public void anExistingPositionCategoryDeleted() {
        wait.until(ExpectedConditions.elementToBeClickable
                        (positionCategoriesPage.searchBarInput))
                .sendKeys(randomName);

        positionCategoriesPage.searchButton.click();
        Tools.waitUntilLoading();

        positionCategoriesPage.deleteButton.click();
        wait.until(ExpectedConditions.elementToBeClickable
                        (positionCategoriesPage.deleteButtonConfirm))
                .click();

        Tools.waitUntilLoading();
    }

    @Then("the position category should be removed from the list")
    public void thePositionCategoryShouldBeRemovedFromTheList() {
        positionCategoriesPage.searchButton.click();
        Tools.waitUntilLoading();

        Assert.assertEquals(positionCategoriesPage.searchResultNoMatch.size(), 1);
    }
}
