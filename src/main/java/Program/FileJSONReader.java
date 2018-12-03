package Program;


import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;


public class FileJSONReader {
    private final String filename = "subjects.json";

    private static FileJSONReader instance = new FileJSONReader();

    private FileJSONReader() {
    }

    public static FileJSONReader getInstance() {
        if (instance == null)
            instance = new FileJSONReader();
        return instance;
    }

    public ArrayList<Subject> readFileJSON()  {
        Gson gson = new Gson();
        JsonReader reader = null;
        try {
            reader = new JsonReader(new FileReader(filename));
            Subject[] data = gson.fromJson(reader, Subject[].class);
            ArrayList<Subject> subjectsData = new ArrayList<Subject>(Arrays.asList(data));
            return subjectsData;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}
