package ua.springboot.web.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.springboot.web.entity.Location;
import ua.springboot.web.repository.LocationRepository;
import ua.springboot.web.service.LocationService;

@Service
public class LocationServiceImpl implements LocationService{

	@Autowired
	private LocationRepository locationRepository;
	
	@Override
	public Location findById(Long id) {
		return locationRepository.findOne(id);
	}

	@Override
	public void save(Location location) {
		locationRepository.save(location);
	}

	@Override
	public List<Location> findAll() {
		return locationRepository.findAll();
	}

	
}
