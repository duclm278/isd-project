package org.openjfx.hellofx;

import java.util.List;
import java.util.Random;

import org.openjfx.hellofx.model.dock.Dock;
import org.openjfx.hellofx.model.dock.DockService;
import org.openjfx.hellofx.model.docking.Docking;
import org.openjfx.hellofx.model.docking.DockingService;
import org.openjfx.hellofx.model.renting.Renting;
import org.openjfx.hellofx.model.renting.RentingService;

public class TestRenting {
    public static void run() {
        DockService dockService = new DockService();
        DockingService dockingService = new DockingService();
        RentingService rentingService = new RentingService();

        List<Dock> docks = dockService.find();
        List<Docking> dockings = dockingService.find();

        // Renting: rentBike
        System.out.println("Renting a random available bike:");
        Docking docking = dockings.get(new Random().nextInt(dockings.size()));
        Renting renting = rentingService.rentBike(docking.getBikeId());
        System.out.println(renting + "\n");

        // Check if bike is no longer available
        System.out.println("Checking if bike is no longer available:");
        System.out.println("Bike " + renting.getBikeId() + " is "
                + (dockingService.findByBikeId(renting.getBikeId()) == null ? "not " : "") + "available\n");

        // Renting: returnBike
        System.out.println("Returning bike " + renting.getBikeId() + " to random dock:");
        Dock dock = docks.get(new Random().nextInt(docks.size()));
        renting = rentingService.returnBike(renting.getBikeId(), dock.getId());
        System.out.println(renting + "\n");

        // Check if bike is available again
        System.out.println("Checking if bike is available again:");
        System.out.println("Bike " + renting.getBikeId() + " is "
                + (dockingService.findByBikeId(renting.getBikeId()) == null ? "not " : "") + "available\n");
    }
}
