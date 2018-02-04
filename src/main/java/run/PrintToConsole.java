package run;

import utilities.ParseFile;
import vehicles.Vehicle;

import java.util.Collections;
import java.util.List;

/**
 * @Author: Natalie Sandford
 * @Date: 03/02/2018
 * Provides a method of printing vehicle data to the console.
 */
public class PrintToConsole {

    public static void main(String[] args) {
        PrintToConsole printToConsole = new PrintToConsole();
        printToConsole.vehiclesPriceAscending();
    }

    /**
     * Print a list of all vehicles ordered by price in ascending order in the format: {name} - {price}.
     */
    public void vehiclesPriceAscending() {
        ParseFile parseFile = new ParseFile();
        List<Vehicle> vehicleList = parseFile.jsonToVehicleList("vehicles.json");
        Collections.sort(vehicleList, Vehicle.PriceAscending);
        for (Vehicle vehicle : vehicleList) {
            System.out.println(vehicle.getName() + " - " + vehicle.getPrice());
        }
    }
}
