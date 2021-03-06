package utilities;

import vehicles.Vehicle;

import java.util.*;

/**
 * @Author: Natalie Sandford
 * @Date: 03/02/2018
 * Provides additional functionality for Vehicle objects, such as obtaining sorted lists of vehicles.
 */
public class VehicleHelper {

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
     * @param vehicleList List of all vehicles to sort by price.
     * @return List of Vehicle objects sorted in descending order by price.
     */
    public List<Vehicle> getVehiclesByPriceDescending(List<Vehicle> vehicleList) {
        // Sort by price descending:
        Collections.sort(vehicleList, Vehicle.PriceDescending);

        return vehicleList;
    }

    /**
     * @param vehicleList List of all vehicles to sort by price.
     * @return List of Vehicle objects sorted in ascending order by price.
     */
    public List<Vehicle> getVehiclesByPriceAscending(List<Vehicle> vehicleList) {
        // Sort by price ascending:
        Collections.sort(vehicleList, Vehicle.PriceAscending);

        return vehicleList;
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
