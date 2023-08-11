package org.openjfx.hellofx;

import java.util.List;
import java.util.Random;

import org.openjfx.hellofx.models.bike.Bike;
import org.openjfx.hellofx.models.bike.BikeService;
import org.openjfx.hellofx.models.dock.Dock;
import org.openjfx.hellofx.models.dock.DockService;
import org.openjfx.hellofx.models.docking.Docking;
import org.openjfx.hellofx.models.docking.DockingService;

public class TestDocking {
    public static void run() {
        DockingService dockingService = new DockingService();
        System.out.println("Deleting all dockings:");
        dockingService.find().forEach(docking -> System.out.println(dockingService.findByIdAndDelete(docking.getId())));

        List<Bike> bikes = new BikeService().find();
        List<Dock> docks = new DockService().find();

        // Assigning bikes to random docks, take capacity into account
        System.out.println("Assigning bikes to random docks:");
        for (Bike bike : bikes) {
            // Random from 0 to docks.size() - 1
            Dock dock = docks.get(new Random().nextInt(docks.size()));
            System.out.println("Bike " + bike.getId() + " to dock " + dock.getId());
            Docking newDocking = dockingService.save(new Docking(null, bike.getId(), dock.getId()));
            System.out.println(newDocking + "\n");
        }
    }
}
