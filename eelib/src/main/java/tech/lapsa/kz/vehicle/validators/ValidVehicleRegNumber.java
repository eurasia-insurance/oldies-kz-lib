package tech.lapsa.kz.vehicle.validators;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RUNTIME)
@Constraint(validatedBy = ValidVehicleRegNumberConstraintValidator.class)
public @interface ValidVehicleRegNumber {

    String message() default "{tech.lapsa.kz.vehicle.validators.ValidVehicleRegNumber.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    boolean areaIsOptional() default true;
}