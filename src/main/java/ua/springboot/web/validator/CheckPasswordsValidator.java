package ua.springboot.web.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Component;

import ua.springboot.web.dto.RegisterRequest;

@Component
public class CheckPasswordsValidator 
		implements ConstraintValidator<CheckPasswords, RegisterRequest>{

	@Override
	public void initialize(CheckPasswords arg0) {
		
	}

	@Override
	public boolean isValid(RegisterRequest user, ConstraintValidatorContext arg1) {
		
		if(user.getPassword() == null 
				|| user.getPasswordConfirm() == null)
			return false;
		if(user.getPassword().equals(user.getPasswordConfirm())) 
			return true;
		
		return false;
	}

	
}
