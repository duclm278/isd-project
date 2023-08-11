package org.openjfx.hellofx.models.docking;

import static com.mongodb.client.model.Filters.eq;

import java.util.List;

import org.bson.types.ObjectId;
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

    @Override
    public Docking save(Docking object) {
        DockService dockService = new DockService();

        // Check if bike is already docked
        Docking docking = findByBikeId(object.getBikeId());
        if (docking != null) {
            return null;
        }

        // Try to dock bike
        Dock dock = dockService.findByIdAndIncrementNumBikes(object.getDockId());
        if (dock == null) {
            return null;
        }

        return super.save(object);
    }

    public Docking findByBikeIdAndDelete(ObjectId bikeId) {
        Docking docking = findByBikeId(bikeId);
        if (docking == null) {
            return null;
        }

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
}
