package org.openjfx.hellofx.repository.docking;

import org.bson.types.ObjectId;
import org.openjfx.hellofx.model.docking.Docking;
import org.openjfx.hellofx.repository.mongo.MongoRepository;

public class DockingRepository extends MongoRepository<Docking, ObjectId> implements IDockingRepository {
    public DockingRepository() {
        super(Docking.class);
    }

    // Implement extra specifications if needed
}
