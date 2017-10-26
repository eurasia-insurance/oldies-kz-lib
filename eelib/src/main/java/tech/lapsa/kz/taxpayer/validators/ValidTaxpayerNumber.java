package tech.lapsa.kz.taxpayer.validators;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RUNTIME)
@Constraint(validatedBy = ValidTaxpayerNumberConstraintValidator.class)
public @interface ValidTaxpayerNumber {

    String message() default "{tech.lapsa.kz.taxpayer.validators.ValidTaxpayerNumber.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}