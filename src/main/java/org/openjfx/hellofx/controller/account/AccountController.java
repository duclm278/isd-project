package org.openjfx.hellofx.controller.account;

import org.openjfx.hellofx.models.account.Account;
import org.openjfx.hellofx.models.account.AccountService;
import org.openjfx.hellofx.models.card.CreditCard;

public class AccountController {
    AccountService accountService = new AccountService();

    private Account account;

    public void validateAccount(CreditCard creditCard){

    }
    public void createNewAccount(Account account){
        accountService.save(account);
    }

    public void resetAccountBalance(Account account){
        accountService.findByIdAndReplace(account.getId(), account);
    }

    public void makePayment(Account account, int amount){
//        accountService.findById()
        accountService.findByIdAndReplace(account.getId(), account);
    }

}
