package org.openjfx.hellofx.models.docking;

import static com.mongodb.client.model.Filters.eq;

import org.bson.types.ObjectId;
import org.openjfx.hellofx.models.common.BaseService;

public class DockingService extends BaseService<Docking> {
    public DockingService() {
        super("dockings", Docking.class);
    }

    public Docking findByBikeIdAndDelete(ObjectId bikeId) {
        return getCollection().findOneAndDelete(eq("bikeId", bikeId));
    }
}
