package org.openjfx.hellofx.repository.bike;

import org.bson.types.ObjectId;
import org.openjfx.hellofx.model.bike.Bike;
import org.openjfx.hellofx.repository.base.IBaseRepository;

public interface IBikeRepository extends IBaseRepository<Bike, ObjectId> {
    // Specify extra specifications if needed
}
