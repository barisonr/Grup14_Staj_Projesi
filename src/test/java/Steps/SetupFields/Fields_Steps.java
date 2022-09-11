package Steps.SetupFields;

import Pages.SetupFields.FieldsPage;
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

public class Fields_Steps {
    SideNav sideNav = new SideNav();
    FieldsPage fieldsPage=new FieldsPage();
    WebDriver driver = DriverManager.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
    static String randomName;

    @And("navigated to Fields Page")
    public void navigatedToFieldsPage() {
        Tools.navigateToMenu(
                sideNav.Setup,
                sideNav.Setup_Parameters,
                sideNav.Setup_Parameters_Fields
        );
        Tools.waitUntilLoading();
    }

    @When("A new field is created")
    public void aNewFieldIsCreated() {
        wait.until(ExpectedConditions.elementToBeClickable(fieldsPage.addButton)).click();
        Tools.waitPopUp();

        randomName = RandomStringUtils.randomAlphanumeric(10);
        fieldsPage.nameInput.sendKeys(randomName);
        fieldsPage.saveButton.click();
        Tools.waitUntilLoading();

    }

    @Then("the fields  should appear in the list")
    public void theFieldsShouldAppearInTheList() {
        fieldsPage.searchBarInput.sendKeys(randomName);
        fieldsPage.searchButton.click();
        Tools.waitUntilLoading();

        Assert.assertEquals(fieldsPage.searchResultNoMatch.size(),0);

    }


    @When("edited an existing field")
    public void editedAnExistingField() {
        wait.until(ExpectedConditions.elementToBeClickable(fieldsPage.searchBarInput)).sendKeys(randomName);
        fieldsPage.searchButton.click();
        Tools.waitUntilLoading();

        fieldsPage.editButton.click();
        Tools.waitPopUp();

        randomName = RandomStringUtils.randomAlphanumeric(8);
        fieldsPage.nameInput.clear();
        fieldsPage.nameInput.sendKeys(randomName);

        fieldsPage.saveButton.click();
        Tools.waitUntilLoading();

        fieldsPage.searchBarInput.clear();
        fieldsPage.searchBarInput.sendKeys(randomName);
        fieldsPage.searchButton.click();
        Tools.waitUntilLoading();

    }

    @Then("the fields should have changed")
    public void theFieldsShouldHaveChanged() {
        Assert.assertEquals(fieldsPage.searchResultNoMatch.size(), 0);
    }

    @When("an existing field deleted")
    public void anExistingFieldDeleted() {
        wait.until(ExpectedConditions.elementToBeClickable(fieldsPage.searchBarInput)).sendKeys(randomName);
        fieldsPage.searchButton.click();
        Tools.waitUntilLoading();

        fieldsPage.deleteButton.click();
        Tools.waitPopUp();
        fieldsPage.deleteButtonConfirm.click();
        Tools.waitUntilLoading();

    }

    @Then("the fields should be removed from the list")
    public void theFieldsShouldBeRemovedFromTheList() {
        fieldsPage.searchButton.click();
        Tools.waitUntilLoading();

        wait.until(ExpectedConditions.visibilityOfAllElements(fieldsPage.searchResultNoMatch));
        Assert.assertEquals(fieldsPage.searchResultNoMatch.size(), 1);

    }
}
