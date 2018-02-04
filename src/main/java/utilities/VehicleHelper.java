package utilities;

import vehicles.Vehicle;
import vehicles.VehicleSpecification;

/**
 * @Author: Natalie Sandford
 * @Date: 03/02/2018
 * Provides functionality to get information from Vehicle objects, such as extracting specification information from SIPP codes.
 */
public class VehicleHelper {

    /**
     * @param vehicle Four letter SIPP code.
     * @return Vehicle speicification object from four letter SIPP code.
     */
    public VehicleSpecification getVehicleSpecification(Vehicle vehicle) {
        return new VehicleSpecification(vehicle.getSipp());
    }
}
