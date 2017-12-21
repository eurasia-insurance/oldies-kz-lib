package com.lapsa.kz.country.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.lapsa.kz.country.KZArea;

public class ValidKZAreaConstraintValidator implements ConstraintValidator<ValidKZArea, KZArea> {

    private KZArea[] invalidTypes;

    @Override
    public void initialize(final ValidKZArea constraintAnnotation) {
	invalidTypes = constraintAnnotation.invalidValues();
    }

    @Override
    public boolean isValid(final KZArea value, final ConstraintValidatorContext context) {
	if (value == null)
	    return true;
	for (final KZArea i : invalidTypes)
	    if (i.equals(value))
		return false;
	return true;
    }

}