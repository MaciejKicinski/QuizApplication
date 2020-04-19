package com.example.demo.service;

import com.example.demo.mapper.MapperUser;
import com.example.demo.model.RegistrationForm;
import com.example.demo.repository.UserRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class RegistrationValidationService {
    UserRepository userRepository;
    @Autowired
    public RegistrationValidationService(UserRepository userRep) {

        this.userRepository = userRep;
    }

    public boolean loginExist(String login) {

        return userRepository.existsByLogin(login);
    }


    public void tryToRegisterUser(RegistrationForm registrationForm) {

        try {
            userRepository.save(MapperUser.mapToUserEntity(registrationForm));

        } catch (Exception e) {

            e.printStackTrace();

        }


    }
}
