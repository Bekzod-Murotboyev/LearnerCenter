package com.example.learningcenter.service;

import com.example.learningcenter.criteria.GenericCriteria;
import com.example.learningcenter.dto.response.Data;
import com.example.learningcenter.dto.timeTable.TimeTableCreateDTO;
import com.example.learningcenter.dto.timeTable.TimeTableDTO;
import com.example.learningcenter.dto.timeTable.TimeTableUpdateDTO;
import com.example.learningcenter.entity.TimeTable;
import com.example.learningcenter.exceptions.AlreadyExistException;
import com.example.learningcenter.exceptions.TargetDidNotFindException;
import com.example.learningcenter.repository.GroupRepository;
import com.example.learningcenter.repository.RoomRepository;
import com.example.learningcenter.repository.TimeTableRepository;
import com.example.learningcenter.service.base.AbstractService;
import com.example.learningcenter.service.base.GenericCrudService;
import com.example.learningcenter.utill.mapper.TimeTableMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class TimeTableService extends AbstractService<TimeTableRepository, TimeTableMapper> implements GenericCrudService<
        TimeTableDTO, GenericCriteria, Long, TimeTableCreateDTO, TimeTableUpdateDTO> {

    private final RoomRepository roomRepository;
    private final GroupRepository groupRepository;

    public TimeTableService(TimeTableRepository repository, TimeTableMapper mapper, RoomRepository roomRepository, GroupRepository groupRepository) {
        super(repository, mapper);
        this.roomRepository = roomRepository;
        this.groupRepository = groupRepository;
    }

    @Override
    public ResponseEntity<Data<Long>> create(TimeTableCreateDTO dto) {
        if (repository.checkAllPossibleCases(dto.getRoomId(), dto.getDay().name(), dto.getStartTime(), dto.getEndTime()) >0)
            throw new AlreadyExistException(alreadyExist("DISTANCE", dto.getStartTime() + " AND " + dto.getEndTime()));
        TimeTable timeTable = mapper.toEntity(dto);
        timeTable.setGroup(groupRepository
                .findById(dto.getGroupId())
                .orElseThrow(() -> new TargetDidNotFindException(notFound("GROUP", "ID", dto.getGroupId().toString()))));
        timeTable.setRoom(roomRepository
                .findById(dto.getRoomId())
                .orElseThrow(() -> new TargetDidNotFindException(notFound("ROOM", "ID", dto.getRoomId().toString()))));
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new Data<>(repository.save(timeTable).getId()));
    }

    @Override
    public ResponseEntity<Data<Long>> update(TimeTableUpdateDTO dto) {
        if (repository.checkAllPossibleCasesButIdNot(dto.getId(), dto.getRoomId(), dto.getDay().name(), dto.getStartTime(), dto.getEndTime()) > 0)
            throw new AlreadyExistException(alreadyExist("DISTANCE", dto.getStartTime() + " AND " + dto.getEndTime()));

        TimeTable timeTable = mapper.toEntity(dto, repository
                .findById(dto.getId())
                .orElseThrow(() -> new TargetDidNotFindException(idNotFound(dto.getId()))));

        if (Objects.nonNull(dto.getGroupId()))
            timeTable.setGroup(groupRepository
                    .findById(dto.getGroupId())
                    .orElseThrow(() -> new TargetDidNotFindException(notFound("GROUP", "ID", dto.getGroupId().toString()))));
        if (Objects.nonNull(dto.getRoomId()))
            timeTable.setRoom(roomRepository
                    .findById(dto.getRoomId())
                    .orElseThrow(() -> new TargetDidNotFindException(notFound("ROOM", "ID", dto.getRoomId().toString()))));

        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(new Data<>(repository.save(timeTable).getId()));
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
        return "TIME TABLE";
    }

    @Override
    public ResponseEntity<List<TimeTableDTO>> getAll(GenericCriteria criteria) {
        return ResponseEntity
                .ok(repository
                        .findAll(PageRequest.of(criteria.getPage(), criteria.getSize()))
                        .map(mapper::toDTO)
                        .toList());
    }

    @Override
    public ResponseEntity<Data<TimeTableDTO>> get(Long id) {
        return ResponseEntity
                .ok(new Data<>(repository
                        .findById(id)
                        .map(mapper::toDTO)
                        .orElseThrow(() -> new TargetDidNotFindException(idNotFound(id)))));
    }
}
