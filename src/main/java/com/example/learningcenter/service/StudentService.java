package com.example.learningcenter.service;

import com.example.learningcenter.criteria.GenericCriteria;
import com.example.learningcenter.dto.response.Data;
import com.example.learningcenter.dto.student.teacher.StudentCreateDTO;
import com.example.learningcenter.dto.student.teacher.StudentDTO;
import com.example.learningcenter.entity.Student;
import com.example.learningcenter.exceptions.AlreadyExistException;
import com.example.learningcenter.exceptions.TargetDidNotFindException;
import com.example.learningcenter.repository.StudentRepository;
import com.example.learningcenter.service.base.AbstractService;
import com.example.learningcenter.service.base.GenericCrudService;
import com.example.learningcenter.utill.mapper.StudentMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class StudentService extends AbstractService<StudentRepository, StudentMapper> implements GenericCrudService<
        StudentDTO, GenericCriteria, Long, StudentCreateDTO, StudentDTO> {
    public StudentService(StudentRepository repository, StudentMapper mapper) {
        super(repository, mapper);
    }

    @Override
    public ResponseEntity<Data<Long>> create(StudentCreateDTO dto) {
        if (repository.existsByPhone(dto.getPhone()))
            throw new AlreadyExistException(alreadyExist("PHONE", dto.getPhone()));
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new Data<>(repository.save(mapper.toEntity(dto)).getId()));
    }

    @Override
    public ResponseEntity<Data<Long>> update(StudentDTO dto) {
        if (Objects.nonNull(dto.getPhone()) && repository.existsByPhoneAndIdNot(dto.getPhone(), dto.getId()))
            throw new AlreadyExistException(alreadyExist("PHONE", dto.getPhone()));
        Student teacher = mapper.toEntity(dto, repository
                .findById(dto.getId())
                .orElseThrow(() -> new TargetDidNotFindException(idNotFound(dto.getId()))));
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(new Data<>(repository.save(teacher).getId()));
    }

    @Override
    public ResponseEntity<Data<Void>> delete(Long id) {
        repository.delete(repository
                .findById(id)
                .orElseThrow(() -> new TargetDidNotFindException(idNotFound(id))));
        return ResponseEntity.noContent().build();
    }

    @Override
    public String getType() {
        return "STUDENT";
    }

    @Override
    public ResponseEntity<List<StudentDTO>> getAll(GenericCriteria criteria) {
        return ResponseEntity.ok(
                repository
                        .findAll(PageRequest.of(criteria.getPage(), criteria.getSize()))
                        .map(mapper::toDTO)
                        .toList());
    }

    @Override
    public ResponseEntity<Data<StudentDTO>> get(Long id) {
        return ResponseEntity
                .ok(new Data<>(repository
                        .findById(id)
                        .map(mapper::toDTO)
                        .orElseThrow(() -> new TargetDidNotFindException(idNotFound(id)))));
    }
}
