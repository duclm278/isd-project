package org.openjfx.hellofx.models.renting;

import static com.mongodb.client.model.Filters.eq;

import java.time.LocalDateTime;

import org.bson.types.ObjectId;
import org.openjfx.hellofx.models.common.BaseService;
import org.openjfx.hellofx.models.docking.Docking;
import org.openjfx.hellofx.models.docking.DockingService;

public class RentingService extends BaseService<Renting> {
    public RentingService() {
        super("rentings", Renting.class);
    }

    public Renting findByBikeId(ObjectId bikeId) {
        return this.find(eq("bikeId", bikeId)).get(0);
    }

    public Renting rentBike(ObjectId bikeId) {
        DockingService dockingService = new DockingService();
        Docking docking = dockingService.findByBikeIdAndDelete(bikeId);
        if (docking == null) {
            return null;
        }

        Renting renting = new Renting(new ObjectId(), bikeId, LocalDateTime.now(), null);
        return this.save(renting);
    }

    public Renting returnBike(ObjectId bikeId, ObjectId dockId) {
        Renting renting = this.findByBikeId(bikeId);
        if (renting == null) {
            return null;
        }

        renting.setEndTime(LocalDateTime.now());
        Renting updatedRenting = this.findByIdAndReplace(renting.getId(), renting);
        if (updatedRenting == null) {
            return null;
        }

        DockingService dockingService = new DockingService();
        Docking docking = dockingService.save(new Docking(new ObjectId(), bikeId, dockId));
        return docking != null ? updatedRenting : null;
    }
}
