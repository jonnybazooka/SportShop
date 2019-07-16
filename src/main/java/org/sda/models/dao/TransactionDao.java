package org.sda.models.dao;

import org.sda.models.dto.Transaction;

import java.util.List;

public interface TransactionDao {
    /**
     * Returns a complete list of completed transactions.
     *
     * @return <tt>null</tt> if there are no transactions in database.
     */
    List<Transaction> getAllTransactions();
}
