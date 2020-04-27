package com.example.demo.service;

import com.example.demo.entity.UserEntity;
import com.example.demo.exception.UserExistsException;
import com.example.demo.form.UserRegisterForm;
import com.example.demo.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void createUser(UserRegisterForm userRegisterForm) {
        if (userRepository
                .existsByUserName(userRegisterForm.getUserName())) {
            throw new UserExistsException(userRegisterForm.getUserName());
        }
        UserEntity user = new UserEntity(userRegisterForm.getLogin(),
                passwordEncoder.encode(userRegisterForm.getPassword()),
                userRegisterForm.getUserName());
        userRepository.save(user);
    }
}

