package enums;

public enum Range2SliderThumbs {
    FROM("From"),
    TO("To");

    private final String caption;

    Range2SliderThumbs(String caption) {
        this.caption = caption;
    }

    public String valueChanged(int position) {
        return "Range 2(" + caption + "):" + position + " link clicked";
    }
}
