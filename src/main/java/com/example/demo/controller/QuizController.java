package com.example.demo.controller;

import com.example.demo.dto.QuestionDTO;
import com.example.demo.service.QuizService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;
import java.util.Set;

@Controller
public class QuizController {

    private final QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @RequestMapping("/main")
    public String getQuizMenu(Model model) {
        model.addAttribute("categories", quizService.getCategories());
        return "/main";
    }

    @PostMapping("/quiz/results")
    public String getResult(@RequestParam Map<String, String> allParameters, Model model) {
        int correctAnswers = quizService.evaluateAnswers(allParameters);
        model.addAttribute("correctAnswers", correctAnswers);
        return "evaluate";
    }

    @PostMapping("/quiz/quizAttempt")
    public String attemptQuiz (@RequestParam String category,Model model) {
        Set<QuestionDTO> quizByCategoryService = quizService.getQuizByCategoryService(category);
        model.addAttribute("questions", quizByCategoryService);
        return "/quizForm";
    }

    //fix path, because when u typ "main.html", server thinks that is a category and try to get quiz by category
    @RequestMapping("/quiz/{category}")
    private ModelAndView getQuizByCategory(@PathVariable String category) {
        ModelAndView mnv = new ModelAndView("quizForm");
        Set<QuestionDTO> questionDTOSet = quizService.getQuizByCategoryService(category);
        mnv.addObject("questions", questionDTOSet);
        return mnv;
    }
}
