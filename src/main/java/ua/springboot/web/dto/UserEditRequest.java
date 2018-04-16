package ua.springboot.web.dto;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import ua.springboot.web.enumaration.Role;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserEditRequest {

	private Long id;

	private String oldPassword;
	
	private String newPassword;
	
	private String confirmNewPassword;
	
	@NotEmpty(message = "E-mail should be fiilled")
	@Pattern(regexp = "^[a-zA-Z]+[a-zA-Z0-9\\.-_]+@[a-zA-Z]{2,6}+\\.[a-z]{2,4}",
				message = "E-mail has an incorrect format")
	private String email;

	private Role role;
	
	@NotEmpty(message = "First Name should be fillled ")
	@Pattern(regexp = "^[A-Z]{1}+[a-zA-Z-]*", 
			message = "Name format is incorrect")
	private String firstName;
	
	@NotEmpty(message = "Last Name should be fillled ")
	@Pattern(regexp = "^[A-Z]{1}+[a-zA-Z-]*",
			message = "Name format is incorrect")
	private String lastName;
	
	@Pattern(regexp = "[0-9+ -]*",
			message = "Incorrect format of phone number")
	private String phoneNumber;
	
	private int yearOfBith;
	private String licenseNumber;
	private String passportNumber;
	private MultipartFile file;
	private String filePath;
}
