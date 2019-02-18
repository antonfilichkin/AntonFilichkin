package hw6.steps.homePage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import enums.ServiceDropdownItems;
import enums.URLs;
import enums.Users;
import pages.hw6.HomePage;

import java.util.List;

import static com.codeborne.selenide.Selenide.page;

public class AssertionSteps {
    private HomePage homePage = page(HomePage.class);

    @Given("^I am on \"([^\"]*)\"$")
    @Then("^Browser title is \"([^\"]*)\"$")
    public void browserTitleIs(URLs url) {
        homePage.assertBrowserTitle(url);
    }

    @Then("^Username in the right-top side of screen is \"([^\"]*)\"$")
    public void usernameShouldBe(String name) {
        Users user = Users.userByName(name);
        homePage.assertUserName(user);
    }

    @Then("^Home page have to contain all elements$")
    public void homePageHaveToContainAllElements() {
        homePage.checkInterface();
    }

    @Then("^Header dropdown contains options:$")
    public void headerDropdownContainsOptions(List<ServiceDropdownItems> options) {
        ServiceDropdownItems[] items = options.toArray(new ServiceDropdownItems[0]);
        homePage.assertTopMenuServiceDropdownElements(items);
    }

    @Then("^Left menu dropdown contains options:$")
    public void leftMenuDropdownContainsOptions(List<ServiceDropdownItems> options) {
        ServiceDropdownItems[] items = options.toArray(new ServiceDropdownItems[0]);
        homePage.assertLeftSectionServiceDropdown(items);
    }
}