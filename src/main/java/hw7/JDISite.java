package hw7;

import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import hw7.pages.HomePage;

@JSite("https://epam.github.io/JDI/")
public class JDISite {
        @Url("index.html")
        public static HomePage homePage;
}
