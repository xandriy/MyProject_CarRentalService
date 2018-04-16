package ua.springboot.web.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ua.springboot.web.dto.PasswodRecovery;
import ua.springboot.web.dto.RegisterRequest;
import ua.springboot.web.dto.UserEditRequest;
import ua.springboot.web.entity.UserEntity;
import ua.springboot.web.mail.Mail;
import ua.springboot.web.mapper.UserMapper;
import ua.springboot.web.repository.UserRepository;
import ua.springboot.web.service.MailService;
import ua.springboot.web.service.UserService;
import ua.springboot.web.utils.CustomFileUtils;
import ua.springboot.web.utils.GenerateRandomData;

@Service
public class UserServiceImpl implements UserService{
	
	
	private UserRepository userRepository;
	private PasswordEncoder passwordEncoder;
	private MailService mailService;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository, 
			PasswordEncoder passwordEncoder,
			MailService mailService) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
		this.mailService = mailService;
	}

	@Override
	@Transactional
	public void save(RegisterRequest request) {
		UserEntity entity = UserMapper.RegisterRequestToAllUserData(request);
		String token = GenerateRandomData.generateRandomToken();
		
		entity.setPassword(passwordEncoder
				.encode(entity.getPassword()));
		entity.setActivated(false);
		entity.setToken(token);
		userRepository.save(entity);
		
		Mail mail = new Mail();
		mail.setTo(entity.getEmail());
		mail.setSubject("Profile activation");
		mail.setContent("Hello, " + entity.getUserDetails().getFirstName() + 
				"! Your have successfully registered in our service. "
				+ "To complete registration and activate your profile, go to the link: " + 
				"http://localhost:8090/verify?token=" + token + 
				"&user-id=" + entity.getId());
		
		mailService.sendMessage(mail);
		CustomFileUtils.createFolderForUserData(entity.getId());
	}
	
	@Override
	public void verifyUser(String id, String token) {
		Long userId = Long.valueOf(id);
		UserEntity user = findById(userId);
		if(user != null && user.getToken().equals(token)) {
			user.setToken("");
			user.setActivated(true);
			userRepository.save(user);
		}
	}

	@Override
	@Transactional
	public void sendSecureCode(String email) {
		UserEntity user = userRepository.findUserByEmail(email);
		if(user != null ) {
			String key = GenerateRandomData.generateRandomRecoveryrKey();
			Mail mail = new Mail();
			mail.setTo(user.getEmail());
			mail.setSubject("Pawword Recovery");
			mail.setContent("Hello, " + user.getUserDetails().getFirstName() + 
					"! Your recovery password key - " + key 
 					+ " . If your didn`t try recovery your password ignore, "
 					+ "this message or contact with support");
			user.setRecoveryKey(key);
			userRepository.save(user);
			mailService.sendMessage(mail);
		}else {
			throw new NullPointerException("User didn't found");
		}
	}

	
	
	@Override
	@Transactional
	public void saveNewPassword(PasswodRecovery passwordRecovery) {
		UserEntity user = userRepository.findUserByEmail(passwordRecovery.getEmail());
		if(user != null && user.getRecoveryKey() != null && !user.getRecoveryKey().equals("")
				&& user.getRecoveryKey().equals(passwordRecovery.getKey())) {	
				user.setPassword(passwordEncoder.encode(passwordRecovery.getPassword()));
				user.setRecoveryKey("");
				userRepository.save(user);
		}else {
			throw new NullPointerException("Wrorng data!");
		}
	}

	@Override
	@Transactional
	public void saveEditUser(UserEditRequest request) throws Exception {
		
		String newPassword = request.getNewPassword();
		if(newPassword != null && !newPassword.equals("")) {
			userRepository.save(UserMapper.EditRequestToUser(request,
						passwordEncoder.encode(request.getNewPassword())));
		}
		else {
			userRepository.save(UserMapper.EditRequestToUser(request, 
					request.getOldPassword()));
		}
		
		CustomFileUtils.saveUserProfilePhoto(request.getId(), request.getFile());
		
	}
	
	@Override
	@Transactional
	public void saveEditUserByAdmin(UserEditRequest request, boolean activate) throws Exception {
		
		String newPassword = request.getNewPassword();
		if(newPassword != null && !newPassword.equals("")) {
			userRepository.save(UserMapper.EditRequestToUser(request,
						passwordEncoder.encode(request.getNewPassword())));
		}
		else {
			UserEntity user = UserMapper.EditRequestToUser(request, 
					request.getOldPassword());
			user.setActivated(activate);
			userRepository.save(user);
		}
		
		CustomFileUtils.saveUserProfilePhoto(request.getId(), request.getFile());
		
	}
	
	@Override
	public UserEntity findUserByEmail(String email) {
		return userRepository.findUserByEmail(email);
	}

	@Override
	public List<UserEntity> findAll() {
		return userRepository.findAll();
	}

	@Override
	public UserEntity findById(long id) {
		return userRepository.findOne(id);
	}

	@Override
	public void delete(Long id) {
		userRepository.delete(id);
	}
}
