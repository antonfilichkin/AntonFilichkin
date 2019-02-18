package hw6.steps.homePage;

import cucumber.api.java.en.When;
import enums.ServiceDropdownItems;
import enums.TopMenuItems;
import enums.Users;
import pages.hw6.HomePage;

import static com.codeborne.selenide.Selenide.page;

public class ActionSteps {
    private HomePage homePage = page(HomePage.class);

    @When("^I login as user \"([^\"]*)\"$")
    public void iLoginAsUser(String name) {
        Users user = Users.userByName(name);
        homePage.login(user);
    }

    @When("^I click on \"([^\"]*)\" subcategory in the header$")
    public void iClickOnSubcategoryInTheHeader(TopMenuItems item) {
        homePage.headerMenuSelect(item);
    }

    @When("^I click on \"([^\"]*)\" subcategory in the left section$")
    public void iClickOnSubcategoryInTheLeftSection(TopMenuItems item) {
        homePage.leftMenuSelect(item);
    }

    @When("^I open through the header menu \"([^\"]*)\" -> \"([^\"]*)\"$")
    public void iOpenThroughTheHeaderMenuPage(TopMenuItems tmItem, ServiceDropdownItems sdItem){
        homePage.headerMenuSelect(tmItem);
        homePage.headerMenuServiceSelect(sdItem);
    }

    @When("^I click on \"([^\"]*)\" button in Service dropdown$")
    public void iClickOnButtonInServiceDropdown(ServiceDropdownItems item) {
        homePage.headerMenuServiceSelect(item);
    }
}