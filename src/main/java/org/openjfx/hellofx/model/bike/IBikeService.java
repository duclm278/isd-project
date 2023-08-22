package org.openjfx.hellofx.model.bike;

import org.bson.types.ObjectId;
import org.openjfx.hellofx.model.common.IBaseService;

public interface IBikeService extends IBaseService<Bike, ObjectId> {
    // Specify extra specifications if needed
    public Bike findByBarcode(String barcode);
}
