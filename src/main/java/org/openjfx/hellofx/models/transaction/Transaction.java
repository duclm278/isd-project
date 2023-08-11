package org.openjfx.hellofx.models.transaction;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
    private ObjectId id;
    private String cardNumber;
    private String cardHolderName;
    private int amount;
    private String note;
    private int status;
}
