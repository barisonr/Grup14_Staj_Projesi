package Steps.SubjectCategories;

import Pages.HumanResources.PositionCategories_Page;
import Pages.SideNav;
import Pages.SubjectCategories.SubjectCategories_Page;
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

public class SubjectCategories_Steps {

    SideNav sideNav = new SideNav();
    SubjectCategories_Page page = new SubjectCategories_Page();
    WebDriver driver = DriverManager.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));

    static String randomName;
    static String randomCode;

    @And("navigated to Subject Categories page")
    public void navigatedToSubjectCategoriesPage() {

        Tools.navigateToMenu(
                sideNav.Education,
                sideNav.Education_Setup,
                sideNav.Education_Setup_SubjectCategories);
        Tools.waitUntilLoading();
    }

    @When("a new subject category is created")
    public void aNewSubjectCategoryIsCreated() {
        wait.until(ExpectedConditions.elementToBeClickable(page.addButton)).click();
        Tools.waitPopUp();

        randomName = RandomStringUtils.randomAlphanumeric(8);
        wait.until(ExpectedConditions.elementToBeClickable(page.nameInput))
                .sendKeys(randomName);

        randomCode = RandomStringUtils.randomNumeric(4);
        wait.until(ExpectedConditions.elementToBeClickable(page.codeInput))
                .sendKeys(randomCode);

        page.saveButton.click();

        Tools.waitUntilLoading();
    }

    @Then("the subject category should appear in the list")
    public void theSubjectCategoryShouldAppearInTheList() {
        page.searchBarInput.sendKeys(randomName);
        page.searchBarCodeInput.sendKeys(randomCode);
        page.searchButton.click();

        Tools.waitUntilLoading();

        Assert.assertEquals(page.searchResultNoMatch.size(), 0);
    }

    @When("an existing subject category edited")
    public void anExistingSubjectCategoryEdited() {

        wait.until(ExpectedConditions.elementToBeClickable(page.searchBarInput)).sendKeys(randomName);

        wait.until(ExpectedConditions.elementToBeClickable(page.searchBarCodeInput)).sendKeys(randomCode);

        page.searchButton.click();
        Tools.waitUntilLoading();

        page.editButton.click();
        Tools.waitPopUp();

        randomName = RandomStringUtils.randomAlphanumeric(8);
        page.nameInput.clear();
        page.nameInput.sendKeys(randomName);

        randomCode = RandomStringUtils.randomNumeric(4);
        page.codeInput.clear();
        page.codeInput.sendKeys(randomCode);

        page.saveButton.click();
        Tools.waitUntilLoading();

        page.searchBarInput.clear();
        page.searchBarCodeInput.clear();
        page.searchBarInput.sendKeys(randomName);
        page.searchBarCodeInput.sendKeys(randomCode);
        page.searchButton.click();
        Tools.waitUntilLoading();
    }

    @Then("the subject category should have changed")
    public void theSubjectCategoryShouldHaveChanged() { Assert.assertEquals(page.searchResultNoMatch.size(), 0);}

    @When("an existing subject category deleted")
    public void anExistingSubjectCategoryDeleted() {

        wait.until(ExpectedConditions.elementToBeClickable(page.searchBarInput)).sendKeys(randomName);

        wait.until(ExpectedConditions.elementToBeClickable(page.searchBarCodeInput)).sendKeys(randomCode);

        page.searchButton.click();
        Tools.waitUntilLoading();

        page.deleteButton.click();
        Tools.waitPopUp();
        page.deleteButtonConfirm.click();
        Tools.waitUntilLoading();
    }

    @Then("the subject category should be removed from the list")
    public void theSubjectCategoryShouldBeRemovedFromTheList() {
        page.searchButton.click();
        Tools.waitUntilLoading();

        wait.until(ExpectedConditions.visibilityOfAllElements(page.searchResultNoMatch));
        Assert.assertEquals(page.searchResultNoMatch.size(), 1);
    }
}
