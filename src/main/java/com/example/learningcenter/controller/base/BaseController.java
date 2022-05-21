package com.example.learningcenter.controller.base;

import com.example.learningcenter.criteria.GenericCriteria;
import com.example.learningcenter.dto.base.DTO;
import com.example.learningcenter.dto.base.GenericDTO;
import com.example.learningcenter.dto.response.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.MappedSuperclass;
import javax.validation.Valid;
import java.io.Serializable;
import java.util.List;

@MappedSuperclass
public interface BaseController<
        C extends GenericCriteria,
        K extends Serializable,
        D extends GenericDTO,
        CD extends DTO,
        UD extends GenericDTO
        > {
    @GetMapping
    ResponseEntity<List<D>> getAll(@Valid C criteria);

    @GetMapping("/{id}")
    ResponseEntity<Data<D>> get(@PathVariable K id);

    @PostMapping
    ResponseEntity<Data<K>> create(@Valid @RequestBody CD dto);

    @PutMapping
    ResponseEntity<Data<K>> update(@Valid @RequestBody UD dto);

    @DeleteMapping
    ResponseEntity<Data<Void>> delete(@RequestParam K id);
}
