package com.example.demo.service;

import com.example.demo.dto.QuizDTO;
import com.example.demo.form.NewQuizForm;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class QuizService {

    private List<QuizDTO> quizzes = new ArrayList<>();
    private long id = 0;

    @PostConstruct
    void init() {
        quizzes.add(new QuizDTO(id++, "firstQuiz", "quiz about java",
                " It's possible to implement a method in interface?",
                "no", "hell no", "yes",
                "I don't know", LocalDate.now()));
    }

    public void addQuiz(NewQuizForm form) {
        QuizDTO quizDTO = new QuizDTO(id++, form.getTitle(), form.getQuestion(), form.getDescription(), form.getWrongAnswerOne(),
                form.getWrongAnswerTwo(), form.getWrongAnswerThree(), form.getCorrectAnswer(), LocalDate.now());
        quizzes.add(quizDTO);
    }

}