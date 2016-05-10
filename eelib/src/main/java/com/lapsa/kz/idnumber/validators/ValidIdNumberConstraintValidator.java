package com.lapsa.kz.idnumber.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.lapsa.kz.idnumber.IDNumberValidator;
import com.lapsa.kz.idnumber.IDNumberValidatorProvider;

public class ValidIdNumberConstraintValidator implements ConstraintValidator<ValidIdNumber, String> {

    private IDNumberValidator validator;

    private boolean checkDigit;

    public void initialize(ValidIdNumber constraintAnnotation) {
	checkDigit = constraintAnnotation.checkDigit();
	validator = IDNumberValidatorProvider.provideDefault();
    }

    public boolean isValid(String value, ConstraintValidatorContext cvc) {
	if (value == null)
	    return true;

	return validator.isValid(value, checkDigit);
    }
}