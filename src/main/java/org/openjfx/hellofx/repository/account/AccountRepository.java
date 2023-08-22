package org.openjfx.hellofx.repository.account;

import java.util.List;

import org.bson.types.ObjectId;
import org.openjfx.hellofx.model.account.Account;
import org.openjfx.hellofx.repository.mongo.MongoRepository;

public class AccountRepository extends MongoRepository<Account, ObjectId> implements IAccountRepository {
    public AccountRepository() {
        super(Account.class);
    }

    @Override
    public Account findByCardCode(String cardCode) {
        List<Account> accounts = findByField("cardCode", String.class, cardCode);
        return accounts.isEmpty() ? null : accounts.get(0);
    }

    @Override
    public Account findByCardCodeAndReplace(Account account) {
        List<Account> accounts = findByFieldAndReplace("cardCode", String.class, account.getCardCode(), account);
        return accounts.isEmpty() ? null : accounts.get(0);
    }
}
