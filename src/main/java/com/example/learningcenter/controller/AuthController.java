package com.example.learningcenter.controller;

import com.example.learningcenter.controller.base.AbstractController;
import com.example.learningcenter.dto.auth.AuthCreateDTO;
import com.example.learningcenter.dto.auth.SessionDTO;
import com.example.learningcenter.dto.response.Data;
import com.example.learningcenter.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.learningcenter.controller.base.AbstractController.PATH;

@RestController
@RequestMapping(PATH + "/auth")
public class AuthController extends AbstractController<UserService> {

    public AuthController(UserService service) {
        super(service);
    }

    @PostMapping("/login")
    public ResponseEntity<Data<SessionDTO>> login(@RequestBody AuthCreateDTO authCreateDTO) {
        return service.login(authCreateDTO);
    }

}
