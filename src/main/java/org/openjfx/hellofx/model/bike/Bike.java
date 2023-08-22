package org.openjfx.hellofx.model.bike;

import java.util.Optional;

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
    private Optional<Integer> battery;
    private Optional<Integer> timeLeft;
    private int value;
    private Optional<Double> lat;
    private Optional<Double> lon;
}
