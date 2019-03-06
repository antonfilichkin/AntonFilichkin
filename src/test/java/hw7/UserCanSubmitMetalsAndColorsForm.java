package hw7;

import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.logger.LogLevels;
import com.epam.jdi.light.settings.WebSettings;
import com.epam.jdi.light.ui.html.PageFactory;
import entities.ElementsJSON;
import entities.User;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static enums.TopMenuItems.METALS_COLORS;
import static hw7.JDISite.*;
import static hw7.pages.MetalsAndColorsPage.elementsFormJSON;
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
    public void MetalsAndColorsPageTest() {
        // 1 Login on JDI site as User: Piter_Chailovskii
        homePage.open();
        header.login(User.PITER);
        header.checkName(User.PITER);

        // 2 Open Metals&Colors page by Header menu
        header.openMenu(METALS_COLORS);
        metalsAndColorsPage.title().check();

        // 3 Fill form Metals & Colors
        elementsFormJSON.submit(ElementsJSON.DEFAULT);

        // 4 Check results sections
        logSidebar.checkResults(ElementsJSON.DEFAULT);
    }
}