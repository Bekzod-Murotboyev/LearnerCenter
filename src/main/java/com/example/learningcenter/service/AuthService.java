package com.example.learningcenter.service;

import com.example.learningcenter.dto.auth.AuthCreateDTO;
import com.example.learningcenter.dto.auth.SessionDTO;
import com.example.learningcenter.dto.response.Data;
import com.example.learningcenter.repository.UserRepository;
import com.example.learningcenter.service.base.AbstractService;
import com.example.learningcenter.service.base.BaseService;
import com.example.learningcenter.utill.mapper.AuthMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService implements UserDetailsService {

    private final UserRepository userRepository;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("USER WITH USERNAME '" + username + "' NOT FOUND"));
    }
}
