package hw7.trash;

import com.epam.jdi.light.elements.complex.Droplist;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.objects.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.Css;
import com.epam.jdi.light.ui.html.base.HtmlChecklist;
import com.epam.jdi.light.ui.html.base.HtmlElement;
import com.epam.jdi.light.ui.html.common.Button;
import com.epam.jdi.light.ui.html.complex.Checklist;
import com.epam.jdi.light.ui.html.complex.DataList;
import com.epam.jdi.light.ui.html.complex.RadioButtons;
import hw7.entities.Elements;
import org.openqa.selenium.By;

import static com.epam.jdi.light.driver.WebDriverByUtils.fillByTemplate;
import static com.epam.jdi.light.ui.html.HtmlFactory.$;
import static org.openqa.selenium.By.cssSelector;

public class ElementsForm_TEST extends Form<Elements> {
    @Css("#odds-selector > p")
    private RadioButtons odds;

    @Css("#even-selector > p")
    private RadioButtons evens;

    @Css("#elements-checklist")
    private Checklist elements = new HtmlChecklist() {
        By checkbox = cssSelector("input[type=checkbox][id='%s'] + *");

//        @Override
//        public HtmlElement get(String value) {
//            return $(fillByTemplate(checkbox, getId(value)), parent).setName("checkboxes");
//        }
//
//        @Override
//        public void select(String... names) {
//            super.select(names);
//        }
    };

    @JDropdown(root = "#colors", value = ".filter-option", list = "li", expand = ".caret")
    public static Droplist colors;

    @JDropdown(root = "#metals", value = ".filter-option", list = "li", expand = ".caret")
    public static Droplist metals;

    @JDropdown(root = "#salad-dropdown", value = ".dropdown-toggle", list = "li", expand = ".caret")
    public static Droplist vegetables;

    @Css("[id='submit-button']")
    public static Button submit;
}