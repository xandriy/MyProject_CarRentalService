package ua.springboot.web.service;

import java.io.IOException;
import java.util.List;

import ua.springboot.web.dto.CarCreate;
import ua.springboot.web.dto.EditCarRequest;
import ua.springboot.web.dto.FindCarByUser;
import ua.springboot.web.entity.Car;

public interface CarService {
	
	public void saveNew(CarCreate create) throws IOException;
	
	public void save(EditCarRequest edit) throws IOException;
	
	public List<Car> findAll();
	
	public Car findById(Long id);
	
	public Car findByMake(String make);
	
	public List<Car> findCarByUserConfig(FindCarByUser findCars);
	
	public void deleteCar(Long id);
	
}
