package com.lapsa.kz.country.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.lapsa.kz.country.KZCity;

public class ValidKZCityConstraintValidator implements ConstraintValidator<ValidKZCity, KZCity> {

    private KZCity[] invalidTypes;

    @Override
    public void initialize(final ValidKZCity constraintAnnotation) {
	invalidTypes = constraintAnnotation.invalidValues();
    }

    @Override
    public boolean isValid(final KZCity value, final ConstraintValidatorContext context) {
	if (value == null)
	    return true;
	for (final KZCity i : invalidTypes)
	    if (i.equals(value))
		return false;
	return true;
    }

}