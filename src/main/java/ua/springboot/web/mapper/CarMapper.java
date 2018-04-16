package ua.springboot.web.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import ua.springboot.web.dto.AllCars;
import ua.springboot.web.dto.CarCreate;
import ua.springboot.web.dto.EditCarRequest;
import ua.springboot.web.entity.Car;
import ua.springboot.web.entity.CarModel;
import ua.springboot.web.utils.CustomFileUtils;

public class CarMapper {

	public static Car CarCreateRequestToCar(CarCreate create) {
		Car car = new Car();
		
		car.setCarClass(create.getCarClass());
		CarModel model = new CarModel();
		model.setModel(create.getModel());
		model.setMake(create.getMake());
		car.setModel(model);
		car.setFuel(create.getFuel());
		car.setTransmission(create.getTransmission());
		
		car.setManufactureYear(create.getManufactureYear());
		car.setPower(create.getPower());
		car.setNumberOfPlace(create.getNumberOfPlace());
		car.setDayRent(create.getDayRent());
		car.setWeekRent(create.getWeekRent());
		car.setMonthRent(create.getMonthRent());
		car.setBooked(false);
		car.setRented(false);
		
		
		if(create.getFiles() != null && create.getFiles().length > 0){
			String[] photos = new String[5];
			MultipartFile[] files = create.getFiles();
			
			for(int i = 0; i < 5; i++) {
				if(!files[i].isEmpty())
					photos[i] = files[i].getOriginalFilename();
			}
			car.setPhotoPath(photos);
		}
		
		return car;
	}
	
	public static List<AllCars> carsToAllCarsDto(List<Car> cars){
		List<AllCars> allCars = new ArrayList<>();
		for(Car car : cars) {
			AllCars allCar = new AllCars();
			allCar.setId(car.getId());
			allCar.setMake(car.getModel().getMake().getMake());
			allCar.setModel(car.getModel().getModel());
			allCar.setFuel(car.getFuel().getFuel());
			allCar.setTransmission(car.getTransmission().getTransmission());
			allCar.setPower(car.getPower());
			allCar.setDayRent(car.getDayRent());
			allCar.setWeekRent(car.getWeekRent());
			allCar.setMonthRent(car.getMonthRent());
			try {
				allCar.setMainPhoto(CustomFileUtils.getMainCarPhoto(car.getId(), car.getPhotoPath()));
			} catch (Exception e) {
				e.printStackTrace();
			}
			allCars.add(allCar);
		}
		
		return allCars;
	}
	
	public static EditCarRequest CarToCarEdit(Car car) {
		EditCarRequest edit = new EditCarRequest();
		
		edit.setId(car.getId());
		edit.setCarClass(car.getCarClass());
		edit.setMake(car.getModel().getMake());
		edit.setModel(car.getModel().getModel());
		edit.setManufactureYear(car.getManufactureYear());
		edit.setPower(car.getPower());
		edit.setFuel(car.getFuel());
		
		edit.setTransmission(car.getTransmission());
		edit.setNumberOfPlace(car.getNumberOfPlace());
		edit.setDayRent(car.getDayRent());
		edit.setWeekRent(car.getWeekRent());
		edit.setMonthRent(car.getMonthRent());
		edit.setBooked(car.isBooked());
		edit.setRented(car.isRented());
		edit.setFilePath(car.getPhotoPath());
		
		return edit;
	}
	
	public static Car EditCarToCar(EditCarRequest edit) {
		Car car = new Car();
		car.setId(edit.getId());
		car.setCarClass(edit.getCarClass());
		CarModel carModel = new CarModel();
		carModel.setModel(edit.getModel());
		carModel.setMake(edit.getMake());
		car.setModel(carModel);
		car.setTransmission(edit.getTransmission());
		car.setFuel(edit.getFuel());

		car.setManufactureYear(edit.getManufactureYear());
		car.setPower(edit.getPower());
		car.setNumberOfPlace(edit.getNumberOfPlace());
		car.setDayRent(edit.getDayRent());
		car.setWeekRent(edit.getWeekRent());
		car.setMonthRent(edit.getMonthRent());
		car.setBooked(edit.isBooked());
		car.setRented(edit.isBooked());
	
		String[] photoPath = new String[5];
		for(int i = 0; i < 5; i++) {
			if(!edit.getFiles()[i].isEmpty()) {
				photoPath[i] = edit.getFiles()[i].getOriginalFilename();
			}
			if(edit.getFilePath()[i] == null || (
					edit.getFiles()[i].isEmpty() && !edit.getFilePath()[i].equals(""))) {
				photoPath[i] = edit.getFilePath()[i];
			}
		}
		
		car.setPhotoPath(photoPath);
		
		return car;
	}
	
}





