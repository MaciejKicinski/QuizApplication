package com.example.demo.controller;

import com.example.demo.dto.QuestionDTO;
import com.example.demo.service.QuestionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/questions")
public class QuestionControler {

    QuestionService questionService;

    public QuestionControler(QuestionService questionService) {
        this.questionService = questionService;
    }

    //model.addAttribute
    @RequestMapping("/getAllQuestions")
    public ModelAndView getAllQuestions() {
        ModelAndView mnv = new ModelAndView("allQuestions");
        List<QuestionDTO> questions = questionService.getAllQuestionsService();
        mnv.addObject("questions", questions);
        mnv.addObject("message", "Wszystkie pytania");
        return mnv;
    }

}
