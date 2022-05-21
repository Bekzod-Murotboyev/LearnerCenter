package com.example.learningcenter.utill.mapper;

import com.example.learningcenter.dto.room.RoomCreateDTO;
import com.example.learningcenter.dto.room.RoomDTO;
import com.example.learningcenter.entity.Room;
import com.example.learningcenter.utill.mapper.base.BaseMapper;
import org.springframework.stereotype.Component;

@Component
public class RoomMapper implements BaseMapper<
        Room,RoomDTO,RoomCreateDTO,RoomDTO> {

    @Override
    public RoomDTO toDTO(Room entity) {
        return new RoomDTO(entity.getId(),entity.getName(), entity.getCapacity());
    }

    @Override
    public Room toEntity(RoomDTO dto, Room entity) {
        if (dto.getName() != null)
            entity.setName(dto.getName());
        if (dto.getCapacity() != null)
            entity.setCapacity(dto.getCapacity());
        return entity;
    }

    @Override
    public Room toEntity(RoomCreateDTO dto) {
        return new Room(dto.getName(), dto.getCapacity());
    }
}
