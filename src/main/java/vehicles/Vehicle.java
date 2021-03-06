package vehicles;

import java.util.Comparator;

/**
 * @Author Natalie Sandford
 * @Date 02/02/2018
 * Provides a vehicle model with rental information information: name, SIPP, supplier, price and rating.
 */
public class Vehicle {

    // Core class variables:
    private String sipp;
    private String name;
    private String supplier;
    private double price;
    private double rating;

    // Vehicle specification variables:
    private String carType;
    private String doors;
    private String transmission;
    private String fuel;
    private String airCon;

    // Vehicle scores:
    private int score;
    private double totalScore;

    /**
     * @param sipp Four letter SIPP code.
     * @param name Name of vehicle, e.g. "Ford Focus".
     * @param price Rental price of the vehicle in GBP.
     * @param supplier Name of the vehicle supplier, e.g. "Hertz".
     * @param rating Supplier's rating out of 10.
     */
    public Vehicle(String sipp, String name, double price, String supplier, double rating) {
        // Populate the core fields:
        setSipp(sipp);
        setName(name);
        setPrice(price);
        setSupplier(supplier);
        setRating(rating);
        // Set vehicle specification fields:
        setVehicleSpecification();
        // Calculate vehicle scores now that the core fields are populated:
        setScore();
        setTotalScore();
    }

    /**
     * Set the vehicle specification fields from the four character SIPP code.
     */
    private void setVehicleSpecification() {
        if (getSipp().length() >= 4) {
            setType(getSippChar(0));
            setDoors(getSippChar(1));
            setTransmission(getSippChar(2));
            setFuelAndAirCon(getSippChar(3));
        }
    }

    /**
     * @param o Vehicle to compare with.
     * @return boolean Checking if the object o is also a Vehicle and has the same name, SIPP code, price, supplier and rating.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vehicle vehicle = (Vehicle) o;

        if (Double.compare(vehicle.price, price) != 0) return false;
        if (Double.compare(vehicle.rating, rating) != 0) return false;
        if (!sipp.equals(vehicle.sipp)) return false;
        if (!name.equals(vehicle.name)) return false;
        return supplier.equals(vehicle.supplier);
    }

    /**
     * @return hashcode for the current vehicle based on name, SIPP code, price, supplier and rating.
     */
    @Override
    public int hashCode() {
        int result;
        long temp;
        result = sipp.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + supplier.hashCode();
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(rating);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "[" + getSipp() + ", " + getName() + ", " + getPrice() + ", " + getSupplier() + ", " + getRating() + "]";
    }

    /**
     * Comparator to sort vehicles by price in ascending order.
     */
    public static Comparator<Vehicle> PriceAscending = new Comparator<Vehicle>() {

        public int compare(Vehicle lhs, Vehicle rhs) {
            double lhsPrice = lhs.getPrice();
            double rhsPrice = rhs.getPrice();

            // Ascending order (multiply by 10 to ensure decimal value is not lost when converted to integer).
            return (int) (lhsPrice - rhsPrice);
        }
    };

    /**
     * Comparator to sort vehicles by price in descending order.
     */
    public static Comparator<Vehicle> PriceDescending = new Comparator<Vehicle>() {

        public int compare(Vehicle lhs, Vehicle rhs) {
            double lhsPrice = lhs.getPrice();
            double rhsPrice = rhs.getPrice();

            // Descending order (multiply by 10 to ensure decimal value is not lost when converted to integer).
            return (int) ((rhsPrice - lhsPrice) * 10);
        }
    };

    /**
     * Comparator to sort vehicles by supplier rating in ascending order.
     */
    public static Comparator<Vehicle> RatingAscending = new Comparator<Vehicle>() {

        public int compare(Vehicle lhs, Vehicle rhs) {
            double lhsRating = lhs.getRating();
            double rhsRating = rhs.getRating();

            // Ascending order (multiply by 10 to ensure decimal value is not lost when converted to integer).
            return (int) ((lhsRating - rhsRating) * 10);
        }
    };

    /**
     * Comparator to sort vehicles by supplier rating in descending order.
     */
    public static Comparator<Vehicle> RatingDescending = new Comparator<Vehicle>() {

        public int compare(Vehicle lhs, Vehicle rhs) {
            double lhsRating = lhs.getRating();
            double rhsRating = rhs.getRating();

            // Descending order (multiply by 10 to ensure decimal value is not lost when converted to integer).
            return (int) ((rhsRating - lhsRating) * 10);
        }
    };

    /**
     * Comparator to order Vehicle objects by total score in ascending order.
     */
    public static Comparator<Vehicle> TotalScoreAscending = new Comparator<Vehicle>() {

        public int compare(Vehicle lhs, Vehicle rhs) {
            double lhsScore = lhs.getTotalScore();
            double rhsScore = rhs.getTotalScore();

            // Ascending order (multiply by 10 to ensure decimal value is not lost when converted to integer).
            return (int) ((lhsScore - rhsScore) * 10);
        }
    };

    /**
     * Comparator to order Vehicle objects by total score in descending order.
     */
    public static Comparator<Vehicle> TotalScoreDescending = new Comparator<Vehicle>() {

        public int compare(Vehicle lhs, Vehicle rhs) {
            double lhsScore = lhs.getTotalScore();
            double rhsScore = rhs.getTotalScore();

            // Descending order (multiply by 10 to ensure decimal value is not lost when converted to integer).
            return (int) ((rhsScore - lhsScore) * 10);
        }
    };

    /**
     * @return Four letter SIPP code.
     */
    public String getSipp() {
        return this.sipp;
    }

    /**
     * @param index the index of the SIPP character to return e.g. the 3rd character which represents transmission is at index 2.
     * @return the character at the corresponding index.
     */
    private char getSippChar(int index) {
        return this.sipp.charAt(index);
    }

    /**
     * @param sipp Must be a valid four letter SIPP code, e.g. "CDMR".
     */
    private void setSipp(String sipp) {
        this.sipp = sipp;
    }

    /**
     * @return Name of the vehicle.
     */
    public String getName() {
        return this.name;
    }

    /**
     * @param name Name of vehicle, e.g. "Ford Focus".
     */
    private void setName(String name) {
        this.name = name;
    }

    /**
     * @return Price of renting the vehicle in GBP.
     */
    public double getPrice() {
        return this.price;
    }

    /**
     * @param price Must be greater than or equal to 0.
     */
    private void setPrice(double price) {
        this.price = price;
    }

    /**
     * @return Supplier of the vehicle.
     */
    public String getSupplier() {
        return this.supplier;
    }

    /**
     * @param supplier Name of the supplier, e.g. "Hertz".
     */
    private void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    /**
     * @return Rating of the supplier.
     */
    public double getRating() {
        return this.rating;
    }

    /**
     * @param rating Must be between 0 and 10.
     */
    private void setRating(double rating) {
        this.rating = rating;
    }

    /**
     * Calculates the vehicle score based on transmission type and air conditioning:
     *      Automatic transmission scores 5.
     *      Manual transmission scores 1.
     *      Air conditioning scores 2.
     */
    private void setScore() {
        int score = 0;
        // If the transmission is automatic, increment the score by 5.
        if (getSippChar(2) == 'A') { score += 5; }
        // If the transmission is manual, increment the score by 1.
        else score += 1;
        // If the vehicle has air conditioning, increment the score by 2.
        if (getSippChar(3) == 'R') { score += 2; }
        this.score = score;
    }

    /**
     * @return The calculated vehicle score based on transmission type and air conditioning.
     */
    public int getScore() {
        return this.score;
    }

    /**
     * Calculate the total score based on vehicle score and rating.
     */
    private void setTotalScore() {
        this.totalScore = getScore() + getRating();
    }

    /**
     * @return The total score based on vehicle score and rating.
     */
    public double getTotalScore() {
        return totalScore;
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


    /**  Enums for calculating Vehicle Specification  **/

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
