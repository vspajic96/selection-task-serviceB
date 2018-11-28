
package com.vedran.serviceb.event;

import com.vedran.serviceb.service.TransactionServiceInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
class EventSubscriber {

    private TransactionServiceInterface transactionServiceInterface;

    EventSubscriber(final TransactionServiceInterface transactionServiceInterface){
        this.transactionServiceInterface = transactionServiceInterface;
    }

    @RabbitListener(queues = "${transaction.queue}")
    void handleTransactions(final TransactionPerformedEvent event) {
        log.info("Transaction performed event received: {}", event.toString());
        try {
            transactionServiceInterface.updateBalance(event.getAmount());
        } catch (final Exception e) {
            log.error("ERROR", e);
            throw new AmqpRejectAndDontRequeueException(e);
        }
    }

}
