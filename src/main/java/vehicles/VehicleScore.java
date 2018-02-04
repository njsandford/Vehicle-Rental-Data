package vehicles;

import utilities.VehicleHelper;

import java.util.Comparator;

/**
 * @Author: Natalie Sandford
 * @Date: 04/02/2018
 * Provides a model to store the vehicle score breakdown.
 */
public class VehicleScore {

    // Private class variables:
    private Vehicle vehicle;
    private int score;
    private double totalScore;

    public VehicleScore(Vehicle vehicle, int score, double totalScore) {
        this.setVehicle(vehicle);
        this.setScore(score);
        this.setTotalScore(totalScore);
    }

    /**
     * Comparator to order VehicleScore objects by total score in descending order.
     */
    public static Comparator<VehicleScore> TotalScoreDescending = new Comparator<VehicleScore>() {

        public int compare(VehicleScore lhs, VehicleScore rhs) {
            double lhsScore = lhs.getTotalScore();
            double rhsScore = rhs.getTotalScore();

            // Descending order (multiply by 10 to ensure decimal value is not lost when converted to integer).
            return (int) ((rhsScore - lhsScore) * 10);
        }
    };

    /**
     * Comparator to order VehicleScore objects by total score in ascending order.
     */
    public static Comparator<VehicleScore> TotalScoreAscending = new Comparator<VehicleScore>() {

        public int compare(VehicleScore lhs, VehicleScore rhs) {
            double lhsScore = lhs.getTotalScore();
            double rhsScore = rhs.getTotalScore();

            // Ascending order (multiply by 10 to ensure decimal value is not lost when converted to integer).
            return (int) ((lhsScore - rhsScore) * 10);
        }
    };

    private void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    private void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    private void setTotalScore(double totalScore) {
        this.totalScore = totalScore;
    }

    public double getTotalScore() {
        return totalScore;
    }
}
