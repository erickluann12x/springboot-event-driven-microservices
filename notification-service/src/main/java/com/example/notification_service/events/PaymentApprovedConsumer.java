package com.example.notification_service.events;

import io.awspring.cloud.sqs.annotation.SqsListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class PaymentApprovedConsumer {

    @SqsListener("notification-queue")

    public void receive(
            PaymentApprovedEvent event
    ){
        log.info("Evento recebido: {}", event);

        log.info("Email enviado para {} referente ao pedido {}",event.getCustomerEmail(),event.getOrderId());
    }
}
