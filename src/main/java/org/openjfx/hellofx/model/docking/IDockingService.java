package org.openjfx.hellofx.model.docking;

import java.util.List;

import org.bson.types.ObjectId;
import org.openjfx.hellofx.model.bike.Bike;
import org.openjfx.hellofx.model.common.ISimpleService;

public interface IDockingService extends ISimpleService<Docking, ObjectId> {
    // Specify extra specifications if needed
    public Docking findByBikeId(ObjectId bikeId);

    public Docking findByBikeBarcode(String barcode);

    public Docking findByBikeIdAndDelete(ObjectId bikeId);

    public List<Bike> findBikesByDockId(ObjectId dockId);
}
