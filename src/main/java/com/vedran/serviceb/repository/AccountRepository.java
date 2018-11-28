package com.vedran.serviceb.repository;

import com.vedran.serviceb.domain.Account;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.sql.Timestamp;

public interface AccountRepository extends CrudRepository<Account, Integer> {

    @Query("SELECT(a.balance) FROM com.vedran.serviceb.domain.Account a " +
            "WHERE a.id = :accountId")
    String getBalance(@Param("accountId") final Integer accountId);

    @Transactional
    @Modifying
    @Query("UPDATE Account a SET a.balance = :newBalance, a.updatedAt =:timestamp " +
            "WHERE a.id = :accountId")
    void updateBalance(@Param("accountId") final Integer accountId, @Param("newBalance") final String newBalance,
                       @Param("timestamp") final Timestamp timestamp);


}
