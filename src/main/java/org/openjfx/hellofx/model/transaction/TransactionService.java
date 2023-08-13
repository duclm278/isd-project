package org.openjfx.hellofx.model.transaction;

import org.openjfx.hellofx.model.common.BaseService;

public class TransactionService extends BaseService<Transaction> {
    public TransactionService() {
        super("transactions", Transaction.class);
    }
}
