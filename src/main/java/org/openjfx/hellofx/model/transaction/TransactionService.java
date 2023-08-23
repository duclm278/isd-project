package org.openjfx.hellofx.model.transaction;

import org.bson.types.ObjectId;
import org.openjfx.hellofx.model.common.SimpleService;
import org.openjfx.hellofx.repository.transaction.TransactionRepository;

public class TransactionService extends SimpleService<Transaction, ObjectId> implements ITransactionService {
    public TransactionService() {
        super(new TransactionRepository());
    }
}
