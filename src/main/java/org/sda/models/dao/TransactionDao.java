package org.sda.models.dao;

import org.sda.models.dto.Transaction;

import java.util.List;

public interface TransactionDao {
    List<Transaction> getAllTransactions();
}
