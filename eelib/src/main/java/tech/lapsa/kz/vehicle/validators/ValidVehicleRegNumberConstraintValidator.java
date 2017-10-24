package tech.lapsa.kz.vehicle.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import tech.lapsa.kz.vehicle.VehicleRegNumber;

public class ValidVehicleRegNumberConstraintValidator implements ConstraintValidator<ValidVehicleRegNumber, String> {

    private boolean areaIsOptional;

    public void initialize(ValidVehicleRegNumber constraintAnnotation) {
	areaIsOptional = constraintAnnotation.areaIsOptional();
    }

    public boolean isValid(String value, ConstraintValidatorContext cvc) {
	if (value == null)
	    return true;
	VehicleRegNumber vrn = VehicleRegNumber.of(value);

	if (!(areaIsOptional || vrn.optionalArea().isPresent()))
	    return false;

	return VehicleRegNumber.isValid(value);
    }
}