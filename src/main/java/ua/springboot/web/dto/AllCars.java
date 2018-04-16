package ua.springboot.web.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AllCars {

	private Long id;
	
	private String make;
	
	private String model;
	
	private String fuel;
	
	private String transmission;
	
	private int power;
	
	private String mainPhoto;
	
	private int dayRent;
	
	private int weekRent;
	
	private int monthRent;
	
}
