package ua.springboot.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ua.springboot.web.dto.PasswodRecovery;
import ua.springboot.web.dto.RegisterRequest;
import ua.springboot.web.service.UserService;

@Controller
public class BaseController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public String showHome() {
		return "home";
	}
	

	@GetMapping("/registration")
	public String showRegistaction(
			Model model
			) {
		model.addAttribute("registerRequest", new RegisterRequest());
		return "registration";
	}
	
	@PostMapping("/registration")
	public ModelAndView saveData(
			@ModelAttribute("registerRequest") 
			@Valid RegisterRequest request,
			BindingResult result
			) {
		if(result.hasErrors())
			return new ModelAndView("registration");
		try {
			userService.save(request);
		}catch(Exception e) {
			e.printStackTrace();
			return new ModelAndView("registration", 
					"error", "Something went wrong during registration");
		}
		
		
		return new ModelAndView("redirect:/");
	}
	
	//@GetMapping("/login")
	public String showLoginPage() {
		return "login";
	}
	
	@GetMapping("/verify")
	public String verifyUser(
			@RequestParam("token")String token,
			@RequestParam("user-id")String userId
			) {
		userService.verifyUser(userId, token);
		
		return "redirect:/";
	}
	
	@GetMapping("/forgot-password")
	public String showforgotPassword(Model  model) {
		model.addAttribute("email", new String());
		return "forgot-password";
	}
	
	@PostMapping("/forgot-password")
	public ModelAndView passwordRecovery(
			@ModelAttribute("email")@Valid String email
			) {
		try {
			userService.sendSecureCode(email);
		}catch(Exception e){
			e.printStackTrace();
			return new ModelAndView("forgot-password",
						"error", "Somethig went wrong during setting email, "
								+ "maybe you entred incorrect e-mail");
		}
		
		return new ModelAndView("redirect:/password-recovery");
	}
	
	@GetMapping("/password-recovery")
	public String showRecoveryPage(Model model) {
		model.addAttribute("recoveryModel", new PasswodRecovery());
		return "password-recovery";
	}
	
	@PostMapping("/password-recovery")
	public ModelAndView saveNewPassword(
			@ModelAttribute("recoveryModel")@Valid PasswodRecovery passwodRecovery,
			BindingResult result
			) {
		System.out.println(passwodRecovery);
		if(result.hasErrors()) {
			System.out.println(result.getErrorCount());
			return new ModelAndView("password-recovery");
		}
		try {
			
			userService.saveNewPassword(passwodRecovery);
		}catch(Exception e) {
			e.printStackTrace();
			return new ModelAndView("password-recovery",
					"error", "Somethig went wrong during password recovery,"
							+ " maybe you entered incorerct data ");
		}
		
		
		
		return new ModelAndView("home");
	}
	
}
