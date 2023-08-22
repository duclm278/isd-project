package org.openjfx.hellofx.repository.bike;

import org.bson.types.ObjectId;
import org.openjfx.hellofx.model.bike.Bike;
import org.openjfx.hellofx.repository.mongo.MongoRepository;

public class BikeRepository extends MongoRepository<Bike, ObjectId> implements IBikeRepository {
    public BikeRepository() {
        super(Bike.class);
    }

    // Implement extra specifications if needed
}
