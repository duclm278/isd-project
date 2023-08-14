package org.openjfx.hellofx.model.docking;

import org.bson.types.ObjectId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Docking {
    private ObjectId id;
    private ObjectId bikeId;
    private ObjectId dockId;
}
