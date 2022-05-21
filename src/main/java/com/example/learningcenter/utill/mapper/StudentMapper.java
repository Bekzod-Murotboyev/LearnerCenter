package com.example.learningcenter.utill.mapper;

import com.example.learningcenter.dto.student.teacher.StudentCreateDTO;
import com.example.learningcenter.dto.student.teacher.StudentDTO;
import com.example.learningcenter.entity.Student;
import com.example.learningcenter.utill.mapper.base.BaseMapper;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class StudentMapper implements BaseMapper<
        Student, StudentDTO, StudentCreateDTO, StudentDTO> {


    @Override
    public StudentDTO toDTO(Student entity) {
        return new StudentDTO(entity.getId(), entity.getFullName(), entity.getPhone());
    }

    @Override
    public Student toEntity(StudentDTO dto, Student entity) {
        if (Objects.nonNull(dto.getFullName()))
            entity.setFullName(dto.getFullName());
        if (Objects.nonNull(dto.getPhone()))
            entity.setPhone(dto.getPhone());
        return entity;
    }

    @Override
    public Student toEntity(StudentCreateDTO dto) {
        return new Student(dto.getFullName(), dto.getPhone());
    }
}
