package tech.lapsa.kz.vehicle.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.ValidationException;

import tech.lapsa.java.commons.function.MyObjects;
import tech.lapsa.kz.vehicle.VehicleRegNumber;

public class ValidVehicleRegNumberConstraintValidator implements ConstraintValidator<ValidVehicleRegNumber, Object> {

    private boolean areaIsOptional;

    public void initialize(ValidVehicleRegNumber constraintAnnotation) {
	areaIsOptional = constraintAnnotation.areaIsOptional();
    }

    public boolean isValid(Object value, ConstraintValidatorContext cvc) {
	if (value == null)
	    return true;

	VehicleRegNumber vrn;
	if (MyObjects.isA(value, String.class)) {
	    vrn = VehicleRegNumber.of(MyObjects.requireA(value, String.class));
	} else if (MyObjects.isA(value, VehicleRegNumber.class)) {
	    vrn = MyObjects.requireA(value, VehicleRegNumber.class);
	} else {
	    throw new ValidationException("Unknown type " + value.getClass());
	}
	
	if (!vrn.isValid())
	    return false;

	if (!(areaIsOptional || vrn.optionalArea().isPresent()))
	    return false;

	return true;
    }
}