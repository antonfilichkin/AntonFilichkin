package hw6.steps.userTablePage;

import cucumber.api.PendingException;
import cucumber.api.java.en.When;
import enums.UserTablePageTableValues;
import pages.hw6.UserTablePage;

public class ActionSteps {
    @When("^I select 'vip' checkbox for \"([^\"]*)\"$")
    public void iSelectVipCheckboxFor(UserTablePageTableValues name) {
        new UserTablePage().clickCheckbox(name);
    }

    @When("^I click on dropdown in column Type for user \"([^\"]*)\"$")
    public void iClickOnDropdownInColumnTypeForUserRoman(UserTablePageTableValues name) {
        new UserTablePage().clickDropdown(name);
    }

}