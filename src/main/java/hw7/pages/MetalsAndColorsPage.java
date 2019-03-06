package hw7.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import hw7.forms.ElementsForm;
import hw7.forms.ElementsFormJSON;
import hw7.sections.LogSidebar;

@Url("metals-colors.html")
@Title("Metal and Colors")
public class MetalsAndColorsPage extends WebPage {
    public static ElementsForm elementsForm;
    public static ElementsFormJSON elementsFormJSON;
    public static LogSidebar logSidebar;
}