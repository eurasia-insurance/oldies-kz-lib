package com.lapsa.kz.idnumber.validators;

import javax.inject.Inject;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.lapsa.kz.idnumber.IDNumberValidator;

public class ValidIdNumberConstraintValidator implements ConstraintValidator<ValidIdNumber, String> {

    @Inject
    private IDNumberValidator validator;

    private boolean checkDigit;

    public void initialize(ValidIdNumber constraintAnnotation) {
	checkDigit = constraintAnnotation.checkDigit();
    }

    public boolean isValid(String value, ConstraintValidatorContext cvc) {
	if (value == null)
	    return true;
	if (!checkDigit)
	    return true;
	return validator.isValid(value);
    }
}