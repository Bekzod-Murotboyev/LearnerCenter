package com.example.learningcenter.controller;

import com.example.learningcenter.controller.base.AbstractController;
import com.example.learningcenter.controller.base.BaseController;
import com.example.learningcenter.criteria.GenericCriteria;
import com.example.learningcenter.dto.response.Data;
import com.example.learningcenter.dto.room.RoomCreateDTO;
import com.example.learningcenter.dto.room.RoomDTO;
import com.example.learningcenter.dto.status.StatusCreateDTO;
import com.example.learningcenter.dto.status.StatusDTO;
import com.example.learningcenter.service.RoomService;
import com.example.learningcenter.service.StatusService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.example.learningcenter.controller.base.AbstractController.PATH;

@RestController
@RequestMapping(PATH + "/status")
public class StatusController extends AbstractController<StatusService> implements BaseController<
        GenericCriteria, Long, StatusDTO, StatusCreateDTO, StatusDTO> {

    public StatusController(StatusService service) {
        super(service);
    }

    @Override
    public ResponseEntity<List<StatusDTO>> getAll(GenericCriteria criteria) {
        return service.getAll(criteria);
    }

    @Override
    public ResponseEntity<Data<StatusDTO>> get(Long id) {
        return service.get(id);
    }

    @Override
    public ResponseEntity<Data<Long>> create(StatusCreateDTO dto) {
        return service.create(dto);
    }

    @Override
    public ResponseEntity<Data<Long>> update(StatusDTO dto) {
        return service.update(dto);
    }

    @Override
    public ResponseEntity<Data<Void>> delete(Long id) {
        return service.delete(id);
    }
}
