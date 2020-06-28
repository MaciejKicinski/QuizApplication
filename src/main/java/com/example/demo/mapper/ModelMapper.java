package com.example.demo.mapper;

import com.example.demo.dto.QuestionDTO;
import com.example.demo.entity.QuestionEntity;

public final class ModelMapper {

    private ModelMapper() {
    }

    public static QuestionDTO mapQuestionEntityToQuestionDto(QuestionEntity questionEntity) {
        return new QuestionDTO(questionEntity.getId(), questionEntity.getContent(), questionEntity.getAnswer1(),
                questionEntity.getAnswer2(), questionEntity.getAnswer3(),
                questionEntity.getTrueAnswer(), questionEntity.getCategory());
    }
}
