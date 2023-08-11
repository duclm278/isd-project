package org.openjfx.hellofx;

import java.util.List;

import org.openjfx.hellofx.models.bike.Bike;
import org.openjfx.hellofx.models.bike.BikeService;

public class TestBike {
    public static void run() {
        // Bike: find
        BikeService bikeService = new BikeService();
        System.out.println("All bikes:");
        List<Bike> bikes = bikeService.find();
        bikes.forEach(bike -> System.out.println(bike + "\n"));

        // Bike: findById
        System.out.println("Bike with id " + bikes.get(0).getId() + ":");
        Bike bike = bikeService.findById(bikes.get(0).getId());
        System.out.println(bike + "\n");

        // Bike: findByBarcode
        System.out.println("Bike with barcode " + bikes.get(0).getBarcode() + ":");
        bike = bikeService.findByBarcode(bikes.get(0).getBarcode());
        System.out.println(bike + "\n");

        // Bike: save
        System.out.println("Saving new bike:");
        Bike newBike = new Bike(null, "11111111", "test", null, null, 0.0, null, null);
        newBike = bikeService.save(newBike);
        System.out.println(newBike + "\n");

        // Bike: findByIdAndDelete
        System.out.println("Deleting recently saved bike:");
        Bike deletedBike = bikeService.findByIdAndDelete(newBike.getId());
        System.out.println(deletedBike + "\n");

        // Bike: findByIdAndReplace
        System.out.println("Replacing bike with id " + bikes.get(0).getId() + ":");
        Bike updatedBike = new Bike(null, "00000001", "test", null, null, 0.0, null, null);
        updatedBike = bikeService.findByIdAndReplace(bikes.get(0).getId(), updatedBike);
        System.out.println(updatedBike + "\n");

        System.out.println("Restoring bike with id " + bikes.get(0).getId() + ":");
        Bike restoredBike = bikeService.findByIdAndReplace(bikes.get(0).getId(), bike);
        System.out.println(restoredBike + "\n");
    }
}
