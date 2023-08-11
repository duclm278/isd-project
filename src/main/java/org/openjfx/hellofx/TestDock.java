package org.openjfx.hellofx;

import org.openjfx.hellofx.models.dock.Dock;
import org.openjfx.hellofx.models.dock.DockService;

import com.mongodb.client.model.Filters;

public class TestDock {
    public static void run() {
        // Dock: find
        DockService dockService = new DockService();
        System.out.println("All docks:");
        dockService.find().forEach(dock -> System.out.println(dock + "\n"));

        // Dock: findByFilters
        String query = "Road";
        System.out.println("Docks having name or address containing \"" + query + "\" (case insensitive):");
        dockService
                .find(
                        Filters.or(
                                Filters.regex("name", query, "i"),
                                Filters.regex("address", query, "i")))
                .forEach(dock -> System.out.println(dock + "\n"));

        // Dock: findById
        System.out.println("Dock with id " + dockService.find().get(0).getId() + ":");
        Dock dock = dockService.findById(dockService.find().get(0).getId());
        System.out.println(dock + "\n");

        // Dock: save
        System.out.println("Saving new dock:");
        Dock newDock = new Dock(null, "test", "test", 0, 0.0, 0.0);
        newDock = dockService.save(newDock);
        System.out.println(newDock + "\n");

        // Dock: findByIdAndDelete
        System.out.println("Deleting recently saved dock:");
        Dock deletedDock = dockService.findByIdAndDelete(newDock.getId());
        System.out.println(deletedDock + "\n");

        // Dock: findByIdAndReplace
        System.out.println("Replacing dock with id " + dockService.find().get(0).getId() + ":");
        Dock updatedDock = new Dock(null, "test", "test", 0, 0.0, 0.0);
        updatedDock = dockService.findByIdAndReplace(dockService.find().get(0).getId(), updatedDock);
        System.out.println(updatedDock + "\n");

        System.out.println("Restoring dock with id " + dockService.find().get(0).getId() + ":");
        Dock restoredDock = dockService.findByIdAndReplace(dockService.find().get(0).getId(), dock);
        System.out.println(restoredDock + "\n");
    }
}
