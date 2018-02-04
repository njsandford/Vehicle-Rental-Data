import org.junit.*;
import vehicles.VehicleSpecification;

/**
 * @Author: Natalie Sandford
 * @Date: 03/02/2018
 * Provides test coverage for the VehicleSpecification class.
 */
public class TestVehicleSpecification {

    @Test
    public void constructorShouldSetCorrectSpecification() {
        VehicleSpecification spec = new VehicleSpecification("CDMR");
        Assert.assertEquals("Compact", spec.getCarType());
        Assert.assertEquals("5 doors", spec.getDoors());
        Assert.assertEquals("Manual", spec.getTransmission());
        Assert.assertEquals("Petrol", spec.getFuel());
        Assert.assertEquals("AC", spec.getAirCon());
    }

}
