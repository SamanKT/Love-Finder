package com.saman.cl.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.saman.cl.api.CommunicationDTO;

public class CommunicationValidator implements ConstraintValidator<Communication, CommunicationDTO> {

	int digits;

	@Override
	public void initialize(Communication constraintAnnotation) {

		this.digits = constraintAnnotation.digits();

	}

	@Override
	public boolean isValid(CommunicationDTO value, ConstraintValidatorContext context) {
		if (value.getPhone().getNumber().length() != digits) {
			return false;
		}		
		
		return true;
	}


}
