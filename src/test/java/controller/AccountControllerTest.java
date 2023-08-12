package controller;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.openjfx.hellofx.controller.account.AccountController;
import org.openjfx.hellofx.models.account.Account;
import org.openjfx.hellofx.models.account.AccountService;

import java.util.concurrent.atomic.AtomicInteger;

public class AccountControllerTest {

    @Test
    void testAccountCreate(){
        AtomicInteger x = new AtomicInteger();
        AtomicInteger y = new AtomicInteger();
        AtomicInteger z = new AtomicInteger();

        Account newAccount = new Account(null,"123456789","Dat", "321", "28/12", 1000);
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
        assertEquals(x.get()+1, y.get(),"create successful");
        assertEquals(y.get()-1, z.get(),"create successful");
        assertEquals(z.get(), x.get(), "delete and create successful");

    }
}
