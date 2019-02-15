package runners;

import com.codeborne.selenide.Configuration;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.BeforeSuite;

@CucumberOptions(
        features = "classpath:hw6",
        glue = "classpath:hw6.steps"
)

public class CucumberRunner extends AbstractTestNGCucumberTests {
    @BeforeSuite(groups = {"Config"})
    public void beforeSuite() {
        Configuration.startMaximized = true;
        Configuration.timeout = 5000;
        Configuration.pollingInterval = 300;
    }
}

