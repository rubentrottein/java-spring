package com.payme.app.service;

import com.payme.app.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;
}
