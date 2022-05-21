package com.example.learningcenter.service;

import com.example.learningcenter.config.security.utils.JwtUtils;
import com.example.learningcenter.dto.auth.AuthCreateDTO;
import com.example.learningcenter.dto.auth.SessionDTO;
import com.example.learningcenter.dto.response.Data;
import com.example.learningcenter.repository.UserRepository;
import com.example.learningcenter.service.base.AbstractService;
import com.example.learningcenter.service.base.BaseService;
import com.example.learningcenter.utill.mapper.AuthMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class UserService extends AbstractService<UserRepository, AuthMapper> implements BaseService {

    public UserService(UserRepository repository, AuthMapper mapper, AuthenticationManager authenticationManager) {
        super(repository, mapper);
        this.authenticationManager = authenticationManager;
    }

    private final AuthenticationManager authenticationManager;


    public ResponseEntity<Data<SessionDTO>> login(AuthCreateDTO dto) {
        authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(dto.getUsername(), dto.getPassword()));

        return ResponseEntity
                .ok(new Data<>(JwtUtils.generate(dto.getUsername())));

    }
}
