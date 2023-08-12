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
    private String command;
    private String cardCode;
    private String owner;
    private String cvvCode;
    private String dateExpired;
    private String transactionContent;
    private int amount;
}
