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
    public String barcode;
    public String type;
    public Optional<Integer> battery;
    private Optional<Integer> timeLeft;
    public int value;
    private Optional<Double> lat;
    private Optional<Double> lon;
}
