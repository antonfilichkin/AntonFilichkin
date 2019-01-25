package hw1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.setProperty;
import static org.testng.Assert.assertEquals;

public class testSiteBrowserBehaviorTest {

    @BeforeMethod
    public void browserInitiateChrome() {
        setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
    }

    @Test
    public void browserTestChrome() {
        // Initiate
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // 1 Open test site by URL
        driver.navigate().to("https://epam.github.io/JDI/index.html");

        // 2 Assert Browser title
        assertEquals(driver.getTitle(), "Home Page");

        // 3 Perform login
        driver.findElement(By.id("user-icon")).click();  // !!!
        driver.findElement(By.cssSelector("[id='name']")).sendKeys("epam");
        driver.findElement(By.cssSelector("[id='password']")).sendKeys("1234");
        driver.findElement(By.cssSelector("[id='login-button']")).click();

        // 4 Assert User name in the left-top side of screen that user is logged in
  //     assertEquals(driver.findElement(By.cssSelector("[id='user-name']")).getText(), "Piter Chailovskii");

        // 5 Assert Browser title
        assertEquals(driver.getTitle(), "Home Page");

        // 6 Assert that there are 4 items on the header section are displayed and they have proper texts
        List<WebElement> headerSectionItems = new ArrayList(driver.findElements(By.className("m-l8>li")));
        assertEquals(4, headerSectionItems.size());
        assertEquals("HOME", headerSectionItems.get(0).getText());
        assertEquals("CONTACT FORM", headerSectionItems.get(1).getText());
        assertEquals("SERVICE", headerSectionItems.get(2).getText());
        assertEquals("METALS & COLORS", headerSectionItems.get(3).getText());

        // 7 Assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> indexPageImages = new ArrayList(driver.findElements(By.className("[class='benefit-icon']")));
        assertEquals(4, indexPageImages.size());

        // 8 Assert that there are 4 texts on the Index Page under icons and they have proper text


        // 9 Assert a text of the main headers


        // 10 Assert that there is the iframe in the center of page


        // 11 Switch to the iframe and check that there is Epam logo in the left top conner of iframe


        // 12 Switch to original window back


        // 13 Assert a text of the sub header


        // 14 Assert that JDI GITHUB is a link and has a proper URL


        // 15 Assert that there is Left Section


        // 16 Assert that there is Footer


        // 17 Close Browser
        driver.close();
    }
}