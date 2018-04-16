package ua.springboot.web.enumaration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CarType {
	ECONOMY("Economy"), 
	MIDLE("Midle"),
	BISINESS("Bisiness"), 
	PREMIUM("Premium"), 
	SUV("Suv"), 
	MINIVAN("Minivan"),
	SPORT("Sport");
	
	private String type;
}
