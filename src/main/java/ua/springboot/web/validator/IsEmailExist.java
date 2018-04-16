package ua.springboot.web.validator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = IsEmailExistClass.class)
public @interface IsEmailExist {
	String message() default "User with this e-mail is already exist";
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default {};
}
