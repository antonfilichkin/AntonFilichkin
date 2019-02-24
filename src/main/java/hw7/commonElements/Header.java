package hw7.commonElements;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.ui.html.common.Image;
import com.epam.jdi.light.ui.html.common.Text;
import com.epam.jdi.light.ui.html.complex.Dropdown;
import com.epam.jdi.light.ui.html.complex.Menu;
import hw7.forms.LoginForm;

public class Header extends WebPage {
    LoginForm loginForm;

    @FindBy(css = "[id='user-icon']")
    private Image userIcon;

    @FindBy(css = "[id='user-name']")
    private Text userName;

    @FindBy(css = ".m-l8")
    private Menu headerMenu;

    @FindBy(css = ".m-l8 > .dropdown")
    private Dropdown headerMenuServiceDropdown;
}
