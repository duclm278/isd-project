package org.openjfx.hellofx.models.account;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    private ObjectId id;
    private String cardCode;
    private String owner;
    private String cvvCode;
    private String dateExpired;
    private int balance;
}
