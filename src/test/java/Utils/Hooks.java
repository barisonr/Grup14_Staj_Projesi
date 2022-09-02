package Utils;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Hooks {
    @Before
    public void before() {
        Logger.getLogger("").setLevel(Level.SEVERE);
        System.setProperty(org.slf4j.impl.SimpleLogger.DEFAULT_LOG_LEVEL_KEY, "Error");
        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");

        WebDriverManager.chromedriver().setup();
        DriverManager.driver = new ChromeDriver();
        DriverManager.getDriver().manage().window().maximize();
    }

    @After
    public void after() {
        DriverManager.quitDriver();
    }
}
