package org.openjfx.hellofx.model.account;

import org.bson.types.ObjectId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
