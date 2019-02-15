package hw6.steps.homePage;

import cucumber.api.java.en.Then;
import enums.ServiceDropdownItems;
import enums.URLs;
import enums.Users;
import pages.hw6.HomePage;

import java.util.List;

public class AssertionSteps {
    @Then("^Browser title is \"([^\"]*)\"$")
    public void browserTitleIs(URLs url) {
        new HomePage().assertBrowserTitle(url);
    }

    @Then("^Username in the right-top side of screen is \"([^\"]*)\"$")
    public void usernameShouldBe(String name) {
        Users user = Users.userByName(name);
        new HomePage().assertUserName(user);
    }

    @Then("^Home page have to contain all elements$")
    public void homePageHaveToContainAllElements() {
        new HomePage().checkInterface();
    }

    @Then("^Header dropdown contains options:$")
    public void headerDropdownContainsOptions(List<ServiceDropdownItems> options) {
        ServiceDropdownItems[] items = options.toArray(new ServiceDropdownItems[0]);
        new HomePage().assertTopMenuServiceDropdownElements(items);
    }

    @Then("^Left menu dropdown contains options:$")
    public void leftMenuDropdownContainsOptions(List<ServiceDropdownItems> options) {
        ServiceDropdownItems[] items = options.toArray(new ServiceDropdownItems[0]);
        new HomePage().assertLeftSectionServiceDropdown(items);
    }
}