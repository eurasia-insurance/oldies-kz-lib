package tech.lapsa.kz.taxpayer.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import tech.lapsa.kz.taxpayer.TaxpayerNumber;

public class ValidTaxpayerNumberConstraintValidator implements ConstraintValidator<ValidTaxpayerNumber, String> {

    public void initialize(ValidTaxpayerNumber constraintAnnotation) {
    }

    public boolean isValid(String value, ConstraintValidatorContext cvc) {
	if (value == null)
	    return true;
	return TaxpayerNumber.valid(value);
    }
}