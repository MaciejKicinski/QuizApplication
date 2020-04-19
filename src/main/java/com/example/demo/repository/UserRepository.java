package com.example.demo.repository;


import com.example.demo.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Long> {

    UserEntity findByLogin(String login);

    boolean existsByLogin(String login);
}
