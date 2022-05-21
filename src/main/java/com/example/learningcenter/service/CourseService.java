package com.example.learningcenter.service;

import com.example.learningcenter.criteria.GenericCriteria;
import com.example.learningcenter.dto.course.CourseCreateDTO;
import com.example.learningcenter.dto.course.CourseDTO;
import com.example.learningcenter.dto.response.Data;
import com.example.learningcenter.entity.Course;
import com.example.learningcenter.exceptions.AlreadyExistException;
import com.example.learningcenter.exceptions.TargetDidNotFindException;
import com.example.learningcenter.repository.CourseRepository;
import com.example.learningcenter.service.base.AbstractService;
import com.example.learningcenter.service.base.GenericCrudService;
import com.example.learningcenter.utill.mapper.CourseMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService
        extends AbstractService<CourseRepository, CourseMapper>
        implements GenericCrudService<CourseDTO, GenericCriteria, Long, CourseCreateDTO, CourseDTO> {


    public CourseService(CourseRepository repository, CourseMapper mapper) {
        super(repository, mapper);
    }

    @Override
    public ResponseEntity<Data<Long>> create(CourseCreateDTO dto) {
        if (repository.existsByName(dto.getName()))
            throw new AlreadyExistException(alreadyExist("NAME", dto.getName()));
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new Data<>(repository.save(mapper.toEntity(dto)).getId()));
    }

    @Override
    public ResponseEntity<Data<Long>> update(CourseDTO dto) {
        if (repository.existsByNameAndIdNot(dto.getName(),dto.getId()))
            throw new AlreadyExistException(alreadyExist("NAME", dto.getName()));
        Course course = repository
                .findById(dto.getId())
                .orElseThrow(() -> new TargetDidNotFindException(idNotFound(dto.getId())));
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(new Data<>(repository.save(mapper.toEntity(dto, course)).getId()));
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
        return "COURSE";
    }

    @Override
    public ResponseEntity<List<CourseDTO>> getAll(GenericCriteria criteria) {
        return ResponseEntity
                .ok(repository
                        .findAll(PageRequest.of(criteria.getPage(), criteria.getSize()))
                        .map(mapper::toDTO)
                        .toList());
    }

    @Override
    public ResponseEntity<Data<CourseDTO>> get(Long id) {
        return ResponseEntity
                .ok(new Data<>(repository
                        .findById(id)
                        .map(mapper::toDTO)
                        .orElseThrow(() -> new TargetDidNotFindException(idNotFound(id)))));
    }
}
