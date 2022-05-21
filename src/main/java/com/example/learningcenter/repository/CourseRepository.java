package com.example.learningcenter.repository;

import com.example.learningcenter.entity.Course;
import com.example.learningcenter.entity.Room;
import com.example.learningcenter.repository.base.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long>, BaseRepository {
    Boolean existsByName(String name);

    Boolean existsByNameAndIdNot(String name, Long id);
}
