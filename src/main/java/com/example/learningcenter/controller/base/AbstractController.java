package com.example.learningcenter.controller.base;

import com.example.learningcenter.service.base.BaseService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class AbstractController<S extends BaseService> {
    public static final String API = "/api";

    public static final String VERSION = "/v1";

    public static final String PATH = API + VERSION;

    protected final S service;
}
