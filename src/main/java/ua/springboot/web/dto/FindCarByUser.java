package ua.springboot.web.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import ua.springboot.web.entity.CarClass;
import ua.springboot.web.entity.CarMake;
import ua.springboot.web.entity.Fuel;
import ua.springboot.web.entity.Transmission;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class FindCarByUser {
	
	private CarClass carClass;
	
	private CarMake make;
	
	private Fuel fuel;
	
	private Transmission transmission;
	
	private int dayRentFrom = 0;
	
	private int dayRentTo = 1000;

	
}
