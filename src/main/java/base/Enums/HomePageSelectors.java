package base.Enums;

public enum HomePageSelectors {
    USER_ICON_CSS("[id='user-icon']"),
    USER_NAME_INPUT_CSS("[id='name']"),
    USER_PASS_INPUT_CSS("[id='password']"),
    LOGIN_BUTTON_CSS("[id='login-button']"),
    USER_NAME_TEXT_CSS("[id='user-name']"),
    NAVBAR_ELEMENTS_CSS(".navbar-nav.m-l8 > li"),
    BENEFIT_ICONS_CSS(".benefit-icon"),
    BENEFIT_TEXTS_CSS(".benefit-icon + .benefit-txt"),
    ICON_PRACTISE_CSS(".icon-practise"),
    ICON_CUSTOM_CSS(".icon-custom"),
    ICON_MULTI_CSS(".icon-multi"),
    ICON_BASE_CSS(".icon-base"),
    MAIN_TITLE_CSS("h3.main-title"),
    MAIN_TEXT("p.main-txt"),
    IFRAME_CSS("[id='iframe']"),
    IFRAME_NAME("iframe"),
    EPAM_LOGO_CSS("img[id = 'epam_logo']"),
    LEFT_SECTION_CSS(".uui-side-bar"),
    SUB_HEADER_CSS("h3.text-center > a"),
    FOOTER_CSS(".footer-bg");

    private final String selector;

    HomePageSelectors(String selector) {
        this.selector = selector;
    }

    @Override
    public String toString() {
        return selector;
    }
}
