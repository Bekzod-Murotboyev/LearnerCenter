package com.example.learningcenter.config.security.filter;

import com.example.learningcenter.config.security.utils.JwtUtils;
import com.example.learningcenter.dto.response.AppErrorDTO;
import com.example.learningcenter.dto.response.Data;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@RequiredArgsConstructor
public class AuthorizationFilter extends OncePerRequestFilter {

    private final ObjectMapper objectMapper;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (token != null && token.startsWith("Bearer ")) {
            try {
                token = token.substring("Bearer ".length());
                String username = JwtUtils.getVerifier().verify(token).getSubject();
                SecurityContextHolder.getContext().setAuthentication(
                        new UsernamePasswordAuthenticationToken(username, null, null));
            } catch (Exception e) {
                response.setContentType(MediaType.APPLICATION_JSON_VALUE);
                objectMapper.writeValue(response.getOutputStream(),
                        new Data<>(AppErrorDTO
                                .secondBuilder()
                                .path(((ServletWebRequest)request).getRequest().getRequestURI())
                                .message(e.getMessage())
                                .status(HttpStatus.FORBIDDEN)
                                .build()));
                return;
            }
        }
        filterChain.doFilter(request, response);
    }
}
