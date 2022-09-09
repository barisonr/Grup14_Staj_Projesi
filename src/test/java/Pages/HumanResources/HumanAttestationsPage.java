package Pages.HumanResources;

import Utils.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HumanAttestationsPage {
    public HumanAttestationsPage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    @FindBy(xpath = "//ms-add-button[contains(@tooltip,'TITLE.ADD')]//button")
    public WebElement addButton;
    @FindBy(css = "ms-text-field[formcontrolname='name'] > input")
    public WebElement nameInput;
    @FindBy(xpath = "//ms-save-button//button")
    public WebElement saveButton;
    @FindBy(xpath = "//div[contains(text(),'successfully')]")
    public WebElement successMessage;
    @FindBy(css = "ms-text-field[placeholder='GENERAL.FIELD.NAME'] > input")
    public WebElement searchBarInput;
    @FindBy(css = "ms-search-button")
    public WebElement searchButton;
    @FindBy(css = "ms-edit-button button")
    public WebElement editButton;
    @FindBy(css = "ms-delete-button button")
    public WebElement deleteButton;
    @FindBy(css = "button[type='submit']")
    public WebElement deleteButtonConfirm;


}