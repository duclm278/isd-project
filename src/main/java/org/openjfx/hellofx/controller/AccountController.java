package org.openjfx.hellofx.controller;

import java.util.Objects;

import org.openjfx.hellofx.model.account.Account;
import org.openjfx.hellofx.model.account.AccountService;
import org.openjfx.hellofx.model.account.IAccountService;
import org.openjfx.hellofx.model.card.CreditCard;

public class AccountController {
    private IAccountService accountService;

    public AccountController() {
        accountService = new AccountService();
    }

    public void save(Account account) {
        accountService.save(account);
    }

    public int makePayment(CreditCard creditCard, int amount) {
        Account account = accountService.findByCardCode(creditCard.getCardNumber());
        if (Objects.isNull(account))
            return 1;

        int currentBalance = account.getBalance();
        if (currentBalance < amount)
            return 2;

        account.setBalance(currentBalance - amount);
        try {
            Account result = accountService.findByCardCodeAndReplace(account);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return 3;
        }
        return 0;
    }

    public int makeRefund(CreditCard creditCard, int amount) {
        Account account = accountService.findByCardCode(creditCard.getCardNumber());
        if (Objects.isNull(account))
            return 1;

        int currentBalance = account.getBalance();
        account.setBalance(currentBalance + amount);
        try {
            Account result = accountService.findByCardCodeAndReplace(account);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return 3;
        }
        return 0;
    }

    public int resetBalance(CreditCard creditCard) {
        Account account = accountService.findByCardCode(creditCard.getCardNumber());
        if (Objects.isNull(account))
            return 1;

        int currentBalance = account.getBalance();
        account.setBalance(1000000);
        try {
            Account result = accountService.findByCardCodeAndReplace(account);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return 3;
        }
        return 0;
    }
}
