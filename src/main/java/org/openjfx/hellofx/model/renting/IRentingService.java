package org.openjfx.hellofx.model.renting;

import org.bson.types.ObjectId;
import org.openjfx.hellofx.model.common.ISimpleService;

public interface IRentingService extends ISimpleService<Renting, ObjectId> {
    // Specify extra specifications if needed
    public Renting findUnfinishedByBikeId(ObjectId bikeId);

    public Renting findByBikeBarcode(String barcode);

    public Renting rentBike(ObjectId bikeId);

    public Renting returnBike(ObjectId bikeId, ObjectId dockId);
}
