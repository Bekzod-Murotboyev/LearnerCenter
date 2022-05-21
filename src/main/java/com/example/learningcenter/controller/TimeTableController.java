package com.example.learningcenter.controller;

import com.example.learningcenter.controller.base.AbstractController;
import com.example.learningcenter.controller.base.BaseController;
import com.example.learningcenter.criteria.GenericCriteria;
import com.example.learningcenter.dto.response.Data;
import com.example.learningcenter.dto.timeTable.TimeTableCreateDTO;
import com.example.learningcenter.dto.timeTable.TimeTableDTO;
import com.example.learningcenter.dto.timeTable.TimeTableUpdateDTO;
import com.example.learningcenter.service.TimeTableService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.example.learningcenter.controller.base.AbstractController.PATH;

@RestController
@RequestMapping(PATH+"/time_table")
public class TimeTableController extends AbstractController<TimeTableService> implements BaseController<
        GenericCriteria,Long, TimeTableDTO, TimeTableCreateDTO, TimeTableUpdateDTO> {
    public TimeTableController(TimeTableService service) {
        super(service);
    }

    @Override
    public ResponseEntity<List<TimeTableDTO>> getAll(GenericCriteria criteria) {
        return service.getAll(criteria);
    }

    @Override
    public ResponseEntity<Data<TimeTableDTO>> get(Long id) {
        return service.get(id);
    }

    @Override
    public ResponseEntity<Data<Long>> create(TimeTableCreateDTO dto) {
        return service.create(dto);
    }

    @Override
    public ResponseEntity<Data<Long>> update(TimeTableUpdateDTO dto) {
        return service.update(dto);
    }

    @Override
    public ResponseEntity<Data<Void>> delete(Long id) {
        return service.delete(id);
    }
}
