package utilities;

import vehicles.Vehicle;
import vehicles.VehicleSpecification;

import java.util.*;

/**
 * @Author: Natalie Sandford
 * @Date: 03/02/2018
 * Provides functionality to get information from Vehicle objects, such as extracting specification information from SIPP codes.
 */
public class VehicleHelper {

    /**
     * @param vehicle Four letter SIPP code.
     * @return Vehicle speicification object from four letter SIPP code.
     */
    public VehicleSpecification getVehicleSpecification(Vehicle vehicle) {
        return new VehicleSpecification(vehicle.getSipp());
    }

    /**
     * @param vehicleList List of all vehicles.
     * @return The highest rated suppliers per car type in descending order.
     */
    public List<Vehicle> getHighestRatedPerCarTypeDescending(List<Vehicle> vehicleList) {
        // First sort the vehicles by rating in descending order for more efficient searching of highest rating per car type.
        Collections.sort(vehicleList, Vehicle.RatingDescending);
        List<Vehicle> highestRated = new ArrayList<Vehicle>();

        // Add car type character to a list to keep track of which types have been added to the final list.
        List<Character> carTypes = new ArrayList<Character>();
        for (Vehicle vehicle : vehicleList) {
            char carType = vehicle.getSipp().charAt(0);
            // If the car types list already contains the current car type, then don't add to list.
            if (!carTypes.contains(carType)) {
                // Add car type to car types list:
                carTypes.add(carType);
                // Add vehicle to final list:
                highestRated.add(vehicle);
            }
        }
        // Return already sorted list:
        return highestRated;
    }

    /**
     * @param vehicleList List of all vehicles to sort by score.
     * @return List of Vehicle objects sorted in descending order by score.
     */
    public List<Vehicle> getVehiclesByScoreDescending(List<Vehicle> vehicleList) {
        // Sort by total score descending:
        Collections.sort(vehicleList, Vehicle.TotalScoreDescending);

        return vehicleList;
    }

    /**
     * @param vehicleList List of all vehicles to sort by score.
     * @return List of Vehicle objects sorted in ascending order by score.
     */
    public List<Vehicle> getVehiclesByScoreAscending(List<Vehicle> vehicleList) {
        // Sort by total score ascending:
        Collections.sort(vehicleList, Vehicle.TotalScoreAscending);

        return vehicleList;
    }
}
