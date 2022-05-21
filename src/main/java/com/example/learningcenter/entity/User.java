package com.example.learningcenter.entity;

import com.example.learningcenter.entity.base.Auditable;
import com.example.learningcenter.entity.base.BaseEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;
import java.util.Collection;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity(name = "users")
@Builder
public class User extends Auditable implements UserDetails, BaseEntity {

    String username;

    String password;

    boolean accountNonExpired = true;
    boolean accountNonLocked = true;
    boolean credentialsNonExpired = true;
    boolean enabled = true;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }
}
