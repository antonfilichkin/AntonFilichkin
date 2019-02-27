package hw7.sections;

import com.epam.jdi.light.elements.complex.JList;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.Css;
import hw7.entities.Elements;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class LogSidebar extends WebPage {
    @Css(".logs")
    WebList logs;

    @Css(".results")
    WebList results;

    public void checkResults(Elements elements){
        Map<String,String> logValues = new HashMap<>();
        for (WebElement webElement : results) {
            logValues.put(webElement.getAttribute("class"), webElement.getText());
        }

        assertThat(results.get(1).getValue(), is(""));
    }
}
