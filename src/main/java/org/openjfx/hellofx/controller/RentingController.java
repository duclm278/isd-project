package org.openjfx.hellofx.controller;

import org.bson.types.ObjectId;
import org.openjfx.hellofx.model.renting.IRentingService;
import org.openjfx.hellofx.model.renting.Renting;
import org.openjfx.hellofx.model.renting.RentingService;

public class RentingController {
    private IRentingService rentingService;

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

    public Renting findUnfinishedByBikeId(ObjectId bikeId) {
        return rentingService.findUnfinishedByBikeId(bikeId);
    }

    public Renting findByBikeBarcode(String barcode) {
        return rentingService.findByBikeBarcode(barcode);
    }

    public Renting returnBike(ObjectId bikeId, ObjectId dockId) {
        Renting result = rentingService.returnBike(bikeId, dockId);
        if (result == null) {
            throw new RuntimeException("Failed to return bike");
        }
        return result;
    }
}
