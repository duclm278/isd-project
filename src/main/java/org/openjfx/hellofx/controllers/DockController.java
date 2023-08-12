package org.openjfx.hellofx.controllers;

import java.util.List;

import org.bson.types.ObjectId;
import org.openjfx.hellofx.models.dock.Dock;
import org.openjfx.hellofx.models.dock.DockService;

public class DockController {
    private DockService dockService;

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

    public Dock findById(String id) {
        return findById(new ObjectId(id));
    }

    public List<Dock> findByNameOrAddress(String query) {
        return dockService.findByNameOrAddress(query);
    }

    public Dock update(ObjectId id, Dock dock) {
        Dock result = dockService.findByIdAndReplace(id, dock);
        if (result == null) {
            throw new RuntimeException("Failed to update dock");
        }
        return result;
    }

    public Dock update(String id, Dock dock) {
        return update(new ObjectId(id), dock);
    }

    public Dock delete(ObjectId id) {
        Dock result = dockService.findByIdAndReplace(id, null);
        if (result == null) {
            throw new RuntimeException("Failed to delete dock");
        }
        return result;
    }

    public Dock delete(String id) {
        return delete(new ObjectId(id));
    }
}
