package ua.springboot.web.serviceImpl;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ua.springboot.web.entity.UserEntity;
import ua.springboot.web.mapper.UserMapper;
import ua.springboot.web.repository.UserRepository;

@Service
public class CustomUserDetailsServiceImpl implements UserDetailsService{

	@Autowired 
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		UserEntity entity = userRepository.findUserForAuthentication(email);
		if(entity == null) 
			throw new EntityNotFoundException("Entity not found");
		return UserMapper.UserEntityToSecurityUser(entity);
	}

}
