package org.openjfx.hellofx.controller;

import java.util.List;

import org.bson.types.ObjectId;
import org.openjfx.hellofx.model.bike.Bike;
import org.openjfx.hellofx.model.docking.Docking;
import org.openjfx.hellofx.model.docking.DockingService;
import org.openjfx.hellofx.model.docking.IDockingService;

public class DockingController {
    private IDockingService dockingService;

    public DockingController() {
        dockingService = new DockingService();
    }

    public Docking create(Docking docking) {
        Docking result = dockingService.save(docking);
        if (result == null) {
            throw new RuntimeException("Failed to create docking status");
        }
        return result;
    }

    public List<Docking> find() {
        return dockingService.find();
    }

    public Docking findById(ObjectId id) {
        return dockingService.findById(id);
    }

    public Docking findByBikeId(ObjectId bikeId) {
        return dockingService.findByBikeId(bikeId);
    }

    public Docking findByBikeBarcode(String barcode) {
        return dockingService.findByBikeBarcode(barcode);
    }

    public Docking update(ObjectId id, Docking docking) {
        Docking result = dockingService.findByIdAndReplace(id, docking);
        if (result == null) {
            throw new RuntimeException("Failed to update docking status");
        }
        return result;
    }

    public Docking delete(ObjectId id) {
        Docking result = dockingService.findByIdAndDelete(id);
        if (result == null) {
            throw new RuntimeException("Failed to delete docking status");
        }
        return result;
    }

    public Docking deleteByBikeId(ObjectId bikeId) {
        Docking result = dockingService.findByBikeIdAndDelete(bikeId);
        if (result == null) {
            throw new RuntimeException("Failed to delete docking status");
        }
        return result;
    }

    public List<Bike> findBikesByDockId(ObjectId dockId) {
        return dockingService.findBikesByDockId(dockId);
    }
}
