package org.openjfx.hellofx.controller;

import java.util.List;

import org.bson.types.ObjectId;
import org.openjfx.hellofx.model.dock.Dock;
import org.openjfx.hellofx.model.dock.DockService;
import org.openjfx.hellofx.model.dock.IDockService;

public class DockController {
    private IDockService dockService;

    public DockController() {
        dockService = new DockService();
    }

    public Dock create(Dock dock) {
        Dock result = dockService.save(dock);
        if (result == null) {
            throw new RuntimeException("Failed to create dock");
        }
        return result;
    }

    public List<Dock> find() {
        return dockService.find();
    }

    public Dock findById(ObjectId id) {
        return dockService.findById(id);
    }

    public List<Dock> findByNameOrAddress(String query) {
        if (query == "") {
            return dockService.find();
        }
        return dockService.findByNameOrAddress(query);
    }

    public Dock update(ObjectId id, Dock dock) {
        Dock result = dockService.findByIdAndReplace(id, dock);
        if (result == null) {
            throw new RuntimeException("Failed to update dock");
        }
        return result;
    }

    public Dock delete(ObjectId id) {
        Dock result = dockService.findByIdAndReplace(id, null);
        if (result == null) {
            throw new RuntimeException("Failed to delete dock");
        }
        return result;
    }
}
