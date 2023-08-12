package controller;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.openjfx.hellofx.controller.account.AccountController;
import org.openjfx.hellofx.models.account.Account;
import org.openjfx.hellofx.models.account.AccountService;
import org.openjfx.hellofx.models.card.CreditCard;

import java.util.concurrent.atomic.AtomicInteger;

public class AccountControllerTest {

    @Test
    void testAccountCreate(){
        AtomicInteger x = new AtomicInteger();
        AtomicInteger y = new AtomicInteger();
        AtomicInteger z = new AtomicInteger();

        Account newAccount = new Account(null,"987654321","Dat", "321", "28/12", 1000000);
        AccountController accountController = new AccountController();
        AccountService accountService = new AccountService();

        accountService.find().forEach(dock -> x.getAndIncrement());
        System.out.println("Before add: " + x);

        accountController.createNewAccount(newAccount);
        accountService.find().forEach(dock -> y.getAndIncrement());
        System.out.println("After add: " + y);

        accountService.findByIdAndDelete(newAccount.getId());
        accountService.find().forEach(dock -> z.getAndIncrement());
        System.out.println("After delete: " + z);
        assertEquals(y.get()-1, z.get(),"delete successful");
        assertEquals(x.get()+1, y.get(),"create successful");
    }

    @Test
    void testMakePaymentSimple(){
        int amount = 100;
        AccountController accountController = new AccountController();
        AccountService accountService = new AccountService();
        CreditCard creditCard = new CreditCard("987654321", "Dat", "123", "28/12");
        Account account = accountService.findAccountByCardCode(creditCard.getCardNumber());
        int balance_before = account.getBalance();
        System.out.println(accountController.makePayment(creditCard, amount));

        account = accountService.findAccountByCardCode(creditCard.getCardNumber());
        int balance_after_pay = account.getBalance();
        System.out.println(accountController.makeRefund(creditCard, amount));
        account = accountService.findAccountByCardCode(creditCard.getCardNumber());
        int balance_after_refund = account.getBalance();

        assertEquals(balance_before, balance_after_refund);
        assertEquals(balance_before, balance_after_pay+amount);
        accountController.resetBalance(creditCard);
    }
    @Test
    void testMakePaymentError1(){
        AccountController accountController = new AccountController();
        AccountService accountService = new AccountService();
        CreditCard creditCard = new CreditCard("98754321", "Dat", "123", "28/12");
        int amount = 100;
        assertEquals(accountController.makePayment(creditCard, amount), 1);
        accountController.resetBalance(creditCard);
    }
    @Test
    void testMakePaymentError2(){
        AccountController accountController = new AccountController();
        AccountService accountService = new AccountService();
        CreditCard creditCard = new CreditCard("987654321", "Dat", "123", "28/12");
        int amount = 10000000; //over budget
        assertEquals(accountController.makePayment(creditCard, amount), 2);
        accountController.resetBalance(creditCard);
    }
    @Test
    void testMakePaymentSuccess(){
        AccountController accountController = new AccountController();
        AccountService accountService = new AccountService();
        CreditCard creditCard = new CreditCard("987654321", "Dat", "123", "28/12");
        int amount = 100;
        assertEquals(accountController.makePayment(creditCard, amount), 0);
        accountController.resetBalance(creditCard);
    }
}
