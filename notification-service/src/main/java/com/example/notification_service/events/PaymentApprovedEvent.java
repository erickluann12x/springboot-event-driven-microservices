package com.example.notification_service.events;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PaymentApprovedEvent {
    private String correlationId;
    private UUID paymantId;
    private UUID orderId;
    private String customerEmail;
    private BigDecimal totalAmount;
}
