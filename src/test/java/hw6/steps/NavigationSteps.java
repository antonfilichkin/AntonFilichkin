package hw6.steps;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import enums.URLs;

import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class NavigationSteps {
    @Given("^I am on \"([^\"]*)\"$")
    @When("^I open test site by URL \"([^\"]*)\"$")
    public void openTestSiteByURL(URLs url) {
        open(url.getUrl());
        getWebDriver().manage().window().maximize(); //Force fullscreen
    }

    @After
    public void after(){
        close();
    }
}