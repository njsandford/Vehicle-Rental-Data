import org.junit.*;
import utilities.VehicleHelper;
import vehicles.Vehicle;
import vehicles.VehicleSpecification;

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
}
