package com.example.learningcenter.config.auditingconfig;

import com.example.learningcenter.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Objects;
import java.util.Optional;

@Configuration
@EnableJpaAuditing
public class AuditingConfig {

    @Bean
    AuditorAware<Long> auditorAware() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (Objects.nonNull(auth) && auth.isAuthenticated() && !"anonymous".equals(auth.getPrincipal()))
            return () -> Optional.of(((User) auth.getPrincipal()).getId());
        return Optional::empty;
    }

}
