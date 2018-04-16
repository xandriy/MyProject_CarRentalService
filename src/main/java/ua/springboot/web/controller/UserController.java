package ua.springboot.web.controller;

import java.io.IOException;
import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ua.springboot.web.dto.UserEditRequest;
import ua.springboot.web.entity.UserEntity;
import ua.springboot.web.mapper.UserMapper;
import ua.springboot.web.service.UserService;
import ua.springboot.web.utils.CustomFileUtils;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	
	@GetMapping("/all-users")
	public String showAllUsers(Model model) {
		
		model.addAttribute("users", userService.findAll());
		
		return "users/all-users";
	}
	
	
	@GetMapping("/profile")
	public String showProfilePage(
			Model model,
			Principal principal
			) {
		UserEntity entity = userService.findUserByEmail(principal.getName());
		if(entity == null)
			return "redirect:/";
		
		model.addAttribute("user", UserMapper.UserEnityAndDetailsToProfileRequest(entity));
		try {
			model.addAttribute("photo", CustomFileUtils.getUserProfilePhoto(entity.getId(), 
						entity.getUserDetails().getPhotoPath()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "users/profile";
	}
	
	@GetMapping("/edit")
	public  String showEditPage(
			Model model,
			Principal principal
			) {
		UserEntity entity = userService.findUserByEmail(principal.getName());
		if(entity == null) 
			return "redirect:/";
		model.addAttribute("userEdit", UserMapper.UserAllDataToEdit(entity));
		
		return "users/edit-user";
	}
	
 	@PostMapping("/edit")
	public ModelAndView saveEditUser(
				@ModelAttribute("userEdit")@Valid UserEditRequest edit,
				BindingResult result
			) {
 		if(result.hasErrors())
 			return new ModelAndView("users/edit-user");
 		
		try {
			userService.saveEditUser(edit);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new ModelAndView("redirect:/user/profile");
	}
}


