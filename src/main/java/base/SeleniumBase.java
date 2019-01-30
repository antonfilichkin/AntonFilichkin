package base;

import org.testng.annotations.BeforeSuite;

import static java.lang.System.setProperty;

public abstract class SeleniumBase {

    @BeforeSuite(groups = {"Config"})
    public void BeforeSuite(){
        setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
    }
}
