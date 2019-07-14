package org.sda.models.dao.Impl;

import org.sda.datasource.Datasource;
import org.sda.models.dao.TransactionDao;
import org.sda.models.dto.Transaction;

import javax.persistence.EntityManager;
import java.util.List;

public class TransactionDaoImpl implements TransactionDao {
    @Override
    public List<Transaction> getAllTransactions() {
        EntityManager entityManager = Datasource.getEntityManager();
        List<Transaction> transactions = entityManager.createQuery("FROM Transaction t").getResultList();
        return transactions;
    }
}
