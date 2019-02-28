package enums;

public enum ResultsLog {
    SUMM ("summ-res","Summary: "),
    ELEMENTS ("elem-res","Elements: "),
    METAL ("met-res","Metal: "),
    COLOR ("col-res","Color: "),
    VEGETABLES ("sal-res","Vegetables: ");

    private final String selector;
    private final String resultString;

    ResultsLog(String selector, String resultString) {
        this.selector = selector;
        this.resultString = resultString;
    }

    public String getSelector() {
        return selector;
    }

    public String getResultString() {
        return resultString;
    }
}
