package ua.springboot.web.enumaration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Transmission {
	AUTOMATIC("Automatic"),
	MANUAl("Manual");
	
	private String type;
}
