package ua.springboot.web.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.springboot.web.entity.CarClass;
import ua.springboot.web.entity.CarMake;
import ua.springboot.web.entity.Fuel;
import ua.springboot.web.entity.Transmission;

@Getter
@Setter
@NoArgsConstructor
public class EditCarRequest {

	private Long id;
	
	private CarClass carClass;
	
	private CarMake make;
	
	private String model;
	
	private int manufactureYear;
	
	private Fuel fuel;
	
	private int power;
	
	private Transmission transmission;
	
	private int numberOfPlace;

	private int dayRent;
	
	private int weekRent;
	
	private int monthRent;

	private boolean rented;
	
	private boolean booked;
	
	private MultipartFile[] files = new MultipartFile[5];
	
	private String[] filePath = new String[5];
}
