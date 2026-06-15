package com.example.payment_service.dto;

import com.example.payment_service.entity.PaymentMethod;

import java.math.BigDecimal;
import java.util.UUID;

public record PaymentRequestDTO(UUID orderId,
                                BigDecimal amount,
                                PaymentMethod method,
                                String customerEmail) {
}
