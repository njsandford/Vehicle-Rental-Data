import org.junit.*;
import utilities.ParseFile;
import utilities.VehicleHelper;
import vehicles.Vehicle;

import java.util.List;

/**
 * @Author: Natalie Sandford
 * @Date: 03/02/2018
 * Provides test coverage for the VehicleHelper class.
 */
public class TestVehicleHelper {

    @Test
    public void shouldGetHighestRatedPerType() {
        VehicleHelper vehicleHelper = new VehicleHelper();
        ParseFile parseFile = new ParseFile();
        List<Vehicle> vehicleList = parseFile.jsonToVehicleList("vehicles.json");
        List<Vehicle> vehicles = vehicleHelper.getHighestRatedPerCarTypeDescending(vehicleList);

        Assert.assertEquals(6, vehicles.size());
    }

    @Test
    public void shouldGetVehiclesByPriceInDescendingOrder() {
        VehicleHelper vehicleHelper = new VehicleHelper();
        ParseFile parseFile = new ParseFile();
        List<Vehicle> vehicleList = parseFile.jsonToVehicleList("vehicles.json");
        List<Vehicle> sortedVehicles = vehicleHelper.getVehiclesByPriceDescending(vehicleList);

        double previousPrice = 1000;
        double currentPrice;

        // Assert true that for every vehicle score, the current score is less than or equal to the previous score.
        for (Vehicle vehicle : sortedVehicles) {
            currentPrice = vehicle.getPrice();
            Assert.assertTrue(currentPrice <= previousPrice);
            previousPrice = currentPrice;
        }
    }

    @Test
    public void shouldGetVehiclesByPriceInAscendingOrder() {
        VehicleHelper vehicleHelper = new VehicleHelper();
        ParseFile parseFile = new ParseFile();
        List<Vehicle> vehicleList = parseFile.jsonToVehicleList("vehicles.json");
        List<Vehicle> sortedVehicles = vehicleHelper.getVehiclesByPriceAscending(vehicleList);

        double previousPrice = 0;
        double currentPrice;

        // Assert true that for every vehicle score, the current score is greater than or equal to the previous score.
        for (Vehicle vehicle : sortedVehicles) {
            currentPrice = vehicle.getPrice();
            Assert.assertTrue(currentPrice >= previousPrice);
            previousPrice = currentPrice;
        }
    }

    @Test
    public void shouldGetVehiclesByScoreInDescendingOrder() {
        VehicleHelper vehicleHelper = new VehicleHelper();
        ParseFile parseFile = new ParseFile();
        List<Vehicle> vehicleList = parseFile.jsonToVehicleList("vehicles.json");
        List<Vehicle> sortedVehicles = vehicleHelper.getVehiclesByScoreDescending(vehicleList);

        double previousScore = 100;
        double currentScore;

        // Assert true that for every vehicle score, the current score is less than or equal to the previous score.
        for (Vehicle vehicle : sortedVehicles) {
            currentScore = vehicle.getTotalScore();
            Assert.assertTrue(currentScore <= previousScore);
            previousScore = currentScore;
        }
    }

    @Test
    public void shouldGetVehiclesByScoreInAscendingOrder() {
        VehicleHelper vehicleHelper = new VehicleHelper();
        ParseFile parseFile = new ParseFile();
        List<Vehicle> vehicleList = parseFile.jsonToVehicleList("vehicles.json");
        List<Vehicle> sortedVehicles = vehicleHelper.getVehiclesByScoreAscending(vehicleList);

        double previousScore = 0;
        double currentScore;

        // Assert true that for every vehicle score, the current score is greater than or equal to the previous score.
        for (Vehicle vehicle : sortedVehicles) {
            currentScore = vehicle.getTotalScore();
            Assert.assertTrue(currentScore >= previousScore);
            previousScore = currentScore;
        }
    }
}
