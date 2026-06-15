package com.example.payment_service.dto;

import com.example.payment_service.entity.PaymentMethod;
import com.example.payment_service.entity.PaymentStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record PaymentResponseDTO(UUID id,
                                 UUID orderId,
                                 String customerEmail,
                                 BigDecimal amount,
                                 PaymentMethod method,
                                 PaymentStatus status,
                                 LocalDateTime paymentDate,
                                 LocalDateTime createdAt) {
}
