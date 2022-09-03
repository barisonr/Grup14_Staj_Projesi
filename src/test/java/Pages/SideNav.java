package Pages;

import Utils.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SideNav {
    public SideNav() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    @FindBy(xpath = "//fuse-nav-vertical-collapsable")
    public WebElement Setup;

    @FindBy(xpath = "(//fuse-nav-vertical-collapsable)[2]")
    public WebElement Setup_Parameters;

    @FindBy(xpath = "(//fuse-nav-vertical-collapsable)[2]//fuse-nav-vertical-item[5]")
    public WebElement Setup_Parameters_Nationalities;

    @FindBy(xpath = "(//fuse-nav-vertical-collapsable)[2]//fuse-nav-vertical-item[7]")
    public WebElement Setup_Parameters_Discounts;

    @FindBy(xpath = "(//fuse-nav-vertical-collapsable)[2]//fuse-nav-vertical-item[8]")
    public WebElement Setup_Parameters_GradeLevels;

    @FindBy(xpath = "(//fuse-nav-vertical-collapsable)[2]//fuse-nav-vertical-item[9]")
    public WebElement Setup_Parameters_DocumentTypes;

    @FindBy(xpath = "(//fuse-nav-vertical-collapsable)[2]//fuse-nav-vertical-item[10]")
    public WebElement Setup_Parameters_BankAccounts;

    @FindBy(xpath = "(//fuse-nav-vertical-collapsable)[2]//fuse-nav-vertical-item[11]")
    public WebElement Setup_Parameters_Fields;

    @FindBy(xpath = "(//fuse-nav-vertical-collapsable)[3]")
    public WebElement Setup_SchoolSetup;

    @FindBy(xpath = "(//fuse-nav-vertical-collapsable)[3]//fuse-nav-vertical-item[4]")
    public WebElement Setup_SchoolSetup_Locations;

    @FindBy(xpath = "(//fuse-nav-vertical-collapsable)[3]//fuse-nav-vertical-item[5]")
    public WebElement Setup_SchoolSetup_Departments;

    @FindBy(xpath = "(//fuse-nav-vertical-collapsable)[11]")
    public WebElement HumanResources;

    @FindBy(xpath = "(//fuse-nav-vertical-collapsable)[12]")
    public WebElement HumanResources_Setup;

    @FindBy(xpath = "(//fuse-nav-vertical-collapsable)[12]//fuse-nav-vertical-item")
    public WebElement HumanResources_Setup_Positions;

    @FindBy(xpath = "(//fuse-nav-vertical-collapsable)[12]//fuse-nav-vertical-item[4]")
    public WebElement HumanResources_Setup_PositionCategories;

    @FindBy(xpath = "(//fuse-nav-vertical-collapsable)[12]//fuse-nav-vertical-item[3]")
    public WebElement HumanResources_Setup_Attestations;

    @FindBy(xpath = "(//fuse-nav-vertical-collapsable)[16]")
    public WebElement Education;

    @FindBy(xpath = "(//fuse-nav-vertical-collapsable)[17]")
    public WebElement Education_Setup;

    @FindBy(xpath = "(//fuse-nav-vertical-collapsable)[17]//fuse-nav-vertical-item")
    public WebElement Education_Setup_SubjectCategories;
}
