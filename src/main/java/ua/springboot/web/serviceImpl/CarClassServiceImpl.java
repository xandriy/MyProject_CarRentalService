package ua.springboot.web.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import ua.springboot.web.entity.CarClass;
import ua.springboot.web.repository.CarClassRepository;
import ua.springboot.web.service.CarClassService;

@Service
public class CarClassServiceImpl implements CarClassService{

	private CarClassRepository carClassRepository;
	
	public CarClassServiceImpl(CarClassRepository carClassRepository) {
		this.carClassRepository = carClassRepository;
	}

	@Override
	public void save(CarClass carClass) {
		carClassRepository.save(carClass);
	}

	@Override
	public CarClass findById(Long id) {
		return carClassRepository.findOne(id);
	}

	@Override
	public List<CarClass> findAll() {
		return carClassRepository.findAll();
	}

	@Override
	public List<String> findAllCarClass() {
		return carClassRepository.findCarClassString();
	}

	
	
}
