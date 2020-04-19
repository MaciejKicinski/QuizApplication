package com.example.demo.service;


import com.example.demo.entity.UserEntity;
import com.example.demo.model.LoginForm;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class LoginService {
    UserRepository userRepository;
    PasswordEncoder passwordEncoder;


    @Autowired
    public LoginService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public boolean isCorrectUser(LoginForm loginForm) {
        UserEntity userEntity = userRepository.findByLogin(loginForm.getLogin());
        if (userEntity == null) {
            return false;
        }
        if (BCrypt.checkpw(loginForm.getPassword(), userEntity.getPassword())) {
            return true;
        }
        System.out.println(loginForm.getPassword());
        System.out.println(new BCryptPasswordEncoder().encode(loginForm.getPassword()));
        return false;
    }

}
