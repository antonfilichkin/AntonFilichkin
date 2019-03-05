package hw7.forms;

import com.epam.jdi.light.elements.complex.Droplist;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.objects.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.Css;
import com.epam.jdi.light.ui.html.base.HtmlChecklist;
import com.epam.jdi.light.ui.html.base.HtmlElement;
import com.epam.jdi.light.ui.html.common.Button;
import com.epam.jdi.light.ui.html.complex.Checklist;
import com.epam.jdi.light.ui.html.complex.RadioButtons;
import entities.Elements;
import org.openqa.selenium.By;

import static com.epam.jdi.light.driver.WebDriverByUtils.fillByTemplate;
import static com.epam.jdi.light.ui.html.HtmlFactory.$;
import static org.openqa.selenium.By.cssSelector;

public class ElementsForm extends Form<Elements> {
    @Css("#odds-selector > p")
    private RadioButtons odds;

    @Css("#even-selector > p")
    private RadioButtons evens;

    @Css("#elements-checklist")
    private Checklist elements = new HtmlChecklist() {
        By checkbox = cssSelector("input[type=checkbox][id='%s'] + *");
        By label = By.xpath(".//label[text()='%s']");

        @Override
        public HtmlElement get(String value) {
            return $(fillByTemplate(checkbox, getId(value)), parent).setName("checkboxes");
        }

        private String getId(String name) {
            return label(name).getAttribute("for");
        }

        private HtmlElement label(String value) {
            return $(fillByTemplate(label, value), parent).setName("label");
        }
    };

    @JDropdown(root = "#colors", value = ".filter-option", list = "li", expand = ".caret")
    private Droplist colors;

    @JDropdown(root = "#metals", value = ".filter-option", list = "li", expand = ".caret")
    private Droplist metals;

    @JDropdown(root = "#salad-dropdown", value = ".dropdown-toggle", list = "li", expand = ".caret")
    private Droplist vegetables;

    @Css("#calculate-button")
    private Button calculate;

    @Css("#submit-button")
    private Button submit;

    @Override
    public void fill(Elements entity) {
        odds.select(String.valueOf(entity.odds));
        evens.select(String.valueOf(entity.evens));
        elements.select(entity.elements);
        colors.select(entity.color);
        metals.select(entity.metal);
        selectVegetables(entity.vegetables);
    }

    @Override
    public void submit(Elements entity) {
        fill(entity);
        submit.click();
    }

    private void selectVegetables(String... values) {
        clearVegetables();
        for (String value : values) {
            vegetables.select(value);
        }
    }

    private void clearVegetables() {
        String[] selectedOptions = vegetables.getSelected().split(", ");
        for (String option : selectedOptions) {
            vegetables.select(option);
        }
    }
}