package org.openjfx.hellofx.model.account;

import static com.mongodb.client.model.Filters.eq;

import org.openjfx.hellofx.model.common.OldService;

import com.mongodb.client.result.UpdateResult;

public class AccountService extends OldService<Account> {
    public AccountService() {
        super("accounts", Account.class);
    }

    public Account findAccountByCardCode(String cardCode) {
        return getCollection().find(eq("cardCode", cardCode)).first();
    }

    public UpdateResult replaceAccountBalanceByCardCode(Account account) {
        return getCollection().replaceOne(eq("cardCode", account.getCardCode()), account);
    }
}
