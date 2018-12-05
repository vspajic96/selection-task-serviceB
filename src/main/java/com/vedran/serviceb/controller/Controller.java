package com.vedran.serviceb.controller;

import com.vedran.serviceb.domain.Account;
import com.vedran.serviceb.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    private AccountRepository accountRepository;

    @CrossOrigin
    @GetMapping("/balance")
    public @ResponseBody Iterable<Account> getBalance() {
        return accountRepository.findAll();
    }

}
