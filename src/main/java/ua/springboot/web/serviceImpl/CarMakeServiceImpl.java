package ua.springboot.web.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.springboot.web.entity.CarMake;
import ua.springboot.web.repository.CarMakeRepository;
import ua.springboot.web.service.CarMakeService;

@Service
public class CarMakeServiceImpl implements CarMakeService{

	private CarMakeRepository carMakeRepository;
	
	@Autowired
	public CarMakeServiceImpl(CarMakeRepository carMakeRepository) {
		this.carMakeRepository = carMakeRepository;
	}

	@Override
	public void save(CarMake carMake) {
		carMakeRepository.save(carMake);
	}

	@Override
	public CarMake findById(Long id) {
		return carMakeRepository.findOne(id);
	}

	@Override
	public List<CarMake> findAll() {
		return carMakeRepository.findAll();
	}

	@Override
	public List<String> findAllCarMake() {
		return carMakeRepository.findCarMake();
	}

}
