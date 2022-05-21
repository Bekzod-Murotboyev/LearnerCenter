package com.example.learningcenter.utill.mapper;

import com.example.learningcenter.dto.status.StatusCreateDTO;
import com.example.learningcenter.dto.status.StatusDTO;
import com.example.learningcenter.entity.Status;
import com.example.learningcenter.utill.mapper.base.BaseMapper;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class StatusMapper implements BaseMapper<
        Status, StatusDTO, StatusCreateDTO, StatusDTO> {

    @Override
    public StatusDTO toDTO(Status entity) {
        return new StatusDTO(entity.getId(), entity.getName(), entity.getDescription());
    }

    @Override
    public Status toEntity(StatusDTO dto, Status entity) {
        if (Objects.nonNull(dto.getName()))
            entity.setName(dto.getName());
        if (Objects.nonNull(dto.getDescription()))
            entity.setDescription(dto.getDescription());
        return entity;
    }

    @Override
    public Status toEntity(StatusCreateDTO dto) {
        return new Status(dto.getName(), dto.getDescription());
    }
}
