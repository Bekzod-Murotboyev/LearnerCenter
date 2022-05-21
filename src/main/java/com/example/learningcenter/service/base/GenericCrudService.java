package com.example.learningcenter.service.base;


import com.example.learningcenter.criteria.GenericCriteria;
import com.example.learningcenter.dto.base.DTO;
import com.example.learningcenter.dto.base.GenericDTO;
import com.example.learningcenter.dto.response.Data;
import org.springframework.http.ResponseEntity;

import java.io.Serializable;

/**
 * @param <D> DTO -> Data Transfer Object
 * @param <C> Criteria -> it is used for giving condition from front
 * @param <K> Key for entity id
 * @param <CD> DTO for doing Operation of Creat
 * @param <UD> DTO for doing Operation of Update
 */

public interface GenericCrudService<
        D extends GenericDTO,
        C extends GenericCriteria,
        K extends Serializable,
        CD extends DTO,
        UD extends GenericDTO
        > extends GenericService<D,C,K> {

    ResponseEntity<Data<K>> create(CD dto);

    ResponseEntity<Data<K>> update(UD dto);

    ResponseEntity<Data<Void>> delete(K id);

    String getType();


    default String alreadyExist(String key,String value){
        return getType()+" WITH "+key+" '"+value+"' ALREADY EXIST";
    }

    default String notFound(String key,String value){
        return getType()+" WITH "+key+" '"+value+"' NOT FOUND";
    }
    default String notFound(String type,String key,String value){
        return type+" WITH "+key+" '"+value+"' NOT FOUND";
    }
    default String idNotFound(K id){
        return getType()+" WITH ID '"+id+"' NOT FOUND";
    }


}
