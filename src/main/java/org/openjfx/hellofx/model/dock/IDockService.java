package org.openjfx.hellofx.model.dock;

import java.util.List;

import org.bson.types.ObjectId;
import org.openjfx.hellofx.model.base.IBaseService;

public interface IDockService extends IBaseService<Dock, ObjectId> {
    // Specify extra specifications if needed
    public List<Dock> findByNameOrAddress(String query);

    public Dock findByIdAndIncrementNumBikes(ObjectId id);

    public Dock findByIdAndDecrementNumBikes(ObjectId id);
}
