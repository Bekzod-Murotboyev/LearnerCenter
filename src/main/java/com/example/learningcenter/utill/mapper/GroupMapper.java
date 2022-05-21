package com.example.learningcenter.utill.mapper;

import com.example.learningcenter.dto.group.GroupCreateDTO;
import com.example.learningcenter.dto.group.GroupDTO;
import com.example.learningcenter.dto.group.GroupUpdateDTO;
import com.example.learningcenter.entity.Group;
import com.example.learningcenter.utill.mapper.base.BaseMapper;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class GroupMapper implements BaseMapper<Group, GroupDTO, GroupCreateDTO, GroupUpdateDTO> {
    @Override
    public GroupDTO toDTO(Group entity) {
        return new GroupDTO(entity.getId(),
                entity.getName(),
                entity.getCourse().getId(),
                entity.getTeacher().getId(),
                entity.getStartDate(),
                entity.getEndDate(),
                entity.getStatus().getName());
    }

    @Override
    public Group toEntity(GroupUpdateDTO dto, Group entity) {
        if (Objects.nonNull(dto.getName()))
            entity.setName(dto.getName());
        if (Objects.nonNull(dto.getStartDate()))
            entity.setStartDate(dto.getStartDate());
        if (Objects.nonNull(dto.getEndDate()))
            entity.setEndDate(dto.getEndDate());
        return entity;
    }

    @Override
    public Group toEntity(GroupCreateDTO dto) {
        return new Group(dto.getName(), dto.getStartDate(), dto.getEndDate());
    }
}
