package org.openjfx.hellofx.model.account;

import org.bson.types.ObjectId;
import org.openjfx.hellofx.model.common.ISimpleService;

public interface IAccountService extends ISimpleService<Account, ObjectId> {
    // Specify extra specifications if needed
    public Account findByCardCode(String cardCode);

    public Account findByCardCodeAndReplace(Account account);
}
