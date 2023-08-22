package org.openjfx.hellofx.repository.account;

import org.bson.types.ObjectId;
import org.openjfx.hellofx.model.account.Account;
import org.openjfx.hellofx.repository.base.IBaseRepository;

public interface IAccountRepository extends IBaseRepository<Account, ObjectId> {
    // Specify extra specifications if needed
    public Account findByCardCode(String cardCode);

    public Account findByCardCodeAndReplace(Account account);
}
