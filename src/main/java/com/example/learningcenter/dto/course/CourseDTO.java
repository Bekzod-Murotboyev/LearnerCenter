package com.example.learningcenter.dto.course;

import com.example.learningcenter.dto.base.GenericDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CourseDTO extends GenericDTO {

    private String name;

    @PositiveOrZero
    private Double price;

    @Positive
    private Integer duration;

    public CourseDTO(Long id, String name, Double price, Integer duration) {
        super(id);
        this.name = name;
        this.price = price;
        this.duration = duration;
    }
}
