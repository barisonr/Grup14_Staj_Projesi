package Pages;

import Utils.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DescriptionPage {
    public DescriptionPage() {
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
    @FindBy(css = "ms-text-field[formcontrolname='description']>input")
    public WebElement descriptionInput;
    @FindBy(css = "ms-text-field[formcontrolname='code']>input")
    public WebElement descriptionCodeInput;
    @FindBy(css = "ms-integer-field[formcontrolname='priority']>input")
    public WebElement priorityInput;
    @FindBy(css = "ms-text-field[placeholder='DISCOUNT.TITLE.DESCRIPTION']>input")
    public WebElement descriptionSearchInput;
    @FindBy(css = "ms-text-field[placeholder='GENERAL.FIELD.CODE']>input")
    public WebElement codeSearchInput;
    @FindBy(xpath = "[id='mat-slide-toggle-25-input']~span")
    public WebElement checkbox;


}

