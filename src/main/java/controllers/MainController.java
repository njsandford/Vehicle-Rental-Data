package controllers;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import utilities.ParseFile;
import utilities.VehicleHelper;
import vehicles.Vehicle;

import java.util.List;

@Controller
public class MainController {

    @RequestMapping("/")
    @ResponseBody
    public String home() {
        return "Vehicle Rental Application";
    }

    /**
     * @return Json string of all vehicles ordered by price in ascending order.
     */
    @RequestMapping(value = "/PriceAscending", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public ResponseEntity<String> priceAscending() {
        ParseFile parseFile = new ParseFile();
        VehicleHelper vehicleHelper = new VehicleHelper();
        List<Vehicle> vehicleList = vehicleHelper.getVehiclesByPriceAscending(parseFile.jsonToVehicleList("vehicles.json"));

        JsonObject vehicleObject;
        JsonArray vehicles = new JsonArray();
        for (Vehicle vehicle : vehicleList) {
            vehicleObject = new JsonObject();
            vehicleObject.addProperty("name", vehicle.getName());
            vehicleObject.addProperty("price", vehicle.getPrice());
            vehicles.add(vehicleObject);
        }
        return new ResponseEntity<String>(vehicles.toString(), HttpStatus.OK);
    }

    /**
     * @return Json string of all vehicle specifications.
     */
    @RequestMapping(value = "/VehicleSpecifications", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public ResponseEntity<String> vehicleSpecifications() {
        ParseFile parseFile = new ParseFile();
        List<Vehicle> vehicleList = parseFile.jsonToVehicleList("vehicles.json");

        JsonObject vehicleObject;
        JsonArray vehicles = new JsonArray();
        for (Vehicle vehicle : vehicleList) {
            vehicleObject = new JsonObject();
            vehicleObject.addProperty("name", vehicle.getName());
            vehicleObject.addProperty("sipp", vehicle.getSipp());
            vehicleObject.addProperty("carType", vehicle.getCarType());
            vehicleObject.addProperty("doors", vehicle.getDoors());
            vehicleObject.addProperty("transmission", vehicle.getTransmission());
            vehicleObject.addProperty("fuel", vehicle.getFuel());
            vehicleObject.addProperty("airCon", vehicle.getAirCon());
            vehicles.add(vehicleObject);
        }
        return new ResponseEntity<String>(vehicles.toString(), HttpStatus.OK);
    }

    /**
     * @return Json string of the highest rated supplier for each vehicle type, sorted by rating descending.
     */
    @RequestMapping(value = "/HighestRated", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public ResponseEntity<String> highestRated() {
        ParseFile parseFile = new ParseFile();
        VehicleHelper vehicleHelper = new VehicleHelper();
        List<Vehicle> vehicleList = vehicleHelper.getHighestRatedPerCarTypeDescending(parseFile.jsonToVehicleList("vehicles.json"));

        JsonObject vehicleObject;
        JsonArray vehicles = new JsonArray();
        for (Vehicle vehicle : vehicleList) {
            vehicleObject = new JsonObject();
            vehicleObject.addProperty("name", vehicle.getName());
            vehicleObject.addProperty("carType", vehicle.getCarType());
            vehicleObject.addProperty("supplier", vehicle.getSupplier());
            vehicleObject.addProperty("rating", vehicle.getRating());
            vehicles.add(vehicleObject);
        }

        return new ResponseEntity<String>(vehicles.toString(), HttpStatus.OK);
    }


    /**
     * @return Json string of all vehicles and corresponding scores, ordered by total score descending.
     */
    @RequestMapping(value = "/VehicleScores", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public ResponseEntity<String> vehicleScores() {
        ParseFile parseFile = new ParseFile();
        VehicleHelper vehicleHelper = new VehicleHelper();
        List<Vehicle> vehicleList = vehicleHelper.getVehiclesByScoreDescending(parseFile.jsonToVehicleList("vehicles.json"));

        JsonObject vehicleObject;
        JsonArray vehicles = new JsonArray();
        for (Vehicle vehicle : vehicleList) {
            vehicleObject = new JsonObject();
            vehicleObject.addProperty("name", vehicle.getName());
            vehicleObject.addProperty("score", vehicle.getScore());
            vehicleObject.addProperty("rating", vehicle.getRating());
            vehicleObject.addProperty("totalScore", vehicle.getTotalScore());
            vehicles.add(vehicleObject);
        }

        return new ResponseEntity<String>(vehicles.toString(), HttpStatus.OK);
    }
}
