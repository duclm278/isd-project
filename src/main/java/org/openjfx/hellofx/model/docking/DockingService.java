package org.openjfx.hellofx.model.docking;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.openjfx.hellofx.model.bike.Bike;
import org.openjfx.hellofx.model.bike.BikeService;
import org.openjfx.hellofx.model.bike.IBikeService;
import org.openjfx.hellofx.model.common.BaseService;
import org.openjfx.hellofx.model.dock.Dock;
import org.openjfx.hellofx.model.dock.DockService;
import org.openjfx.hellofx.model.dock.IDockService;
import org.openjfx.hellofx.repository.docking.DockingRepository;
import org.openjfx.hellofx.repository.docking.IDockingRepository;

public class DockingService extends BaseService<Docking, ObjectId> implements IDockingService {
    private IBikeService bikeService;
    private IDockService dockService;
    private IDockingRepository dockingRepository;

    public DockingService() {
        super(new DockingRepository());
        dockingRepository = (IDockingRepository) getRepository();
    }

    public IBikeService getBikeService() {
        if (bikeService == null) {
            return new BikeService();
        }
        return bikeService;
    }

    public IDockService getDockService() {
        if (dockService == null) {
            return new DockService();
        }
        return dockService;
    }

    @Override
    public Docking save(Docking object) {
        // Check if bike is already docked
        Docking docking = findByBikeId(object.getBikeId());
        if (docking != null) {
            return null;
        }

        // Try to dock bike
        IDockService dockService = getDockService();
        Dock dock = dockService.findByIdAndIncrementNumBikes(object.getDockId());
        if (dock == null) {
            return null;
        }

        return dockingRepository.save(object);
    }

    // Implement extra specifications if needed
    @Override
    public Docking findByBikeId(ObjectId bikeId) {
        List<Docking> dockings = dockingRepository.findByField("bikeId", ObjectId.class, bikeId);
        return dockings.size() > 0 ? dockings.get(0) : null;
    }

    @Override
    public Docking findByBikeBarcode(String barcode) {
        IBikeService bikeService = getBikeService();
        Bike bike = bikeService.findByBarcode(barcode);
        if (bike == null) {
            return null;
        }
        return findByBikeId(bike.getId());
    }

    @Override
    public Docking findByBikeIdAndDelete(ObjectId bikeId) {
        // Check if bike is already docked
        Docking docking = findByBikeId(bikeId);
        if (docking == null) {
            return null;
        }

        // Try to undock bike
        IDockService dockService = getDockService();
        Dock dock = dockService.findByIdAndDecrementNumBikes(docking.getDockId());
        if (dock == null) {
            return null;
        }

        return dockingRepository.findByIdAndDelete(docking.getId());
    }

    @Override
    public List<Bike> findBikesByDockId(ObjectId dockId) {
        List<Docking> dockings = dockingRepository.findByField("dockId", ObjectId.class, dockId);

        List<Bike> bikes = new ArrayList<>();
        IBikeService bikeService = getBikeService();
        for (Docking docking : dockings) {
            Bike bike = bikeService.findById(docking.getBikeId());
            bikes.add(bike);
        }

        return bikes;
    }
}
