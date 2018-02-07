package controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import utilities.ParseFile;
import utilities.VehicleHelper;
import vehicles.Vehicle;

import java.util.Collections;
import java.util.List;

@Controller
public class MainController {

    @RequestMapping("/")
    @ResponseBody
    public String home() {
        return "Vehicle Rental Application";
    }

    @RequestMapping("/PriceAscending")
    @ResponseBody
    public String priceAscending() {
        ParseFile parseFile = new ParseFile();
        List<Vehicle> vehicleList = parseFile.jsonToVehicleList("vehicles.json");
        Collections.sort(vehicleList, Vehicle.PriceAscending);
        String content = "";
        for (Vehicle vehicle : vehicleList) {
            content += "<p>" + vehicle.getName() + " - " + vehicle.getPrice() + "</p>";
        }
        return content;
    }

    @RequestMapping("/VehicleSpecifications")
    @ResponseBody
    public String vehicleSpecifications() {
        ParseFile parseFile = new ParseFile();
        List<Vehicle> vehicleList = parseFile.jsonToVehicleList("vehicles.json");

        String content = "";

        for (Vehicle vehicle : vehicleList) {
            content += "<p>" + vehicle.getName() + " - " + vehicle.getSipp() + " - " + vehicle.getCarType() + " - " +
                    vehicle.getDoors() + " - " + vehicle.getTransmission() + " - " + vehicle.getFuel() + " - " + vehicle.getAirCon() + "</p>";
        }

        return content;
    }

    @RequestMapping("/HighestRated")
    @ResponseBody
    public String highestRated() {
        ParseFile parseFile = new ParseFile();
        List<Vehicle> vehicleList = parseFile.jsonToVehicleList("vehicles.json");

        VehicleHelper vehicleHelper = new VehicleHelper();
        List<Vehicle> vehicles = vehicleHelper.getHighestRatedPerCarTypeDescending(vehicleList);

        String content = "";

        for (Vehicle vehicle : vehicles) {
            content += "<p>" + vehicle.getName() + " - " + vehicle.getCarType() + " - " + vehicle.getSupplier() + " - " + vehicle.getRating() + "</p>";
        }
        return content;
    }


    @RequestMapping("/VehicleScores")
    @ResponseBody
    public String vehicleScores() {
        ParseFile parseFile = new ParseFile();
        List<Vehicle> vehicleList = parseFile.jsonToVehicleList("vehicles.json");

        VehicleHelper vehicleHelper = new VehicleHelper();
        List<Vehicle> vehicles = vehicleHelper.getVehiclesByScoreDescending(vehicleList);

        String content = "";

        for (Vehicle vehicle : vehicles) {
            content += "<p>" + vehicle.getName() + " - " + vehicle.getScore() + " - " + vehicle.getRating() + " - " + vehicle.getTotalScore() + "</p>";
        }
        return content;
    }

    @RequestMapping(value = "/vehicle/", method = RequestMethod.GET)
    public ResponseEntity<List<Vehicle>> listAllUsers() {
        ParseFile parseFile = new ParseFile();
        List<Vehicle> vehicles = parseFile.jsonToVehicleList("vehicles.json");
        if (vehicles.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
            // You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Vehicle>>(vehicles, HttpStatus.OK);
    }
}
