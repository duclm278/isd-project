package org.openjfx.hellofx.models.docking;

import org.bson.types.ObjectId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Docking {
    private ObjectId bikeId;
    private ObjectId dockId;
}
