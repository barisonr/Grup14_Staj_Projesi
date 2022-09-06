package Pages;

import Utils.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HRPositionsPage {

   public HRPositionsPage(){ PageFactory.initElements(DriverManager.getDriver(),this);}

    @FindBy(xpath = "//button[text()='Accept all cookies']")
    public WebElement cookies;

    @FindBy(xpath="//ms-add-button[contains(@tooltip,'TITLE.ADD')]//button")
    public WebElement addButton;

    @FindBy(xpath = "//ms-text-field[@formcontrolname='name']//input")
    public WebElement nameInput;

    @FindBy(xpath = "//ms-text-field[@formcontrolname='shortName']//input")
    public WebElement shortNameInput;

    @FindBy(xpath = "//ms-save-button//button")
    public WebElement saveButton;

    @FindBy(xpath = "//div[contains(text(),'successfully')]")
    public WebElement successMessage;

    @FindBy(xpath = "//ms-text-field[contains(@placeholder,'NAME')]//input")
    public WebElement searchNameInput;

    @FindBy(xpath = "//ms-search-button//button")
    public WebElement searchButton;

    @FindBy(xpath = "//ms-edit-button[contains(@class,'ng-star')]//button")
    public WebElement editButton;

    @FindBy(xpath = "//ms-delete-button//button")
    public WebElement deleteButton;

    @FindBy(xpath = "//span[contains(text(),'Delete')]" )
    public WebElement hrPageDeleteButton;

}
