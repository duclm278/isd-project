package org.openjfx.hellofx.model.transaction;

import org.bson.types.ObjectId;
import org.openjfx.hellofx.model.base.BaseService;
import org.openjfx.hellofx.repository.transaction.TransactionRepository;

public class TransactionService extends BaseService<Transaction, ObjectId> implements ITransactionService {
    public TransactionService() {
        super(new TransactionRepository());
    }
}
