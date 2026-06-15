package com.example.payment_service.service;

import com.example.payment_service.dto.PaymentRequestDTO;
import com.example.payment_service.dto.PaymentResponseDTO;
import com.example.payment_service.entity.Payment;
import com.example.payment_service.entity.PaymentStatus;
import com.example.payment_service.exception.PaymentNotFoundException;
import com.example.payment_service.mapper.PaymentMapper;
import com.example.payment_service.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final PaymentMapper paymentMapper;

    public PaymentResponseDTO createPayment(PaymentRequestDTO paymentRequestDTO) {
        Payment payment = new Payment();

        payment.setOrderId(paymentRequestDTO.orderId());
        payment.setAmount(paymentRequestDTO.amount());
        payment.setMethod(paymentRequestDTO.method());
        payment.setCustomerEmail(paymentRequestDTO.customerEmail());


        payment.setStatus(PaymentStatus.APPROVED);

        Payment savedPayment = paymentRepository.save(payment);

        return paymentMapper.ToResponse(savedPayment);

    }

    public List<PaymentResponseDTO> findAllPayments(){

        List<Payment> payments = paymentRepository.findAll();
        return payments.stream().map(paymentMapper::ToResponse).toList();
    }

    public PaymentResponseDTO findPaymentById(UUID id){
        Payment payment = paymentRepository.findById(id)
                .orElseThrow(()->
                new PaymentNotFoundException
                        ("Pagamento com ID " + id + " não encontrado"));
        return paymentMapper.ToResponse(payment);
    }

    public PaymentResponseDTO findPaymentByOrderId(Long orderId){
        Payment payment =
                paymentRepository.findByOrderId(orderId)
                        .orElseThrow(()->
                                new PaymentNotFoundException
                                        ("Pagamento do pedido " + orderId + " não encontrado"));
        return paymentMapper.ToResponse(payment);
    }
}
