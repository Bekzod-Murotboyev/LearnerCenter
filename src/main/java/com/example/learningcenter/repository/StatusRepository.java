package com.example.learningcenter.repository;

import com.example.learningcenter.entity.Room;
import com.example.learningcenter.entity.Status;
import com.example.learningcenter.repository.base.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StatusRepository extends JpaRepository<Status, Long>, BaseRepository {
    Boolean existsByNameAndIdNot(String name, Long id);
    Boolean existsByName(String name);
}
