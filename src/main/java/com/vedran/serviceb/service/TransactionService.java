package com.vedran.serviceb.service;

import com.vedran.serviceb.domain.Account;
import com.vedran.serviceb.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.sql.Timestamp;

@Service
class TransactionService implements TransactionServiceInterface{

    private AccountRepository accountRepository;


    TransactionService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }


    public void updateBalance(BigInteger amount) {
        BigInteger balance = new BigInteger(accountRepository.getBalance(1));
        balance = balance.add(amount);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        accountRepository.updateBalance(1, balance.toString(), timestamp);
    }

    public void updateBalancev2(BigInteger amount) {}

}
