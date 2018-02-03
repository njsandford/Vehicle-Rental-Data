import org.junit.*;
import vehicles.Vehicle;

public class TestVehicle {

    @Test
    public void testConstructor() {
        String sipp = "CDMR";
        String name = "Ford Focus";
        double price = 157.85;
        String supplier = "Hertz";
        double rating = 8.9;

        Vehicle vehicle = new Vehicle(sipp, name, price, supplier, rating);

        Assert.assertEquals(sipp, vehicle.getSipp());
        Assert.assertEquals(name, vehicle.getName());
        Assert.assertTrue(price == vehicle.getPrice());
        Assert.assertEquals(supplier, vehicle.getSupplier());
        Assert.assertTrue(rating == vehicle.getRating());
    }

    @Test
    public void equalsShoubleBeTrue() {
        String sipp = "CDMR";
        String name = "Ford Focus";
        double price = 157.85;
        String supplier = "Hertz";
        double rating = 8.9;

        Vehicle vehicleOne = new Vehicle(sipp, name, price, supplier, rating);
        Vehicle vehicleTwo = new Vehicle(sipp, name, price, supplier, rating);

        // The equals relationship should be symmetrical.
        Assert.assertTrue(vehicleOne.equals(vehicleTwo));
        Assert.assertTrue(vehicleTwo.equals(vehicleOne));
    }

    @Test
    public void equalsShouldBeFalse() {
        Vehicle vehicleOne = new Vehicle("CDMR", "Ford Focus", 157.85, "Hertz", 8.9);
        Vehicle vehicleTwo = new Vehicle("CDAR", "Skoda Fabia", 219.71, "Sixt", 8.2);

        // The equals relationship should be symmetrical.
        Assert.assertFalse(vehicleOne.equals(vehicleTwo));
        Assert.assertFalse(vehicleTwo.equals(vehicleOne));
    }

    @Test
    public void toStringShouldReturnVehicleDetails() {
        String sipp = "CDMR";
        String name = "Ford Focus";
        double price = 157.85;
        String supplier = "Hertz";
        double rating = 8.9;

        String expected = "[" + sipp + ", " + name + ", " + price + ", " + supplier + ", " + rating + "]";
        Vehicle vehicle = new Vehicle(sipp, name, price, supplier, rating);

        Assert.assertEquals(expected, vehicle.toString());
    }
}
