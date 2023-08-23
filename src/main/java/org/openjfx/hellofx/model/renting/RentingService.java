package org.openjfx.hellofx.model.renting;

import java.time.LocalDateTime;

import org.bson.types.ObjectId;
import org.openjfx.hellofx.model.common.SimpleService;
import org.openjfx.hellofx.model.docking.Docking;
import org.openjfx.hellofx.model.docking.DockingService;
import org.openjfx.hellofx.model.docking.IDockingService;
import org.openjfx.hellofx.repository.renting.IRentingRepository;
import org.openjfx.hellofx.repository.renting.RentingRepository;

public class RentingService extends SimpleService<Renting, ObjectId> implements IRentingService {
    private IDockingService dockingService;
    private IRentingRepository rentingRepository;

    public RentingService() {
        super(new RentingRepository());
        rentingRepository = (IRentingRepository) getRepository();
    }

    public IDockingService getDockingService() {
        if (dockingService == null) {
            return new DockingService();
        }
        return dockingService;
    }

    @Override
    public Renting findUnfinishedByBikeId(ObjectId bikeId) {
        return rentingRepository.findUnfinishedByBikeId(bikeId);
    }

    @Override
    public Renting findByBikeBarcode(String barcode) {
        IDockingService dockingService = getDockingService();
        Docking docking = dockingService.findByBikeBarcode(barcode);
        if (docking == null) {
            return null;
        }
        return findUnfinishedByBikeId(docking.getBikeId());
    }

    @Override
    public Renting rentBike(ObjectId bikeId) {
        IDockingService dockingService = getDockingService();
        Docking docking = dockingService.findByBikeIdAndDelete(bikeId);
        if (docking == null) {
            return null;
        }
        Renting renting = new Renting(new ObjectId(), bikeId, LocalDateTime.now(),
                null, null);
        return save(renting);
    }

    @Override
    public Renting returnBike(ObjectId bikeId, ObjectId dockId) {
        Renting renting = rentingRepository.findUnfinishedByBikeId(bikeId);
        if (renting == null) {
            return null;
        }

        IDockingService dockingService = getDockingService();
        Docking docking = dockingService.save(new Docking(new ObjectId(), bikeId, dockId));
        if (docking == null) {
            return null;
        }

        renting.setEndTime(LocalDateTime.now());
        return findByIdAndReplace(renting.getId(), renting);
    }
}
