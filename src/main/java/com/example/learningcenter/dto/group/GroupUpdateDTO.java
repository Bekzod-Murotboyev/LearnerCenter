package com.example.learningcenter.dto.group;

import com.example.learningcenter.dto.base.GenericDTO;
import com.example.learningcenter.entity.Status;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GroupUpdateDTO extends GenericDTO {

    String name;

    Long courseId;

    Long teacherId;

    @JsonProperty("start_date")
    LocalDate startDate;

    @JsonProperty("end_date")
    LocalDate endDate;

    @JsonProperty("status_id")
    Long statusId;

}
