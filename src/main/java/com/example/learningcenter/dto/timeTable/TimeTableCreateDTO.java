package com.example.learningcenter.dto.timeTable;

import com.example.learningcenter.dto.base.DTO;
import com.example.learningcenter.utill.enums.Day;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TimeTableCreateDTO implements DTO {

    @NotNull
    Day day;

    @NotNull
    Long roomId;

    @NotNull
    Long groupId;

    @NotNull
    LocalDateTime startTime;

    @NotNull
    LocalDateTime endTime;
}
