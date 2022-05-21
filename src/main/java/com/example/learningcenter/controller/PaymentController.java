package com.example.learningcenter.controller;

import com.example.learningcenter.controller.base.AbstractController;
import com.example.learningcenter.controller.base.BaseController;
import com.example.learningcenter.criteria.GenericCriteria;
import com.example.learningcenter.dto.payment.PaymentCreatDTO;
import com.example.learningcenter.dto.payment.PaymentDTO;
import com.example.learningcenter.dto.response.Data;
import com.example.learningcenter.service.PaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.example.learningcenter.controller.base.AbstractController.PATH;

@RestController
@RequestMapping(PATH+"/payment")
public class PaymentController extends AbstractController<PaymentService> implements BaseController<
        GenericCriteria,Long, PaymentDTO, PaymentCreatDTO,PaymentDTO> {
    public PaymentController(PaymentService service) {
        super(service);
    }

    @Override
    public ResponseEntity<List<PaymentDTO>> getAll(GenericCriteria criteria) {
        return service.getAll(criteria);
    }

    @Override
    public ResponseEntity<Data<PaymentDTO>> get(Long id) {
        return service.get(id);
    }

    @Override
    public ResponseEntity<Data<Long>> create(PaymentCreatDTO dto) {
        return service.create(dto);
    }

    @Override
    public ResponseEntity<Data<Long>> update(PaymentDTO dto) {
        return service.update(dto);
    }

    @Override
    public ResponseEntity<Data<Void>> delete(Long id) {
        return service.delete(id);
    }
}
