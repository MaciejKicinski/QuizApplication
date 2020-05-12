package com.example.demo.controller;

import com.example.demo.service.QuestionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class QuestionControler {

    QuestionService questionService;

    public QuestionControler(QuestionService questionService) {
        this.questionService = questionService;
    }

    @RequestMapping("/getAllQuestions")
    public ResponseEntity<String> getAllQuestions() {
        String responseString = questionService.getAllQuestionsService();
        return new ResponseEntity<String>(responseString, HttpStatus.OK);
    }


}
