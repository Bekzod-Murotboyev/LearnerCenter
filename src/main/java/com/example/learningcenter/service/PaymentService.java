package com.example.learningcenter.service;

import com.example.learningcenter.criteria.GenericCriteria;
import com.example.learningcenter.dto.payment.PaymentCreatDTO;
import com.example.learningcenter.dto.payment.PaymentDTO;
import com.example.learningcenter.dto.response.Data;
import com.example.learningcenter.entity.Payment;
import com.example.learningcenter.exceptions.TargetDidNotFindException;
import com.example.learningcenter.repository.PaymentRepository;
import com.example.learningcenter.repository.StudentRepository;
import com.example.learningcenter.service.base.AbstractService;
import com.example.learningcenter.service.base.GenericCrudService;
import com.example.learningcenter.utill.mapper.PaymentMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class PaymentService extends AbstractService<PaymentRepository, PaymentMapper> implements GenericCrudService<
        PaymentDTO, GenericCriteria, Long, PaymentCreatDTO, PaymentDTO> {

    private final StudentRepository studentRepository;

    public PaymentService(PaymentRepository repository, PaymentMapper mapper, StudentRepository studentRepository) {
        super(repository, mapper);
        this.studentRepository = studentRepository;
    }

    @Override
    public ResponseEntity<Data<Long>> create(PaymentCreatDTO dto) {
        Payment payment = mapper.toEntity(dto);
        payment.setStudent(studentRepository
                .findById(dto.getStudentId())
                .orElseThrow(() -> new TargetDidNotFindException(notFound("STUDENT", "ID", dto.getStudentId().toString()))));

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new Data<>(repository.save(payment).getId()));
    }

    @Override
    public ResponseEntity<Data<Long>> update(PaymentDTO dto) {

        Payment payment = mapper.toEntity(dto, repository
                .findById(dto.getId())
                .orElseThrow(() -> new TargetDidNotFindException(idNotFound(dto.getId()))));

        if (Objects.nonNull(dto.getStudentId()))
            payment.setStudent(studentRepository
                    .findById(dto.getStudentId())
                    .orElseThrow(() -> new TargetDidNotFindException(notFound("STUDENT", "ID", dto.getStudentId().toString()))));

        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(new Data<>(repository.save(payment).getId()));
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
        return "PAYMENT";
    }

    @Override
    public ResponseEntity<List<PaymentDTO>> getAll(GenericCriteria criteria) {
        return ResponseEntity
                .ok(repository
                        .findAll(PageRequest.of(criteria.getPage(), criteria.getSize()))
                        .map(mapper::toDTO)
                        .toList());
    }

    @Override
    public ResponseEntity<Data<PaymentDTO>> get(Long id) {
        return ResponseEntity
                .ok(new Data<>(repository
                        .findById(id)
                        .map(mapper::toDTO)
                        .orElseThrow(() -> new TargetDidNotFindException(idNotFound(id)))));
    }
}
