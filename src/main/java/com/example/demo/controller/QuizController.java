package com.example.demo.controller;

import com.example.demo.form.NewQuizForm;
import com.example.demo.service.QuizService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/home")
public class QuizController {

    private QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @RequestMapping("/newQuiz")
    public ModelAndView newQuizPage() {
        ModelAndView mnv = new ModelAndView("newQuiz");
        mnv.addObject("newQuiz", new NewQuizForm());
        return mnv;
    }

    @PostMapping(value= "/newquiz")
    public String saveNewQuiz (@ModelAttribute ("newQuiz") NewQuizForm form) {
        System.out.println(form);
        return "redirect:/";
    }

}
