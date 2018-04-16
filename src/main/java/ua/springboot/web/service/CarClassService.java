package ua.springboot.web.service;

import java.util.List;

import ua.springboot.web.entity.CarClass;

public interface CarClassService {
	
	void save(CarClass carClass);
	
	CarClass findById(Long id);
	
	List<CarClass> findAll();
	
	List<String> findAllCarClass();
	
}
