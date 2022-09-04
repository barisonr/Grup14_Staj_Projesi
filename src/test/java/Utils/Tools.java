package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Tools {
    public static void waitUntilLoading() {
        WebDriverWait wait = new WebDriverWait(DriverManager.driver, Duration.ofSeconds(120));
        wait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector("fuse-progress-bar > *"), 0));
    }

    public static void navigateToMenu(WebElement menu) {
        WebDriverWait wait = new WebDriverWait(DriverManager.driver, Duration.ofSeconds(120));
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(menu)));
        menu.click();

        List<WebElement> animateDiv = menu.findElements(By.tagName("div"));

        if (animateDiv.size() > 0) {
            wait.until(ExpectedConditions
                    .refreshed(ExpectedConditions.attributeContains(animateDiv.get(0), "class", "ng-animating")));

            wait.until(ExpectedConditions.refreshed
                    (ExpectedConditions.not
                            (ExpectedConditions.attributeContains(animateDiv.get(0), "class", "ng-animating"))));
        }
    }
    public static void waitPopUp() {
        WebDriverWait wait = new WebDriverWait(DriverManager.driver, Duration.ofSeconds(120));
        wait.until(ExpectedConditions.attributeContains(By.className("cdk-overlay-pane"), "style", "static"));
    }
}
