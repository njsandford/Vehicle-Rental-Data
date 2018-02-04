package utilities;

import vehicles.Vehicle;
import vehicles.VehicleScore;
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
     * @param vehicle The vehicle to calculate the score for.
     * @return Integer score based on transmission type and air conditioning:
     *      Automatic transmission scores 5.
     *      Manual transmission scores 1.
     *      Air conditioning scores 2.
     */
    public int calculateScore(Vehicle vehicle) {
        int score = 0;
        String sipp = vehicle.getSipp();
        // If the transmission is automatic, increment the score by 5.
        if (sipp.charAt(2) == 'A') { score += 5; }
        // If the transmission is manual, increment the score by 1.
        else score += 1;
        // If the vehicle has air conditioning, increment the score by 2.
        if (sipp.charAt(3) == 'R') { score += 2; }
        return score;
    }

    /**
     * @param vehicleList List of all vehicles to calculate score for.
     * @return List of VehicleScore objects.
     */
    public List<VehicleScore> getVehicleScores(List<Vehicle> vehicleList) {
        List<VehicleScore> scores = new ArrayList<VehicleScore>();

        VehicleScore vehicleScore;
        for (Vehicle vehicle : vehicleList) {
            int score = calculateScore(vehicle);
            double totalScore = score + vehicle.getRating();
            vehicleScore = new VehicleScore(vehicle, score, totalScore);
            scores.add(vehicleScore);
        }

        return scores;
    }

    /**
     * @param vehicleList List of all vehicles to calculate score for.
     * @return List of VehicleScore objects sorted in descending order.
     */
    public List<VehicleScore> getVehicleScoresDescending(List<Vehicle> vehicleList) {
        List<VehicleScore> scores = getVehicleScores(vehicleList);

        // Sort by total score descending:
        Collections.sort(scores, VehicleScore.TotalScoreDescending);

        return scores;
    }

    /**
     * @param vehicleList List of all vehicles to calculate score for.
     * @return List of VehicleScore objects sorted in ascending order.
     */
    public List<VehicleScore> getVehicleScoresAscending(List<Vehicle> vehicleList) {
        List<VehicleScore> scores = getVehicleScores(vehicleList);

        // Sort by total score ascending:
        Collections.sort(scores, VehicleScore.TotalScoreAscending);

        return scores;
    }
}
