package com.example.learningcenter.service;

import com.example.learningcenter.criteria.GenericCriteria;
import com.example.learningcenter.dto.response.Data;
import com.example.learningcenter.dto.teacher.TeacherCreateDTO;
import com.example.learningcenter.dto.teacher.TeacherDTO;
import com.example.learningcenter.entity.Teacher;
import com.example.learningcenter.exceptions.AlreadyExistException;
import com.example.learningcenter.exceptions.TargetDidNotFindException;
import com.example.learningcenter.repository.TeacherRepository;
import com.example.learningcenter.service.base.AbstractService;
import com.example.learningcenter.service.base.GenericCrudService;
import com.example.learningcenter.utill.mapper.TeacherMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class TeacherService extends AbstractService<TeacherRepository, TeacherMapper> implements GenericCrudService<
        TeacherDTO, GenericCriteria, Long, TeacherCreateDTO, TeacherDTO> {
    public TeacherService(TeacherRepository repository, TeacherMapper mapper) {
        super(repository, mapper);
    }

    @Override
    public ResponseEntity<Data<Long>> create(TeacherCreateDTO dto) {
        if (repository.existsByPhone(dto.getPhone()))
            throw new AlreadyExistException(alreadyExist("PHONE", dto.getPhone()));
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new Data<>(repository.save(mapper.toEntity(dto)).getId()));
    }

    @Override
    public ResponseEntity<Data<Long>> update(TeacherDTO dto) {
        if (Objects.nonNull(dto.getPhone()) && repository.existsByPhoneAndIdNot(dto.getPhone(), dto.getId()))
            throw new AlreadyExistException(alreadyExist("PHONE", dto.getPhone()));
        Teacher teacher = mapper.toEntity(dto, repository
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
        return "TEACHER";
    }

    @Override
    public ResponseEntity<List<TeacherDTO>> getAll(GenericCriteria criteria) {
        return ResponseEntity.ok(
                repository
                        .findAll(PageRequest.of(criteria.getPage(), criteria.getSize()))
                        .map(mapper::toDTO)
                        .toList());
    }

    @Override
    public ResponseEntity<Data<TeacherDTO>> get(Long id) {
        return ResponseEntity
                .ok(new Data<>(repository
                        .findById(id)
                        .map(mapper::toDTO)
                        .orElseThrow(() -> new TargetDidNotFindException(idNotFound(id)))));
    }
}
