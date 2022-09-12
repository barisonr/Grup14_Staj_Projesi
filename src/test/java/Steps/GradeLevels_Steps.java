package Steps;

import Pages.GradeLevels_Page;
import Pages.SideNav;
import Utils.DriverManager;
import Utils.Tools;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class GradeLevels_Steps {
    SideNav sideNav = new SideNav();
    GradeLevels_Page page = new GradeLevels_Page();
    WebDriver driver = DriverManager.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
    static String randomName;
    static String randomShortName;
    static String randomOrder;
    static WebElement gradeLevelElement;

    @And("navigated to Grade Levels page")
    public void navigatedToGradeLevelsPage() {
        Tools.navigateToMenu(
                sideNav.Setup,
                sideNav.Setup_Parameters,
                sideNav.Setup_Parameters_GradeLevels);
        Tools.waitUntilLoading();
    }

    @When("a new grade level is created")
    public void aNewGradeLevelIsCreated() {
        waitUntilListLoading();
        page.addButton.click();
        Tools.waitPopUp();

        randomName = RandomStringUtils.randomAlphanumeric(8);
        randomShortName = RandomStringUtils.randomAlphanumeric(3);
        randomOrder = RandomStringUtils.random(1, "123456789");

        page.nameInput.sendKeys(randomName);
        page.shortNameInput.sendKeys(randomShortName);
        page.orderInput.sendKeys(randomOrder);

        page.saveButton.click();
        Tools.waitUntilLoading();
    }

    @Then("the grade level should appear in the list")
    public void theGradeLevelShouldAppearInTheList() {
        waitUntilElementListed(randomName);
        Assert.assertNotNull(getElement(randomName, randomShortName, randomOrder));
    }

    @When("an existing grade level edited")
    public void anExistingGradeLevelEdited() {
        waitUntilListLoading();
        getEditButton().click();
        Tools.waitPopUp();

        randomName = RandomStringUtils.randomAlphanumeric(8);
        randomShortName = RandomStringUtils.randomAlphanumeric(3);
        randomOrder = RandomStringUtils.random(1, "123456789");

        page.nameInput.clear();
        page.nameInput.sendKeys(randomName);

        page.shortNameInput.clear();
        page.shortNameInput.sendKeys(randomShortName);

        page.orderInput.clear();
        page.orderInput.sendKeys(randomOrder);

        page.saveButton.click();
        Tools.waitUntilLoading();
    }

    @Then("the grade level should have changed")
    public void theGradeLevelShouldHaveChanged() {
        waitUntilElementListed(randomName);
        Assert.assertNotNull(getElement(randomName, randomShortName, randomOrder));
    }

    @When("an existing grade level deleted")
    public void anExistingGradeLevelDeleted() {
        waitUntilListLoading();
        gradeLevelElement = getElement(randomName, randomShortName, randomOrder);
        getDeleteButton().click();
        Tools.waitPopUp();

        page.deleteButtonConfirm.click();
        Tools.waitUntilLoading();
    }

    @Then("the grade level should be removed from the list")
    public void theGradeLevelShouldBeRemovedFromTheList() {
        wait.until(ExpectedConditions.stalenessOf(gradeLevelElement));
        Assert.assertNull(getElement(randomName, randomShortName, randomOrder));
    }

    public WebElement getElement(String name, String shortName, String order) {
        for (WebElement gradeLevel : page.allGradeLevels) {
            String gradeName = wait.until(ExpectedConditions
                    .presenceOfNestedElementLocatedBy(gradeLevel, By.cssSelector("td:nth-child(2)"))).getText();
            String gradeShortName = gradeLevel.findElement(By.cssSelector("td:nth-child(3)")).getText();
            String gradeOrder = gradeLevel.findElement(By.cssSelector("td:nth-child(5)")).getText();

            if (gradeName.equals(name) && gradeShortName.equals(shortName) && gradeOrder.equals(order)) {
                return gradeLevel;
            }
        }
        return null;
    }

    private WebElement getEditButton() {
        return getElement(randomName, randomShortName, randomOrder)
                .findElement(By.cssSelector("ms-edit-button"));
    }

    private WebElement getDeleteButton() {
        return getElement(randomName, randomShortName, randomOrder)
                .findElement(By.cssSelector("ms-delete-button"));
    }

    private void waitUntilElementListed(String name) {
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(
                By.xpath("//tbody//td[2][text()='" + name + "']"), 0));
    }

    private void waitUntilListLoading() {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("tbody[role='rowgroup'] > tr")));
    }
}
