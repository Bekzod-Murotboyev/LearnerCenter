package com.example.learningcenter.config.security.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.learningcenter.dto.auth.SessionDTO;

import java.util.Date;

public class JwtUtils {

    private static final Long expiry = 3_600_000L;
    private static final String secret = "SD784SRTED34JNBNJ@@*&p45kbNBKRIIHB@456#$%&f%&t#sxyASX345";


    public static Algorithm getAlgorithm() {
        return Algorithm.HMAC256(secret.getBytes());
    }

    public static JWTVerifier getVerifier() {
        return JWT.require(getAlgorithm()).build();
    }

    public static SessionDTO generate(String username) {
        Date issuedAt = new Date();
        Date expiredAt = new Date(issuedAt.getTime() + JwtUtils.expiry);
        String token = JWT
                .create()
                .withSubject(username)
                .withIssuedAt(issuedAt)
                .withExpiresAt(expiredAt)
                .sign(getAlgorithm());
        return new SessionDTO(token, expiredAt, issuedAt);
    }


}
