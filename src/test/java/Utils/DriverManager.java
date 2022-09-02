package Utils;

import org.openqa.selenium.WebDriver;


public class DriverManager {
    static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    public static void quitDriver() {
        if (driver != null)
            driver.quit();
    }

    public static void bekle(int saniye) {
        try {
            Thread.sleep(saniye * 1000L);
        } catch (InterruptedException ignored) {
        }
    }
}
