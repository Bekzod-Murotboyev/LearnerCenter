package com.example.learningcenter.dto.room;

import com.example.learningcenter.dto.base.DTO;
import com.example.learningcenter.dto.base.GenericDTO;
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
public class RoomCreateDTO implements DTO {

    @NotBlank
    private String name;

    @NotNull
    @Positive
    private Integer capacity;
}
