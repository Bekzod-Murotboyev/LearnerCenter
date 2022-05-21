package com.example.learningcenter.dto.teacher;

import com.example.learningcenter.dto.base.GenericDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.PositiveOrZero;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TeacherDTO extends GenericDTO {

    @JsonProperty("full_name")
    String fullName;

    @Pattern(regexp = "998\\d{9}")
    String phone;

    @PositiveOrZero
    Double salary;

    public TeacherDTO(@NotNull Long id, String fullName, String phone, Double salary) {
        super(id);
        this.fullName = fullName;
        this.phone = phone;
        this.salary = salary;
    }
}
