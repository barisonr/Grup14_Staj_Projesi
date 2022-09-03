package Steps;

import Pages.LoginPage;
import Utils.DriverManager;
import Utils.Tools;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Login_Steps {
    LoginPage loginPage = new LoginPage();
    WebDriver driver = DriverManager.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
    @Given("User successfully logged in as Admin")
    public void userSuccessfullyLoggedInAsAdmin() {
        driver.get("https://demo.mersys.io/");

        Tools.waitUntilLoading();

        wait.until(ExpectedConditions.elementToBeClickable(loginPage.username));
        loginPage.username.sendKeys("richfield.edu");
        loginPage.password.sendKeys("Richfield2020!");

        loginPage.loginButton.click();
    }
}
