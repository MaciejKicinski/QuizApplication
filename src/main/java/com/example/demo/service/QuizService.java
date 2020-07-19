package com.example.demo.service;

import com.example.demo.dto.QuestionDTO;
import com.example.demo.entity.Category;
import com.example.demo.entity.QuestionEntity;
import com.example.demo.mapper.ModelMapper;
import com.example.demo.repository.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class QuizService {

    private QuestionRepository questionRepository;
    private QuestionService questionService;

    public QuizService(QuestionRepository questionRepository, QuestionService questionService) {
        this.questionRepository = questionRepository;
        this.questionService = questionService;
    }

    public Set<QuestionDTO> getQuizByCategoryService(String category) {
        Category searchedCategory = Category.valueOf(category.trim().toUpperCase());
        Set<QuestionEntity> quizSet = questionRepository
                .findAll()
                .stream()
                .filter(question -> question.getCategory() == searchedCategory).collect(Collectors.toSet());
        System.out.println("method: getQuizByCategoryService");
        return quizSet.stream()
                .limit(5)
                .map(ModelMapper::mapQuestionEntityToQuestionDto)
                .collect(Collectors.toSet());
    }

    public int evaluateAnswers(Map<String, String> allParameters) {
        int counter = 0;
        for (Map.Entry<String, String> entry : allParameters.entrySet()) {
            QuestionDTO questionDTO = questionService.getOneQuestionByIdService(entry.getKey());
           if (questionService.compereAnswer(entry.getValue(), questionDTO.getTrueAnswer())){
               counter++;
           };
            System.out.println(entry.getKey() + "/" + entry.getValue());
        }
        System.out.println("number of correct answers: " + counter);
        return counter;
    }

    public List <Category> getCategories () {
        ArrayList<Category> categories = new ArrayList<>(EnumSet.allOf(Category.class));
        System.out.println(categories);
        return categories;
    }
}