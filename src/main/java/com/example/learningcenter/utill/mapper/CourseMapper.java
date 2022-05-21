package com.example.learningcenter.utill.mapper;

import com.example.learningcenter.dto.course.CourseCreateDTO;
import com.example.learningcenter.dto.course.CourseDTO;
import com.example.learningcenter.entity.Course;
import com.example.learningcenter.utill.mapper.base.BaseMapper;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class CourseMapper implements BaseMapper<
        Course,CourseDTO,CourseCreateDTO,CourseDTO> {

    @Override
    public CourseDTO toDTO(Course entity) {
        return new CourseDTO(entity.getId(),entity.getName(), entity.getPrice(), entity.getDuration());
    }

    @Override
    public Course toEntity(CourseDTO dto, Course entity) {
        if (Objects.nonNull(dto.getName()))
            entity.setName(dto.getName());
        if (Objects.nonNull(dto.getPrice()))
            entity.setPrice(dto.getPrice());
        if (Objects.nonNull(dto.getDuration()))
            entity.setDuration(dto.getDuration());
        return entity;
    }

    @Override
    public Course toEntity(CourseCreateDTO dto) {
        return new Course(dto.getName(), dto.getPrice(), dto.getDuration());
    }
}
