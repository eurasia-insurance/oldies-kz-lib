package tech.lapsa.kz.taxpayer.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.ValidationException;

import tech.lapsa.java.commons.function.MyObjects;
import tech.lapsa.kz.taxpayer.TaxpayerNumber;
import tech.lapsa.kz.vehicle.VehicleRegNumber;

public class ValidTaxpayerNumberConstraintValidator implements ConstraintValidator<ValidTaxpayerNumber, Object> {

    public void initialize(ValidTaxpayerNumber constraintAnnotation) {
    }

    public boolean isValid(Object value, ConstraintValidatorContext cvc) {
	if (value == null)
	    return true;

	TaxpayerNumber check;

	if (MyObjects.isA(value, String.class))
	    check = TaxpayerNumber.assertValid(MyObjects.requireA(value, String.class));
	else if (MyObjects.isA(value, VehicleRegNumber.class))
	    check = MyObjects.requireA(value, TaxpayerNumber.class);
	else
	    throw new ValidationException("Unknown type " + value.getClass());

	if (TaxpayerNumber.nonValid(check))
	    return false;

	return true;
    }
}