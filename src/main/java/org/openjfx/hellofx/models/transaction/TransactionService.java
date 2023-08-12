package org.openjfx.hellofx.models.transaction;

import org.openjfx.hellofx.models.common.BaseService;

public class TransactionService extends BaseService<Transaction> {
    public TransactionService(){
        super("transactions", Transaction.class);
    }
}
