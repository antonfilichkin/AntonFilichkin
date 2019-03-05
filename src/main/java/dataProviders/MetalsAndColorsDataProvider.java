package dataProviders;

import entities.Elements;
import org.json.JSONObject;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static utils.JSONUtils.parseJSONFile;

public class MetalsAndColorsDataProvider {
    private final static String DATA_FILE = "src/test/resources/hw8/metalsColorsDataSet.json";

    @DataProvider(name = "MetalsAndColors")
    public Object[][] metalsColorsDataProvider() {
        List<Elements> dataSet = dataSetFromJSON(parseJSONFile(DATA_FILE));
        Iterator<Elements> dataSetIterator = dataSet.iterator();
        Object[][] dataProvider = new Object[dataSet.size()][1];
        for (Object[] each : dataProvider) {
            each[0] = dataSetIterator.next();
        }
        return dataProvider;
    }

    private List<Elements> dataSetFromJSON(JSONObject JSONData) {
        List<Elements> testData = new ArrayList<>();
        Iterator<String> dataIterator = JSONData.keys();
        while (dataIterator.hasNext()) {
            String key = dataIterator.next();
            JSONObject o = JSONData.getJSONObject(key);
            Elements e = new Elements(
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