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
        QuestionEntity question1 = new QuestionEntity("Jakie są różnice pomiędzy typem primitywnym a typem obiektowym?", "Nie ma różnic", "Typ primitywny dziedziczy po klasie Object", "Typy obiektowe przechowują dane oraz zachowania", "Typy obiektowe przechowują dane oraz zachowania", Category.JAVA);
        QuestionEntity question2 = new QuestionEntity("Do czego służy import statyczny?", "Umożliwia dostęp do statycznych metod oraz pól klasy po odwołaniu się po nazwie klasy", "Pozwala również na dostęp do elemnetów statycznych eksportowanych", "Pozwala na dostęp do pól i metod dynamicznych", "Umożliwia dostęp do statycznych metod oraz pól klasy po odwołaniu się po nazwie klasy", Category.JAVA);
        QuestionEntity question3 = new QuestionEntity("Czy interfejs może być oznaczony jako finalny?", "Nie", "tak", "Zależy od rodzaju interfejsu", "Nie", Category.JAVA);
        QuestionEntity question4 = new QuestionEntity("Czy metoda w interjesie może być prywatna?", "Nie", "Tak", "Zależy od wersji javy", "Zależy od wersji javy", Category.JAVA);
        QuestionEntity question5 = new QuestionEntity("Jak zablokować dziedziczenie?", "Oznaczyć jako final", "Oznaczyć jako finally", "Oznaczyć jako finalize", "Oznaczyć jako final", Category.JAVA);
        questionRepository.save(question1);
        questionRepository.save(question2);
        questionRepository.save(question3);
        questionRepository.save(question4);
        questionRepository.save(question5);
    }

    public List<QuestionDTO> getAllQuestionsService() {
        return questionRepository.findAll().stream()
                .map(ModelMapper::mapQuestionEntityToQuestionDto)
                .collect(Collectors.toList());
    }

    //fix ifPresent optional
    public QuestionDTO getOneQuestionByIdService(String id) {
        Optional<QuestionEntity> optionalQuestion = questionRepository.findById(Long.parseLong(id.trim()));
        QuestionEntity questionEntity = optionalQuestion.get();
        return ModelMapper.mapQuestionEntityToQuestionDto(questionEntity);
    }

    public Boolean compereAnswer(String answer, String correctAnswer) {
        return answer.equals(correctAnswer);
    }


}
