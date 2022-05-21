package com.example.learningcenter.dto.payment;

import com.example.learningcenter.dto.base.GenericDTO;
import com.example.learningcenter.entity.Student;
import com.example.learningcenter.utill.enums.PayType;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PaymentDTO extends GenericDTO {

    PayType type;

    @Positive
    Double amount;

    String description;

    @JsonProperty("student_id")
    Long studentId;

    public PaymentDTO(@NotNull Long id, PayType type, Double amount, String description, Long studentId) {
        super(id);
        this.type = type;
        this.amount = amount;
        this.description = description;
        this.studentId = studentId;
    }
}
