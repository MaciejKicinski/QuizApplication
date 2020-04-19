package com.example.demo.mapper;

import com.example.demo.entity.UserEntity;
import com.example.demo.model.RegistrationForm;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MapperUser {

    private static PasswordEncoder passwordEncoder;

    public MapperUser(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public static UserEntity mapToUserEntity(RegistrationForm registrationForm) {

        return UserEntity.builder().login(registrationForm.getLogin())
                .password(passwordEncoder.encode(registrationForm.getPassword()))
                .build();

    }
}
