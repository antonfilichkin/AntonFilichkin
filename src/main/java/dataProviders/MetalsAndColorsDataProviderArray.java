package dataProviders;

import com.google.gson.Gson;
import entities.Elements;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class MetalsAndColorsDataProviderArray {
    private final static String DATA_FILE = "src/test/resources/hw8/metalsColorsDataSetAsArray.json";

    @DataProvider(name = "MetalsAndColors")
    public Object[][] metalsColorsDataProvider() throws IOException {
        List<Elements> dataSet = getTestDataFromJSON(DATA_FILE);
        Iterator<Elements> dataSetIterator = dataSet.iterator();
        Object[][] dataProvider = new Object[dataSet.size()][1];
        for (Object[] each : dataProvider) {
            each[0] = dataSetIterator.next();
        }
        return dataProvider;
    }

    private List<Elements> getTestDataFromJSON(String path) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            Gson gson = new Gson();
            return Arrays.asList(gson.fromJson(br, Elements[].class));
        }
    }
}