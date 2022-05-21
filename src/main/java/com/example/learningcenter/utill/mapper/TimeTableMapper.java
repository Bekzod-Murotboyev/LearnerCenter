package com.example.learningcenter.utill.mapper;

import com.example.learningcenter.dto.timeTable.TimeTableCreateDTO;
import com.example.learningcenter.dto.timeTable.TimeTableDTO;
import com.example.learningcenter.dto.timeTable.TimeTableUpdateDTO;
import com.example.learningcenter.entity.TimeTable;
import com.example.learningcenter.utill.mapper.base.BaseMapper;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class TimeTableMapper implements BaseMapper<TimeTable, TimeTableDTO, TimeTableCreateDTO, TimeTableUpdateDTO> {
    @Override
    public TimeTableDTO toDTO(TimeTable entity) {
        return new TimeTableDTO(
                entity.getId(),
                entity.getDay(),
                entity.getRoom().getName(),
                entity.getGroup().getName(),
                entity.getStartTime(),
                entity.getEndTime());
    }

    @Override
    public TimeTable toEntity(TimeTableUpdateDTO dto, TimeTable entity) {
        if(Objects.nonNull(dto.getDay()))
            entity.setDay(dto.getDay());
        if(Objects.nonNull(dto.getStartTime()))
            entity.setStartTime(dto.getStartTime());
        if(Objects.nonNull(dto.getEndTime()))
            entity.setEndTime(dto.getEndTime());
        return entity;
    }

    @Override
    public TimeTable toEntity(TimeTableCreateDTO dto) {
        return new TimeTable(dto.getDay(),dto.getStartTime(),dto.getEndTime());
    }
}
