package org.openjfx.hellofx.models.docking;

import static com.mongodb.client.model.Filters.eq;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.openjfx.hellofx.models.bike.Bike;
import org.openjfx.hellofx.models.bike.BikeService;
import org.openjfx.hellofx.models.common.BaseService;
import org.openjfx.hellofx.models.dock.Dock;
import org.openjfx.hellofx.models.dock.DockService;

public class DockingService extends BaseService<Docking> {
    public DockingService() {
        super("dockings", Docking.class);
    }

    public Docking findByBikeId(ObjectId bikeId) {
        List<Docking> dockings = find(eq("bikeId", bikeId));
        return dockings.size() > 0 ? dockings.get(0) : null;
    }

    public Docking findByBikeId(String bikeId) {
        return findByBikeId(new ObjectId(bikeId));
    }

    public Docking findByBikeBarcode(String barcode) {
        BikeService bikeService = new BikeService();
        Bike bike = bikeService.findByBarcode(barcode);
        if (bike == null) {
            return null;
        }
        return findByBikeId(bike.getId());
    }

    @Override
    public Docking save(Docking object) {
        // Check if bike is already docked
        Docking docking = findByBikeId(object.getBikeId());
        if (docking != null) {
            return null;
        }

        // Try to dock bike
        DockService dockService = new DockService();
        Dock dock = dockService.findByIdAndIncrementNumBikes(object.getDockId());
        if (dock == null) {
            return null;
        }

        return super.save(object);
    }

    public Docking findByBikeIdAndDelete(ObjectId bikeId) {
        // Check if bike is already docked
        Docking docking = findByBikeId(bikeId);
        if (docking == null) {
            return null;
        }

        // Try to undock bike
        DockService dockService = new DockService();
        Dock dock = dockService.findByIdAndDecrementNumBikes(docking.getDockId());
        if (dock == null) {
            return null;
        }

        return findByIdAndDelete(docking.getId());
    }

    public Docking findByBikeIdAndDelete(String bikeId) {
        return findByBikeIdAndDelete(new ObjectId(bikeId));
    }

    public List<Bike> findBikesByDockId(ObjectId dockId) {
        List<Docking> dockings = find(eq("dockId", dockId));

        List<Bike> bikes = new ArrayList<>();
        BikeService bikeService = new BikeService();
        for (Docking docking : dockings) {
            Bike bike = bikeService.findById(docking.getBikeId());
            bikes.add(bike);
        }

        return bikes;
    }

    public List<Bike> findBikesByDockId(String dockId) {
        return findBikesByDockId(new ObjectId(dockId));
    }
}
