package ua.springboot.web.controller;

import java.io.IOException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ua.springboot.web.dto.CarCreate;
import ua.springboot.web.dto.EditCarRequest;
import ua.springboot.web.dto.UserEditRequest;
import ua.springboot.web.entity.Car;
import ua.springboot.web.entity.UserEntity;
import ua.springboot.web.enumaration.Role;
import ua.springboot.web.mapper.CarMapper;
import ua.springboot.web.mapper.UserMapper;
import ua.springboot.web.service.CarClassService;
import ua.springboot.web.service.CarMakeService;
import ua.springboot.web.service.CarService;
import ua.springboot.web.service.FuelService;
import ua.springboot.web.service.TransmissionService;
import ua.springboot.web.service.UserService;
import ua.springboot.web.utils.CarUtils;
import ua.springboot.web.utils.CustomFileUtils;

@Controller
@RequestMapping("/admin")
public class AdminController {

	private CarService carService;
	private UserService userService;
	
	private CarClassService carClassService;
	private CarMakeService carMakeService;
	private FuelService fuelService;
	private TransmissionService transmissionService;

	@Autowired
	public AdminController(CarService carService, UserService userService, CarClassService carClassService,
			CarMakeService carMakeService, FuelService fuelService, TransmissionService transmissionService) {
		this.carService = carService;
		this.userService = userService;
		this.carClassService = carClassService;
		this.carMakeService = carMakeService;
		this.fuelService = fuelService;
		this.transmissionService = transmissionService;
	}
	
	@GetMapping("/admin-page")
	public String showAdminPage() {
		return "admin/admin-main-page";
		
	}
	
	

	@GetMapping("/car/all")
	public String showAllCar(Model model) {
		model.addAttribute("allCar", carService.findAll());
		return "admin/all-car";
	}
	
	@GetMapping("/car/all/{carId}/delete")
	public String deleteCar(
			@PathVariable("carId")String carId
			) {
		carService.deleteCar(Long.valueOf(carId));
		return "redirect:/admin/car/all";
	}
	
	@GetMapping("/car/all/{carId}/edit")
	public String editCarByAdmin(
			@PathVariable("carId")Long carId,
			Model model
			) {
		Car car = carService.findById(Long.valueOf(carId));
		if(car == null) 
			return "redirect:/admin/car/all";
		model.addAttribute("car", CarMapper.CarToCarEdit(car));
		
		model.addAttribute("manufactureYears", CarUtils.generateManufactureYear());
		model.addAttribute("carClasses", carClassService.findAll());
		model.addAttribute("makes", carMakeService.findAll());
		model.addAttribute("fuel", fuelService.findAll());
		model.addAttribute("transmission", transmissionService.findAll());

		return "admin/edit-car";
	}
	
	@PostMapping("/car/edit")
	public ModelAndView saveEditCar(
				@ModelAttribute("car")EditCarRequest edit,
				BindingResult result
			) {
		try {
			carService.save(edit);
		} catch (Exception e) {
			e.printStackTrace();
			return new ModelAndView("redirect:/admin/car/all",
									"error", "Something went wrong");
		}
		
		return new ModelAndView("redirect:/admin/car/all");
	}
	
	
	
	@GetMapping("/users/all")
	public String showAllUser(Model model) {
		model.addAttribute("users", userService.findAll());
		return "admin/all-user";
	}
	
	
	
	@GetMapping("/car/add")
	public String addCar(Model model) {
	
		model.addAttribute("newCar", new CarCreate());
		model.addAttribute("manufactureYears", CarUtils.generateManufactureYear());
		
		model.addAttribute("carClasses", carClassService.findAll());
		model.addAttribute("makes", carMakeService.findAll());
		model.addAttribute("fuel", fuelService.findAll());
		model.addAttribute("transmission", transmissionService.findAll());
		return "admin/add-car";
	}
	
	@PostMapping("/car/add")
	public ModelAndView saveNewCar(
			@ModelAttribute("newCar") CarCreate carCreate
			) {
		
		try {
			carService.saveNew(carCreate);
		}catch (Exception e) {
			e.printStackTrace();
			return new ModelAndView("redirect:/admin/car/add","error", "Something went wrong");		}
		
		return new ModelAndView("redirect:/admin/car/all");
	}
	
	@GetMapping("users/add")
	public String showAddNewUserByAdmin(Model model) {
		model.addAttribute("newUser", new UserEditRequest());
		model.addAttribute("roles", Role.values());
		return "admin/add-user";
	}
	
	@PostMapping("/users/add")
	public ModelAndView saveNewUser(
				@ModelAttribute("newUser")@Valid UserEditRequest edit,
				BindingResult result,
				Model model
			) {
 		if(result.hasErrors()) {
 			model.addAttribute("roles", Role.values());
 			return new ModelAndView("admin/add-user");
 		}
 		
		try {
			userService.saveEditUser(edit);
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("roles", Role.values());
			return new ModelAndView("admin/add-user","error","Something went wrong");
		}
		
		return new ModelAndView("redirect:/users/all");
	}
	
	@GetMapping("/users/{userId}/profile")
	public String showUserProfile(
			@PathVariable("userId")Long userId,
			Model model
			) {
		UserEntity entity = userService.findById(userId);
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
	
	@GetMapping("/users/{userId}/delete")
	public String deleteUser(
			@PathVariable("userId")String userIdStr
			) {
		userService.delete(Long.valueOf(userIdStr));
		return "redirect:/admin/users/all";
	}
	
	
	@GetMapping("/{userId}/edit")
	public String editUserProfileByAdmin(
			@PathVariable("userId")Long userId,
			Model model
			) {
		UserEntity entity = userService.findById(userId);
		if(entity == null) 
			return "redirect:/admin/users/all";
		model.addAttribute("roles", Role.values());
		model.addAttribute("userEdit", UserMapper.UserAllDataToEdit(entity));
		
		return "admin/edit-user-by-admin";
	}
	
	@PostMapping("/{userId}/edit")
	public ModelAndView saveEditUser(
				@ModelAttribute("userEdit")@Valid UserEditRequest edit,
				@RequestParam("state")boolean state,
				BindingResult result
			) {
 		if(result.hasErrors())
 			return new ModelAndView("users/edit-user");
 		
		try {
			userService.saveEditUserByAdmin(edit, state);
		} catch (Exception e) {
			e.printStackTrace();
			return new ModelAndView("redirect:/admin/edit-user-by-admin",
									"error", "Something went wrong");
		}
		
		return new ModelAndView("redirect:/admin/users/all");
	}
	
	
}
