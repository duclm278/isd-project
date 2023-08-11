package org.openjfx.hellofx;

import org.openjfx.hellofx.models.bike.Bike;
import org.openjfx.hellofx.models.bike.BikeService;

public class TestBike {
    public static void run() {
        // Bike: find
        BikeService bikeService = new BikeService();
        System.out.println("All bikes:");
        bikeService.find().forEach(bike -> System.out.println(bike + "\n"));

        // Bike: findById
        System.out.println("Bike with id 64d64f967ed72fcda7b145b1:");
        Bike bike = bikeService.findById("64d64f967ed72fcda7b145b1");
        System.out.println(bike + "\n");

        // Bike: findByBarcode
        System.out.println("Bike with barcode 00000001:");
        bike = bikeService.findByBarcode("00000001");
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
        System.out.println("Replacing bike with id 64d64f967ed72fcda7b145b1:");
        Bike updatedBike = new Bike(null, "00000001", "test", null, null, 0.0, null, null);
        updatedBike = bikeService.findByIdAndReplace("64d64f967ed72fcda7b145b1", updatedBike);
        System.out.println(updatedBike + "\n");

        System.out.println("Restoring bike with id 64d64f967ed72fcda7b145b1:");
        Bike restoredBike = bikeService.findByIdAndReplace("64d64f967ed72fcda7b145b1", bike);
        System.out.println(restoredBike + "\n");
    }
}
