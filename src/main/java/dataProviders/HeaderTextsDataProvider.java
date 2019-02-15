package dataProviders;

import org.testng.annotations.DataProvider;

public class HeaderTextsDataProvider {
    @DataProvider(name = "HeaderTextsDataProvider")
    private Object[][] TextsDataProvider() {
        return new Object[][] {
                {"practise", "To include good practices\nand ideas from successful\nEPAM project"},
                {"custom", "To be flexible and\ncustomizable"},
                {"multi", "To be multiplatform"},
                {"base", "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…"}
        };
    }
}
