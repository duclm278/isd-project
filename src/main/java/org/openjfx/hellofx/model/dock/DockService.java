package org.openjfx.hellofx.model.dock;

import java.util.List;

import org.bson.types.ObjectId;
import org.openjfx.hellofx.model.common.BaseService;

import com.mongodb.client.model.Filters;

public class DockService extends BaseService<Dock> {
    public DockService() {
        super("docks", Dock.class);
    }

    public List<Dock> findByNameOrAddress(String query) {
        return find(Filters.or(
                Filters.regex("name", query, "i"),
                Filters.regex("address", query, "i")));
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
