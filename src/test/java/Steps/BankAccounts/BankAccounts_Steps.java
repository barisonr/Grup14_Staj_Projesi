package Steps.BankAccounts;

import Pages.BankAccounts.BankAccountsPage;
import Pages.SetupFields.FieldsPage;
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

public class BankAccounts_Steps {
    SideNav sideNav = new SideNav();
    BankAccountsPage bankAccountsPage=new BankAccountsPage();
    WebDriver driver = DriverManager.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
    static String randomName;



    @And("navigated to Bank Accounts")
    public void navigatedToBankAccounts() {
        Tools.navigateToMenu(
                sideNav.Setup,
                sideNav.Setup_Parameters,
                sideNav.Setup_Parameters_BankAccounts
        );
        Tools.waitUntilLoading();

    }

    @When("A new Bank Accounts is created")
    public void aNewBankAccountsIsCreated() {
        wait.until(ExpectedConditions.elementToBeClickable(bankAccountsPage.addButton)).click();
        Tools.waitPopUp();

        randomName = RandomStringUtils.randomAlphanumeric(10);
        bankAccountsPage.nameInput.sendKeys(randomName);
        bankAccountsPage.iban.sendKeys("KZ563190000012344567");
        bankAccountsPage.currency.click();
        wait.until(ExpectedConditions.elementToBeClickable(bankAccountsPage.OP)).click();
        bankAccountsPage.integrationcod.sendKeys("1234");
        Tools.waitPopUp();
        bankAccountsPage.saveButton.click();
        Tools.waitUntilLoading();
    }

    @Then("the Bank Account  should appear in the list")
    public void theBankAccountShouldAppearInTheList() {
        bankAccountsPage.searchBarInput.sendKeys(randomName);
        bankAccountsPage.searchButton.click();
        Tools.waitUntilLoading();

        Assert.assertEquals(bankAccountsPage.searchResultNoMatch.size(),0);

    }

    @When("edited an existing bank account")
    public void editedAnExistingBankAccount() {
        wait.until(ExpectedConditions.elementToBeClickable(bankAccountsPage.searchBarInput)).sendKeys(randomName);
        bankAccountsPage.searchButton.click();
        Tools.waitUntilLoading();

       bankAccountsPage.editButton.click();
        Tools.waitPopUp();

        randomName = RandomStringUtils.randomAlphanumeric(8);
        bankAccountsPage.nameInput.clear();
        bankAccountsPage.nameInput.sendKeys(randomName);

        bankAccountsPage.iban.clear();
        bankAccountsPage.iban.sendKeys("TR37527628872982082922");

        bankAccountsPage.integrationcod.clear();
        bankAccountsPage.integrationcod.sendKeys("4321");

        bankAccountsPage.currency.click();
        wait.until(ExpectedConditions.elementToBeClickable(bankAccountsPage.OP)).click();

        bankAccountsPage.saveButton.click();
        Tools.waitUntilLoading();

        bankAccountsPage.searchBarInput.clear();
        bankAccountsPage.searchBarInput.sendKeys(randomName);
        bankAccountsPage.searchButton.click();
        Tools.waitUntilLoading();
    }

    @Then("the bank account should have changed")
    public void theBankAccountShouldHaveChanged() {
        Assert.assertEquals(bankAccountsPage.searchResultNoMatch.size(), 0);
    }

    @When("an existing bank account deleted")
    public void anExistingBankAccountDeleted() {
        wait.until(ExpectedConditions.elementToBeClickable(bankAccountsPage.searchBarInput)).sendKeys(randomName);
        bankAccountsPage.searchButton.click();
        Tools.waitUntilLoading();

        bankAccountsPage.deleteButton.click();
        Tools.waitPopUp();
        bankAccountsPage.deleteButtonConfirm.click();
        Tools.waitUntilLoading();
    }

    @Then("the bank account should be removed from the list")
    public void theBankAccountShouldBeRemovedFromTheList() {
        bankAccountsPage.searchButton.click();
        Tools.waitUntilLoading();

        wait.until(ExpectedConditions.visibilityOfAllElements(bankAccountsPage.searchResultNoMatch));
        Assert.assertEquals(bankAccountsPage.searchResultNoMatch.size(), 1);

    }
}
