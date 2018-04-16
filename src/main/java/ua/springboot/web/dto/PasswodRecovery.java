package ua.springboot.web.dto;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import ua.springboot.web.validator.CheckPasswords;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class PasswodRecovery {
	
	@NotEmpty(message = "E-mail should be fiilled")
//	@Pattern(regexp = "^[a-zA-Z]+[a-zA-Z0-9\\.-_]+@[a-zA-Z]{2,6}+\\.[a-z]{2,4}",
//				message = "E-mail has an incorrect format")
	private String email;
	
	@NotEmpty(message = "Password field should be fiilled") 
	private String password;
	
	@NotEmpty(message = "Password confirm field should be fiilled") 
	private String passwordConfirm;
	
	@NotEmpty
	private String key;
}
