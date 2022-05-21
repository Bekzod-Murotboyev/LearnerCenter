package com.example.learningcenter.criteria;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springdoc.api.annotations.ParameterObject;


import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@ParameterObject
public class GenericCriteria {
    @PositiveOrZero
    Integer page=0;

    @Positive
    Integer size=10;
}
