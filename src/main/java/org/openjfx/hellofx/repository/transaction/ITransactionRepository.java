package org.openjfx.hellofx.repository.transaction;

import org.bson.types.ObjectId;
import org.openjfx.hellofx.model.transaction.Transaction;
import org.openjfx.hellofx.repository.base.IBaseRepository;

public interface ITransactionRepository extends IBaseRepository<Transaction, ObjectId> {
    // Specify extra specifications if needed
}
