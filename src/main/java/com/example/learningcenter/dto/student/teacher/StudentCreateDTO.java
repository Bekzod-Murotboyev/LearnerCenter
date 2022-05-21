package com.example.learningcenter.dto.student.teacher;

import com.example.learningcenter.dto.base.DTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.PositiveOrZero;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StudentCreateDTO implements DTO {

    @NotBlank
    @JsonProperty("full_name")
    String fullName;

    @NotBlank
    @Pattern(regexp = "998\\d{9}")
    String phone;
}
