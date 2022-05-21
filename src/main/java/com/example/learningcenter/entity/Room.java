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
public class Room extends Auditable implements BaseEntity {

    @Column(nullable = false,unique = true)
    String name;

    @Column(nullable = false)
    Integer capacity;

    public Room(Long id, String name, Integer capacity) {
        super(id);
        this.name = name;
        this.capacity = capacity;
    }
}
