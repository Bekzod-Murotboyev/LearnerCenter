package com.example.learningcenter.dto.auth;

import com.example.learningcenter.dto.base.DTO;
import com.example.learningcenter.dto.base.GenericDTO;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthDTO extends GenericDTO {
    String username;
    String password;
}
