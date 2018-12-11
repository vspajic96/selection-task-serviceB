package com.vedran.serviceb.event;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigInteger;

/*
    Model of received event from service-a
 */
@RequiredArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public class TransactionPerformedEvent implements Serializable {

    private final BigInteger amount;
    private final String currency;

    TransactionPerformedEvent() {
        this(null, null);
    }
}
