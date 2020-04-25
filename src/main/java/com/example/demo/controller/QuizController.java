package com.example.demo.controller;

import com.example.demo.form.NewQuizForm;
import com.example.demo.service.QuizService;
import com.example.demo.validator.NewQuizFormValidator;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/home")
public class QuizController {

    private final QuizService quizService;
    private final NewQuizFormValidator validator;

    public QuizController(QuizService quizService, NewQuizFormValidator validator) {
        this.quizService = quizService;
        this.validator = validator;
    }

    @InitBinder
    public void init(WebDataBinder binder) {
        binder.setValidator(validator);
    }

    @RequestMapping("/newquiz")
    public ModelAndView newQuizPage() {
        ModelAndView mnv = new ModelAndView("newQuiz");
        mnv.addObject("newQuiz", new NewQuizForm());
        return mnv;
    }

    @PostMapping(value = "/newquiz")
    public String saveNewQuiz(@ModelAttribute("newQuiz") @Validated NewQuizForm form, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println("somethings wrong whit title");
            return "/newquiz";
        }
       quizService.addQuiz(form);
        return "redirect:/home";
    }

}
