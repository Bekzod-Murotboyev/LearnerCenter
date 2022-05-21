package com.example.learningcenter.dto.group;

import com.example.learningcenter.dto.base.DTO;
import com.example.learningcenter.dto.base.GenericDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GroupCreateDTO implements DTO {

    @NotBlank
    String name;

    @NotNull
    Long courseId;

    @NotNull
    Long teacherId;

    @NotNull
    @JsonProperty("start_date")
    LocalDate startDate;

    @NotNull
    @JsonProperty("end_date")
    LocalDate endDate;

    @NotNull
    @JsonProperty("status_id")
    Long statusId;

}
