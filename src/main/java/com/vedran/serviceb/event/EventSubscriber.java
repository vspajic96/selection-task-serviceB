
package com.vedran.serviceb.event;

import com.vedran.serviceb.service.AccountServiceInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/*
    Handles received events and tries to perform a transaction on the account
 */
@Slf4j
@Component
class EventSubscriber {

    private AccountServiceInterface accountServiceInterface;

    EventSubscriber(final AccountServiceInterface accountServiceInterface){
        this.accountServiceInterface = accountServiceInterface;
    }

    @RabbitListener(queues = "${transaction.queue}")
    void handleTransactions(final TransactionPerformedEvent event) {
        log.info("Transaction performed event received: {}", event.toString());
        try {
            accountServiceInterface.completeTransaction(event.getAmount());
        } catch (final Exception e) {
            log.error("ERROR", e);
            throw new AmqpRejectAndDontRequeueException(e);
        }
    }

}
