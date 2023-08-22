package org.openjfx.hellofx.model.account;

import org.bson.types.ObjectId;
import org.openjfx.hellofx.model.base.BaseService;
import org.openjfx.hellofx.repository.account.AccountRepository;
import org.openjfx.hellofx.repository.account.IAccountRepository;

public class AccountService extends BaseService<Account, ObjectId> implements IAccountService {
    private IAccountRepository rentingRepository;

    public AccountService() {
        super(new AccountRepository());
        rentingRepository = (IAccountRepository) getRepository();
    }

    @Override
    public Account findByCardCode(String cardCode) {
        return rentingRepository.findByCardCode(cardCode);
    }

    @Override
    public Account findByCardCodeAndReplace(Account account) {
        return rentingRepository.findByCardCodeAndReplace(account);
    }
}
