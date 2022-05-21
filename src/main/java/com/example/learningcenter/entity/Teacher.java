package com.example.learningcenter.entity;

import com.example.learningcenter.entity.base.Auditable;
import com.example.learningcenter.entity.base.BaseEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Teacher extends Auditable implements BaseEntity {

    @Column(nullable = false)
    String fullName;

    @Column(unique = true,nullable = false, length = 50)
    String phone;

    @Column(nullable = false)
    Double salary;
}
