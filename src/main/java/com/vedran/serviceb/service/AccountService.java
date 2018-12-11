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

    /*
         Retrieve current account balance and update it by the amount received in the event
     */
    public void completeTransaction(BigInteger amount) {
        // Hardcoded id = 1 because this initial version doesn't support multiple users
        BigInteger balance = new BigInteger(accountRepository.getBalance(1));
        balance = balance.add(amount);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        accountRepository.updateBalance(1, balance.toString(), timestamp);
    }

}
