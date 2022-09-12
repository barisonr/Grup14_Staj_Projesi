package Pages;

import Utils.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class GradeLevels_Page {
    public GradeLevels_Page() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    @FindBy(css = "ms-add-button button")
    public WebElement addButton;

    @FindBy(css = "button[type='submit']")
    public WebElement deleteButtonConfirm;

    @FindBy(css = "ms-text-field[formcontrolname='name'] > input")
    public WebElement nameInput;

    @FindBy(css = "ms-text-field[formcontrolname='shortName'] > input")
    public WebElement shortNameInput;

    @FindBy(css = "ms-text-field[formcontrolname='order'] > input")
    public WebElement orderInput;

    @FindBy(css = "ms-save-button > button")
    public WebElement saveButton;

    @FindBy(css = "tbody[role='rowgroup'] > tr")
    public List<WebElement> allGradeLevels;
}
