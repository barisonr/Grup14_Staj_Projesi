package Pages.HumanResources;

import Utils.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PositionCategories_Page {
    public PositionCategories_Page() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    @FindBy(css = "ms-add-button button")
    public WebElement addButton;

    @FindBy(css = "ms-edit-button button")
    public WebElement editButton;

    @FindBy(css = "ms-delete-button button")
    public WebElement deleteButton;

    @FindBy(css = "button[type='submit']")
    public WebElement deleteButtonConfirm;

    @FindBy(css = "ms-text-field[formcontrolname='name'] > input")
    public WebElement nameInput;

    @FindBy(css = "ms-save-button > button")
    public WebElement saveButton;

    @FindBy(css = "ms-search-button")
    public WebElement searchButton;

    @FindBy(css = "ms-text-field[placeholder='GENERAL.FIELD.NAME'] > input")
    public WebElement searchBarInput;

    @FindBy(css = "tbody [class*='mat-no-data-row']")
    public List<WebElement> searchResultNoMatch;
}
