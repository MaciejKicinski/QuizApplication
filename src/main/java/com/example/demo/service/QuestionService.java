package com.example.demo.service;

import com.example.demo.entity.Category;
import com.example.demo.entity.QuestionEntity;
import com.example.demo.repository.QuestionRepository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {

    private QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @PostConstruct
    void init() {
        QuestionEntity question1 = new QuestionEntity("pytanie 1", "odp1", "odp2", "odp3", "odp1", Category.JAVA);
        QuestionEntity question2 = new QuestionEntity("pytanie 2", "odp1", "odp2", "odp3", "odp3", Category.JAVA);
        QuestionEntity question3 = new QuestionEntity("pytanie 3", "odp1", "odp2", "odp3", "odp2", Category.JAVA);
        QuestionEntity question4 = new QuestionEntity("pytanie 4", "odp1", "odp2", "odp3", "odp1", Category.JAVA);
        QuestionEntity question5 = new QuestionEntity("pytanie 5", "odp1", "odp2", "odp3", "odp3", Category.JAVA);
        QuestionEntity question6 = new QuestionEntity("pytanie 6", "odp1", "odp2", "odp3", "odp3", Category.HISTORY);
        QuestionEntity question7 = new QuestionEntity("pytanie 7", "odp1", "odp2", "odp3", "odp3", Category.GEOGRAPHY);
        questionRepository.save(question1);
        questionRepository.save(question2);
        questionRepository.save(question3);
        questionRepository.save(question4);
        questionRepository.save(question5);
        questionRepository.save(question6);
        questionRepository.save(question7);
    }

    public String getAllQuestionsService() {
        List<QuestionEntity> all = questionRepository.findAll();
        StringBuilder stringBuilder = new StringBuilder();
        all.forEach(questionEntity -> stringBuilder
                .append(questionEntity.getId())
                .append(questionEntity.getContent())
                .append(questionEntity.getAnswer1())
                .append(questionEntity.getAnswer2())
                .append(questionEntity.getAnswer3())
                .append(questionEntity.getTrueAnswer())
                .append(questionEntity.getCategory()));
        return stringBuilder.toString();
    }

    public String getOneQuestionByIdService(String id) {
        Optional<QuestionEntity> optionalQuestion = questionRepository.findById(Long.parseLong(id.trim()));
        StringBuilder stringBuilder = new StringBuilder();
        if (optionalQuestion.isPresent()) {
            QuestionEntity question = optionalQuestion.get();
            stringBuilder.append(question.getId()).append(":  pytanie: ")
                    .append(question.getContent()).append(", odpowiedzi: <br>")
                    .append(question.getAnswer1()).append(" <br>")
                    .append(question.getAnswer2()).append(" <br>")
                    .append(question.getAnswer3()).append(" <br>")
                    .append(" prawidlowa odp: ").append(question.getTrueAnswer());
        }
        return stringBuilder.toString();
    }


}
