package com.payme.app.service;

import com.payme.app.model.Transaction;
import com.payme.app.model.User;
import com.payme.app.repository.TransactionRepository;
import com.payme.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    UserService userService;

    public List<Transaction> getTransactionListByUser(User user) {
        return transactionRepository.findBySender(user);
    }

    public void addTransaction(Transaction transaction, String userName){
        userService.getCurrentUser().getTransactionList().add(transaction);
    }
}
