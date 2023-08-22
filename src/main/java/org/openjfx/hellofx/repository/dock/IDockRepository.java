package org.openjfx.hellofx.repository.dock;

import java.util.List;

import org.bson.types.ObjectId;
import org.openjfx.hellofx.model.dock.Dock;
import org.openjfx.hellofx.repository.base.IBaseRepository;

public interface IDockRepository extends IBaseRepository<Dock, ObjectId> {
    // Specify extra specifications if needed
    public List<Dock> findByNameOrAddress(String query);
}
