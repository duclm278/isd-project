package org.openjfx.hellofx.models.dock;

import org.bson.types.ObjectId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dock {
    private ObjectId id;
    private String name;
    private String address;
    private int capacity;
    private double lat;
    private double lon;
}
