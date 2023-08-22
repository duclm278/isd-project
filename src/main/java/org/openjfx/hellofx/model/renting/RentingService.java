package org.openjfx.hellofx.model.renting;

import java.time.LocalDateTime;
import java.util.List;

import org.bson.types.ObjectId;
import org.openjfx.hellofx.model.common.OldService;
import org.openjfx.hellofx.model.docking.Docking;
import org.openjfx.hellofx.model.docking.DockingService;

import com.mongodb.client.ClientSession;
import com.mongodb.client.TransactionBody;
import com.mongodb.client.model.Filters;

public class RentingService extends OldService<Renting> {
    public RentingService() {
        super("rentings", Renting.class);
    }

    public Renting findUnfinishedByBikeId(ObjectId bikeId) {
        List<Renting> rentings = find(
                Filters.and(Filters.eq("bikeId", bikeId), Filters.eq("endTime", null)));
        return rentings.size() > 0 ? rentings.get(0) : null;
    }

    public Renting findUnfinishedByBikeId(String bikeId) {
        return findUnfinishedByBikeId(new ObjectId(bikeId));
    }

    public Renting findByBikeBarcode(String barcode) {
        DockingService dockingService = new DockingService();
        Docking docking = dockingService.findByBikeBarcode(barcode);
        if (docking == null) {
            return null;
        }
        return findUnfinishedByBikeId(docking.getBikeId());
    }

    public Renting rentBike(ObjectId bikeId) {
        DockingService dockingService = new DockingService();
        Docking docking = dockingService.findByBikeIdAndDelete(bikeId);
        if (docking == null) {
            return null;
        }
        Renting renting = new Renting(new ObjectId(), bikeId, LocalDateTime.now(),
                null, null);
        return save(renting);
        // return null;
    }

    public Renting rentBike(String bikeId) {
        return rentBike(new ObjectId(bikeId));
    }

    public Renting returnBike(ObjectId bikeId, ObjectId dockId) {
        ClientSession clientSession = getClient().startSession();

        TransactionBody<Renting> txnBody = new TransactionBody<>() {
            public Renting execute() {
                Renting renting = findUnfinishedByBikeId(bikeId);
                if (renting == null) {
                    return null;
                }

                DockingService dockingService = new DockingService();
                Docking docking = dockingService.save(new Docking(new ObjectId(), bikeId, dockId));
                if (docking == null) {
                    return null;
                }

                renting.setEndTime(LocalDateTime.now());
                return findByIdAndReplace(renting.getId(), renting);
            }
        };

        Renting result = null;
        try {
            result = clientSession.withTransaction(txnBody);
        } catch (RuntimeException e) {
            System.out.println(e);
        } finally {
            clientSession.close();
        }

        return result;
    }

    public Renting returnBike(String bikeId, String dockId) {
        return returnBike(new ObjectId(bikeId), new ObjectId(dockId));
    }
}
