package com.example.demo.service;

import com.example.demo.dto.QuestionDTO;
import com.example.demo.entity.Category;
import com.example.demo.entity.QuestionEntity;
import com.example.demo.mapper.ModelMapper;
import com.example.demo.repository.QuestionRepository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
        QuestionEntity question8 = new QuestionEntity("Wojciech Stawowy czy Wojciech Schabowy kto prowadzil miedzy innymi Arke i Cracovie?", "odp1", "odp2", "odp3", "odp3", Category.COOKING);
        QuestionEntity question9 = new QuestionEntity("Ja to sie nie wpierdalam czy nie wpraszam? Jak swoja szkoleniowa taktyke opisywal Pawel Janas", "odp1", "odp2", "odp3", "odp3", Category.SAVOIR_VIVRE);
        QuestionEntity question10 = new QuestionEntity("Franciszek Smuda to trener skuteczny. Zapowiedzial walke o spadek i rzeczywiscie spadl. Z jakim klubem?", "Arka Gdynia", "Łks", "odp3", "odp3", Category.POLISH_LANGUAGE);
        questionRepository.save(question1);
        questionRepository.save(question2);
        questionRepository.save(question3);
        questionRepository.save(question4);
        questionRepository.save(question5);
        questionRepository.save(question6);
        questionRepository.save(question7);
        questionRepository.save(question8);
        questionRepository.save(question9);
        questionRepository.save(question10);
    }

    public List<QuestionDTO> getAllQuestionsService() {
        return questionRepository.findAll().stream()
                .map(ModelMapper::map)
                .collect(Collectors.toList());
    }

    //fix ifPresent optional
    public QuestionDTO getOneQuestionByIdService(String id) {
        Optional<QuestionEntity> optionalQuestion = questionRepository.findById(Long.parseLong(id.trim()));
        QuestionEntity questionEntity = optionalQuestion.get();
        return ModelMapper.map(questionEntity);
    }

    public Boolean compereAnswer(String answer, String correctAnswer) {
        return answer.equals(correctAnswer);
    }


}
