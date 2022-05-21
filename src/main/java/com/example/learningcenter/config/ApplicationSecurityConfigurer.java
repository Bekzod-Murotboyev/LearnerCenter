package com.example.learningcenter.config;

import com.example.learningcenter.config.security.filter.AuthenticationFilter;
import com.example.learningcenter.config.security.filter.AuthorizationFilter;
import com.example.learningcenter.service.AuthService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static com.example.learningcenter.controller.base.AbstractController.PATH;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class ApplicationSecurityConfigurer extends WebSecurityConfigurerAdapter {

    private final ObjectMapper objectMapper;
    private final AuthService authService;
    private final PasswordEncoder passwordEncoder;

    private final AuthorizationFilter authorizationFilter;

    private static final String[] WHITE_LIST = {
            PATH + "/login",
            PATH + "/auth/login",
            "/swagger-ui/**",
            "/api-docs/**"
    };


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(authService)
                .passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                .cors()
                .disable()
                .authorizeRequests()
                .antMatchers(WHITE_LIST)
                .permitAll()
                .anyRequest()
                .authenticated();


        http.addFilter(new AuthenticationFilter(authenticationManager(), objectMapper));
        http.addFilterBefore(authorizationFilter, UsernamePasswordAuthenticationFilter.class);

        http
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }


    // WITH THIS CONFIGURATION WE CAN MANAGE CORS
//    @Bean
//    CorsConfigurationSource corsConfigurationSource() {
//        CorsConfiguration configuration = new CorsConfiguration();
//        configuration.setAllowedOrigins(List.of("http://localhost:3000"));
//        configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "PATCH", "DELETE"));
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", configuration);
//        return source;
//    }
}
