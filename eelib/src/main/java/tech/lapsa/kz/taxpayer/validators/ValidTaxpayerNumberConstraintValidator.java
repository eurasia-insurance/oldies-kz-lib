package tech.lapsa.kz.taxpayer.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.ValidationException;

import tech.lapsa.java.commons.function.MyObjects;
import tech.lapsa.kz.taxpayer.TaxpayerNumber;

public class ValidTaxpayerNumberConstraintValidator implements ConstraintValidator<ValidTaxpayerNumber, Object> {

    @Override
    public void initialize(final ValidTaxpayerNumber constraintAnnotation) {
    }

    @Override
    public boolean isValid(final Object value, final ConstraintValidatorContext cvc) {
	if (value == null)
	    return true;

	TaxpayerNumber check;

	if (MyObjects.isA(value, String.class))
	    check = TaxpayerNumber.assertValid(MyObjects.requireA(value, String.class));
	else if (MyObjects.isA(value, TaxpayerNumber.class))
	    check = MyObjects.requireA(value, TaxpayerNumber.class);
	else
	    throw new ValidationException("Unknown type " + value.getClass());

	if (TaxpayerNumber.nonValid(check))
	    return false;

	return true;
    }
}