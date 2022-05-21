package com.example.learningcenter.utill.mapper;

import com.example.learningcenter.dto.teacher.TeacherCreateDTO;
import com.example.learningcenter.dto.teacher.TeacherDTO;
import com.example.learningcenter.entity.Teacher;
import com.example.learningcenter.utill.mapper.base.BaseMapper;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class TeacherMapper implements BaseMapper<
        Teacher, TeacherDTO, TeacherCreateDTO, TeacherDTO> {


    @Override
    public TeacherDTO toDTO(Teacher entity) {
        return new TeacherDTO(entity.getId(), entity.getFullName(), entity.getPhone(), entity.getSalary());
    }

    @Override
    public Teacher toEntity(TeacherDTO dto, Teacher entity) {
        if (Objects.nonNull(dto.getFullName()))
            entity.setFullName(dto.getFullName());
        if (Objects.nonNull(dto.getPhone()))
            entity.setPhone(dto.getPhone());
        if (Objects.nonNull(dto.getSalary()))
            entity.setSalary(dto.getSalary());
        return entity;
    }

    @Override
    public Teacher toEntity(TeacherCreateDTO dto) {
        return new Teacher(dto.getFullName(), dto.getPhone(), dto.getSalary());
    }
}
