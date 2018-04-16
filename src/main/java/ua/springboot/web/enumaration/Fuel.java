package ua.springboot.web.enumaration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Fuel {
	DIESEL("Diesel"),
	PETROL("Petrol"), 
	ELECTRIC("Electric");
	
	private String type;
}
