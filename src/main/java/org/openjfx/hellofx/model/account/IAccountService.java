package org.openjfx.hellofx.model.account;

import org.bson.types.ObjectId;
import org.openjfx.hellofx.model.base.IBaseService;

public interface IAccountService extends IBaseService<Account, ObjectId> {
    // Specify extra specifications if needed
    public Account findByCardCode(String cardCode);

    public Account findByCardCodeAndReplace(Account account);
}
