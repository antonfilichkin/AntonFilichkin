package hw6.steps.userTablePage;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import enums.URLs;
import enums.UserTablePageElements;
import enums.UserTablePageTableValues;
import pages.hw6.HomePage;
import pages.hw6.UserTablePage;

import java.util.List;

public class AssertionSteps {
    @Then("^\"([^\"]*)\" is opened$")
    public void browserTitleIs(URLs url) {
        new HomePage().assertBrowserTitle(url);
    }

    @Then("^(\\d+) \"([^\"]*)\" .*are displayed on Users Table on User Table Page$")
    public void areDisplayedOnUsersTableOnUserTablePage(int quantity, UserTablePageElements element) {
        new UserTablePage().checkInterface(element, quantity);
    }

    @Then("^User table contains following values:$")
    public void userTableContainsFollowingValues(DataTable values) {
        new UserTablePage().assertTableContents(values.raw());
    }

    @Then("^1 log row has \"([^\"]*)\" text in log section$")
    public void logRowHasTextInLogSection(String message) {
        new UserTablePage().assertLog(message);
    }

    @Then("^\"([^\"]*)\"s droplist contains values$")
    public void droplistContainsValues(UserTablePageTableValues name, List<String> texts) {
        new UserTablePage().dropdownContains(name, texts);
    }
}

