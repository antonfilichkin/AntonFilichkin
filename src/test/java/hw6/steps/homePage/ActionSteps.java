package hw6.steps.homePage;

import cucumber.api.java.en.When;
import enums.ServiceDropdownItems;
import enums.TopMenuItems;
import enums.Users;
import pages.hw6.HomePage;

// TODO In general, this is not the best approach to create new page in each step
// TODO Take a look on cucumber hooks
public class ActionSteps {
    @When("^I login as user \"([^\"]*)\"$")
    public void iLoginAsUser(String name) {
        Users user = Users.userByName(name);
        new HomePage().login(user);
    }

    @When("^I click on \"([^\"]*)\" subcategory in the header$")
    public void iClickOnSubcategoryInTheHeader(TopMenuItems item) {
        new HomePage().headerMenuSelect(item);
    }

    @When("^I click on \"([^\"]*)\" subcategory in the left section$")
    public void iClickOnSubcategoryInTheLeftSection(TopMenuItems item) {
        new HomePage().leftMenuSelect(item);
    }

    @When("^I open through the header menu \"([^\"]*)\" -> \"([^\"]*)\"$")
    public void iOpenThroughTheHeaderMenuPage(TopMenuItems tmItem, ServiceDropdownItems sdItem){
        new HomePage().headerMenuSelect(tmItem);
        new HomePage().headerMenuServiceSelect(sdItem);
    }

    @When("^I click on \"([^\"]*)\" button in Service dropdown$")
    public void iClickOnButtonInServiceDropdown(ServiceDropdownItems item) {
        new HomePage().headerMenuServiceSelect(item);
    }
}