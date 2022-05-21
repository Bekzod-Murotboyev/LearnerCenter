package com.example.learningcenter.dto.payment;

import com.example.learningcenter.dto.base.DTO;
import com.example.learningcenter.dto.base.GenericDTO;
import com.example.learningcenter.entity.Student;
import com.example.learningcenter.utill.enums.PayType;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PaymentCreatDTO implements DTO {

    @NotNull
    PayType type;

    @NotNull
    @Positive
    Double amount;

    @NotBlank
    String description;

    @NotNull
    @JsonProperty("student_id")
    Long studentId;
}
