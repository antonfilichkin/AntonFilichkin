package hw4.Enums;

public enum URLs {
    HOME_PAGE("https://epam.github.io/JDI/index.html", "Home Page"),
    DIFFERENT_ELEMENTS_PAGE("https://epam.github.io/JDI/different-elements.html", "Different Elements"),
    DATES_PAGE("https://epam.github.io/JDI/dates.html", "Dates");

    private final String url;
    private final String title;

    URLs(String url, String title) {
        this.url = url;
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public String getTitle() {
        return title;
    }
}
