package org.openjfx.hellofx.model.transaction;

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

    public void display() {
        System.out.println(this.getCommand());
        System.out.println(this.getCardCode());
        System.out.println(this.getOwner());
        System.out.println(this.getCvvCode());
        System.out.println(this.getDateExpired());
        System.out.println(this.getTransactionContent());
    }
}
