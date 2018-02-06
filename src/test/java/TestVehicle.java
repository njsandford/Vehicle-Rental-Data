import org.junit.*;
import utilities.ParseFile;
import vehicles.Vehicle;

import java.util.Collections;
import java.util.List;

/**
 * @Author: Natalie Sandford
 * @Date: 03/02/2018
 * Provides test coverage for the Vehicle class.
 */
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

    @Test
    public void comparatorShouldSortByPriceAscending() {
        ParseFile pf = new ParseFile();
        List<Vehicle> vehicleList = pf.jsonToVehicleList("vehicles.json");
        Collections.sort(vehicleList, Vehicle.PriceAscending);

        double previousPrice = 0;
        double currentPrice;

        // Assert true that for every vehicle, the rating is greater than or equal to the previous price.
        for (Vehicle vehicle : vehicleList) {
            currentPrice = vehicle.getPrice();
            Assert.assertTrue(currentPrice >= previousPrice);
            previousPrice = currentPrice;
        }
    }

    @Test
    public void comparatorShouldSortByPriceDescending() {
        ParseFile pf = new ParseFile();
        List<Vehicle> vehicleList = pf.jsonToVehicleList("vehicles.json");
        Collections.sort(vehicleList, Vehicle.PriceDescending);

        double previousPrice = 1000;
        double currentPrice;

        // Assert true that for every vehicle, the rating is less than or equal to the previous price.
        for (Vehicle vehicle : vehicleList) {
            currentPrice = vehicle.getPrice();
            Assert.assertTrue(currentPrice <= previousPrice);
            previousPrice = currentPrice;
        }
    }

    @Test
    public void comparatorShouldSortByRatingAscending() {
        ParseFile pf = new ParseFile();
        List<Vehicle> vehicleList = pf.jsonToVehicleList("vehicles.json");
        Collections.sort(vehicleList, Vehicle.RatingAscending);

        double previousRating = 0;
        double currentRating;

        // Assert true that for every vehicle, the rating is greater than or equal to the previous rating.
        for (Vehicle vehicle : vehicleList) {
            currentRating = vehicle.getRating();
            Assert.assertTrue(currentRating >= previousRating);
            previousRating = currentRating;
        }
    }

    @Test
    public void comparatorShouldSortByRatingDescending() {
        ParseFile pf = new ParseFile();
        List<Vehicle> vehicleList = pf.jsonToVehicleList("vehicles.json");
        Collections.sort(vehicleList, Vehicle.RatingDescending);

        double previousRating = 10;
        double currentRating;

        // Assert true that for every vehicle, the rating is less than or equal to the previous rating.
        for (Vehicle vehicle : vehicleList) {
            currentRating = vehicle.getRating();
            Assert.assertTrue(currentRating <= previousRating);
            previousRating = currentRating;
        }
    }

    @Test
    public void calculatesCorrectVehicleScore() {
        Vehicle vehicleOne = new Vehicle("CDMR", "Ford Focus", 157.85, "Hertz", 8.9);
        Vehicle vehicleTwo = new Vehicle("CDAR", "Skoda Fabia", 219.71, "Sixt", 8.2);
        Vehicle vehicleThree = new Vehicle("MBMN", "Kia Picanto", 136.57, "Hertz", 8.9);

        int scoreOne = vehicleOne.getScore();
        int scoreTwo = vehicleTwo.getScore();
        int scoreThree = vehicleThree.getScore();

        Assert.assertEquals(3, scoreOne);
        Assert.assertEquals(7, scoreTwo);
        Assert.assertEquals(1, scoreThree);
    }

    @Test
    public void shouldGetScoresInDescendingOrder() {
        ParseFile parseFile = new ParseFile();
        List<Vehicle> vehicleList = parseFile.jsonToVehicleList("vehicles.json");
        Collections.sort(vehicleList, Vehicle.TotalScoreDescending);

        double previousScore = 100;
        double currentScore;

        // Assert true that for every vehicle score, the current score is less than or equal to the previous score.
        for (Vehicle vehicle : vehicleList) {
            currentScore = vehicle.getTotalScore();
            Assert.assertTrue(currentScore <= previousScore);
            previousScore = currentScore;
        }
    }

    @Test
    public void shouldGetScoresInAscendingOrder() {
        ParseFile parseFile = new ParseFile();
        List<Vehicle> vehicleList = parseFile.jsonToVehicleList("vehicles.json");
        Collections.sort(vehicleList, Vehicle.TotalScoreAscending);

        double previousScore = 0;
        double currentScore;

        // Assert true that for every vehicle score, the current score is greater than or equal to the previous score.
        for (Vehicle vehicle : vehicleList) {
            currentScore = vehicle.getTotalScore();
            Assert.assertTrue(currentScore >= previousScore);
            previousScore = currentScore;
        }
    }
}
