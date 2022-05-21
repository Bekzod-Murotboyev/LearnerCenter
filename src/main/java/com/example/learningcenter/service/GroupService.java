package com.example.learningcenter.service;

import com.example.learningcenter.criteria.GenericCriteria;
import com.example.learningcenter.dto.group.GroupCreateDTO;
import com.example.learningcenter.dto.group.GroupDTO;
import com.example.learningcenter.dto.group.GroupUpdateDTO;
import com.example.learningcenter.dto.response.Data;
import com.example.learningcenter.entity.Group;
import com.example.learningcenter.exceptions.AlreadyExistException;
import com.example.learningcenter.exceptions.TargetDidNotFindException;
import com.example.learningcenter.repository.CourseRepository;
import com.example.learningcenter.repository.GroupRepository;
import com.example.learningcenter.repository.StatusRepository;
import com.example.learningcenter.repository.TeacherRepository;
import com.example.learningcenter.service.base.AbstractService;
import com.example.learningcenter.service.base.GenericCrudService;
import com.example.learningcenter.utill.mapper.GroupMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class GroupService extends AbstractService<GroupRepository, GroupMapper> implements GenericCrudService<
        GroupDTO, GenericCriteria, Long, GroupCreateDTO, GroupUpdateDTO> {

    private final CourseRepository courseRepository;
    private final TeacherRepository teacherRepository;
    private final StatusRepository statusRepository;

    public GroupService(GroupRepository repository,
                        GroupMapper mapper,
                        CourseRepository courseRepository,
                        TeacherRepository teacherRepository,
                        StatusRepository statusRepository) {
        super(repository, mapper);
        this.courseRepository = courseRepository;
        this.teacherRepository = teacherRepository;
        this.statusRepository = statusRepository;
    }


    @Override
    public ResponseEntity<Data<Long>> create(GroupCreateDTO dto) {
        if (repository.existsByName(dto.getName()))
            throw new AlreadyExistException(alreadyExist("NAME", dto.getName()));
        Group group = mapper.toEntity(dto);
        group.setCourse(courseRepository
                .findById(dto.getCourseId())
                .orElseThrow(() -> new TargetDidNotFindException(notFound("COURSE", "ID", dto.getCourseId().toString()))));
        group.setTeacher(teacherRepository
                .findById(dto.getTeacherId())
                .orElseThrow(() -> new TargetDidNotFindException(notFound("TEACHER", "ID", dto.getTeacherId().toString()))));
        group.setStatus(statusRepository
                .findById(dto.getStatusId())
                .orElseThrow(() -> new TargetDidNotFindException(notFound("STATUS", "ID", dto.getStatusId().toString()))));
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new Data<>(repository.save(group).getId()));
    }

    @Override
    public ResponseEntity<Data<Long>> update(GroupUpdateDTO dto) {
        if (Objects.nonNull(dto.getName()) && repository.existsByNameAndIdNot(dto.getName(), dto.getId()))
            throw new AlreadyExistException(alreadyExist("NAME", dto.getName()));

        Group group = mapper.toEntity(dto, repository
                .findById(dto.getId())
                .orElseThrow(() -> new TargetDidNotFindException(idNotFound(dto.getId()))));

        if (Objects.nonNull(dto.getCourseId()))
            group.setCourse(courseRepository
                    .findById(dto.getCourseId())
                    .orElseThrow(() -> new TargetDidNotFindException(notFound("COURSE", "ID", dto.getCourseId().toString()))));
        if (Objects.nonNull(dto.getTeacherId()))
            group.setTeacher(teacherRepository
                    .findById(dto.getTeacherId())
                    .orElseThrow(() -> new TargetDidNotFindException(notFound("TEACHER", "ID", dto.getTeacherId().toString()))));
        if (Objects.nonNull(dto.getStatusId()))
            group.setStatus(statusRepository
                    .findById(dto.getStatusId())
                    .orElseThrow(() -> new TargetDidNotFindException(notFound("STATUS", "ID", dto.getStatusId().toString()))));
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(new Data<>(repository.save(group).getId()));
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
        return "GROUP";
    }

    @Override
    public ResponseEntity<List<GroupDTO>> getAll(GenericCriteria criteria) {
        return ResponseEntity
                .ok(repository
                        .findAll(PageRequest.of(criteria.getPage(), criteria.getSize()))
                        .map(mapper::toDTO)
                        .toList());
    }

    @Override
    public ResponseEntity<Data<GroupDTO>> get(Long id) {
        return ResponseEntity
                .ok(new Data<>(repository
                        .findById(id)
                        .map(mapper::toDTO)
                        .orElseThrow(() -> new TargetDidNotFindException(idNotFound(id)))));
    }
}
