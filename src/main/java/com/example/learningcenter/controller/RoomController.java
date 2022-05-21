package com.example.learningcenter.controller;

import com.example.learningcenter.controller.base.AbstractController;
import com.example.learningcenter.controller.base.BaseController;
import com.example.learningcenter.criteria.GenericCriteria;
import com.example.learningcenter.dto.response.Data;
import com.example.learningcenter.dto.room.RoomCreateDTO;
import com.example.learningcenter.dto.room.RoomDTO;
import com.example.learningcenter.service.RoomService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.example.learningcenter.controller.base.AbstractController.PATH;

@RestController
@RequestMapping(PATH + "/room")
public class RoomController extends AbstractController<RoomService> implements BaseController<
        GenericCriteria, Long, RoomDTO, RoomCreateDTO, RoomDTO> {

    public RoomController(RoomService service) {
        super(service);
    }

    @Override
    public ResponseEntity<List<RoomDTO>> getAll(GenericCriteria criteria) {
        return service.getAll(criteria);
    }

    @Override
    public ResponseEntity<Data<RoomDTO>> get(Long id) {
        return service.get(id);
    }

    @Override
    public ResponseEntity<Data<Long>> create(RoomCreateDTO dto) {
        return service.create(dto);
    }

    @Override
    public ResponseEntity<Data<Long>> update(RoomDTO dto) {
        return service.update(dto);
    }

    @Override
    public ResponseEntity<Data<Void>> delete(Long id) {
        return service.delete(id);
    }


}
