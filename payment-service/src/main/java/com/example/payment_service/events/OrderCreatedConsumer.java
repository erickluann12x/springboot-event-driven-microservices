package com.example.payment_service.events;

import com.example.payment_service.entity.Payment;
import com.example.payment_service.entity.PaymentStatus;
import com.example.payment_service.repository.PaymentRepository;
import io.awspring.cloud.sqs.annotation.SqsListener;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Slf4j
@RequiredArgsConstructor
public class OrderCreatedConsumer {

    private final PaymentRepository paymentRepository;
    private final PaymentEventPublisher paymentEventPublisher;

    @SqsListener("payment-queue")
    public void receive(OrderCreatedEvent event){

        log.info("EVENTO RECEBIDO: {}", event);

        if (paymentRepository.existsByOrderId(event.getOrderId())){
            log.info(
                    "Pagamento já existe para o pedido {}", event.getOrderId()
            );

            return;
        }

        Payment payment = new Payment();

        payment.setOrderId(event.getOrderId());
        payment.setCustomerEmail(event.getCustomerEmail());
        payment.setAmount(event.getTotalAmount());
        payment.setMethod(event.getMethod());

        payment.setStatus(PaymentStatus.APPROVED);

        payment.setCreatedAt(LocalDateTime.now());
        payment.setPaymentDate(LocalDateTime.now());

        paymentRepository.save(payment);

        log.info("Pagamento Criado {}", payment.getId());

        PaymentApprovedEvent approvedEvent =
                new PaymentApprovedEvent(event.getCorrelationId(),
                        payment.getId(),
                        payment.getOrderId(),
                        payment.getCustomerEmail(),
                        payment.getAmount());

        paymentEventPublisher.publish(approvedEvent);
        log.info("Evento de pagamento aprovado enviado");
    }
}
