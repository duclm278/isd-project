package org.openjfx.hellofx.repository.transaction;

import org.bson.types.ObjectId;
import org.openjfx.hellofx.model.transaction.Transaction;
import org.openjfx.hellofx.repository.mongo.MongoRepository;

public class TransactionRepository extends MongoRepository<Transaction, ObjectId> implements ITransactionRepository {
    public TransactionRepository() {
        super(Transaction.class);
    }

    // Implement extra specifications if needed
}
