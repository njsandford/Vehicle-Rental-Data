import org.junit.*;
import utilities.ParseFile;
import vehicles.Vehicle;

import java.util.List;

/**
 * @Author: Natalie Sandford
 * @Date: 03/02/2018
 * Provides test coverage for the ParseFile class.
 */
public class TestParseFile {

    @Test
    public void jsonToVehicleListShouldReturnAllVehicles() {
        ParseFile pf = new ParseFile();
        List<Vehicle> vehicleList = pf.jsonToVehicleList("vehicles.json");
        Assert.assertEquals(31, vehicleList.size());
    }


}
