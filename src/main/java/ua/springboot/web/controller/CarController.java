package ua.springboot.web.controller;

import java.io.IOException;
import java.security.Principal;
import java.util.Date;

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

import ua.springboot.web.dto.FindCarByUser;
import ua.springboot.web.entity.Car;
import ua.springboot.web.entity.History;
import ua.springboot.web.entity.UserEntity;
import ua.springboot.web.mapper.CarMapper;
import ua.springboot.web.service.CarClassService;
import ua.springboot.web.service.CarMakeService;
import ua.springboot.web.service.CarService;
import ua.springboot.web.service.FuelService;
import ua.springboot.web.service.HisoryService;
import ua.springboot.web.service.LocationService;
import ua.springboot.web.service.TransmissionService;
import ua.springboot.web.service.UserService;
import ua.springboot.web.utils.CustomFileUtils;

@Controller
@RequestMapping("/cars")
public class CarController {
	
	private CarService carService;
	
	private CarClassService carClassService;
	private CarMakeService carMakeService;
	private FuelService fuelService;
	private TransmissionService transmissionService;
	private LocationService locationService;
	private UserService userService;
	private HisoryService historySevice;

	@Autowired
	public CarController(CarService carService, CarClassService carClassService,
			CarMakeService carMakeService, FuelService fuelService, 
			TransmissionService transmissionService, LocationService locationService,
			UserService userService, HisoryService historySevice) {
		this.carService = carService;
		
		this.carClassService = carClassService;
		this.carMakeService = carMakeService;
		this.fuelService = fuelService;
		this.transmissionService = transmissionService;
		this.locationService =locationService;
		this.userService = userService;
		this.historySevice = historySevice;
	}
	
	@GetMapping("/rent-car/{carId}")
	public String rentCarPage(Model model,
			@PathVariable("carId")String carId){
		//model.addAttribute("offices", locationService.findAll());
		//model.addAttribute("history", new History());
		Car car = carService.findById(Long.valueOf(carId));
		if(car != null) {
			model.addAttribute("car", car);
			String[] photoPath ={car.getPhotoPath()[0]};
			try {
				model.addAttribute("mainPhoto",CustomFileUtils.getMainCarPhoto(car.getId(), photoPath));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			return "redirect:/cars";
		}
		
		return "cars/rent-car";
	}
	
	@PostMapping("/rent-car/{carId}")
	public String saveHistory(
			
			@RequestParam("dateFrom")String dateFrom,
			@RequestParam("dateFrom")String dateTo,
			@PathVariable("carId")String carIdStr,
			Principal principal
			
			) {
		Car car = carService.findById(Long.valueOf(carIdStr));
		if(car != null) {
			History history = new History();
			history.setDayFrom(dateFrom);
			history.setDayTo(dateTo);
			UserEntity entity = userService.findUserByEmail(principal.getName());
			history.setUser(entity);
			history.setCar(car);
			historySevice.save(history);
			
			// Sending rent data to admin mail
			
		}
		System.out.println( "date from " + dateFrom);
		System.out.println("date to" + dateTo);
		return "redirect:/cars";
	}
	
	@GetMapping
	public String showAllCarsPage(Model model) {
		
		model.addAttribute("allCars", CarMapper.carsToAllCarsDto(carService.findAll()));
		
		model.addAttribute("findCars", new FindCarByUser());
		model.addAttribute("carClasses", carClassService.findAll());
		model.addAttribute("makes", carMakeService.findAll());
		model.addAttribute("fuel", fuelService.findAll());
		model.addAttribute("transmission", transmissionService.findAll());
		return "cars/all-cars";
	}
	
	@PostMapping
	public String showCatToUserConfig(
			Model model,
			@ModelAttribute("findCars")FindCarByUser findCars,
			BindingResult result
			) {
		model.addAttribute("findCars", new FindCarByUser());
		model.addAttribute("carClasses", carClassService.findAll());
		model.addAttribute("makes", carMakeService.findAll());
		model.addAttribute("fuel", fuelService.findAll());
		model.addAttribute("transmission", transmissionService.findAll());
		
		model.addAttribute("allCars", CarMapper.carsToAllCarsDto(carService.findCarByUserConfig(findCars)));
		System.out.println(findCars);
		return "cars/all-cars";
	}
	
	@GetMapping("/{carId}")
	public String showOneCar(
			@PathVariable("carId")String carId,
			Model model) {
		Long id = Long.valueOf(carId);
		Car car = carService.findById(id);
		model.addAttribute("car",car);
		
		try {
			model.addAttribute("photos", CustomFileUtils.getCarPhotos(car.getId(), 
						car.getPhotoPath()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return "cars/car-info";
	}
	
	
}
