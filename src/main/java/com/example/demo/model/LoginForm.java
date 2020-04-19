package com.example.demo.model;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@Service
public class LoginForm {

    @Size(min = 5, max = 30, message = "Login, ilsoc znakow 5-30")
    private String login;
    @Size(min = 5, max = 30, message = " haslo ilosc znakow 5-30 ")
    private String password;

}
