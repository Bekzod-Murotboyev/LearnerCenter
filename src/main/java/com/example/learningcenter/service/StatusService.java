package com.example.learningcenter.service;

import com.example.learningcenter.criteria.GenericCriteria;
import com.example.learningcenter.dto.response.Data;
import com.example.learningcenter.dto.status.StatusCreateDTO;
import com.example.learningcenter.dto.status.StatusDTO;
import com.example.learningcenter.entity.Status;
import com.example.learningcenter.exceptions.AlreadyExistException;
import com.example.learningcenter.exceptions.TargetDidNotFindException;
import com.example.learningcenter.repository.StatusRepository;
import com.example.learningcenter.service.base.AbstractService;
import com.example.learningcenter.service.base.GenericCrudService;
import com.example.learningcenter.utill.mapper.StatusMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class StatusService extends AbstractService<
        StatusRepository, StatusMapper
        > implements GenericCrudService<StatusDTO, GenericCriteria, Long, StatusCreateDTO, StatusDTO> {


    protected StatusService(StatusRepository repository, StatusMapper mapper) {
        super(repository, mapper);
    }

    @Override
    public ResponseEntity<Data<Long>> create(StatusCreateDTO dto) {
        if (repository.existsByName(dto.getName()))
            throw new AlreadyExistException(alreadyExist("NAME", dto.getName()));
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new Data<>(repository.save(mapper.toEntity(dto)).getId()));
    }

    @Override
    public ResponseEntity<Data<Long>> update(StatusDTO dto) {
        if (Objects.nonNull(dto.getName()) && repository.existsByNameAndIdNot(dto.getName(), dto.getId()))
            throw new AlreadyExistException(alreadyExist("NAME", dto.getName()));

        Status room = mapper.toEntity(dto, repository
                .findById(dto.getId())
                .orElseThrow(() -> new TargetDidNotFindException(idNotFound(dto.getId()))));
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(new Data<>(repository.save(room).getId()));
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
        return "STATUS";
    }

    @Override
    public ResponseEntity<List<StatusDTO>> getAll(GenericCriteria criteria) {
        return ResponseEntity.ok(repository
                .findAll(PageRequest.of(criteria.getPage(), criteria.getSize()))
                .map(mapper::toDTO).toList());
    }

    @Override
    public ResponseEntity<Data<StatusDTO>> get(Long id) {
        return ResponseEntity.ok(
                new Data<>(mapper.toDTO(repository
                        .findById(id)
                        .orElseThrow(() -> new TargetDidNotFindException(idNotFound(id))))));
    }
}
