package com.example.demo.controller;

import com.example.demo.form.LoginForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/login")
public class LoginController {

    @RequestMapping
    public ModelAndView login() {
        ModelAndView mvn = new ModelAndView("login");
        mvn.addObject("login", new LoginForm());
        return mvn;
    }
}