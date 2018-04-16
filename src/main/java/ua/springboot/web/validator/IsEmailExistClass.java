package ua.springboot.web.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import ua.springboot.web.service.UserService;

public class IsEmailExistClass implements ConstraintValidator<IsEmailExist, String>{

	@Autowired
	private UserService userService;
	
	@Override
	public void initialize(IsEmailExist arg0) {
		
	}

	@Override
	public boolean isValid(String email, ConstraintValidatorContext arg1) {
		return userService.findUserByEmail(email) == null;
	}
	
}
