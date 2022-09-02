package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/resources/Features/"},
        glue = {"Steps", "Utils"}
)

public class Runner extends AbstractTestNGCucumberTests {
}
