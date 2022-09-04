package Utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Tools {
    public static void waitUntilLoading() {
        WebDriverWait wait = new WebDriverWait(DriverManager.driver, Duration.ofSeconds(120));
        wait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector("fuse-progress-bar > *"), 0));
    }

    public static void navigateToMenu(WebElement... menu) {
        FluentWait<WebDriver> wait = new FluentWait<>(DriverManager.driver);
        wait.withTimeout(Duration.ofSeconds(30));
        wait.pollingEvery(Duration.ofMillis(10));
        wait.ignoring(StaleElementReferenceException.class, NoSuchElementException.class);

        for (int i = 0; i < menu.length; i++) {

            if (i == 0) {
                wait.until(ExpectedConditions.elementToBeClickable(menu[i]));
            } else {
                wait.until(ExpectedConditions.or(
                        ExpectedConditions.elementToBeClickable(menu[i]),
                        ExpectedConditions.not(ExpectedConditions.attributeContains(menu[0], "class", "open"))));

                if (!menu[0].getAttribute("class").contains("open")) {
                    i = -1;
                    continue;
                }
            }

            menu[i].click();
        }
    }
    public static void waitPopUp() {
        WebDriverWait wait = new WebDriverWait(DriverManager.driver, Duration.ofSeconds(120));
        wait.until(ExpectedConditions.attributeContains(By.className("cdk-overlay-pane"), "style", "static"));
    }
}
