package com.example.learningcenter.utill.mapper;

import com.example.learningcenter.dto.auth.AuthCreateDTO;
import com.example.learningcenter.dto.auth.AuthDTO;
import com.example.learningcenter.entity.User;
import com.example.learningcenter.utill.mapper.base.BaseMapper;
import org.springframework.stereotype.Component;

@Component
public class AuthMapper implements BaseMapper<User, AuthDTO, AuthCreateDTO,AuthDTO> {


    @Override
    public AuthDTO toDTO(User entity) {
        return null;
    }

    @Override
    public User toEntity(AuthDTO dto, User entity) {
        return null;
    }

    @Override
    public User toEntity(AuthCreateDTO dto) {
        return null;
    }
}
