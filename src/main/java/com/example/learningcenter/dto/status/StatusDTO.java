package com.example.learningcenter.dto.status;

import com.example.learningcenter.dto.base.GenericDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StatusDTO extends GenericDTO {

    private String name;


    private String description;

    public StatusDTO(@NotNull Long id, String name, String description) {
        super(id);
        this.name = name;
        this.description = description;
    }
}
