package org.openjfx.hellofx.controller;

import java.util.List;

import org.bson.types.ObjectId;
import org.openjfx.hellofx.model.bike.Bike;
import org.openjfx.hellofx.model.bike.BikeService;

public class BikeController {
    private BikeService bikeService;

    public BikeController() {
        bikeService = new BikeService();
    }

    public Bike create(Bike bike) {
        Bike result = bikeService.save(bike);
        if (result == null) {
            throw new RuntimeException("Failed to create bike");
        }
        return result;
    }

    public List<Bike> find() {
        return bikeService.find();
    }

    public Bike findById(ObjectId id) {
        return bikeService.findById(id);
    }

    public Bike findById(String id) {
        return findById(new ObjectId(id));
    }

    public Bike findByBarcode(String barcode) {
        return bikeService.findByBarcode(barcode);
    }

    public Bike update(ObjectId id, Bike bike) {
        Bike result = bikeService.findByIdAndReplace(id, bike);
        if (result == null) {
            throw new RuntimeException("Failed to update bike");
        }
        return result;
    }

    public Bike update(String id, Bike bike) {
        return update(new ObjectId(id), bike);
    }

    public Bike delete(ObjectId id) {
        Bike result = bikeService.findByIdAndReplace(id, null);
        if (result == null) {
            throw new RuntimeException("Failed to delete bike");
        }
        return result;
    }

    public Bike delete(String id) {
        return delete(new ObjectId(id));
    }
}
