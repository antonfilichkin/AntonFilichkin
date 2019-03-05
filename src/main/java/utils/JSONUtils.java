package utils;

import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JSONUtils {
    public static JSONObject parseJSONFile(String JSONFile) {
        String JSONFileContent = "";
        try {
            JSONFileContent = new String(Files.readAllBytes(Paths.get(JSONFile)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new JSONObject(JSONFileContent);
    }
}