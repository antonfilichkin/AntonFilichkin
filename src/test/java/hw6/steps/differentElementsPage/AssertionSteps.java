package hw6.steps.differentElementsPage;

import cucumber.api.java.en.Then;
import enums.Colors;
import enums.NatureElements;
import enums.Metals;
import enums.URLs;
import pages.hw6.DifferentElementsPage;

import java.util.List;

import static com.codeborne.selenide.Selenide.page;

public class AssertionSteps {
    private DifferentElementsPage differentElementsPage = page(DifferentElementsPage.class);
    
    @Then("^Page \"([^\"]*)\" is opened$")
    public void pagePageIsOpened(URLs url){
        differentElementsPage.assertBrowserTitle(url);
    }

    @Then("^Different elements page contains all needed elements$")
    public void differentElementsPageContainsAllNeededElements() {
        differentElementsPage.checkInterface();
    }

    @Then("^Right section is displayed$")
    public void rightSectionIsDisplayed() {
        differentElementsPage.assertRightSectionIsPresent();
    }

    @Then("^Left section is displayed$")
    public void thenLeftSectionIsDisplayed() {
        differentElementsPage.assertLeftSectionIsPresent();
    }

    @Then("^Checkboxes \"([^\"]*)\" are .*checked \\(\"([^\"]*)\"\\)$")
    public void elementsAreChecked(List<NatureElements> options, boolean status){
        NatureElements[] items = options.toArray(new NatureElements[0]);
        differentElementsPage.assertCheckboxesStatus(items, status);
    }

    @Then("^There is an individual log for elements:$")
    public void thereIsAnIndividualLogRowAndValueForEachSelectedCheckbox(List<String> logs) {
        String[] logsArray = logs.toArray(new String[0]);
        differentElementsPage.assertLog(logsArray);
    }

    @Then("^Metal \"([^\"]*)\" is checked \\(\"([^\"]*)\"\\)$")
    public void elementIsChecked(Metals metal, boolean status) {
        differentElementsPage.assertRadioButton(metal, status);
    }

    @Then("^Color \"([^\"]*)\" is selected$")
    public void elementIsSelected(Colors color) {
        differentElementsPage.selectDropdown(color);
    }
}