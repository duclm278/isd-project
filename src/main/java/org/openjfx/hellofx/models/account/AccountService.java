package org.openjfx.hellofx.models.account;
import static com.mongodb.client.model.Filters.eq;

import com.mongodb.client.result.UpdateResult;
import org.openjfx.hellofx.models.common.BaseService;

public class AccountService extends BaseService<Account> {
    public AccountService() {
        super("accounts", Account.class);
    }

    public Account findAccountByCardCode(String cardCode){
        return getCollection().find(eq("cardCode", cardCode)).first();
    }
    public UpdateResult replaceAccountBalanceByCardCode(Account account){
        return getCollection().replaceOne(eq("cardCode", account.getCardCode()),account);
    }
}
