package com.lapsa.kz.idnumber.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.lapsa.kz.idnumber.IdNumbers;

public class ValidIdNumberConstraintValidator implements ConstraintValidator<ValidIdNumber, String> {

    private boolean checkDigit;

    public void initialize(ValidIdNumber constraintAnnotation) {
	checkDigit = constraintAnnotation.checkDigit();
    }

    public boolean isValid(String value, ConstraintValidatorContext cvc) {
	if (value == null)
	    return true;
	return IdNumbers.valid(value, checkDigit);
    }
}