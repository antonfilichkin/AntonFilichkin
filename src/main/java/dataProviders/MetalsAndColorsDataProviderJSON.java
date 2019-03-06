package dataProviders;

import entities.ElementsJSON;
import org.json.JSONObject;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static utils.JSONUtils.parseJSONFile;

public class MetalsAndColorsDataProviderJSON {
    private final static String DATA_FILE = "src/test/resources/hw8/metalsColorsDataSet.json";

    @DataProvider(name = "MetalsAndColors")
    public Object[][] metalsColorsDataProvider() {
        List<ElementsJSON> dataSet = dataSetFromJSON(parseJSONFile(DATA_FILE));
        Iterator<ElementsJSON> dataSetIterator = dataSet.iterator();
        Object[][] dataProvider = new Object[dataSet.size()][1];
        for (Object[] each : dataProvider) {
            each[0] = dataSetIterator.next();
        }
        return dataProvider;
    }

    private List<ElementsJSON> dataSetFromJSON(JSONObject JSONData) {
        List<ElementsJSON> testData = new ArrayList<>();
        Iterator<String> dataIterator = JSONData.keys();
        while (dataIterator.hasNext()) {
            String key = dataIterator.next();
            JSONObject o = JSONData.getJSONObject(key);
            ElementsJSON e = new ElementsJSON(
                    o.getJSONArray("summary").toList().toArray(new Integer[0]),
                    o.getJSONArray("elements").toList().toArray(new String[0]),
                    o.getString("color"),
                    o.getString("metals"),
                    o.getJSONArray("vegetables").toList().toArray(new String[0])
            );
            testData.add(e);
        }
        return testData;
    }
}