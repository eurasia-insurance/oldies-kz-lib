package tech.lapsa.kz.taxpayer.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.ValidationException;

import tech.lapsa.java.commons.function.MyObjects;
import tech.lapsa.kz.taxpayer.TaxpayerNumber;

public class ValidTaxpayerNumberConstraintValidator implements ConstraintValidator<ValidTaxpayerNumber, Object> {

    public void initialize(ValidTaxpayerNumber constraintAnnotation) {
    }

    public boolean isValid(Object value, ConstraintValidatorContext cvc) {
	if (value == null)
	    return true;

	TaxpayerNumber tpn;
	if (MyObjects.isA(value, String.class)) {
	    tpn = TaxpayerNumber.of(MyObjects.requireA(value, String.class));
	} else if (MyObjects.isA(value, TaxpayerNumber.class)) {
	    tpn = MyObjects.requireA(value, TaxpayerNumber.class);
	} else {
	    throw new ValidationException("Unknown type " + value.getClass());
	}

	return tpn.isValid();
    }
}