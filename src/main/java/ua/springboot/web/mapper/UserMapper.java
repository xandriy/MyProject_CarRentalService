package ua.springboot.web.mapper;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import ua.springboot.web.dto.RegisterRequest;
import ua.springboot.web.dto.UserEditRequest;
import ua.springboot.web.dto.UserProfileRequest;
import ua.springboot.web.entity.UserDetails;
import ua.springboot.web.entity.UserEntity;
import ua.springboot.web.enumaration.Role;

public class UserMapper {
	
	public static User UserEntityToSecurityUser(UserEntity entity) {
		return new User(entity.getEmail(),
						entity.getPassword(),
						AuthorityUtils.createAuthorityList(
								String.valueOf(entity.getRole())));
	}
	
	public static UserEntity RegisterRequestToAllUserData(RegisterRequest request) {
		UserEntity entity = new UserEntity();
		entity.setEmail(request.getEmail());
		entity.setPassword(request.getPassword());
		entity.setRole(Role.ROLE_CLIENT);
		UserDetails details = new UserDetails();
		details.setFirstName(request.getFirstName());
		details.setLastName(request.getLastName());
		entity.setUserDetails(details);
		return entity;
	}

	
	public static UserProfileRequest UserEnityAndDetailsToProfileRequest(UserEntity entity) {
		UserProfileRequest profile = new UserProfileRequest();
		profile.setId(entity.getId());
		profile.setEmail(entity.getEmail());
		profile.setFirstName(entity.getUserDetails().getFirstName());
		profile.setLastName(entity.getUserDetails().getLastName());
		profile.setYearOfBith(entity.getUserDetails().getYearOfBirth());
		profile.setLicenseNumber(entity.getUserDetails().getLicenseNumber());
		profile.setPassportNumber(entity.getUserDetails().getPassportNumber());
		profile.setPhoneNumber(entity.getUserDetails().getPhoneNumber());
		
		return profile;
	}
	
	public static UserEditRequest UserAllDataToEdit(UserEntity entity) {
		UserEditRequest request = new UserEditRequest();
		request.setId(entity.getId());
		request.setEmail(entity.getEmail());
		request.setRole(entity.getRole());
		request.setFirstName(entity.getUserDetails().getFirstName());
		request.setLastName(entity.getUserDetails().getLastName());
		request.setPhoneNumber(entity.getUserDetails().getPhoneNumber());
		request.setYearOfBith(entity.getUserDetails().getYearOfBirth());
		request.setLicenseNumber(entity.getUserDetails().getLicenseNumber());
		request.setPassportNumber(entity.getUserDetails().getPassportNumber());
		
		request.setFilePath(entity.getUserDetails().getPhotoPath());
		
		request.setOldPassword(entity.getPassword());
		
		System.out.println(request);
		return request;
	}
	
	public static UserEntity EditRequestToUser(UserEditRequest request, String password) {
		UserEntity user = new UserEntity();
		user.setId(request.getId());
		user.setEmail(request.getEmail());
		user.setRole(request.getRole());
		user.setPassword(password);
		
		UserDetails details = new UserDetails();
		details.setId(request.getId());
		details.setFirstName(request.getFirstName());
		details.setLastName(request.getLastName());
		details.setPhoneNumber(request.getPhoneNumber());
		details.setYearOfBirth(request.getYearOfBith());
		details.setPassportNumber(request.getPassportNumber());
		details.setLicenseNumber(request.getLicenseNumber());
		if(!request.getFile().isEmpty()){
			details.setPhotoPath(request.getFile().getOriginalFilename());
		}
		
		if(request.getFilePath() == null || (request.getFile().isEmpty() && !request.getFilePath().equals(""))) {	
			details.setPhotoPath(request.getFilePath());
		}
		user.setUserDetails(details);
		return user;
	}

	
	
	
}
