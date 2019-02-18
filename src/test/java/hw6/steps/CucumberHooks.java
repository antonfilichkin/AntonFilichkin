package hw6.steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static enums.URLs.HOME_PAGE;

public class CucumberHooks {
    private static final String START_PAGE = HOME_PAGE.getUrl();

    @Before
    public void openTestSiteByURL() {
        open(START_PAGE);
        getWebDriver().manage().window().maximize(); //Force fullscreen
    }

    @After
    public void after() {
        close();
    }
}