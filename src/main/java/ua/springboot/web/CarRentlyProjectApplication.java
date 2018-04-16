package ua.springboot.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.security.crypto.password.PasswordEncoder;

import ua.springboot.web.entity.UserDetails;
import ua.springboot.web.entity.UserEntity;
import ua.springboot.web.enumaration.Role;
import ua.springboot.web.repository.UserRepository;

@SpringBootApplication
public class CarRentlyProjectApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		ConfigurableApplicationContext context = 
				SpringApplication.run(CarRentlyProjectApplication.class, args);
		addAdmin(context);
	}

	private static void addAdmin(ConfigurableApplicationContext context) {
		String email = "admin@gmail.com";
		String password = "12345";
		
		UserRepository userRepository = 
				context.getBean(UserRepository.class);
		
		if(userRepository.findUserByEmail(email) == null) {
			UserEntity entity = new UserEntity();
			PasswordEncoder encoder = context.getBean(PasswordEncoder.class);
			entity.setEmail(email);
			entity.setPassword(encoder.encode(password));
			entity.setRole(Role.ROLE_ADMIN);
			
			UserDetails details = new UserDetails();
			details.setFirstName("Admin");
			details.setLastName("Admin");
			entity.setUserDetails(details);
			
			userRepository.save(entity);
		}
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(CarRentlyProjectApplication.class);
	}
	
	
	
}
