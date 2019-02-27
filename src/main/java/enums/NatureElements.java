package enums;

public enum NatureElements {
    WATER("Water"),
    EARTH("Earth"),
    WIND("Wind"),
    FIRE("Fire");

    private final String value;

    NatureElements(String value) {
        this.value = value;
    }

    public String valueChanged(boolean status) {
        return value + ": condition changed to " + status;
    }

    @Override
    public String toString() {
        return value;
    }
}
