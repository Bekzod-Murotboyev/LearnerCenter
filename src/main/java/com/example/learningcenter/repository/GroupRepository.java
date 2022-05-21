package com.example.learningcenter.repository;

import com.example.learningcenter.entity.Group;
import com.example.learningcenter.repository.base.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group,Long>, BaseRepository {
    Boolean existsByName(String name);

    Boolean existsByNameAndIdNot(String name, Long id);
}
