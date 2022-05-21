package com.example.learningcenter.dto.status;

import com.example.learningcenter.dto.base.DTO;
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
public class StatusCreateDTO implements DTO {

    @NotBlank
    private String name;

    @NotBlank
    private String description;
}
