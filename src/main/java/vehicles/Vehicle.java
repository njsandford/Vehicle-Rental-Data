package vehicles;

public class Vehicle {

    // Private class variables
    private String sipp, name, supplier;
    private double price, rating;

    /**
     * Create a vehicle object.
     * @param sipp
     * @param name
     * @param price
     * @param supplier
     * @param rating
     */
    public Vehicle(String sipp, String name, double price, String supplier, double rating) {
        setSipp(sipp);
        setName(name);
        setPrice(price);
        setSupplier(supplier);
        setRating(rating);
    }

    /**
     * Get the SIPP of the vehicle.
     * @return The vehicle's SIPP.
     */
    public String getSipp() {
        return this.sipp;
    }

    /**
     * Set the SIPP of the vehicle.
     * @param sipp
     */
    private void setSipp(String sipp) {
        this.sipp = sipp;
    }

    /**
     * Get the name of the vehicle.
     * @return The name of the vehicle.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Set the name of the vehicle.
     * @param name
     */
    private void setName(String name) {
        this.name = name;
    }

    /**
     * Get the price of renting the vehicle.
     * @return The price of renting the vehicle.
     */
    public double getPrice() {
        return this.price;
    }

    /**
     * Set the price of renting the vehicle.
     * @param price
     */
    private void setPrice(double price) {
        this.price = price;
    }

    /**
     * Get the supplier of the vehicle.
     * @return The supplier of the vehicle.
     */
    public String getSupplier() {
        return this.supplier;
    }

    /**
     * Set the supplier of the vehicle.
     * @param supplier
     */
    private void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    /**
     * Get the rating of the supplier.
     * @return The rating of the supplier.
     */
    public double getRating() {
        return this.rating;
    }

    /**
     * Set the rating of the supplier.
     * @param rating
     */
    private void setRating(double rating) {
        this.rating = rating;
    }
}
