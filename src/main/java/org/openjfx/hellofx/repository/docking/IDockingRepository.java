package org.openjfx.hellofx.repository.docking;

import org.bson.types.ObjectId;
import org.openjfx.hellofx.model.docking.Docking;
import org.openjfx.hellofx.repository.base.IBaseRepository;

public interface IDockingRepository extends IBaseRepository<Docking, ObjectId> {
    // Specify extra specifications if needed
}
