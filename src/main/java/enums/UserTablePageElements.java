package enums;

public enum UserTablePageElements {
    NUMBERS("Numbers"),
    DROPDOWNS("Dropdowns"),
    USER_NAMES("User Names"),
    DESCRIPTION_IMAGES("Description Images"),
    DESCRIPTION_TEXTS("Description Texts"),
    CHECKBOXES("Checkboxes");

    private final String name;

    UserTablePageElements(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
