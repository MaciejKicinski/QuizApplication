package com.example.demo.controller;

import com.example.demo.form.NewQuizForm;
import com.example.demo.service.QuizService;
import com.example.demo.validator.NewQuizFormValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/home")
public class QuizController {

    //powinna być tylko jedna metoda GetPost na endpoincie w controlerze, co oznacza że w każdym controlerze bedzie tylko jeden validator,
    //nie bedziemy tu przekazywac kilku validatorow

    private final QuizService quizService;
    private final NewQuizFormValidator validator;

    //@Autowired
    //Jak by tu był stosowany LOMBOK to można przegabić to że każde nowe pole musi być dodane do konstruktora
    public QuizController(QuizService quizService, NewQuizFormValidator validator) {
        this.quizService = quizService;
        this.validator = validator;
    }

    // wstrzykujemy validatro (Bean), musi być komponentem (dodajemy adnotacje @Component w NewQuizFormValidator
    // oraz musi być w controlerze,
    // zadziałało by również z adnotacja @Service oraz @Repository(coś tam z MySQL coś innego robi, to jest dla naszej wiedzy
    //
    //Ponizej wersji spingra 4.2 musi byc autowire
    @InitBinder
    public void init(WebDataBinder binder) {
        binder.setValidator(validator);
    }

    //@RequestMapping jest domyślnie z GetMappingiem
    //@GetMapping wykona request z metoda get
    @GetMapping("/newquiz")
    public ModelAndView newQuizPage() {
        ModelAndView mnv = new ModelAndView("newQuiz");
        mnv.addObject("newQuiz", new NewQuizForm());
        return mnv;
    }

    //tutaj request z metoda post
    @PostMapping(value = "/newquiz")
    public String saveNewQuiz(@ModelAttribute("newQuiz") @Validated NewQuizForm form, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println("somethings wrong whit title");
            return "/newquiz";
            // zwracamy nazwe widoku, cofamy sie
            // gdzies w Springowym modelu sa przekazane błędy
            //i poźniej ten model jest przekazany do widoku
        }
       quizService.addQuiz(form);
        return "redirect:/home";
    }

}
