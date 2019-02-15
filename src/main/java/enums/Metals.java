package enums;

public enum Metals {
    GOLD("Gold"),
    SILVER("Silver"),
    BRONZE("Bronze"),
    SELEN("Selen");

    private final String metal;

    Metals(String metal) {
        this.metal = metal;
    }

    public String valueChanged() {
        return "metal: value changed to " + metal;
    }
}
