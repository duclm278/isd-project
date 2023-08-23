package org.openjfx.hellofx.model.dock;

import java.util.List;

import org.bson.types.ObjectId;
import org.openjfx.hellofx.model.common.SimpleService;
import org.openjfx.hellofx.repository.dock.DockRepository;
import org.openjfx.hellofx.repository.dock.IDockRepository;

public class DockService extends SimpleService<Dock, ObjectId> implements IDockService {
    private IDockRepository dockRepository;

    public DockService() {
        super(new DockRepository());
        dockRepository = (IDockRepository) getRepository();
    }

    // Implement extra specifications if needed
    @Override
    public List<Dock> findByNameOrAddress(String query) {
        return dockRepository.findByNameOrAddress(query);
    }

    @Override
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

    @Override
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
