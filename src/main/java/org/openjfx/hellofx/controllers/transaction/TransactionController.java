package org.openjfx.hellofx.controllers.transaction;

import com.mongodb.client.result.UpdateResult;
import org.openjfx.hellofx.controllers.account.AccountController;
import org.openjfx.hellofx.models.card.CreditCard;
import org.openjfx.hellofx.models.transaction.Transaction;

public class TransactionController {
    private Transaction transaction;
    private AccountController accountController = new AccountController();

    public int progressTransaction(Transaction transaction){
        int result = 0;
        CreditCard creditCard = new CreditCard(transaction.getCardCode(), transaction.getOwner(), transaction.getCvvCode(), transaction.getDateExpired());
        if(transaction.getCommand().equals("pay")){
            result =  accountController.makePayment(creditCard, transaction.getAmount());
        } else if (transaction.getCommand().equals("refund")) {
            result =  accountController.makeRefund(creditCard, transaction.getAmount());
        }
        return result;
    }
}
