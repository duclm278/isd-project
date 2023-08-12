package controller;

import org.junit.jupiter.api.Test;
import org.openjfx.hellofx.controller.account.AccountController;
import org.openjfx.hellofx.controller.transaction.TransactionController;
import org.openjfx.hellofx.models.account.Account;
import org.openjfx.hellofx.models.account.AccountService;
import org.openjfx.hellofx.models.transaction.Transaction;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TransactionControllerTest {
    @Test
    void testProgressTransaction1(){
        String cardCode = "987654321";
        TransactionController transactionController = new TransactionController();
        AccountService accountService = new AccountService();
        Transaction transaction = new Transaction(
                null,
                "pay",
                "987654321",
                "Dat",
                "321",
                "28/12",
                "rent a bike",
                100
        );
        Account account = accountService.findAccountByCardCode(cardCode);
        int balance_before = account.getBalance();
        System.out.println(transactionController.progressTransaction(transaction));
        account = accountService.findAccountByCardCode(cardCode);
        int balance_after = account.getBalance();
        assertEquals(balance_before, balance_after+transaction.getAmount());
    }
    @Test
    void testProgressTransaction2(){
        String cardCode = "987654321";
        TransactionController transactionController = new TransactionController();
        AccountService accountService = new AccountService();
        Transaction transaction = new Transaction(
                null,
                "refund",
                "987654321",
                "Dat",
                "321",
                "28/12",
                "rent a bike",
                100
        );
        Account account = accountService.findAccountByCardCode(cardCode);
        int balance_before = account.getBalance();
        System.out.println(transactionController.progressTransaction(transaction));
        account = accountService.findAccountByCardCode(cardCode);
        int balance_after = account.getBalance();
        assertEquals(balance_before, balance_after - transaction.getAmount());
    }
    @Test
    void testProgressTransactionError1(){
        String cardCode = "987654321";
        TransactionController transactionController = new TransactionController();
        AccountService accountService = new AccountService();
        Transaction transaction = new Transaction(
                null,
                "pay",
                "98754321",
                "Dat",
                "321",
                "28/12",
                "rent a bike",
                100
        );
        assertEquals(transactionController.progressTransaction(transaction), 1);
    }
    @Test
    void testProgressTransactionError2(){

        String cardCode = "987654321";
        AccountController accountController = new AccountController();
        TransactionController transactionController = new TransactionController();
        AccountService accountService = new AccountService();
        Transaction transaction = new Transaction(
                null,
                "pay",
                "987654321",
                "Dat",
                "321",
                "28/12",
                "rent a bike",
                10000000
        );
        assertEquals(transactionController.progressTransaction(transaction), 2);
    }
}

