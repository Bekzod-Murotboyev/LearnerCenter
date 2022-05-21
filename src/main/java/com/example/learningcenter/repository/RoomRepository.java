package com.example.learningcenter.repository;

import com.example.learningcenter.entity.Room;
import com.example.learningcenter.entity.base.BaseEntity;
import com.example.learningcenter.repository.base.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface RoomRepository extends JpaRepository<Room, Long>, BaseRepository {
    Boolean existsByNameAndIdNot(String name, Long id);
    Boolean existsByName(String name);
}
