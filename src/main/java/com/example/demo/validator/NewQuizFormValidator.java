package com.example.demo.validator;

import com.example.demo.form.NewQuizForm;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class NewQuizFormValidator implements Validator {


    @Override
    public boolean supports(Class<?> aClass) {
        return NewQuizForm.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        NewQuizForm form = (NewQuizForm) o;
        if (form.getTitle().isBlank()) {
            errors.rejectValue("title", "newQuizForm.validator.field.empty");
        }
        System.out.println("validate");
    }
}
