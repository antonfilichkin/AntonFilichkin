package hw2.ex2;

import base.SeleniumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class TextBelowPicturesTest extends SeleniumBase {


    @DataProvider(parallel = true)
    private Object[][] TextsDataProvider() {
        return new Object[][] {
                {"icon-practise", "To include good practices\nand ideas from successful\nEPAM project"},
                {"icon-custom", "To be flexible and\ncustomizable"},
                {"icon-multi", "To be multiplatform"},
                {"icon-base", "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…"}
        };
    }

    @Test(dataProvider = "TextsDataProvider")
    public void simpleTest(String icon, String text) {
        WebDriver driver = new ChromeDriver();

        //driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(25000, TimeUnit.MILLISECONDS);
        driver.navigate().to("https://epam.github.io/JDI/index.html");

        String xPath = "//span[contains(@class, '" + icon + "')]//../following-sibling::span";
        assertEquals(driver.findElement(By.xpath(xPath)).getText(), text);

        driver.close();
    }
}






//              Exercise 2:
//              Create 3 copies of the HW1 test in a new class.
//        Include all these tests to the group “Smoke”
//        Create 3 copies of the HW1 test in a next class.
//        Include all these tests to the group “Regression”
//        Create 3 copies of the HW1 test in a next class.
//        Include 2 of them to the group “Regression” another one to the group “Smoke”
//        Create 3 copies of the HW1 test in a next class.
//        Include all these tests to the groups “Regression” and “Smoke” simultaneously
//        Create two TestNg config files, the first one runs all “Smoke” test, the second runs “Regression”. Run both of configs must be in parallel by methods mode and with 3 threads.
//
//        Exercise 3:
//        Copy your HW1 test and refactor it in a such way that the test uses all annotations and instructions listed below. Each annotation can contain the only 1 instruction.
//        Create a dedicated TestNG config for particular test.
//
//@BeforeSuite
//@AfterMethod
//@BeforeMethod
//@BeforeClass
//@AfterSuite
//@AfterClass
//setProperty("webdriver.chrome.driver", driverPath);
//
//        WebDriver driver = new ChromeDriver();
//
//        System.out.println(driver.getTitle());
//
//        driver.manage().window().maximize();
//
//        System.out.println(System.currentTimeMillis());
//
//        driver.close()
//
//