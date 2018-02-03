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
}
