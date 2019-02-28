package enums;

public enum ResultsLog {
    SUMM ("summ-res","Summary: "),
    ELEMENTS ("elem-res","Elements: "),
    METAL ("met-res","Metal: "),
    COLOR ("col-res","Color: "),
    VEGETABLES ("sal-res","Vegetables: ");

    private final String selector;
    private final String resultStringStartsWith;

    ResultsLog(String selector, String resultStringStartsWith) {
        this.selector = selector;
        this.resultStringStartsWith = resultStringStartsWith;
    }

    public String getSelector() {
        return selector;
    }

    public String getResultStringStartsWith() {
        return resultStringStartsWith;
    }
}
