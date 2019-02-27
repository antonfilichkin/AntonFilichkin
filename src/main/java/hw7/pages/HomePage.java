package hw7.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import hw7.sections.Header;

@Url("index.html") @Title("Home Page")
public class HomePage extends WebPage {
    public static Header header;
}