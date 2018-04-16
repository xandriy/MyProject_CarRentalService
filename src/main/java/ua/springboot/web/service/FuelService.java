package ua.springboot.web.service;

import java.util.List;

import ua.springboot.web.entity.Fuel;

public interface FuelService {

	void save(Fuel fuel);
	
	Fuel findById(Long id);
	
	List<Fuel> findAll();
	
	List<String> findAllFuel();
	
}
