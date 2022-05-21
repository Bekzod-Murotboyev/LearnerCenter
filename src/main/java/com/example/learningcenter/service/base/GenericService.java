package com.example.learningcenter.service.base;

import com.example.learningcenter.criteria.GenericCriteria;
import com.example.learningcenter.dto.base.GenericDTO;
import com.example.learningcenter.dto.response.Data;
import org.springframework.http.ResponseEntity;

import java.io.Serializable;
import java.util.List;

/**
 * @param <D> DTO -> Data Transfer Object
 * @param <C> Criteria
 * @param <K> Key type for entity id
 */

public interface GenericService<
        D extends GenericDTO,
        C extends GenericCriteria,
        K extends Serializable
        > extends BaseService{

    ResponseEntity<List<D>> getAll(C criteria);

    ResponseEntity<Data<D>> get(K id);

}
