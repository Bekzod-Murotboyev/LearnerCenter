package com.example.learningcenter.controller;

import com.example.learningcenter.controller.base.AbstractController;
import com.example.learningcenter.controller.base.BaseController;
import com.example.learningcenter.criteria.GenericCriteria;
import com.example.learningcenter.dto.group.GroupCreateDTO;
import com.example.learningcenter.dto.group.GroupDTO;
import com.example.learningcenter.dto.group.GroupUpdateDTO;
import com.example.learningcenter.dto.response.Data;
import com.example.learningcenter.service.GroupService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.example.learningcenter.controller.base.AbstractController.PATH;

@RestController
@RequestMapping(PATH+"/group")
public class GroupController extends AbstractController<GroupService> implements BaseController<
        GenericCriteria,Long, GroupDTO, GroupCreateDTO, GroupUpdateDTO> {
    public GroupController(GroupService service) {
        super(service);
    }

    @Override
    public ResponseEntity<List<GroupDTO>> getAll(GenericCriteria criteria) {
        return service.getAll(criteria);
    }

    @Override
    public ResponseEntity<Data<GroupDTO>> get(Long id) {
        return service.get(id);
    }

    @Override
    public ResponseEntity<Data<Long>> create(GroupCreateDTO dto) {
        return service.create(dto);
    }

    @Override
    public ResponseEntity<Data<Long>> update(GroupUpdateDTO dto) {
        return service.update(dto);
    }

    @Override
    public ResponseEntity<Data<Void>> delete(Long id) {
        return service.delete(id);
    }
}
