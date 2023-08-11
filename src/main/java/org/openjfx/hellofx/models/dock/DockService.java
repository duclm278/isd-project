package org.openjfx.hellofx.models.dock;

import org.bson.types.ObjectId;
import org.openjfx.hellofx.models.common.BaseService;

public class DockService extends BaseService<Dock> {
    public DockService() {
        super("docks", Dock.class);
    }

    public Dock findByIdAndIncrementNumBikes(ObjectId id) {
        Dock dock = findById(id);
        if (dock == null) {
            return null;
        }
        if (dock.getNumBikes() >= dock.getCapacity()) {
            return null;
        }

        dock.setNumBikes(dock.getNumBikes() + 1);
        return findByIdAndReplace(id, dock);
    }

    public Dock findByIdAndDecrementNumBikes(ObjectId id) {
        Dock dock = findById(id);
        if (dock == null) {
            return null;
        }
        if (dock.getNumBikes() <= 0) {
            return null;
        }

        dock.setNumBikes(dock.getNumBikes() - 1);
        return findByIdAndReplace(id, dock);
    }
}
