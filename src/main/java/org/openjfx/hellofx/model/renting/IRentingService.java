package org.openjfx.hellofx.model.renting;

import org.bson.types.ObjectId;
import org.openjfx.hellofx.model.base.IBaseService;

public interface IRentingService extends IBaseService<Renting, ObjectId> {
    // Specify extra specifications if needed
    public Renting findUnfinishedByBikeId(ObjectId bikeId);

    public Renting findByBikeBarcode(String barcode);

    public Renting rentBike(ObjectId bikeId);

    public Renting returnBike(ObjectId bikeId, ObjectId dockId);
}
