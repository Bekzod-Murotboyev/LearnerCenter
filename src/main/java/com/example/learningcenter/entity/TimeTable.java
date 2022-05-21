package com.example.learningcenter.entity;

import com.example.learningcenter.entity.base.Auditable;
import com.example.learningcenter.entity.base.BaseEntity;
import com.example.learningcenter.utill.enums.Day;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TimeTable extends Auditable implements BaseEntity {

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    Day day;

    @ManyToOne
    Room room;

    @ManyToOne
    Group group;

    @Column(nullable = false)
    LocalDateTime startTime;

    @Column(nullable = false)
    LocalDateTime endTime;

    public TimeTable(Day day, LocalDateTime startTime, LocalDateTime endTime) {
        this.day = day;
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
