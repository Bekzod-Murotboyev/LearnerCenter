package com.example.learningcenter.dto.room;

import com.example.learningcenter.dto.base.GenericDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RoomDTO extends GenericDTO {

    private String name;

    @Positive
    private Integer capacity;

    public RoomDTO(Long id, String name, Integer capacity) {
        super(id);
        this.name = name;
        this.capacity = capacity;
    }
}
