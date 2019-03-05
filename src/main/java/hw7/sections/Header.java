package hw7.sections;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.Css;
import com.epam.jdi.light.ui.html.common.Image;
import com.epam.jdi.light.ui.html.common.Text;
import com.epam.jdi.light.ui.html.complex.Menu;
import enums.TopMenuItems;
import entities.User;
import hw7.forms.LoginForm;

import static org.hamcrest.Matchers.equalTo;

public class Header extends WebPage {
    public static LoginForm loginForm;

    @Css("[id='user-icon']")
    private Image userIcon;

    @Css("[id='user-name']")
    private Text userName;

    @Css(".m-l8")
    private Menu menu;

    public void login(User user) {
        userIcon.click();
        loginForm.login(user);
    }

    public void checkName(User user) {
        userName.assertThat().text(equalTo(user.getFullName().toUpperCase()));
    }

    public void openMenu(Enum<TopMenuItems> element) {
        menu.select(element);
    }
}