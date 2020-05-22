package com.example.demo.service;

import com.example.demo.entity.Category;
import com.example.demo.entity.QuestionEntity;
import com.example.demo.repository.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class QuizService {

    private QuestionRepository questionRepository;

    public QuizService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public String getQuizService() {
        List<QuestionEntity> all = questionRepository.findAll();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("MixedQuestionsQuiz: <br>");
        Set<QuestionEntity> quizSet = new HashSet<>(all);
        quizSet.stream()
                .limit(5)
                .collect(Collectors.toList())
                .forEach(questionEntity -> stringBuilder
                        .append(questionEntity.getId())
                        .append(": pytanie: ")
                        .append(questionEntity.getContent())
                        .append(": prawidlowa odpowiedź   ")
                        .append(questionEntity.getTrueAnswer())
                        .append("<br>"));
        System.out.println("method: getQuiz");
        return stringBuilder.toString();
    }
    public String getQuizByCategoryService(String category) {
        Category searchedCategory = Category.valueOf(category.trim().toUpperCase());
        List<QuestionEntity> quizFilteredByCategory = questionRepository
                .findAll()
                .stream()
                .filter(question -> question.getCategory() == searchedCategory).collect(Collectors.toList());
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("randomowe pytania: <br>");
        Set<QuestionEntity> quizSet = new HashSet<QuestionEntity>(quizFilteredByCategory);
        quizSet.stream()
                .limit(5)
                .collect(Collectors.toList())
                .forEach(question -> stringBuilder
                        .append(question.getId())
                        .append(": pytanie: ")
                        .append(question.getContent())
                        .append(": prawidlowa odpowiedź   ")
                        .append(question.getTrueAnswer())
                        .append("<br>"));
        System.out.println("method: getQuiz");
        return stringBuilder.toString();
    }

    public int evaluateAnswers(Map<String, String> allParameters) {
        return 5;
    }
}