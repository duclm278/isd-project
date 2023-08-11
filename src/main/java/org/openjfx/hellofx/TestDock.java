package org.openjfx.hellofx;

import org.openjfx.hellofx.models.dock.Dock;
import org.openjfx.hellofx.models.dock.DockService;

public class TestDock {
    public static void run() {
        // Dock: find
        DockService dockService = new DockService();
        System.out.println("All docks:");
        dockService.find().forEach(dock -> System.out.println(dock + "\n"));

        // Dock: findById
        System.out.println("Dock with id 64d6466e7ed72fcda7b14597:");
        Dock dock = dockService.findById("64d6466e7ed72fcda7b14597");
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
        System.out.println("Replacing dock with id 64d6466e7ed72fcda7b14597:");
        Dock updatedDock = new Dock(null, "test", "test", 0, 0.0, 0.0);
        updatedDock = dockService.findByIdAndReplace("64d6466e7ed72fcda7b14597", updatedDock);
        System.out.println(updatedDock + "\n");

        System.out.println("Restoring dock with id 64d6466e7ed72fcda7b14597:");
        Dock restoredDock = dockService.findByIdAndReplace("64d6466e7ed72fcda7b14597", dock);
        System.out.println(restoredDock + "\n");
    }
}
