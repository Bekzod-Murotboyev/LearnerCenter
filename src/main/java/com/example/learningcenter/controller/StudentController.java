package com.example.learningcenter.controller;

import com.example.learningcenter.controller.base.AbstractController;
import com.example.learningcenter.controller.base.BaseController;
import com.example.learningcenter.criteria.GenericCriteria;
import com.example.learningcenter.dto.response.Data;
import com.example.learningcenter.dto.student.teacher.StudentCreateDTO;
import com.example.learningcenter.dto.student.teacher.StudentDTO;
import com.example.learningcenter.dto.teacher.TeacherCreateDTO;
import com.example.learningcenter.dto.teacher.TeacherDTO;
import com.example.learningcenter.service.StudentService;
import com.example.learningcenter.service.TeacherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.example.learningcenter.controller.base.AbstractController.PATH;

@RestController
@RequestMapping(PATH + "/student")
public class StudentController extends AbstractController<StudentService> implements BaseController<
        GenericCriteria, Long, StudentDTO, StudentCreateDTO, StudentDTO> {


    public StudentController(StudentService service) {
        super(service);
    }

    @Override
    public ResponseEntity<List<StudentDTO>> getAll(GenericCriteria criteria) {
        return service.getAll(criteria);
    }

    @Override
    public ResponseEntity<Data<StudentDTO>> get(Long id) {
        return service.get(id);
    }

    @Override
    public ResponseEntity<Data<Long>> create(StudentCreateDTO dto) {
        return service.create(dto);
    }

    @Override
    public ResponseEntity<Data<Long>> update(StudentDTO dto) {
        return service.update(dto);
    }

    @Override
    public ResponseEntity<Data<Void>> delete(Long id) {
        return service.delete(id);
    }
}
