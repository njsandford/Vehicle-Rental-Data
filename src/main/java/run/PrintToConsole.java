package run;

import utilities.ParseFile;
import utilities.VehicleHelper;
import vehicles.Vehicle;

import java.util.Collections;
import java.util.List;

/**
 * @Author: Natalie Sandford
 * @Date: 03/02/2018
 * Provides a method of printing vehicle data to the console.
 */
public class PrintToConsole {

    private ParseFile parseFile = new ParseFile();

    public static void main(String[] args) {
        PrintToConsole printToConsole = new PrintToConsole();

        ParseFile parseFile = new ParseFile();
        List<Vehicle> vehicleList = parseFile.jsonToVehicleList("vehicles.json");

        printToConsole.vehiclesPriceAscending(vehicleList);
        printToConsole.vehicleSpecifications(vehicleList);
        printToConsole.highestRatedPerTypeDescending(vehicleList);
        printToConsole.vehicleScoresDescending(vehicleList);
    }

    /**
     * Print a list of all vehicles ordered by price in ascending order in the format:
     *      {name} - {price}
     */
    public void vehiclesPriceAscending(List<Vehicle> vehicleList) {
        Collections.sort(vehicleList, Vehicle.PriceAscending);

        System.out.println("--- All vehicles in ascending price order: ---");
        for (Vehicle vehicle : vehicleList) {
            System.out.println(vehicle.getName() + " - " + vehicle.getPrice());
        }
        System.out.println("--- End of vehicles ---");
    }

    /**
     * Print a list of all vehicles with their full specification in the format:
     *      {name} - {sipp} - {type} - {doors} - {transmission} - {fuel} - {air con}
     */
    public void vehicleSpecifications(List<Vehicle> vehicleList) {
        System.out.println("--- Full specification of all vehicles: ---");
        for (Vehicle vehicle : vehicleList) {
            System.out.println(vehicle.getName() + " - " + vehicle.getSipp() + " - " + vehicle.getCarType() + " - " +
                    vehicle.getDoors() + " - " + vehicle.getTransmission() + " - " + vehicle.getFuel() + " - " + vehicle.getAirCon());
        }
        System.out.println("--- End of specifications ---");
    }

    /**
     * Print a list of the highest rated suppliers per car type in descending order in the format:
     *      {name} - {type} - {supplier} - {rating}
     */
    public void highestRatedPerTypeDescending(List<Vehicle> vehicleList) {
        VehicleHelper vehicleHelper = new VehicleHelper();
        List<Vehicle> vehicles = vehicleHelper.getHighestRatedPerCarTypeDescending(vehicleList);

        System.out.println("--- Highest rated supplier per car type, descending order: ---");
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle.getName() + " - " + vehicle.getCarType() + " - " + vehicle.getSupplier() + " - " + vehicle.getRating());
        }
        System.out.println("--- End of highest rated suppliers per car type ---");
    }

    /**
     * Print a list of all vehicle scores, sorted in descending order in the format:
     *      {name} - {score} - {rating} - {totalScore}
     */
    public void vehicleScoresDescending(List<Vehicle> vehicleList) {
        VehicleHelper vehicleHelper = new VehicleHelper();
        List<Vehicle> sortedVehicles = vehicleHelper.getVehiclesByScoreDescending(vehicleList);

        System.out.println("--- Vehicle Scores: ---");
        for (Vehicle vehicle : sortedVehicles) {
            System.out.println(vehicle.getName() + " - " + vehicle.getScore() + " - " + vehicle.getRating() + " - " + vehicle.getTotalScore());
        }
        System.out.println("--- End of scores ---");
    }
}
