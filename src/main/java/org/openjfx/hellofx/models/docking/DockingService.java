package org.openjfx.hellofx.models.docking;

import org.openjfx.hellofx.models.common.BaseService;

import com.mongodb.client.MongoCollection;

public class DockingService extends BaseService<Docking> {
    private final MongoCollection<Docking> collection;

    public DockingService() {
        super("dockings", Docking.class);
        this.collection = super.getCollection();
    }
}
