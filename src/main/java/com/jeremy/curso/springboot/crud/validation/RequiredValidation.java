package com.jeremy.curso.springboot.crud.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class RequiredValidation implements ConstraintValidator<isRequired, String>{

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value != null && !value.isEmpty() && value.isBlank()) {
            return true;
        }
        return false;
    }

}
