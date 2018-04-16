package ua.springboot.web.serviceImpl;

import java.io.IOException;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.springboot.web.dto.CarCreate;
import ua.springboot.web.dto.EditCarRequest;
import ua.springboot.web.dto.FindCarByUser;
import ua.springboot.web.entity.Car;
import ua.springboot.web.mapper.CarMapper;
import ua.springboot.web.repository.CarRepository;
import ua.springboot.web.service.CarService;
import ua.springboot.web.utils.CustomFileUtils;

@Service
public class CarServiceImpl implements CarService{

	private CarRepository carRepository;
		
	@Autowired
	public CarServiceImpl(CarRepository carRepository) {
		this.carRepository = carRepository;
	}

	
	@Override
	@Transactional
	public void saveNew(CarCreate create) throws IOException {
		Car car = CarMapper.CarCreateRequestToCar(create);
		carRepository.save(car);
		CustomFileUtils.createFolderForCarPhoto(car.getId());
		CustomFileUtils.saveCarPhotos(car.getId(), create.getFiles());
	}
	
	@Override
	public void save(EditCarRequest edit) throws IOException {
		carRepository.save(CarMapper.EditCarToCar(edit));
		CustomFileUtils.saveCarPhotos(edit.getId(), edit.getFiles());
	}

	@Override
	public List<Car> findAll() {
		return carRepository.findAll();
	}
	
	

	@Override
	public Car findById(Long id) {
		return carRepository.findOne(id);
	}


	@Override
	public Car findByMake(String make) {
		return null/*carRepository.findByMake(make)*/;
	}


	@Override
	public List<Car> findCarByUserConfig(FindCarByUser findCars) {
		/*if(findCars.getCarClass() != null && findCars.getMake() != null 
				&& findCars.getFuel() != null && findCars.getTransmission() != null) {
			return carRepository.findCarByUserConfig(findCars.getCarClass().getCarClass());
		}*/
		if(findCars.getCarClass() == null) {
			if(findCars.getMake() == null) {
				if(findCars.getFuel() == null) {
					if(findCars.getTransmission() == null) {
						return carRepository.findCarByUserConfig(findCars.getDayRentFrom(),findCars.getDayRentTo());
					}else {
						return carRepository.findCarByUserConfigTransmission(findCars.getDayRentFrom(),
									findCars.getDayRentTo(),
									findCars.getTransmission().getTransmission());
					}
				}else {
					if(findCars.getTransmission() == null) {
						return carRepository.findCarByUserConfigFuel(findCars.getDayRentFrom(),
									findCars.getDayRentTo(),
									findCars.getFuel().getFuel());
					}else {
						return carRepository.findCarByUserConfigFuelAndTransmission(findCars.getDayRentFrom(),
									findCars.getDayRentTo(),
									findCars.getFuel().getFuel(),
									findCars.getTransmission().getTransmission());
					}
				}
			}else {
				if(findCars.getFuel() == null) {
					if(findCars.getTransmission() == null) {
						return carRepository.findCarByUserConfigMake(findCars.getDayRentFrom(),
									findCars.getDayRentTo(),
									findCars.getMake().getMake());
					}else {
						return carRepository.findCarByUserConfigMakeAndTransmission(findCars.getDayRentFrom(),
									findCars.getDayRentTo(),
									findCars.getMake().getMake(),
									findCars.getTransmission().getTransmission());
					}
				}else {
					if(findCars.getTransmission() == null) {
						return carRepository.findCarByUserConfigMakeAndFuel(findCars.getDayRentFrom(),
									findCars.getDayRentTo(),
									findCars.getMake().getMake(),
									findCars.getFuel().getFuel());
					}else {
						return carRepository.findCarByUserConfigMakeAndFuelAndTransnission(findCars.getDayRentFrom(),
									findCars.getDayRentTo(),
									findCars.getMake().getMake(),
									findCars.getFuel().getFuel(),
									findCars.getTransmission().getTransmission());
					}
				}
			}
		}else {
			if(findCars.getMake() == null) {
				if(findCars.getFuel() == null) {
					if(findCars.getTransmission() == null) {
						return carRepository.findCarByUserConfigCarClass(findCars.getDayRentFrom(),findCars.getDayRentTo(),
																findCars.getCarClass().getCarClass());
					}else {
						return carRepository.findCarByUserConfigCarClassAndTransmission(findCars.getDayRentFrom(),
									findCars.getDayRentTo(),
									findCars.getTransmission().getTransmission(),
									findCars.getCarClass().getCarClass());
					}
				}else {
					if(findCars.getTransmission() == null) {
						return carRepository.findCarByUserConfigCarClassAndFuel(findCars.getDayRentFrom(),
									findCars.getDayRentTo(),
									findCars.getFuel().getFuel(),
									findCars.getCarClass().getCarClass());
					}else {
						return carRepository.findCarByUserConfigCarClassAndFuelAndTransmission(findCars.getDayRentFrom(),
									findCars.getDayRentTo(),
									findCars.getFuel().getFuel(),
									findCars.getTransmission().getTransmission(),
									findCars.getCarClass().getCarClass());
					}
				}
			}else {
				if(findCars.getFuel() == null) {
					if(findCars.getTransmission() == null) {
						return carRepository.findCarByUserConfigCarClassAndMake(findCars.getDayRentFrom(),
									findCars.getDayRentTo(),
									findCars.getMake().getMake(),
									findCars.getCarClass().getCarClass());
					}else {
						return carRepository.findCarByUserConfigCarClassAndMakeAndTransmission(findCars.getDayRentFrom(),
									findCars.getDayRentTo(),
									findCars.getMake().getMake(),
									findCars.getTransmission().getTransmission(),
									findCars.getCarClass().getCarClass());
					}
				}else {
					if(findCars.getTransmission() == null) {
						return carRepository.findCarByUserConfigCarClassAndMakeAndFuel(findCars.getDayRentFrom(),
									findCars.getDayRentTo(),
									findCars.getMake().getMake(),
									findCars.getFuel().getFuel(),
									findCars.getCarClass().getCarClass());
					}else {
						return carRepository.findCarByUserConfigCarClassAndMakeAndFuelAndTransnission(findCars.getDayRentFrom(),
									findCars.getDayRentTo(),
									findCars.getMake().getMake(),
									findCars.getFuel().getFuel(),
									findCars.getTransmission().getTransmission(),
									findCars.getCarClass().getCarClass());
					}
				}
			}
			
			
		}
		
		
		
		
		
	}


	@Override
	public void deleteCar(Long id) {
		carRepository.delete(id);
	}




}
