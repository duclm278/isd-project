package org.openjfx.hellofx.model.transaction;

import org.openjfx.hellofx.model.common.OldService;

public class TransactionService extends OldService<Transaction> {
    public TransactionService() {
        super("transactions", Transaction.class);
    }
}
