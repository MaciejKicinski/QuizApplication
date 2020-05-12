package com.example.demo.controller;

import com.example.demo.entity.Category;
import com.example.demo.entity.QuestionEntity;
import com.example.demo.form.NewQuizForm;
import com.example.demo.repository.QuestionRepository;
import com.example.demo.service.QuizService;
import com.example.demo.validator.NewQuizFormValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/quiz")
public class QuizController {

    private final QuizService quizService;
    private final NewQuizFormValidator validator;
    private QuestionRepository questionRepository;

    public QuizController(QuizService quizService, NewQuizFormValidator validator, QuestionRepository questionRepository) {
        this.quizService = quizService;
        this.validator = validator;
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
