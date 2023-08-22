package org.openjfx.hellofx.repository.dock;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.openjfx.hellofx.model.dock.Dock;
import org.openjfx.hellofx.repository.mongo.MongoRepository;

import com.mongodb.client.model.Filters;

public class DockRepository extends MongoRepository<Dock, ObjectId> implements IDockRepository {
    public DockRepository() {
        super(Dock.class);
    }

    // Implement extra specifications if needed
    public List<Dock> findByNameOrAddress(String query) {
        List<Dock> docks = new ArrayList<>();
        return getCollection()
                .find(Filters.or(
                        Filters.regex("name", query, "i"),
                        Filters.regex("address", query, "i")))
                .into(docks);
    }
}
