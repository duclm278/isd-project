package org.openjfx.hellofx.repository;

import org.bson.types.ObjectId;
import org.openjfx.hellofx.model.account.Account;
import org.openjfx.hellofx.repository.mongo.MongoRepository;

public class AccountRepository extends MongoRepository<Account, ObjectId> {
    public AccountRepository() {
        super(Account.class);
    }
}
