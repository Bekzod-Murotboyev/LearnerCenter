package com.example.learningcenter.entity;

import com.example.learningcenter.entity.base.Auditable;
import com.example.learningcenter.entity.base.BaseEntity;
import com.example.learningcenter.utill.enums.PayType;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Payment extends Auditable implements BaseEntity {

    @Column(nullable = false)
    PayType type;

    @Column(nullable = false)
    Double amount;

    @Column(columnDefinition = "TEXT")
    String description;

    @ManyToOne
    Student student;

    public Payment(PayType type, Double amount, String description) {
        this.type = type;
        this.amount = amount;
        this.description = description;
    }
}
