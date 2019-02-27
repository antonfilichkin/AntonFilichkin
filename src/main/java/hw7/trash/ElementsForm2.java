package hw7.trash;

import com.epam.jdi.light.elements.complex.Droplist;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.objects.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.Css;
import com.epam.jdi.light.ui.html.common.Button;
import com.epam.jdi.light.ui.html.complex.MultiSelect;
import com.epam.jdi.light.ui.html.complex.RadioButtons;

public class ElementsForm2 extends Form<Elements2> {
    @Css("#odds-selector > p")
    private RadioButtons odds;

    @Css("#even-selector > p")
    private RadioButtons evens;

//    @Css("#elements-checklist > p")
//    private WebList elements;

//    @Css("#elements-checklist")
//    private Checklist elements = new HtmlChecklist() {
//        @Override
//        public void select(String... names) {
//            for (String name : names) {
//                HtmlElement value = get(name);
//                //"input" is invisible => repointing to "label"
//                value.setLocator(By.cssSelector(correctLocator(value.locator.toString())));
//                // ---
//                if (value.isEnabled())
//                    value.click();
//            }
//        }

//        private String correctLocator(String wrongLocator){
//            return wrongLocator.substring(5,wrongLocator.length() - 1)+ " + *";
//        }
//    };

    @JDropdown(root = "#colors", value = ".filter-option", list = "li", expand = ".caret")
    private Droplist colors;

    @JDropdown(root = "#metals", value = ".filter-option", list = "li", expand = ".caret")
    private Droplist metals;

    //@JDropdown(root = "#salad-dropdown", value = ".dropdown-toggle", list = "li", expand = ".caret")
    private MultiSelect vegetables;
//    private Droplist vegetables;

    @Css("[id='submit-button']")
    private Button submit;


}