package com.example.learningcenter.repository;

import com.example.learningcenter.entity.User;
import com.example.learningcenter.repository.base.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long>, BaseRepository {

    Optional<User> findByUsername(String username);
}
