package org.openjfx.hellofx;

import java.util.List;
import java.util.Optional;

import org.openjfx.hellofx.model.bike.Bike;
import org.openjfx.hellofx.model.bike.BikeService;
import org.openjfx.hellofx.model.bike.IBikeService;

public class TestBike {
    public static void run() {
        // Bike: find
        IBikeService bikeService = new BikeService();
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
        Bike newBike = new Bike(null, "11111111", "test", Optional.ofNullable(null), Optional.ofNullable(null), 0,
                Optional.ofNullable(null), Optional.ofNullable(null));
        newBike = bikeService.save(newBike);
        System.out.println(newBike + "\n");

        // Bike: findByIdAndDelete
        System.out.println("Deleting recently saved bike:");
        Bike deletedBike = bikeService.findByIdAndDelete(newBike.getId());
        System.out.println(deletedBike + "\n");

        // Bike: findByIdAndReplace
        System.out.println("Replacing bike with id " + bikes.get(0).getId() + ":");
        Bike updatedBike = new Bike(bikes.get(0).getId(), "11111111", "test", Optional.ofNullable(null),
                Optional.ofNullable(null), 0, Optional.ofNullable(null), Optional.ofNullable(null));
        updatedBike = bikeService.findByIdAndReplace(bikes.get(0).getId(), updatedBike);
        System.out.println(updatedBike + "\n");

        System.out.println("Restoring bike with id " + bikes.get(0).getId() + ":");
        Bike restoredBike = bikeService.findByIdAndReplace(bikes.get(0).getId(), bike);
        System.out.println(restoredBike + "\n");
    }
}
