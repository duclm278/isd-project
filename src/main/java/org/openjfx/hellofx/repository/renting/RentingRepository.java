package org.openjfx.hellofx.repository.renting;

import org.bson.types.ObjectId;
import org.openjfx.hellofx.model.renting.Renting;
import org.openjfx.hellofx.repository.mongo.MongoRepository;

import com.mongodb.client.model.Filters;

public class RentingRepository extends MongoRepository<Renting, ObjectId> implements IRentingRepository {
    public RentingRepository() {
        super(Renting.class);
    }

    // Implement extra specifications if needed
    public Renting findUnfinishedByBikeId(ObjectId bikeId) {
        return getCollection()
                .find(Filters.and(
                        Filters.eq("bikeId", bikeId),
                        Filters.eq("endTime", null)))
                .first();
    }
}
