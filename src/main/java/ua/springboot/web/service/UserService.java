package ua.springboot.web.service;

import java.util.List;

import ua.springboot.web.dto.PasswodRecovery;
import ua.springboot.web.dto.RegisterRequest;
import ua.springboot.web.dto.UserEditRequest;
import ua.springboot.web.entity.UserEntity;

public interface UserService {
	
	void delete(Long id);
	
	void save(RegisterRequest request);
	
	void saveEditUser(UserEditRequest request) throws Exception;
	
	public void saveEditUserByAdmin(UserEditRequest request, boolean activate) throws Exception;
	
	List<UserEntity> findAll();
	
	UserEntity findById(long id);
	
	UserEntity findUserByEmail(String email);
	
	void verifyUser(String id, String token);
	
	void sendSecureCode(String email);
	
	void saveNewPassword(PasswodRecovery passwordRecovery);
}
