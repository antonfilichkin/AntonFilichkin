package hw6.steps.userTablePage;

import cucumber.api.java.en.When;
import enums.UserTablePageTableValues;
import pages.hw6.UserTablePage;

import static com.codeborne.selenide.Selenide.page;

public class ActionSteps {
    private UserTablePage userTablePage = page(UserTablePage.class);

    @When("^I select 'vip' checkbox for \"([^\"]*)\"$")
    public void iSelectVipCheckboxFor(UserTablePageTableValues name) {
        userTablePage.clickCheckbox(name);
    }

    @When("^I click on dropdown in column Type for user \"([^\"]*)\"$")
    public void iClickOnDropdownInColumnTypeForUserRoman(UserTablePageTableValues name) {
        userTablePage.clickDropdown(name);
    }

}