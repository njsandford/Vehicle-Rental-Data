package utilities;

import com.google.gson.*;
import vehicles.Vehicle;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Natalie Sandford
 * @Date 03/02/2018
 * Provides JSON file parsing functionality to extract vehicle data into Vehicle objects.
 */
public class ParseFile {

    private static final String FILE_PATH = "./data/";

//    public static void main(String[] args) {
//        ParseFile pf = new ParseFile();
//        pf.jsonToVehicleList("vehicles.json");
//    }

    /**
     * Produces an ArrayList of Vehicle objects from a JSON file.
     * @param filename name of the JSON file containing vehicle data.
     * @return ArrayList of Vehicle objects.
     */
    public List<Vehicle> jsonToVehicleList(String filename) {
        List<Vehicle> vehicleList = new ArrayList<Vehicle>();

        filename = FILE_PATH + filename;

        JsonObject jsonFile;

        try {
            // Parse JSON file and store as JsonObject:
            JsonParser parser = new JsonParser();
            FileReader fileReader = new FileReader(filename);
            jsonFile = parser.parse(fileReader).getAsJsonObject();

            // Get the 'Search' element of the JSON file and store as JsonObject.
            JsonObject search = jsonFile.get("Search").getAsJsonObject();
            // Get the 'VehicleList' element from the 'Search' object, and store as JsonObject.
            JsonArray vehicles = search.get("VehicleList").getAsJsonArray();

            // Using GSON, iterate through the JsonArray of vehicle data, storing each element as a Vehicle in an ArrayList.
            Gson gson = new Gson();
            // For each element in the JSON vehicle list, create a new Vehicle object and add it to the Vehicle List.
            for (JsonElement element : vehicles) {
                Vehicle vehicle = gson.fromJson(element, Vehicle.class);
                vehicleList.add(vehicle);
            }
            //System.out.println(vehicleList);

        } catch (IOException e) {
            throw new RuntimeException("Should not happen; file is known to exist", e);
        }

        return vehicleList;
    }
}
