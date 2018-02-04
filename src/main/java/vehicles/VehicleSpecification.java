package vehicles;

import java.util.Map;

/**
 * @Author: Natalie Sandford
 * @Date: 03/02/2018
 * Provides a model for the vehicle specification information which is obtained from the SIPP code.
 */
public class VehicleSpecification {

    private static Map<Character, String> typeMapping;
    private static Map<Character, String> doorsMapping;
    private static Map<Character, String> transmissionMapping;
    private static Map<Character, String> fuelMapping;
    private static Map<Character, String> airConMapping;

    private String carType;
    private String doors;
    private String transmission;
    private String fuel;
    private String airCon;

    public VehicleSpecification(String sipp) {
        if (sipp.length() >= 4) {
            setType(sipp.charAt(0));
            setDoors(sipp.charAt(1));
            setTransmission(sipp.charAt(2));
            setFuelAndAirCon(sipp.charAt(3));
        }
    }

    private void setType(char typeChar) {
        this.carType = CarType.valueOf(Character.toString(typeChar)).getValue();
    }

    public String getCarType() {
        return carType;
    }

    private void setDoors(char doorChar) {
        this.doors = Doors.valueOf(Character.toString(doorChar)).getValue();
    }

    public String getDoors() {
        return doors;
    }

    private void setTransmission(char transmissionChar) {
        this.transmission = Transmission.valueOf(Character.toString(transmissionChar)).getValue();
    }

    public String getTransmission() {
        return transmission;
    }

    private void setFuelAndAirCon(char fuelAndAirCon) {
        this.fuel = Fuel.valueOf(Character.toString(fuelAndAirCon)).getValue();
        this.airCon = AirCon.valueOf(Character.toString(fuelAndAirCon)).getValue();
    }

    public String getFuel() {
        return fuel;
    }

    public String getAirCon() {
        return airCon;
    }

    public enum CarType {
        M("Mini"), E("Economy"), C("Compact"), I("Intermediate"), S("Standard"), F("Full size"), P("Premium"), L("Luxury"), X("Special");

        private final String value;

        private CarType(String value) {
            this.value = value;
        }

        public String getValue() {
            return this.value;
        }
    }

    public enum Doors {
        B("2 doors"), C("4 doors"), D("5 doors"), W("Estate"), T("Convertible"), F("SUV"), P("Pick up"), V("Passenger Van");

        private final String value;

        private Doors(String value) {
            this.value = value;
        }

        public String getValue() {
            return this.value;
        }
    }

    public enum Transmission {
        M("Manual"), A("Automatic");

        private final String value;

        private Transmission(String value) {
            this.value = value;
        }

        public String getValue() {
            return this.value;
        }
    }

    public enum Fuel {
        N("Petrol"), R("Petrol");

        private final String value;

        private Fuel(String value) {
            this.value = value;
        }

        public String getValue() {
            return this.value;
        }
    }

    public enum AirCon {
        N("No AC"), R("AC");

        private final String value;

        private AirCon(String value) {
            this.value = value;
        }

        public String getValue() {
            return this.value;
        }
    }
}
