package ua.springboot.web.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.springboot.web.entity.Fuel;
import ua.springboot.web.repository.FuelRepository;
import ua.springboot.web.service.FuelService;

@Service
public class FuelServiceImpl implements FuelService{

	private FuelRepository fuelRepository;
	
	@Autowired
	public FuelServiceImpl(ua.springboot.web.repository.FuelRepository fuelRepository) {
		this.fuelRepository = fuelRepository;
	}

	@Override
	public void save(Fuel fuel) {
		fuelRepository.save(fuel);
	}

	@Override
	public Fuel findById(Long id) {
		return fuelRepository.findOne(id);
	}

	@Override
	public List<Fuel> findAll() {
		return fuelRepository.findAll();
	}

	@Override
	public List<String> findAllFuel() {
		return fuelRepository.findFuelString();
	}

}
