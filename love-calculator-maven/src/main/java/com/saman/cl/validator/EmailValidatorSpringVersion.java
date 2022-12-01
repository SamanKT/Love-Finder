package com.saman.cl.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.saman.cl.api.LoveCalculatorRegisterDTO;

@Component
public class EmailValidatorSpringVersion implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return LoveCalculatorRegisterDTO.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "communicationDTO.email", "email.empty");
		  LoveCalculatorRegisterDTO dto =  (LoveCalculatorRegisterDTO)target ;
		  if (!dto.getCommunicationDTO().getEmail().endsWith("saman.com")) {
			  errors.rejectValue("communicationDTO.email", "email.invalid");
		  }
		
	}

}
