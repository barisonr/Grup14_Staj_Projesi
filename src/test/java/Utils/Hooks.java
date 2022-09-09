package Utils;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
    @Before
    public void before() {
        DriverManager.setupDriver();
    }

    @After
    public void after() {
        DriverManager.quitDriver();
    }
}
