package hw6.steps.userTablePage;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import enums.URLs;
import enums.UserTablePageElements;
import enums.UserTablePageTableValues;
import pages.hw6.UserTablePage;

import java.util.List;

import static com.codeborne.selenide.Selenide.page;

public class AssertionSteps {
    private UserTablePage userTablePage = page(UserTablePage.class);

    @Then("^\"([^\"]*)\" is opened$")
    public void browserTitleIs(URLs url) {
        userTablePage.assertBrowserTitle(url);
    }

    @Then("^(\\d+) \"([^\"]*)\" .*are displayed on Users Table on User Table Page$")
    public void areDisplayedOnUsersTableOnUserTablePage(int quantity, UserTablePageElements element) {
        userTablePage.checkInterface(element, quantity);
    }

    @Then("^User table contains following values:$")
    public void userTableContainsFollowingValues(DataTable values) {
        userTablePage.assertTableContents(values.raw());
    }

//    @Then("^User table contains following values:$")
//    public void userTableContainsFollowingValues(List<SuperHero> superHeroes) {
//        userTablePage.assertTableContents(superHeroes);
//    }

    @Then("^1 log row has \"([^\"]*)\" text in log section$")
    public void logRowHasTextInLogSection(String message) {
        userTablePage.assertLog(message);
    }

    @Then("^\"([^\"]*)\"s droplist contains values$")
    public void droplistContainsValues(UserTablePageTableValues name, List<String> texts) {
        userTablePage.dropdownContains(name, texts);
    }
}

