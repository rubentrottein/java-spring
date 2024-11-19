package com.payme.app.repository;

import com.payme.app.model.Transaction;
import com.payme.app.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Long> {
    List<Transaction> findBySender(User userName);
}