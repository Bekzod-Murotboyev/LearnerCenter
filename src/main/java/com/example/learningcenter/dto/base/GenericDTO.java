package com.example.learningcenter.dto.base;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GenericDTO implements DTO {
    @NotNull
    Long id;
}

