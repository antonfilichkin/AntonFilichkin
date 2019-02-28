package hw7;

import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.logger.LogLevels;
import com.epam.jdi.light.settings.WebSettings;
import com.epam.jdi.light.ui.html.PageFactory;
import enums.NatureElements;
import enums.Vegetables;
import hw7.entities.Elements;
import hw7.entities.User;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static enums.Colors.RED;
import static enums.Metals.SELEN;
import static enums.NatureElements.EARTH;
import static enums.NatureElements.WIND;
import static enums.TopMenuItems.METALS_COLORS;
import static enums.Users.PITER_CHAILOVSKII;
import static enums.Vegetables.CUCUMBER;
import static enums.Vegetables.TOMATO;
import static hw7.JDISite.*;
import static hw7.pages.MetalsAndColorsPage.elementsForm;
import static hw7.pages.MetalsAndColorsPage.logSidebar;

public class UserCanSubmitMetalsAndColorsForm {
    @BeforeSuite
    public void beforeSuite() {
        PageFactory.initElements(JDISite.class);
        WebSettings.logger.setLogLevel(LogLevels.OFF);
        WebSettings.logger.toLog("Run Tests");
    }

    @AfterSuite
    public void afterSuite() {
        WebDriverFactory.close();
    }

    @Test
    public void simpleJdiTest() {
        // 1 Login on JDI site as User: Piter_Chailovskii
        User user = new User(PITER_CHAILOVSKII);
        homePage.open();
        header.login(user);
        header.checkName(user);

        // 2 Open Metals&Colors page by Header menu
        header.openMenu(METALS_COLORS);
        metalsAndColorsPage.title().check();

        // 3 Fill form Metals & Colors
        Elements elements = new Elements(
                3, 8, new NatureElements[]{WIND, EARTH}, RED, SELEN, new Vegetables[]{CUCUMBER, TOMATO});
        elementsForm.submit(elements);

        // 4 Check results sections
        logSidebar.checkResults(elements);
    }
}