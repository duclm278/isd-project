package org.openjfx.hellofx.model.transaction;

import org.bson.types.ObjectId;
import org.openjfx.hellofx.model.common.ISimpleService;

public interface ITransactionService extends ISimpleService<Transaction, ObjectId> {
    // Specify extra specifications if needed
}
