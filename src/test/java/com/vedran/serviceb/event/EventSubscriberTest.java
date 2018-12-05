package com.vedran.serviceb.event;

import com.vedran.serviceb.service.AccountServiceInterface;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigInteger;

import static org.mockito.Mockito.verify;

public class EventSubscriberTest {

    private EventSubscriber eventSubscriber;

    @Mock
    private AccountServiceInterface accountService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        eventSubscriber = new EventSubscriber(accountService);
    }

    @Test
    public void transactionPerformedEventReceivedTest() {
        //given
        BigInteger amount = new BigInteger("100");
        String currency = "EUR";
        TransactionPerformedEvent event = new TransactionPerformedEvent(amount, currency);

        //when
        eventSubscriber.handleTransactions(event);

        //then
        verify(accountService).completeTransaction(amount);
    }

}
