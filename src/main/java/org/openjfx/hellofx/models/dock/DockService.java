package org.openjfx.hellofx.models.dock;

import org.openjfx.hellofx.models.common.BaseService;

import com.mongodb.client.MongoCollection;

public class DockService extends BaseService<Dock> {
    private final MongoCollection<Dock> collection;

    public DockService() {
        super("docks", Dock.class);
        this.collection = super.getCollection();
    }
}
