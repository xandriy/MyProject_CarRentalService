package ua.springboot.web.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserProfileRequest {

	private Long id;
	private String email;
	private String firstName;
	private String lastName;
	private int yearOfBith;
	private String licenseNumber;
	private String passportNumber;
	private String phoneNumber;
	
}
