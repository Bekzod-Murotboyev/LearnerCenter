package com.example.learningcenter.dto.timeTable;

import com.example.learningcenter.dto.base.GenericDTO;
import com.example.learningcenter.utill.enums.Day;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TimeTableUpdateDTO extends GenericDTO {

    Day day;

    Long roomId;

    Long groupId;

    LocalDateTime startTime;

    LocalDateTime endTime;
}
