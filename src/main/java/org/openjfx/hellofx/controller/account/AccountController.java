package org.openjfx.hellofx.controller.account;

import com.mongodb.client.result.UpdateResult;
import org.openjfx.hellofx.models.account.Account;
import org.openjfx.hellofx.models.account.AccountService;
import org.openjfx.hellofx.models.card.CreditCard;

import java.util.Objects;

public class AccountController {
    AccountService accountService = new AccountService();

    private Account account;
    public void createNewAccount(Account account){
        accountService.save(account);
    }

    public int makePayment(CreditCard creditCard, int amount){
        Account account = accountService.findAccountByCardCode(creditCard.getCardNumber());
        if(Objects.isNull(account)) return 1;

        int currentBalance = account.getBalance();
        if (currentBalance < amount) return 2;

        account.setBalance(currentBalance-amount);
        UpdateResult status =  accountService.replaceAccountBalanceByCardCode(account);
        return 0;
    }
    public int makeRefund(CreditCard creditCard, int amount){

        Account account = accountService.findAccountByCardCode(creditCard.getCardNumber());
        if(Objects.isNull(account)) return 1;

        int currentBalance = account.getBalance();
        account.setBalance(currentBalance + amount);
        UpdateResult status =  accountService.replaceAccountBalanceByCardCode(account);
        return 0;
    }
    public int resetBalance(CreditCard creditCard){

        Account account = accountService.findAccountByCardCode(creditCard.getCardNumber());
        if(Objects.isNull(account)) return 1;

        int currentBalance = account.getBalance();
        account.setBalance(1000000);
        UpdateResult status =  accountService.replaceAccountBalanceByCardCode(account);
        return 0;
    }

}
