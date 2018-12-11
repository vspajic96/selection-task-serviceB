package com.vedran.serviceb.Database;

import com.vedran.serviceb.domain.Account;
import com.vedran.serviceb.repository.AccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/*
    Initializes database on startup
 */
@Component
public class DBInitializer implements CommandLineRunner {

    private AccountRepository accountRepository;

    public DBInitializer(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void run(String... strings) throws Exception {
        Account account = new Account();
        this.accountRepository.save(account);
    }

}
