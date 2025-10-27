package com.nightclub.nightclub_management.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class AgeAbove18Validator implements ConstraintValidator<AgeAbove18, Integer> {

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        if (value == null) return false;
        return value > 18; // strictly greater than 18 per your requirement
    }
}

