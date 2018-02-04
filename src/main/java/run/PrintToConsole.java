package run;

import utilities.ParseFile;
import utilities.VehicleHelper;
import vehicles.Vehicle;
import vehicles.VehicleSpecification;

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
        printToConsole.vehiclesPriceAscending();
        printToConsole.vehicleSpecifications();
        printToConsole.highestRatedPerTypeDescending();
    }

    /**
     * Print a list of all vehicles ordered by price in ascending order in the format:
     *      {name} - {price}
     */
    public void vehiclesPriceAscending() {
        List<Vehicle> vehicleList = parseFile.jsonToVehicleList("vehicles.json");
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
    public void vehicleSpecifications() {
        List<Vehicle> vehicleList = parseFile.jsonToVehicleList("vehicles.json");
        VehicleHelper vehicleHelper = new VehicleHelper();
        VehicleSpecification spec;
        System.out.println("--- Full specification of all vehicles: ---");
        for (Vehicle vehicle : vehicleList) {
            spec = vehicleHelper.getVehicleSpecification(vehicle);
            System.out.println(vehicle.getName() + " - " + vehicle.getSipp() + " - " + spec.getCarType() + " - " +
                    spec.getDoors() + " - " + spec.getTransmission() + " - " + spec.getFuel() + " - " + spec.getAirCon());
        }
        System.out.println("--- End of specifications ---");
    }

    /**
     * Print a list of the highest rated suppliers per car type in descending order in the format:
     *      {name} - {type} - {supplier} - {rating}
     */
    public void highestRatedPerTypeDescending() {
        VehicleHelper vehicleHelper = new VehicleHelper();
        ParseFile parseFile = new ParseFile();
        List<Vehicle> vehicleList = parseFile.jsonToVehicleList("vehicles.json");
        List<Vehicle> vehicles = vehicleHelper.getHighestRatedPerCarTypeDescending(vehicleList);
        System.out.println("--- Highest rated supplier per car type, descending order: ---");
        for (Vehicle vehicle : vehicles) {
            VehicleSpecification spec = vehicleHelper.getVehicleSpecification(vehicle);
            System.out.println(vehicle.getName() + " - " + spec.getCarType() + " - " + vehicle.getSupplier() + " - " + vehicle.getRating());
        }
        System.out.println("--- End of highest rated suppliers per car type ---");
    }
}
