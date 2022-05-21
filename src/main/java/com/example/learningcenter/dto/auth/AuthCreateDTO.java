package com.example.learningcenter.dto.auth;

import com.example.learningcenter.dto.base.DTO;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthCreateDTO implements DTO {
    @NotBlank
    String username;

    @NotBlank
    String password;
}
