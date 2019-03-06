package dataProviders;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import entities.Elements;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class MetalsAndColorsDataProvider {
    private final static String DATA_FILE = "src/test/resources/hw8/metalsColorsDataSet.json";

    @DataProvider(name = "MetalsAndColors")
    public Object[][] metalsColorsDataProvider() {
        List<Elements> dataSet = getTestDataFromJSON(DATA_FILE);
        Iterator<Elements> dataSetIterator = dataSet.iterator();
        Object[][] dataProvider = new Object[dataSet.size()][1];
        for (Object[] each : dataProvider) {
            each[0] = dataSetIterator.next();
        }
        return dataProvider;
    }

    @SuppressWarnings("unchecked")
    private List<Elements> getTestDataFromJSON(String path) {
        Map<String, LinkedTreeMap> rawData = new HashMap<>();
        List<Elements> testData = new ArrayList<>();
        Gson gson = new Gson();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            rawData = gson.fromJson(br, rawData.getClass());
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (LinkedTreeMap value : rawData.values()) {
            testData.add(gson.fromJson(value.toString(), Elements.class));
        }
        return testData;
    }
}