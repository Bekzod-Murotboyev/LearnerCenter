package com.example.learningcenter.service.base;

import com.example.learningcenter.repository.base.BaseRepository;
import com.example.learningcenter.utill.mapper.base.BaseMapper;
import lombok.RequiredArgsConstructor;

/**
 * @param <R> Repository
 * @param <M> Mapper for converting data between entity and DTO
 */

@RequiredArgsConstructor
public abstract class AbstractService<
        R extends BaseRepository,
        M extends BaseMapper
        > {

    protected final R repository;
    protected final M mapper;


}
