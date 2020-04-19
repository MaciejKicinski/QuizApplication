package com.example.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@Service
public class RegistrationForm {

    @Size(min=5, max=30, message = "wymagany login ilość znaków pomiędzy 5 a 30")
    private String login;
    @Size(min=5, max=30,message = "wymagane hasło ilość znaków pomiędzy 5 a 30")
    private String password;



}
