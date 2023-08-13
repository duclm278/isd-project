package org.openjfx.hellofx.model.renting;

import java.time.LocalDateTime;

import org.bson.types.ObjectId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Renting {
    private ObjectId id;
    private ObjectId bikeId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
}
