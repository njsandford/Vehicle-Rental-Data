import org.junit.*;
import utilities.ParseFile;
import utilities.VehicleHelper;
import vehicles.Vehicle;
import vehicles.VehicleSpecification;

import java.util.List;

/**
 * @Author: Natalie Sandford
 * @Date: 03/02/2018
 * Provides test coverage for the VehicleHelper class.
 */
public class TestVehicleHelper {

    @Test
    public void shouldGetCorrectVehicleSpecification() {
        Vehicle vehicle = new Vehicle("CDMR", "Ford Focus", 157.85, "Hertz", 8.9);
        VehicleHelper vehicleHelper = new VehicleHelper();
        VehicleSpecification spec = vehicleHelper.getVehicleSpecification(vehicle);

        Assert.assertEquals("Compact", spec.getCarType());
        Assert.assertEquals("5 doors", spec.getDoors());
        Assert.assertEquals("Manual", spec.getTransmission());
        Assert.assertEquals("Petrol", spec.getFuel());
        Assert.assertEquals("AC", spec.getAirCon());
    }

    @Test
    public void shouldGetHighestRatedPerType() {
        VehicleHelper vehicleHelper = new VehicleHelper();
        ParseFile parseFile = new ParseFile();
        List<Vehicle> vehicleList = parseFile.jsonToVehicleList("vehicles.json");
        List<Vehicle> vehicles = vehicleHelper.getHighestRatedPerCarTypeDescending(vehicleList);

        Assert.assertEquals(6, vehicles.size());
    }

    @Test
    public void calculatesCorrectVehicleScore() {
        Vehicle vehicleOne = new Vehicle("CDMR", "Ford Focus", 157.85, "Hertz", 8.9);
        Vehicle vehicleTwo = new Vehicle("CDAR", "Skoda Fabia", 219.71, "Sixt", 8.2);
        Vehicle vehicleThree = new Vehicle("MBMN", "Kia Picanto", 136.57, "Hertz", 8.9);

        VehicleHelper vehicleHelper = new VehicleHelper();

        int scoreOne = vehicleHelper.calculateScore(vehicleOne);
        int scoreTwo = vehicleHelper.calculateScore(vehicleTwo);
        int scoreThree = vehicleHelper.calculateScore(vehicleThree);

        Assert.assertEquals(3, scoreOne);
        Assert.assertEquals(7, scoreTwo);
        Assert.assertEquals(1, scoreThree);
    }
}
