package com.example.demo.validator;

import com.example.demo.form.NewQuizForm;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class NewQuizFormValidator implements Validator {

//musimy stworzyc klase validator dla kazdej innej klasy ktora bedziemy chcieli zvalidowac

    //Przykładowo jeden kontroler może przyjmować 4 różne formularze,
    // tam metoda sprawdza czy ten formularz jest odpowiedniej klasy
    // aClass - parametr przekazywany do tej metody
    @Override
    public boolean supports(Class<?> aClass) {
        return NewQuizForm.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        NewQuizForm form = (NewQuizForm) o;
        //Tu nie ma możliwości wystąpienia wyjątku newClassException po jest to sprawdzane
        if (form.getTitle().isBlank()) {
            //{title=nazwa pola, Wstawiamy klucz: tu pobiera z pliku properties klucz=wiadomość }
            errors.rejectValue("title", "newQuizForm.validator.field.empty");
        }
        System.out.println("validate");
    }
}
