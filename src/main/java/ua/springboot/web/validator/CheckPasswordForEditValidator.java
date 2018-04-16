package ua.springboot.web.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Component;

import ua.springboot.web.dto.UserEditRequest;
@Component
public class CheckPasswordForEditValidator 
			implements ConstraintValidator<CheckPasswordForEdit, UserEditRequest>
{
	@Override
	public void initialize(CheckPasswordForEdit arg0) {
		
	}

		@Override
		public boolean isValid(UserEditRequest user, ConstraintValidatorContext arg1) {
			
			return false;
		}

		

		
	}

