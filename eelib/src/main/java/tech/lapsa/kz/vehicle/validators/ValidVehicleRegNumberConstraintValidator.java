package tech.lapsa.kz.vehicle.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.ValidationException;

import tech.lapsa.java.commons.function.MyObjects;
import tech.lapsa.kz.vehicle.VehicleRegNumber;

public class ValidVehicleRegNumberConstraintValidator implements ConstraintValidator<ValidVehicleRegNumber, Object> {

    private boolean areaIsOptional;

    @Override
    public void initialize(final ValidVehicleRegNumber constraintAnnotation) {
	areaIsOptional = constraintAnnotation.areaIsOptional();
    }

    @Override
    public boolean isValid(final Object value, final ConstraintValidatorContext cvc) {
	if (value == null)
	    return true;

	VehicleRegNumber check;

	if (MyObjects.isA(value, String.class))
	    check = VehicleRegNumber.assertValid(MyObjects.requireA(value, String.class));
	else if (MyObjects.isA(value, VehicleRegNumber.class))
	    check = MyObjects.requireA(value, VehicleRegNumber.class);
	else
	    throw new ValidationException("Unknown type " + value.getClass());

	if (VehicleRegNumber.nonValid(check))
	    return false;

	if (!(areaIsOptional || check.optionalArea().isPresent()))
	    return false;

	return true;
    }
}