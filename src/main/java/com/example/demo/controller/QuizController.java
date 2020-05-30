package com.example.demo.controller;

import com.example.demo.service.QuizService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class QuizController {

    private final QuizService quizService;
    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @RequestMapping("/getRandom")
    private ResponseEntity getQuiz() {
        String responseString = quizService.getQuizService();
        return new ResponseEntity(responseString, HttpStatus.OK);
    }

    @PostMapping("/quiz/results")
    public String getResult (@RequestParam Map<String,String> allParameters, Model model) {
      int correctAnswers=quizService.evaluateAnswers(allParameters);
        model.addAttribute("correctAnswers",correctAnswers);
        return "evaluate";
    }

    @RequestMapping("/{category}")
    private ResponseEntity getQuizByCategory(@PathVariable String category) {
        String responseString = quizService.getQuizByCategoryService(category);
        return new ResponseEntity(responseString, HttpStatus.OK);
    }



}
