package org.openjfx.hellofx.repository.renting;

import org.bson.types.ObjectId;
import org.openjfx.hellofx.model.renting.Renting;
import org.openjfx.hellofx.repository.base.IBaseRepository;

public interface IRentingRepository extends IBaseRepository<Renting, ObjectId> {
    // Specify extra specifications if needed
    public Renting findUnfinishedByBikeId(ObjectId bikeId);
}
