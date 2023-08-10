package org.openjfx.hellofx.models.movie;

import java.time.LocalDateTime;

import org.bson.types.ObjectId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Review {
    private ObjectId id;
    private String body;
    private LocalDateTime created;
    private LocalDateTime updated;
}
