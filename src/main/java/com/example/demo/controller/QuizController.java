package com.example.demo.controller;

import com.example.demo.repository.QuestionRepository;
import com.example.demo.service.QuizService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/quiz")
public class QuizController {

    private final QuizService quizService;
    private QuestionRepository questionRepository;

    public QuizController(QuizService quizService,  QuestionRepository questionRepository) {
        this.quizService = quizService;
        this.questionRepository = questionRepository;
    }

    @RequestMapping("/getRandom")
    private ResponseEntity getQuiz() {
        String responseString = quizService.getQuizService();
        return new ResponseEntity(responseString, HttpStatus.OK);
    }

    @RequestMapping("/{category}")
    private ResponseEntity getQuizByCategory(@PathVariable String category) {
        String responseString = quizService.getQuizByCategoryService(category);
        return new ResponseEntity(responseString, HttpStatus.OK);
    }



}
