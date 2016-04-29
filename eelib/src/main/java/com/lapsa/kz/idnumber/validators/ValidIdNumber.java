package com.lapsa.kz.idnumber.validators;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ METHOD, FIELD, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = ValidIdNumberConstraintValidator.class)
public @interface ValidIdNumber {

    boolean checkDigit() default true;

    String message() default "{com.lapsa.kz.idnumber.validators.ValidIdNumber.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}