package com.example.demo.controller;

import com.example.demo.service.QuizService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    QuizService quizService;

    public HomeController(QuizService quizService) {
        this.quizService = quizService;
    }

    @GetMapping(value = {"/home", "/"})
    public String getHomePage() {
        return "home";
    }

    @RequestMapping("/main")
    public String getQuizMenu(Model model) {
        model.addAttribute("categories", quizService.getCategories());
        return "main";
    }

    @GetMapping("registration")
    public ModelAndView getRegistrationPage() {
        ModelAndView mnv = new ModelAndView();
        mnv.setViewName("registration");
        return mnv;
    }

    @GetMapping("login")
    public ModelAndView getLoginPage() {
        ModelAndView mnv = new ModelAndView();
        mnv.setViewName("login");
        return mnv;
    }


}
