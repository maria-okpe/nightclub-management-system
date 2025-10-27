package com.nightclub.nightclub_management.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = AgeAbove18Validator.class)
@Documented
public @interface AgeAbove18 {
    String message() default "User must be older than 18";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

