package org.openjfx.hellofx.models.bikedock;

import org.bson.types.ObjectId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BikeDock {
    private ObjectId bikeId;
    private ObjectId dockId;
}
