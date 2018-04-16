package ua.springboot.web.dto;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.springboot.web.enumaration.Role;
import ua.springboot.web.validator.CheckPasswords;
import ua.springboot.web.validator.IsEmailExist;

@NoArgsConstructor
@Getter
@Setter
@CheckPasswords
public class RegisterRequest {

	@IsEmailExist
	@NotEmpty(message = "E-mail should be fiilled")
	@Pattern(regexp = "^[a-zA-Z]+[a-zA-Z0-9\\.-_]+@[a-zA-Z]{2,6}+\\.[a-z]{2,4}",
				message = "E-mail has an incorrect format")
	private String email;
	
	@NotEmpty(message = "Password should be fiilled") 
	private String password;
	
	@NotEmpty(message = "Password confirm should be fiilled") 
	private String passwordConfirm;
	
	
	@NotEmpty(message = "First Name should be fillled ")
	@Pattern(regexp = "^[A-Z]{1}+[a-zA-Z-]*", 
			message = "Name format is incorrect")
	private String firstName;
	
	@NotEmpty(message = "Last Name should be fillled ")
	@Pattern(regexp = "^[A-Z]{1}+[a-zA-Z-]*",
			message = "Name format is incorrect")
	private String lastName;
	
	private boolean agreement = false;
	
	private Role role;
	
}
