package com.saman.cl.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AgeValidator implements ConstraintValidator<age, Integer> {

	int lower;
	int higher;

	@Override
	public void initialize(age constraintAnnotation) {

		this.lower = constraintAnnotation.lower();
		this.higher = constraintAnnotation.higher();

	}

	@Override
	public boolean isValid(Integer value, ConstraintValidatorContext context) {

		if (value < lower || value > higher || value == null) {
			return false;
		}

		return true;
	}

}
