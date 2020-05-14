package com.example.demo.dto;

import com.example.demo.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class QuestionDTO {
    private Long id;
    private String content;
    private String answer1;
    private String answer2;
    private String answer3;
    private String trueAnswer;
    private Category category;

}
