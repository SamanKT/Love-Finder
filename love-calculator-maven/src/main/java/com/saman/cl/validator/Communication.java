package com.saman.cl.validator;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Retention(RUNTIME)
@Target(FIELD)
@Constraint(validatedBy =  CommunicationValidator.class)
public @interface Communication {

	int digits() default 10;
	
	String message() default "{invalidPhoneMessage}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
	
}
