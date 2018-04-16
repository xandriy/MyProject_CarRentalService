package ua.springboot.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.springboot.web.dto.FindCarByUser;
import ua.springboot.web.entity.Car;
import ua.springboot.web.mapper.CarMapper;
import ua.springboot.web.service.CarService;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api/v1")
public class RestController {
	
	private CarService carService;
	
	@Autowired
	public RestController(CarService carService) {
		this.carService = carService;
	}
	
	/*@GetMapping("/cars")
	public List<CarJSON> getAllCar(){
		return CarMapper.CarToCarJSON(carService.findAll());
	}
	*/
	
}
