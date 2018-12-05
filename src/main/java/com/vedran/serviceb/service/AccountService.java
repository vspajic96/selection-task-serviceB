package com.vedran.serviceb.service;

import com.vedran.serviceb.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.sql.Timestamp;

@Service
class AccountService implements AccountServiceInterface {

    private AccountRepository accountRepository;


    AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }


    public void completeTransaction(BigInteger amount) {
        BigInteger balance = new BigInteger(accountRepository.getBalance(1));
        balance = balance.add(amount);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        accountRepository.updateBalance(1, balance.toString(), timestamp);
    }

}
