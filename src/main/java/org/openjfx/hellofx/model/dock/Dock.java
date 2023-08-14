package org.openjfx.hellofx.model.dock;

import org.bson.types.ObjectId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dock {
    public ObjectId id;
    private String name;
    private String address;
    private int capacity;
    private int numBikes;
    private double lat;
    private double lon;
}
