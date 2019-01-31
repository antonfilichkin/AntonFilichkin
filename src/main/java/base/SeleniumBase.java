package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

import static java.lang.System.setProperty;

public abstract class SeleniumBase {

    @BeforeSuite(groups = {"Config"})
    public void BeforeSuite(){
        setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
    }

    protected WebDriver getWebDriver() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10000, TimeUnit.MILLISECONDS);
        return driver;
    }
}
