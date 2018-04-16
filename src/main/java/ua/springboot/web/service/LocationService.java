package ua.springboot.web.service;

import java.util.List;

import ua.springboot.web.entity.Location;

public interface LocationService {

	Location findById(Long id);
	
	void save(Location location);
	
	List<Location> findAll();
	
}
