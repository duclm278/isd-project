package org.openjfx.hellofx.controllers;

import java.util.List;

import org.bson.types.ObjectId;
import org.openjfx.hellofx.models.bike.Bike;
import org.openjfx.hellofx.models.docking.Docking;
import org.openjfx.hellofx.models.docking.DockingService;

public class DockingController {
    private DockingService dockingService;

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

    public Docking findById(String id) {
        return findById(new ObjectId(id));
    }

    public Docking findByBikeId(ObjectId bikeId) {
        return dockingService.findByBikeId(bikeId);
    }

    public Docking findByBikeId(String bikeId) {
        return findByBikeId(new ObjectId(bikeId));
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

    public Docking update(String id, Docking docking) {
        return update(new ObjectId(id), docking);
    }

    public Docking delete(ObjectId id) {
        Docking result = dockingService.findByIdAndReplace(id, null);
        if (result == null) {
            throw new RuntimeException("Failed to delete docking status");
        }
        return result;
    }

    public Docking delete(String id) {
        return delete(new ObjectId(id));
    }

    public Docking deleteByBikeId(ObjectId bikeId) {
        Docking result = dockingService.findByBikeIdAndDelete(bikeId);
        if (result == null) {
            throw new RuntimeException("Failed to delete docking status");
        }
        return result;
    }

    public Docking deleteByBikeId(String bikeId) {
        return deleteByBikeId(new ObjectId(bikeId));
    }

    public List<Bike> findBikesByDockId(ObjectId dockId) {
        return dockingService.findBikesByDockId(dockId);
    }

    public List<Bike> findBikesByDockId(String dockId) {
        return findBikesByDockId(new ObjectId(dockId));
    }
}
