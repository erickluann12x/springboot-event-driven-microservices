package com.example.payment_service.mapper;

import com.example.payment_service.dto.PaymentResponseDTO;
import com.example.payment_service.entity.Payment;
import org.springframework.stereotype.Component;

@Component
public class PaymentMapper {
    public PaymentResponseDTO ToResponse(Payment payment){
        return new PaymentResponseDTO(payment.getId(),
                        payment.getOrderId(),
                        payment.getCustomerEmail(),
                        payment.getAmount(),
                        payment.getMethod(),
                        payment.getStatus(),
                        payment.getPaymentDate(),
                        payment.getCreatedAt());
    }
}
