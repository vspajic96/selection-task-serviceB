package com.vedran.serviceb.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigInteger;
import java.sql.Timestamp;

@Getter
@ToString
@EqualsAndHashCode
@Entity
public final class Account {

    @Id
    @GeneratedValue
    private Integer id;

    private String balance;
    private Timestamp updatedAt;

    public Account() {
        balance = "0";
        updatedAt = null;
    }



}
