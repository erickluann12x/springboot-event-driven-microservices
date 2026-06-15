package com.example.payment_service.events;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentApprovedEvent {
    private String correlationId;
    private UUID paymantId;
    private UUID orderId;
    private String customerEmail;
    private BigDecimal totalAmount;

}
