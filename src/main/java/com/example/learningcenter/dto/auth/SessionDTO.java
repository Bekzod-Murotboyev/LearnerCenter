package com.example.learningcenter.dto.auth;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class SessionDTO {
    String token;
    Date issuedAt;
    Date expiry;
}
