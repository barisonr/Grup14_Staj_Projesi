package Pages;

import Utils.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SideNav {
    public SideNav() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    @FindBy(xpath = "//span[text()='Setup']/../..")
    public WebElement Setup;

    @FindBy(xpath = "//span[text()='Parameters']/../..")
    public WebElement Setup_Parameters;

    @FindBy(xpath = "//span[text()='Nationalities']/../..")
    public WebElement Setup_Parameters_Nationalities;

    @FindBy(xpath = "//span[text()='Discounts']/../..")
    public WebElement Setup_Parameters_Discounts;

    @FindBy(xpath = "//span[text()='Grade Levels']/../..")
    public WebElement Setup_Parameters_GradeLevels;

    @FindBy(xpath = "//span[text()='Document Types']/../..")
    public WebElement Setup_Parameters_DocumentTypes;

    @FindBy(xpath = "//span[text()='Bank Accounts']/../..")
    public WebElement Setup_Parameters_BankAccounts;

    @FindBy(xpath = "//span[text()='Fields']/../..")
    public WebElement Setup_Parameters_Fields;

    @FindBy(xpath = "//span[text()='School Setup']/../..")
    public WebElement Setup_SchoolSetup;

    @FindBy(xpath = "//span[text()='Locations']/../..")
    public WebElement Setup_SchoolSetup_Locations;

    @FindBy(xpath = "//span[text()='Departments']/../..")
    public WebElement Setup_SchoolSetup_Departments;

    @FindBy(xpath = "//span[text()='Human Resources']/../..")
    public WebElement HumanResources;

    @FindBy(xpath = "(//span[text()='Setup'])[3]/../..")
    public WebElement HumanResources_Setup;

    @FindBy(xpath = "//span[text()='Positions']/../..")
    public WebElement HumanResources_Setup_Positions;

    @FindBy(xpath = "//span[text()='Position Categories']/../..")
    public WebElement HumanResources_Setup_PositionCategories;

    @FindBy(xpath = "//span[text()='Attestations']/../..")
    public WebElement HumanResources_Setup_Attestations;

    @FindBy(xpath = "//span[text()='Education']/../..")
    public WebElement Education;

    @FindBy(xpath = "(//span[text()='Setup'])[4]/../..")
    public WebElement Education_Setup;

    @FindBy(xpath = "//span[text()='Subject Categories']/../..")
    public WebElement Education_Setup_SubjectCategories;
}
