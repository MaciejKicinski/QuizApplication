package com.example.demo.controller;

import com.example.demo.entity.Quiz;
import com.example.demo.form.QuizForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@RestController
public class QuizController {


    private List<QuizForm> quiz;

    public QuizController() {
        this.quiz = new ArrayList<>();
        quiz.add(new QuizForm("Kulinaria", "Wojciech Stawowy czy Wojciech Schabowy kto prowadzil miedzy innymi Arke i Cracovie?", "??????"));
        quiz.add(new QuizForm("Savoir-Vivre", "Ja to sie nie wpierdalam czy nie wpraszam? Jak swoja szkoleniowa taktyke opisywal Pawel Janas", "?????"));
        quiz.add(new QuizForm("Jezyk Polski", "Franciszek Smuda to trener skuteczny. Zapowiedzial walke o spadek i rzeczywiscie spadl. Z jakim klubem?", "?????"));
    }

    //udostepniamy liste wszytskich quizow
    @GetMapping("/quiz")
    public ModelAndView quizList() {
        ModelAndView mvn = new ModelAndView("quiz");
        mvn.addObject("quizList", quiz);
        return mvn;
    }


}