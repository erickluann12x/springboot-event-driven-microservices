package com.example.payment_service.events;


import io.awspring.cloud.sns.core.SnsTemplate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j

public class PaymentEventPublisher {
    private final SnsTemplate snsTemplate;

    public void publish(PaymentApprovedEvent event){
        log.info("Publicando evento de pagamento {}", event);
        snsTemplate.convertAndSend("payment-approved-topic",event);
    }
}
