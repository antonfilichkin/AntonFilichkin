package enums;

public enum HomePageData {
    TEST_PAGE_URL("https://epam.github.io/JDI/index.html"),
    TEST_PAGE_TITLE("Home Page"),
    MAIN_HEADER_TITLE("EPAM FRAMEWORK WISHES…"),
    MAIN_HEADER_TEXT("LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT " +
            "LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT " +
            "ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM " +
            "DOLORE EU FUGIAT NULLA PARIATUR."),
    SUB_HEADER_TEXT("JDI GITHUB"),
    SUB_HEADER_URL("https://github.com/epam/JDI");

    private final String value;

    HomePageData(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}