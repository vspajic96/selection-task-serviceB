package com.vedran.serviceb.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Timestamp;

/*
    JPA entity representing an account
 */
@RequiredArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
@Entity
public final class Account {

    @Id
    @GeneratedValue
    private Integer id;

    private final String balance;
    private final Timestamp updatedAt;

    public Account() {
        balance = "0";
        updatedAt = null;
    }



}
