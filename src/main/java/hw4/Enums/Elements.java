package hw4.Enums;

public enum Elements {
    WATER("Water"),
    EARTH("Earth"),
    WIND("Wind"),
    FIRE("Fire");

    private final String text;

    Elements(String text) {
        this.text = text;
    }

    // TODO That's really cool. I haven't faced approach like this before.
    public String valueChanged(boolean status) {
        return text + ": condition changed to " + Boolean.toString(status);
    }
}
