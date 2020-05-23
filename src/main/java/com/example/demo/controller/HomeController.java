package com.example.demo.controller;

import com.example.demo.exception.UserExistsException;
import com.example.demo.form.UserRegisterForm;
import com.example.demo.service.UserService;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {


    private final UserService userService;

    public HomeController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/home")
    public String getHomePage() {
        return "/home";
    }

    @GetMapping("/registration")
    public ModelAndView getUserFormPage() {
        ModelAndView mvn = new ModelAndView("registration");
        mvn.addObject("form", new UserRegisterForm());
        return mvn;
    }

    @PostMapping("/registration")
    public ModelAndView createUser(@ModelAttribute("form")
                                   @Validated UserRegisterForm userRegisterForm,
                                   BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("registration");
        }
        try {
            userService.createUser(userRegisterForm);
        } catch (UserExistsException e) {
            ModelAndView modelAndView = new ModelAndView("registration");
            modelAndView.addObject("message", e.getMessage());
            return modelAndView;
        }
        return new ModelAndView("redirect:/login");
    }
}