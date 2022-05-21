package com.example.learningcenter.controller;

import com.example.learningcenter.controller.base.AbstractController;
import com.example.learningcenter.controller.base.BaseController;
import com.example.learningcenter.criteria.GenericCriteria;
import com.example.learningcenter.dto.course.CourseCreateDTO;
import com.example.learningcenter.dto.course.CourseDTO;
import com.example.learningcenter.dto.response.Data;
import com.example.learningcenter.service.CourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.example.learningcenter.controller.base.AbstractController.PATH;

@RestController
@RequestMapping(PATH+"/course")
public class CourseController extends AbstractController<CourseService> implements BaseController<
        GenericCriteria,Long, CourseDTO, CourseCreateDTO,CourseDTO> {
    public CourseController(CourseService service) {
        super(service);
    }

    @Override
    public ResponseEntity<List<CourseDTO>> getAll(GenericCriteria criteria) {
        return service.getAll(criteria);
    }

    @Override
    public ResponseEntity<Data<CourseDTO>> get(Long id) {
        return service.get(id);
    }

    @Override
    public ResponseEntity<Data<Long>> create(CourseCreateDTO dto) {
        return service.create(dto);
    }

    @Override
    public ResponseEntity<Data<Long>> update(CourseDTO dto) {
        return service.update(dto);
    }

    @Override
    public ResponseEntity<Data<Void>> delete(Long id) {
        return service.delete(id);
    }
}
