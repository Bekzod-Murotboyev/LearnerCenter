package com.example.learningcenter.dto.timeTable;

import com.example.learningcenter.dto.base.GenericDTO;
import com.example.learningcenter.utill.enums.Day;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TimeTableDTO extends GenericDTO {

    Day day;

    String room;

    String group;

    LocalDateTime startTime;

    LocalDateTime endTime;

    public TimeTableDTO(@NotNull Long id, Day day, String room, String group, LocalDateTime startTime, LocalDateTime endTime) {
        super(id);
        this.day = day;
        this.room = room;
        this.group = group;
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
