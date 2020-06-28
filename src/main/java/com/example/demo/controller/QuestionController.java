package com.example.demo.controller;

import com.example.demo.dto.QuestionDTO;
import com.example.demo.service.QuestionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping
public class QuestionController {

    QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    //model.addAttribute
    @RequestMapping("/quizForm")
    public ModelAndView getAllQuestions() {
        ModelAndView mnv = new ModelAndView("quizForm");
        List<QuestionDTO> questions = questionService.getAllQuestionsService();
        mnv.addObject("questions", questions);
        return mnv;
    }

    @RequestMapping("/allQuestions")
    public ModelAndView getAllQuestions2() {
        ModelAndView mnv = new ModelAndView("allQuestions");
        List<QuestionDTO> questions = questionService.getAllQuestionsService();
        mnv.addObject("questions", questions);
        return mnv;
    }
}
