package vehicles;

import java.util.Map;

/**
 * @Author: Natalie Sandford
 * @Date: 03/02/2018
 * Provides a model for the vehicle specification information which is obtained from the SIPP code.
 */
public class VehicleSpecification {

    // Private class variables
    private String carType;
    private String doors;
    private String transmission;
    private String fuel;
    private String airCon;

    /**
     * SIPP code must be at least four letters in length to be able to calculate the specification.
     * @param sipp
     */
    public VehicleSpecification(String sipp) {
        if (sipp.length() >= 4) {
            setType(sipp.charAt(0));
            setDoors(sipp.charAt(1));
            setTransmission(sipp.charAt(2));
            setFuelAndAirCon(sipp.charAt(3));
        }
    }

    /**
     * @param typeChar Corresponding letter from the SIPP code that represents car type.
     */
    private void setType(char typeChar) {
        try {
            this.carType = CarType.valueOf(Character.toString(typeChar)).getValue();
        } catch (IllegalArgumentException e) {
            this.carType = "Unknown";
        }
    }

    public String getCarType() {
        return carType;
    }

    /**
     * @param doorChar Corresponding letter from the SIPP code that represents doors/car type.
     */
    private void setDoors(char doorChar) {
        try {
            this.doors = Doors.valueOf(Character.toString(doorChar)).getValue();
        } catch (IllegalArgumentException e) {
            this.doors = "Unknown";
        }
    }

    public String getDoors() {
        return doors;
    }

    /**
     * @param transmissionChar Corresponding letter from the SIPP code that represents transmission.
     */
    private void setTransmission(char transmissionChar) {
        try {
            this.transmission = Transmission.valueOf(Character.toString(transmissionChar)).getValue();
        } catch (IllegalArgumentException e) {
            this.transmission = "Unknown";
        }
    }

    public String getTransmission() {
        return transmission;
    }

    /**
     * @param fuelAndAirCon Corresponding letter from the SIPP code that represents fuel/air con.
     */
    private void setFuelAndAirCon(char fuelAndAirCon) {
        try {
            this.fuel = Fuel.valueOf(Character.toString(fuelAndAirCon)).getValue();
        } catch (IllegalArgumentException e) {
            this.fuel = "Unknown";
        }
        try {
            this.airCon = AirCon.valueOf(Character.toString(fuelAndAirCon)).getValue();
        } catch (IllegalArgumentException e) {
            this.airCon = "Unknown";
        }
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

        CarType(String value) {
            this.value = value;
        }

        public String getValue() {
            return this.value;
        }
    }

    public enum Doors {
        B("2 doors"), C("4 doors"), D("5 doors"), W("Estate"), T("Convertible"), F("SUV"), P("Pick up"), V("Passenger Van");

        private final String value;

        Doors(String value) {
            this.value = value;
        }

        public String getValue() {
            return this.value;
        }
    }

    public enum Transmission {
        M("Manual"), A("Automatic");

        private final String value;

        Transmission(String value) {
            this.value = value;
        }

        public String getValue() {
            return this.value;
        }
    }

    public enum Fuel {
        N("Petrol"), R("Petrol");

        private final String value;

        Fuel(String value) {
            this.value = value;
        }

        public String getValue() {
            return this.value;
        }
    }

    public enum AirCon {
        N("No AC"), R("AC");

        private final String value;

        AirCon(String value) {
            this.value = value;
        }

        public String getValue() {
            return this.value;
        }
    }
}
