package com.example.learningcenter.utill.mapper.base;

import com.example.learningcenter.dto.base.DTO;
import com.example.learningcenter.dto.base.GenericDTO;
import com.example.learningcenter.entity.base.BaseEntity;

/**
 * @param <E> Entity
 * @param <D> DTO
 * @param <CD> DTO for doing operation of Creat
 * @param <UD> DTO for doing operation of Update
 */
public interface BaseMapper<
        E extends BaseEntity,
        D extends GenericDTO,
        CD extends DTO,
        UD extends GenericDTO
        > {


    D toDTO(E entity);

    E toEntity(UD dto, E entity);

    E toEntity(CD dto);

}
