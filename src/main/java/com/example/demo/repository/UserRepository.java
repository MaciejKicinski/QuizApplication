package com.example.demo.repository;


import com.example.demo.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository
        extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByUserName(String userName);
    boolean existsByUserName(String userName);
}