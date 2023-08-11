package org.openjfx.hellofx.models.bike;

import org.bson.types.ObjectId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bike {
    private ObjectId id;
    private String barcode;
    private String type;
    private int battery;
    private int timeLeft;
    private int value;
    private double lat;
    private double lon;
}
