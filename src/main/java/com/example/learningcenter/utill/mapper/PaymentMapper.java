package com.example.learningcenter.utill.mapper;

import com.example.learningcenter.dto.payment.PaymentCreatDTO;
import com.example.learningcenter.dto.payment.PaymentDTO;
import com.example.learningcenter.entity.Payment;
import com.example.learningcenter.utill.mapper.base.BaseMapper;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class PaymentMapper implements BaseMapper<Payment, PaymentDTO, PaymentCreatDTO, PaymentDTO> {
    @Override
    public PaymentDTO toDTO(Payment entity) {
        return new PaymentDTO(entity.getId(),entity.getType(), entity.getAmount(), entity.getDescription(), entity.getStudent().getId());
    }

    @Override
    public Payment toEntity(PaymentDTO dto, Payment entity) {
        if (Objects.nonNull(dto.getType()))
            entity.setType(dto.getType());
        if (Objects.nonNull(dto.getAmount()))
            entity.setAmount(dto.getAmount());
        if (Objects.nonNull(dto.getDescription()))
            entity.setDescription(dto.getDescription());
        return entity;
    }

    @Override
    public Payment toEntity(PaymentCreatDTO dto) {
        return new Payment(dto.getType(), dto.getAmount(), dto.getDescription());
    }
}

