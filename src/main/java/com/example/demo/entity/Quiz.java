package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idQuiz;
    private String title;
    private String description;
    private String question;
    private String wrongAnswerOne;
    private String wrongAnswerTwo;
    private String wrongAnswerThree;
    private String correctAnswer;
    private LocalDate creationDate;

    public Quiz() {
    }

    public long getIdQuiz() {
        return idQuiz;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getQuestion() {
        return question;
    }

    public String getWrongAnswerOne() {
        return wrongAnswerOne;
    }

    public String getWrongAnswerTwo() {
        return wrongAnswerTwo;
    }

    public String getWrongAnswerThree() {
        return wrongAnswerThree;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }
}
