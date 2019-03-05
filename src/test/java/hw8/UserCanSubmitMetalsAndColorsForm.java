package hw8;

import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.logger.LogLevels;
import com.epam.jdi.light.settings.WebSettings;
import com.epam.jdi.light.ui.html.PageFactory;
import dataProviders.MetalsAndColorsDataProvider;
import entities.Elements;
import entities.User;
import hw7.JDISite;
import org.testng.annotations.*;

import static com.epam.jdi.light.elements.composite.WebPage.refresh;
import static enums.TopMenuItems.METALS_COLORS;
import static hw7.JDISite.*;
import static hw7.pages.MetalsAndColorsPage.elementsForm;
import static hw7.pages.MetalsAndColorsPage.logSidebar;

public class UserCanSubmitMetalsAndColorsForm {
    @BeforeSuite
    public void beforeSuite() {
        PageFactory.initElements(JDISite.class);
        WebSettings.logger.setLogLevel(LogLevels.STEP);
        WebSettings.logger.toLog("Run Tests");

        // 1 Login on JDI site as User: Piter_Chailovskii
        homePage.open();
        header.login(User.PITER);
        header.checkName(User.PITER);

        // 2 Open Metals&Colors page by Header menu
        header.openMenu(METALS_COLORS);
        metalsAndColorsPage.title().check();
    }

    @AfterSuite
    public void afterSuite() {
        WebDriverFactory.close();
    }

    @AfterMethod
    public void AfterMethod() {
        refresh();
    }

    @Test(dataProvider = "MetalsAndColors", dataProviderClass = MetalsAndColorsDataProvider.class)
    public void MetalsAndColorsPageTest(Elements elements) {
        // 3 Fill form Metals & Colors
        elementsForm.submit(elements);

        // 4 Check results sections
        logSidebar.checkResults(elements);
    }
}