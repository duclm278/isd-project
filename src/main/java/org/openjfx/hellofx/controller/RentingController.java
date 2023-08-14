package org.openjfx.hellofx.controller;

import org.bson.types.ObjectId;
import org.openjfx.hellofx.model.renting.Renting;
import org.openjfx.hellofx.model.renting.RentingService;

public class RentingController {
    private RentingService rentingService;

    public RentingController() {
        rentingService = new RentingService();
    }

    public Renting rentBike(ObjectId bikeId) {
        Renting result = rentingService.rentBike(bikeId);
        if (result == null) {
            throw new RuntimeException("Failed to rent bike");
        }
        return result;
    }

    public Renting findByBikeId(ObjectId bikeId) {
        return rentingService.findByBikeId(bikeId);
    }

    public Renting findByBikeId(String bikeId) {
        return findByBikeId(new ObjectId(bikeId));
    }

    public Renting findByBikeBarcode(String barcode) {
        return rentingService.findByBikeBarcode(barcode);
    }

    public Renting rentBike(String bikeId) {
        return rentBike(new ObjectId(bikeId));
    }

    public Renting returnBike(ObjectId bikeId, ObjectId dockId) {
        Renting result = rentingService.returnBike(bikeId, dockId);
        if (result == null) {
            throw new RuntimeException("Failed to return bike");
        }
        return result;
    }

    public Renting returnBike(String bikeId, String dockId) {
        return returnBike(new ObjectId(bikeId), new ObjectId(dockId));
    }
}
