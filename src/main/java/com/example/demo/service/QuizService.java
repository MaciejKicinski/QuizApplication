package com.example.demo.service;

import com.example.demo.dto.QuizDTO;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class QuizService {

    private List<QuizDTO> quizzes = new ArrayList<>();

    @PostConstruct
    void init() {
        quizzes.add(new QuizDTO(1, "firstQuiz", "quiz about java",
                " It's possible to implement a method in interface?",
                "no", "hell no", "yes",
                "I don't know", LocalDate.now() ));
    }


}