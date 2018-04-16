package ua.springboot.web.service;

import java.util.List;

import ua.springboot.web.entity.CarMake;

public interface CarMakeService {
	
	void save(CarMake carMake);
	
	CarMake findById(Long id);
	
	List<CarMake> findAll();
	
	List<String> findAllCarMake();
}
